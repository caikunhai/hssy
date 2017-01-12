package controllers;
import static play.data.Form.form;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
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
import services.SiteService;
import system.log.Logger;
import utils.CryptTool;
import bean.SiteForm;

import com.thoughtworks.xstream.XStream;

import entities.BnsSite;

@Controller
public class SiteController extends play.mvc.Controller {
	
	private static SiteService siteService;

	@Autowired
	@Qualifier("siteService")
	public void setSiteService(SiteService siteService) {
		SiteController.siteService = siteService;
	}
	
	@Security.Authenticated(Secured.class)
	public static Result list(){
		String token = request().getHeader("token");
		String company =CompanyController.getByToken(token).getId();
		return ok(Json.toJson(siteService.searchByCompany(company)));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result save() throws IllegalAccessException, InvocationTargetException{
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		Form<SiteForm> form = form(SiteForm.class).bindFromRequest();
		if (form.hasErrors()) {
			Logger.error("保存景点", form.toString());
			return status(403,Json.toJson(form.toString()));
		}
		SiteForm data =form.get();
		XStream xstream = new XStream();
		xstream.alias("request", SiteForm.class);
		Logger.info("保存景点", xstream.toXML(data));
		
		BnsSite obj =data.getId()==null?null:siteService.get(data.getId());
		if(obj==null){
			obj=new BnsSite();
			BeanUtils.copyProperties(obj, data);
			obj.setId(CryptTool.getUUID());
			String token = request().getHeader("token");
			obj.setCompany(CompanyController.getByToken(token).getId());
			obj.setMoney(new BigDecimal(0));
			obj.setState(0);
			obj.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		}else{
			if(data.getCity()!=null){
				obj.setCity(data.getCity());
			}
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
			if(data.getMoney()!=null){
				obj.setMoney(data.getMoney());
			}
			if(data.getRemark()!=null){
				obj.setRemark(data.getRemark());
			}
		}
		siteService.save(obj);
		vo.put("code", 1);
		vo.put("message", "保存成功");
		return ok(Json.toJson(vo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result site(String id){
		return ok(Json.toJson(siteService.get(id)));
	}
	
	public static List<BnsSite> search(String company){
		return siteService.searchByCompany(company);
	}

}
