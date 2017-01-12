package controllers;
import static play.data.Form.form;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import services.ServService;
import system.log.Logger;
import utils.CryptTool;
import bean.ServForm;

import com.thoughtworks.xstream.XStream;

import entities.BnsService;

@Controller
public class ServController extends play.mvc.Controller {
	
	private static ServService servService;

	@Autowired
	@Qualifier("servService")
	public void setServService(ServService servService) {
		ServController.servService = servService;
	}
	
	@Security.Authenticated(Secured.class)
	public static Result list(){
		String token = request().getHeader("token");
		String company =CompanyController.getByToken(token).getId();
		return ok(Json.toJson(servService.listByCompany(company)));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result save() throws IllegalAccessException, InvocationTargetException{
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		Form<ServForm> form = form(ServForm.class).bindFromRequest();
		if (form.hasErrors()) {
			Logger.error("保存套餐", form.toString());
			return status(403,Json.toJson(form.toString()));
		}
		ServForm data =form.get();
		XStream xstream = new XStream();
		xstream.alias("request", ServForm.class);
		Logger.info("保存套餐", xstream.toXML(data));
		BnsService obj =data.getId()==null?null:servService.get(data.getId());
		if(obj==null){
			obj=new BnsService();
			BeanUtils.copyProperties(obj, data);
			obj.setId(CryptTool.getUUID());
			String token = request().getHeader("token");
			obj.setCompany(CompanyController.getByToken(token).getId());
			obj.setState(0);
			obj.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		}else{
			if(data.getName()!=null){
				obj.setName(data.getName());
			}
			if(data.getUnit()!=null){
				obj.setUnit(data.getUnit());
			}
			if(data.getNum()!=null){
				obj.setNum(data.getNum());
			}
			if(data.getState()!=null){
				obj.setState(data.getState());
			}
			if(data.getPrice()!=null){
				obj.setPrice(data.getPrice());
			}
			if(data.getMoney()!=null){
				obj.setMoney(data.getMoney());
			}
			if(data.getAdditional()!=null){
				obj.setAdditional(data.getAdditional());
			}
			if(data.getRemark()!=null){
				obj.setRemark(data.getRemark());
			}
		}
		servService.save(obj);
		vo.put("code", 1);
		vo.put("message", "保存成功");
		return ok(Json.toJson(vo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result get(String id){
		return ok(Json.toJson(servService.get(id)));
	}
	

}
