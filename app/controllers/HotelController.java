package controllers;
import static play.data.Form.form;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.thoughtworks.xstream.XStream;

import bean.HotelForm;
import entities.BnsCompany;
import entities.BnsHotel;
import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import services.HotelService;
import system.log.Logger;
import utils.BnsUtils;
import utils.CryptTool;

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
		return ok(Json.toJson(hotelService.search(UserController.companyId(token))));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result all(){
		Map<String, BnsCompany> companyMap =CompanyController.comapnyMap();
		List<Object> data =new ArrayList<Object>();
		List<BnsHotel> list =hotelService.listAll();
		for(BnsHotel obj:list){
			Map<String,Object> map =new HashMap<String,Object>();
			map.put("id", obj.getId());
			map.put("company", obj.getCompany());
			map.put("companyName", companyMap.get(obj.getCompany()).getCompany());
			map.put("city", obj.getCity());
			map.put("name", obj.getName());
			map.put("logo", obj.getLogo());
			map.put("type", obj.getType());
			map.put("state", obj.getState());
			map.put("star", obj.getStar());
			map.put("description", obj.getDescription());
			map.put("address", obj.getAddress());
			map.put("money", obj.getPrice());
			map.put("remark", obj.getRemark());
			map.put("createdTime", new SimpleDateFormat("yyyy-MM-dd").format(obj.getCreatedTime()));
			data.add(map);
		}
		return ok(Json.toJson(data));
	}
	
	public static List<Object> search(String company){
		List<Object> list =new ArrayList<Object>();
		List<BnsHotel> caches =hotelService.search(company);
		for(BnsHotel obj:caches){
			Map<String,Object> map =new HashMap<String,Object>();
			map.put("id", obj.getId());
			map.put("company", obj.getCompany());
			map.put("city", obj.getCity());
			map.put("name", obj.getName());
			map.put("logo", obj.getLogo());
			map.put("type", obj.getType());
			map.put("state", obj.getState());
			map.put("star", obj.getStar());
			map.put("description", obj.getDescription());
			map.put("address", obj.getAddress());
			map.put("money", obj.getPrice());
			map.put("remark", obj.getRemark());
			list.add(map);
		}
		return list;
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
			obj.setCompany(UserController.companyId(token));
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
	
	public static BnsHotel hotelObj(String id){
		return hotelService.get(id);
	}

}
