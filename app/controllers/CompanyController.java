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
import entities.BnsService;
import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import services.CompanyService;
import services.ServService;
import system.log.Logger;
import utils.CryptTool;

@Controller
public class CompanyController extends play.mvc.Controller {
	
	public static CompanyService companyService;
	
	public static ServService servService;
	
	@Autowired
	@Qualifier("companyService")
	public void setCompanyService(CompanyService companyService) {
		CompanyController.companyService = companyService;
	}
	
	@Autowired
	@Qualifier("servService")
	public void setServService(ServService servService) {
		CompanyController.servService = servService;
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
		obj.setHistory(0);
		obj.setState(0);
		obj.setRank(0);
		obj.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		//同步创建管理账户
		Boolean flag =UserController.companyAdministrator(obj);
		if(!flag){
			companyService.detele(obj);
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
		if(data.getRank()!=null){
			obj.setRank(data.getRank());
		}
		Logger.info("保存公司", Json.toJson(obj)+"");
		companyService.save(obj);
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
		return ok(Json.toJson(companyService.findService()));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result search(String city){
		List<Object> vo = new ArrayList<Object>();
		List<BnsCompany> list =companyService.listByCity(city);
		for(BnsCompany obj:list){
			Map<String,Object> map =new HashMap<String,Object>();
			map.put("id", obj.getId());
			map.put("name", obj.getName());
			map.put("logo", obj.getLogo());
			map.put("address", obj.getAddress());
			map.put("frName", obj.getFrName());
			map.put("frMobile", obj.getFrMobile());
			map.put("linkman", obj.getLinkman());
			map.put("mobile", obj.getMobile());
			map.put("gos", obj.getGos());
			List<BnsService> temp =servService.listByCompany(obj.getId());
			map.put("serv", temp);
			if(temp.size()>0){
				vo.add(map);
			}
		}
		return ok(Json.toJson(vo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result change(String id){
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("work", WorksController.search(id));
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
		BnsCompany obj=companyService.getByToken(token);
		return ok(Json.toJson(Map4Obj(obj)));
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
		map.put("history", obj.getHistory());
		map.put("num", obj.getNum());
		map.put("state", obj.getState());
		map.put("state_", obj.getState()==0?"启用":"禁用");
		map.put("rank", obj.getRank());
		map.put("rank_", obj.getRank()==0?"普通服务商":(obj.getRank()==1?"升级中":"高级服务商"));
		map.put("createdTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(obj.getCreatedTime()));
		return map;
	}
	
	
	//根据token获取机构对象
	public static BnsCompany getByToken(String token){
		return companyService.getByToken(token);
	}
	
	//根据id获取机构对象
	public static BnsCompany Obj(String id){
		return companyService.get(id);
	}
	
	
}
