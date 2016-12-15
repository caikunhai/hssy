package controllers;

import static play.data.Form.form;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.thoughtworks.xstream.XStream;

import bean.CompanyForm;
import entities.BnsCompany;
import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import services.CompanyService;
import system.init.SetupManager;
import system.log.Logger;
import utils.CryptTool;

@Controller
public class CompanyController extends play.mvc.Controller {
	
	private static CompanyService companyService;
	
	@Autowired
	@Qualifier("companyService")
	public void setCompanyService(CompanyService companyService) {
		CompanyController.companyService = companyService;
	}

	@Security.Authenticated(Secured.class)
	public static Result save() throws IllegalAccessException, InvocationTargetException{
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		Form<CompanyForm> form = form(CompanyForm.class).bindFromRequest();
		if (form.hasErrors()) {
			Logger.error("保存公司", form.toString());
			return status(403,Json.toJson(form.toString()));
		}
		CompanyForm data =form.get();
		XStream xstream = new XStream();
		xstream.alias("request", CompanyForm.class);
		Logger.info("保存公司", xstream.toXML(data));
		BnsCompany obj =data.getId()==null?null:companyService.get(data.getId());
		if(obj!=null){
			return companyEdit(vo,obj,data);
		}
		obj=new BnsCompany();
		BeanUtils.copyProperties(obj, data);
		obj.setId(CryptTool.getUUID());
		obj.setState(0);
		obj.setRank(0);
		obj.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		//同步创建管理账户
		Boolean flag =UserController.companyAdministrator(obj);
		if(!flag){
			vo.put("message", "创建公司账户失败");
			return ok(Json.toJson(vo));
		}
		//同步创建钱包
		WalletController.createWallet(obj.getId());
		Logger.info("保存公司", Json.toJson(obj)+"");
		companyService.save(obj);
		vo.put("code", 1);
		vo.put("message", "保存成功");
		return ok(Json.toJson(vo));
	}
	
	public static Result companyEdit(Map<String,Object> vo,BnsCompany obj,CompanyForm data){
		if(data.getName()!=null){
			obj.setName(data.getName());
		}
		if(data.getLogo()!=null){
			obj.setLogo(data.getLogo());
		}
		if(data.getAddress()!=null){
			obj.setAddress(data.getAddress());
		}
		if(data.getFrName()!=null){
			obj.setFrName(data.getFrName());
		}
		if(data.getFrMobile()!=null){
			obj.setFrMobile(data.getFrMobile());
		}
		if(data.getLinkman()!=null){
			obj.setLinkman(data.getLinkman());
		}
		if(data.getMobile()!=null){
			obj.setMobile(data.getMobile());
		}
		if(data.getGos()!=null){
			obj.setGos(data.getGos());
		}
		if(data.getNum()!=null){
			obj.setNum(data.getNum());
		}
		Logger.info("保存公司", Json.toJson(obj)+"");
		companyService.save(obj);
		if(obj.getRank()==2){
			SetupManager.initCompany();
		}
		vo.put("code", 1);
		vo.put("message", "保存成功");
		return ok(Json.toJson(vo));
	}
	
	
	@Security.Authenticated(Secured.class)
	public static Result list() throws Exception{
		List<Object> list =new ArrayList<Object>();
		Iterable<BnsCompany> itr =companyService.list();
		Iterator<BnsCompany> it =itr.iterator();
		while(it.hasNext()){
			BnsCompany obj =it.next();
			list.add(Map4Obj(obj));
		}
		return ok(Json.toJson(list));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result simple(){
		Iterable<BnsCompany> itr =companyService.list();
		Iterator<BnsCompany> it =itr.iterator();
		List<Object> list =new ArrayList<Object>();
		while(it.hasNext()){
			BnsCompany obj =it.next();
			if(obj.getRank()==2){
				Map<String,Object> map =new HashMap<String,Object>();
				map.put("id", obj.getId());
				map.put("name", obj.getName());
				map.put("address", obj.getAddress());
				map.put("linkman", obj.getLinkman());
				map.put("mobile", obj.getMobile());
				list.add(map);
			}
		}
		return ok(Json.toJson(list));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result search(String city){
		return ok(Json.toJson(companyService.listByCity(city)));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result change(String id){
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("cloth", ClothController.search(id));
		map.put("hotel", HotelController.search(id));
		map.put("site", SiteController.search(id));
		return ok(Json.toJson(map));
	}
	
	public static Result get(String id){
		BnsCompany obj =companyService.get(id);
		if(obj==null){
			return ok();
		}
		return ok(Json.toJson(Map4Obj(obj)));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result info(){
		String token = request().getHeader("token");
		return get(UserController.companyId(token));
	}
	
	private static Map<String,Object> Map4Obj(BnsCompany obj){
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("id", obj.getId());
		map.put("city", obj.getCity());
		map.put("name", obj.getName());
		map.put("logo", obj.getLogo());
		map.put("address", obj.getAddress());
		map.put("frName", obj.getFrName());
		map.put("frMobile", obj.getFrMobile());
		map.put("linkman", obj.getLinkman());
		map.put("mobile", obj.getMobile());
		map.put("gos", obj.getGos());
		map.put("num", obj.getNum());
		map.put("state", obj.getState());
		map.put("rank", obj.getRank());
		map.put("createdTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(obj.getCreatedTime()));
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String,BnsCompany> comapnyMap(){
		return (Map<String,BnsCompany>)play.cache.Cache.get("company");
	}
	
	public static BnsCompany Obj(String id){
		return companyService.get(id);
	}
	
	//组装公司dialog
	public static String dialog4Company(String id){
		BnsCompany comapny =comapnyMap().get(id);
		if(comapny ==null){
			return "";
		}
		StringBuffer html=new StringBuffer();
		html.append("<p>组织名称："+comapny.getName()+"</p>");
		html.append("<p>联系电话："+comapny.getMobile()+"</p>");
		html.append("<p>所在地址："+comapny.getAddress()+"</p>");
		return html.toString();
	}
	
	//组装公司dialog
	public static String name4Company(String id){
		BnsCompany comapny =comapnyMap().get(id);
		if(comapny ==null){
			return "";
		}
		return comapny.getName();
	}
	
	public static BnsCompany companyHistoryOrderPlus(String id){
		BnsCompany comapny =companyService.get(id);
		if(comapny ==null){
			return null;
		}
		//comapny.setHistory(comapny.getHistory()+1);
		return companyService.save(comapny);
	}
	
	
}
