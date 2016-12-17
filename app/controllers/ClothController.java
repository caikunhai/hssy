package controllers;
import static play.data.Form.form;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import services.ClothService;
import system.log.Logger;
import utils.CryptTool;
import bean.ClothesForm;

import com.thoughtworks.xstream.XStream;

import entities.BnsClothes;

@Controller
public class ClothController extends play.mvc.Controller {
	
	private static ClothService clothService;

	@Autowired
	@Qualifier("clothService")
	public void setClothService(ClothService clothService) {
		ClothController.clothService = clothService;
	}
	
	@Security.Authenticated(Secured.class)
	public static Result list(){
		String token = request().getHeader("token");
		String company =CompanyController.getByToken(token).getId();
		return ok(Json.toJson(clothService.search(company)));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result all(){
		return ok(Json.toJson(clothService.listAll()));
	}
	
	public static List<BnsClothes> search(String company){
		return clothService.search(company);
	}
	
	@Security.Authenticated(Secured.class)
	public static Result cloth(String id){
		return ok(Json.toJson(clothService.get(id)));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result save() throws IllegalAccessException, InvocationTargetException{
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		Form<ClothesForm> form = form(ClothesForm.class).bindFromRequest();
		if (form.hasErrors()) {
			Logger.error("保存服装", form.toString());
			return status(403,Json.toJson(form.toString()));
		}
		ClothesForm data =form.get();
		XStream xstream = new XStream();
		xstream.alias("request", ClothesForm.class);
		Logger.info("保存服装", xstream.toXML(data));
		BnsClothes obj =data.getId()==null?null:clothService.get(data.getId());
		if(obj==null){
			obj=new BnsClothes();
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
		}
		clothService.save(obj);
		vo.put("code", 1);
		vo.put("message", "保存服装成功");
		return ok(Json.toJson(vo));
	}

}
