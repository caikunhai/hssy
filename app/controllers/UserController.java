package controllers;

import static play.data.Form.form;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import services.UserService;
import system.log.Logger;
import utils.BnsUtils;
import utils.CryptTool;
import utils.MD5Util;
import bean.LoginForm;
import bean.PasswordForm;
import bean.UserForm;

import com.thoughtworks.xstream.XStream;

import entities.BnsCompany;
import entities.BnsUser;
import entities.SysMenu;
import enumeration.ComRole;

@Controller
public class UserController extends play.mvc.Controller {
	
	public static UserService userService;
	
	@Autowired
	@Qualifier("userService")
	public void setUserService(UserService userService) {
		UserController.userService = userService;
	}
	
	public static Result login(){
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		Form<LoginForm> form = form(LoginForm.class).bindFromRequest();
		if (form.hasErrors()) {
			Logger.error("用户登录", form.toString());
			return status(403,Json.toJson(form.toString()));
		}
		LoginForm data =form.get();
		XStream xstream = new XStream();
		xstream.alias("request", LoginForm.class);
		Logger.info("用户登录", xstream.toXML(data));
		BnsUser obj =userService.login(data.getUsername(), MD5Util.encode(data.getPassword()));
		if(obj==null){
			vo.put("message", "用户名或密码错误");
			return ok(Json.toJson(vo));
		}
		if(obj.getState()==1){
			vo.put("message", "该账户被禁用");
			return ok(Json.toJson(vo));
		}
		obj.setToken(obj.getId()+UUID.randomUUID().toString());
		obj.setLoginIp(BnsUtils.getClientIP(request()));
		obj.setLoginTime(new Timestamp(System.currentTimeMillis()));
		userService.saveSysUser(obj);
		vo.put("code", 1);
		vo.put("message", "登录成功");
		vo.put("token", obj.getToken());
		return ok(Json.toJson(vo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result menu2(){
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		String token = request().getHeader("token");
		BnsUser obj =userService.findByToken(token);
		if(obj==null){
			return ok();
		}
		//获取菜单
		List<Object> menus =new ArrayList<Object>();
		List<SysMenu> list =userService.findMenu(obj.getRole());
		for(SysMenu o:list){
			if(o.getParent()==0){
				List<Object> submenus =new ArrayList<Object>();
				for(SysMenu oo:list){
					if(o.getId()==oo.getParent()){
						Map<String,Object> sub =new HashMap<String,Object>();
						sub.put("menuid", oo.getId());
						sub.put("menuname", oo.getName());
						sub.put("icon", oo.getIcon());
						sub.put("url", oo.getUrl());
						submenus.add(sub);
					}
				}
				Map<String,Object> main =new HashMap<String,Object>();
				main.put("menuid", o.getId());
				main.put("menuname", o.getName());
				main.put("icon", o.getIcon());
				main.put("menus", submenus);
				menus.add(main);
			}
		}
		vo.put("code", 1);
		vo.put("message", menus);
		return ok(Json.toJson(vo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result menu(){
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		String token = request().getHeader("token");
		BnsUser obj =userService.findByToken(token);
		if(obj==null){
			return ok();
		}
		//获取菜单
		List<Object> menus =new ArrayList<Object>();
		List<SysMenu> list =userService.findMenu(obj.getRole());
		for(SysMenu o:list){
			if(o.getParent()==0){
				List<Object> submenus =new ArrayList<Object>();
				for(SysMenu oo:list){
					if(o.getId()==oo.getParent()){
						Map<String,Object> sub =new HashMap<String,Object>();
						sub.put("name", oo.getName());
						sub.put("url", oo.getUrl());
						submenus.add(sub);
					}
				}
				Map<String,Object> main =new HashMap<String,Object>();
				main.put("name", o.getName());
				main.put("sub", submenus);
				menus.add(main);
			}
		}
		vo.put("code", 1);
		vo.put("message", menus);
		vo.put("role", obj.getCompany()==null||"".equals(obj.getCompany())?1:0);
		return ok(Json.toJson(vo));
	}
	
	
	
	@Security.Authenticated(Secured.class)
	public static Result save(){
		String token = request().getHeader("token");
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		Form<UserForm> form = form(UserForm.class).bindFromRequest();
		if (form.hasErrors()) {
			Logger.error("保存用户", form.toString());
			return status(403,Json.toJson(form.toString()));
		}
		UserForm data =form.get();
		XStream xstream = new XStream();
		xstream.alias("request", UserForm.class);
		Logger.info("保存用户", xstream.toXML(data));
		BnsUser user =data.getId()==null?null:userService.get(data.getId());
		if(user==null){
			user =new BnsUser();
			if(!isUsable(data.getUsername())){
				vo.put("message", "该账户已存在");
				return ok(Json.toJson(vo));
			}
			user.setId(CryptTool.getUUID());
			user.setCompany(CompanyController.getByToken(token).getId());
			user.setPassword(MD5Util.encode("123456"));
			user.setSecret(MD5Util.encode("123456"));
			user.setUsername(data.getUsername());
			user.setRole(ComRole.employee.ordinal());
			user.setState(0);
			user.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		}else{
			if(data.getState()!=null){
				user.setState(data.getState());
			}
		}
		userService.saveSysUser(user);
		vo.put("code", 1);
		vo.put("message", "操作成功");
		return ok(Json.toJson(vo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result password(){
		String token = request().getHeader("token");
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		Form<PasswordForm> form = form(PasswordForm.class).bindFromRequest();
		if (form.hasErrors()) {
			Logger.error("修改密码", form.toString());
			return status(403,Json.toJson(form.toString()));
		}
		PasswordForm data =form.get();
		XStream xstream = new XStream();
		xstream.alias("request", PasswordForm.class);
		Logger.info("修改密码", xstream.toXML(data));
		BnsUser user =userService.get(BnsUtils.getId(token));
		if(user==null){
			vo.put("message", "非法操作");
			return ok(Json.toJson(vo));
		}
		if(!user.getPassword().equals(MD5Util.encode(data.getOld()))){
			vo.put("message", "旧密码不对");
			return ok(Json.toJson(vo));
		}
		user.setPassword(MD5Util.encode(data.getNow()));
		userService.saveSysUser(user);
		vo.put("code", 1);
		vo.put("message", "修改成功");
		return ok(Json.toJson(vo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result code(){
		String token = request().getHeader("token");
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		Form<PasswordForm> form = form(PasswordForm.class).bindFromRequest();
		if (form.hasErrors()) {
			Logger.error("修改密码", form.toString());
			return status(403,Json.toJson(form.toString()));
		}
		PasswordForm data =form.get();
		XStream xstream = new XStream();
		xstream.alias("request", PasswordForm.class);
		Logger.info("修改密码", xstream.toXML(data));
		BnsUser user =userService.get(BnsUtils.getId(token));
		if(user==null){
			vo.put("message", "非法操作");
			return ok(Json.toJson(vo));
		}
		if(!user.getPassword().equals(MD5Util.encode(data.getOld()))){
			vo.put("message", "旧密码不对");
			return ok(Json.toJson(vo));
		}
		user.setSecret(MD5Util.encode(data.getNow()));
		userService.saveSysUser(user);
		vo.put("code", 1);
		vo.put("message", "修改成功");
		return ok(Json.toJson(vo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result list(){
		String token = request().getHeader("token");
		return ok(Json.toJson(userService.listEmployeeByToken(token)));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result get(String id){
		return ok(Json.toJson(userService.get(id)));
	}

	
	public static Boolean companyAdministrator(BnsCompany company){
		try {
			if(!isUsable(company.getFrMobile())){
				return false;
			}
			BnsUser obj =new BnsUser();
			obj.setId(CryptTool.getUUID());
			obj.setCompany(company.getId());
			obj.setPassword(MD5Util.encode("123456"));
			obj.setSecret(MD5Util.encode("123456"));
			obj.setUsername(company.getFrMobile());
			obj.setState(0);
			obj.setRole(ComRole.company.ordinal());
			obj.setCreatedTime(new Timestamp(System.currentTimeMillis()));
			userService.saveSysUser(obj);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
		return true;
	}
	
	//检查账户是否存在
	public static Boolean isUsable(String username){
		BnsUser obj =userService.findByUsername(username);
		if(obj==null){
			return true;
		}
		return false;
	}
	
}
