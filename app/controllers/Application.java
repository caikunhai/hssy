package controllers;

import static play.data.Form.form;

import java.io.File;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.thoughtworks.xstream.XStream;

import bean.RoleForm;
import entities.SysMenuRole;
import external.qiniu.Qiniu;
import play.Play;
import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import services.SystemService;
import system.log.Logger;
import utils.CryptTool;

@Controller
public class Application extends play.mvc.Controller {
	
	private static SystemService systemService;
	
	@Autowired
	@Qualifier("systemService")
	public void setSystemService(SystemService systemService) {
		Application.systemService = systemService;
	}

	public static Result index(){
		return redirect("index.html");
	}
	
	public static Result getFile(String path) {
		File file = new File(Play.application().path() + path);
		return ok(file);
	}
	
	public static Result sms() {
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		JsonNode jsonNode =request().body().asJson();
		if(jsonNode==null){
			vo.put("message", "参数有误");
			return ok(Json.toJson(vo));
		}
		if(jsonNode.get("mobile")==null){
			vo.put("message", "参数有误");
			return ok(Json.toJson(vo));
		}
		String sms =CryptTool.getNum(6);
		play.cache.Cache.set(jsonNode.get("mobile").toString().replace("\"", ""), sms, 5*60*1000);
		System.out.println("----------sms--------"+play.cache.Cache.get(jsonNode.get("mobile").toString().replace("\"", "")));
		vo.put("code", 1);
		vo.put("message", sms);
		return ok(Json.toJson(vo));
	}
	
	public static Result uptoken() {
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("uptoken", new Qiniu().getUpToken());
		return ok(Json.toJson(vo));
	}
	
	public static Result role(){
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		Form<RoleForm> form = form(RoleForm.class).bindFromRequest();
		if (form.hasErrors()) {
			Logger.error("设置权限", form.toString());
			return status(403,Json.toJson(form.toString()));
		}
		RoleForm data =form.get();
		XStream xstream = new XStream();
		xstream.alias("request", RoleForm.class);
		Logger.info("设置权限", xstream.toXML(data));
		systemService.removeMenuRole(data.getRole());
		String[] ids =data.getMenus().split("#");
		for(String id:ids){
			if(id!=null&&id!=""){
				SysMenuRole obj=new SysMenuRole();
				obj.setMenu(new Long(id));
				obj.setRole(data.getRole());
				obj.setCreatedTime(new Timestamp(System.currentTimeMillis()));
				systemService.saveMenuRole(obj);
			}
		}
		vo.put("code", 1);
		vo.put("message", "设置成功.");
		return ok(Json.toJson(vo));
	}
	
	public static Result listMenu() {
		return ok(Json.toJson(systemService.listMenu()));
	}
	
}