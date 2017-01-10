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
import services.HotelService;
import system.log.Logger;
import utils.CryptTool;
import bean.HotelForm;

import com.thoughtworks.xstream.XStream;

import entities.BnsHotel;

@Controller
public class HotelController extends play.mvc.Controller {
	
	private static HotelService hotelService;

	@Autowired
	@Qualifier("hotelService")
	public void setHotelService(HotelService hotelService) {
		HotelController.hotelService = hotelService;
	}
	
	@Security.Authenticated(Secured.class)
	public static Result list(){
		String token = request().getHeader("token");
		String company =CompanyController.getByToken(token).getId();
		return ok(Json.toJson(hotelService.search(company)));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result save() throws IllegalAccessException, InvocationTargetException{
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		Form<HotelForm> form = form(HotelForm.class).bindFromRequest();
		if (form.hasErrors()) {
			Logger.error("保存住宿", form.toString());
			return status(403,Json.toJson(form.toString()));
		}
		HotelForm data =form.get();
		XStream xstream = new XStream();
		xstream.alias("request", HotelForm.class);
		Logger.info("保存住宿", xstream.toXML(data));
		BnsHotel obj =data.getId()==null?null:hotelService.get(data.getId());
		if(obj==null){
			obj=new BnsHotel();
			BeanUtils.copyProperties(obj, data);
			obj.setId(CryptTool.getUUID());
			String token = request().getHeader("token");
			obj.setCompany(CompanyController.getByToken(token).getId());
			obj.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		}else{
			if(data.getName()!=null){
				obj.setName(data.getName());
			}
			if(data.getLogo()!=null){
				obj.setLogo(data.getLogo());
			}
			if(data.getDescription()!=null){
				obj.setDescription(data.getDescription());
			}
			if(data.getState()!=null){
				obj.setState(data.getState());
			}
			if(data.getPrice()!=null){
				obj.setPrice(data.getPrice());
			}
			if(data.getAddress()!=null){
				obj.setAddress(data.getAddress());
			}
			if(data.getType()!=null){
				obj.setType(data.getType());
			}
			if(data.getRemark()!=null){
				obj.setRemark(data.getRemark());
			}
		}
		hotelService.save(obj);
		vo.put("code", 1);
		vo.put("message", "保存成功");
		return ok(Json.toJson(vo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result hotel(String id){
		return ok(Json.toJson(hotelService.get(id)));
	}
	
	public static List<BnsHotel> search(String company){
		return hotelService.search(company);
	}

}
