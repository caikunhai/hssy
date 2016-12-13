package controllers;
import static play.data.Form.form;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.thoughtworks.xstream.XStream;

import bean.AreaForm;
import entities.SysArea;
import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import services.AreaService;
import system.init.SetupManager;
import system.log.Logger;

@Controller
public class AreaController extends play.mvc.Controller {
	
	private static AreaService areaService;

	@Autowired
	@Qualifier("areaService")
	public void setAreaService(AreaService areaService) {
		AreaController.areaService = areaService;
	}
	
	public static Result list(){
		return ok(Json.toJson(areaService.list()));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result save(){
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		Form<AreaForm> form = form(AreaForm.class).bindFromRequest();
		if (form.hasErrors()) {
			Logger.error("保存地区", form.toString());
			return status(403,Json.toJson(form.toString()));
		}
		AreaForm data =form.get();
		XStream xstream = new XStream();
		xstream.alias("request", AreaForm.class);
		Logger.info("保存地区", xstream.toXML(data));
		
		SysArea area = data.getId()==null?null:areaService.get(data.getId());
		if(area==null){
			area =new SysArea();
			area.setName(data.getName());
			area.setSort(0);
			area.setState(0);
			area.setCreatedTime(new Timestamp(System.currentTimeMillis()));
			SysArea obj =areaService.findByName(data.getName());
			if(obj!=null){
				vo.put("message", "已存在");
				return ok(Json.toJson(vo));
			}
		}else{
			area.setState(data.getState());
		}
		areaService.save(area);
		SetupManager.initArea();
		vo.put("code", 1);
		vo.put("message", "保存成功");
		return ok(Json.toJson(vo));
	}
	
	@SuppressWarnings("unchecked")
	public static List<SysArea> areaMap(){
		return (List<SysArea>)play.cache.Cache.get("area");
	}
	

}
