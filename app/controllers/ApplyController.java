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

import com.thoughtworks.xstream.XStream;

import bean.ApplyForm;
import entities.BnsApply;
import entities.BnsApplyImg;
import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import services.ApplyService;
import system.log.Logger;
import utils.CryptTool;

@Controller
public class ApplyController extends play.mvc.Controller {
	
	public static ApplyService applyService;

	@Autowired
	@Qualifier("applyService")
	public void setApplyService(ApplyService applyService) {
		ApplyController.applyService = applyService;
	}
	
	@Security.Authenticated(Secured.class)
	public static Result save() throws IllegalAccessException, InvocationTargetException{
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		Form<ApplyForm> form = form(ApplyForm.class).bindFromRequest();
		if (form.hasErrors()) {
			Logger.error("保存申请", form.toString());
			return status(403,Json.toJson(form.toString()));
		}
		ApplyForm data =form.get();
		XStream xstream = new XStream();
		xstream.alias("request", ApplyForm.class);
		Logger.info("保存申请", xstream.toXML(data));
		BnsApply obj =data.getId()==null?null:applyService.get(data.getId());
		if(obj!=null){
			obj.setName(data.getName());
			obj.setAddress(data.getAddress());
			obj.setFrName(data.getFrName());
			obj.setFrMobile(data.getFrMobile());
			obj.setGos(data.getGos());
			applyService.save(obj);
			saveImg(data.getImgs(),obj.getId());
			vo.put("code", 1);
			vo.put("message", "保存成功");
			return ok(Json.toJson(vo));
		}
		obj=new BnsApply();
		BeanUtils.copyProperties(obj, data);
		obj.setId(CryptTool.getUUID());
		obj.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		Logger.info("保存申请", Json.toJson(obj)+"");
		applyService.save(obj);
		saveImg(data.getImgs(),obj.getId());
		vo.put("code", 1);
		vo.put("message", "保存成功");
		return ok(Json.toJson(vo));
	}
	
	
	public static void saveImg(List<String> imgs,String apply){
		applyService.delImg(apply);
		for(String filename:imgs){
			BnsApplyImg obj =new BnsApplyImg();
			obj.setId(CryptTool.getUUID());
			obj.setApply(apply);
			obj.setFilename(filename);
			obj.setCreatedTime(new Timestamp(System.currentTimeMillis()));
			applyService.saveImg(obj);
		}
	}
	
	
	public static Result get(String company) {
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		BnsApply obj =applyService.search(company);
		if(obj==null){
			return ok(Json.toJson(vo));
		}
		vo.put("obj", obj);
		vo.put("imgs", applyService.listImgs(obj.getId()));
		vo.put("code", 1);
		vo.put("message", "success");
		return ok(Json.toJson(vo));
	}
	
	

}
