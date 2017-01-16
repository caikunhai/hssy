package controllers;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import entities.BnsWorks;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import services.WorkService;
import utils.CryptTool;

@Controller
public class WorksController extends play.mvc.Controller {
	
	public static WorkService workService;
	
	@Autowired
	@Qualifier("workService")
	public void setWorkService(WorkService workService) {
		WorksController.workService = workService;
	}

	@Security.Authenticated(Secured.class)
	public static Result save(String filename){
		String token = request().getHeader("token");
		String company =CompanyController.getByToken(token).getId();
		BnsWorks obj=new BnsWorks();
		obj.setId(CryptTool.getUUID());
		obj.setCompany(company);
		obj.setFilename(filename);
		obj.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		workService.save(obj);
		return ok(Json.toJson(obj));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result delete(String id){
		workService.delete(id);
		return ok();
	}
	
	@Security.Authenticated(Secured.class)
	public static Result list(String company){
		return ok(Json.toJson(workService.listByCompany(company)));
	}
	
}
