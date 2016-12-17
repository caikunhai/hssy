package controllers;
import static play.data.Form.form;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.thoughtworks.xstream.XStream;

import bean.CashCheckForm;
import bean.CashForm;
import entities.BnsCash;
import entities.BnsUser;
import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import services.CashService;
import system.log.Logger;
import utils.BnsUtils;
import utils.CryptTool;

@Controller
public class CashController extends play.mvc.Controller {
	
	private static CashService cashService;

	@Autowired
	@Qualifier("cashService")
	public void setCashService(CashService cashService) {
		CashController.cashService = cashService;
	}
	
	@Security.Authenticated(Secured.class)
	public static Result save(){
		String token = request().getHeader("token");
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		Form<CashForm> form = form(CashForm.class).bindFromRequest();
		if (form.hasErrors()) {
			Logger.error("提现申请", form.toString());
			return status(403,Json.toJson(form.toString()));
		}
		CashForm data =form.get();
		XStream xstream = new XStream();
		xstream.alias("request", CashForm.class);
		Logger.info("提现申请", xstream.toXML(data));
		if(!UserController.checkCode(BnsUtils.getId(token), data.getCode())){
			vo.put("message", "密码不对");
			return ok(Json.toJson(vo));
		}
		if(!WalletController.walletMinus(BnsUtils.getId(token), data.getMoney())){
			vo.put("message", "提现失败");
			return ok(Json.toJson(vo));
		}
		BnsCash obj =new BnsCash();
		obj.setId(CryptTool.getUUID());
		obj.setCode(CryptTool.getCode("C"));
		obj.setMoney(data.getMoney());
		obj.setType(0);
		obj.setCreatedUser(BnsUtils.getId(token));
		obj.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		cashService.save(obj);
		vo.put("code", 1);
		vo.put("message", "保存成功");
		return ok(Json.toJson(vo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result list(){
		String token = request().getHeader("token");
		List<Object> list =new ArrayList<Object>();
		Iterable<BnsCash> itr =cashService.list();
		Iterator<BnsCash> it =itr.iterator();
		while(it.hasNext()){
			BnsCash obj =it.next();
			if(obj.getCreatedUser().equals(BnsUtils.getId(token))){
				list.add(obj);
			}
		}
		return ok(Json.toJson(list));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result all(){
		//Map<String, BnsUser> map =UserController.userMap();
		List<Object> list =new ArrayList<Object>();
		Iterable<BnsCash> itr =cashService.list();
		Iterator<BnsCash> it =itr.iterator();
		while(it.hasNext()){
			BnsCash obj =it.next();
		//	obj.setCreatedUser(map.get(obj.getCreatedUser()).getUsername());
		//	obj.setCheckedUser(obj.getCheckedUser()==null?"":map.get(obj.getCheckedUser()).getUsername());
			list.add(obj);
		}
		return ok(Json.toJson(list));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result check(){
		String token = request().getHeader("token");
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		Form<CashCheckForm> form = form(CashCheckForm.class).bindFromRequest();
		if (form.hasErrors()) {
			Logger.error("提现审核", form.toString());
			return status(403,Json.toJson(form.toString()));
		}
		CashCheckForm data =form.get();
		XStream xstream = new XStream();
		xstream.alias("request", CashCheckForm.class);
		Logger.info("提现审核", xstream.toXML(data));
		BnsCash obj =cashService.get(data.getId());
		if(obj==null){
			vo.put("message", "查无此记录");
			return ok(Json.toJson(vo));
		}
		obj.setCheckedUser(BnsUtils.getId(token));
		obj.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		cashService.save(obj);
		vo.put("code", 1);
		vo.put("message", "操作成功");
		return ok(Json.toJson(vo));
	}
	

}
