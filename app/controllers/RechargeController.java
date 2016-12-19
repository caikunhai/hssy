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

import bean.RechargeForm;
import entities.BnsRecharge;
import entities.BnsUser;
import external.alipay.alipaydirect.util.AlipaydirectBean;
import external.alipay.alipaydirect.util.AlipaydirectHtmlText;
import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import services.RechargeService;
import system.log.Logger;
import utils.BnsUtils;
import utils.CryptTool;

@Controller
public class RechargeController extends play.mvc.Controller {
	
	private static RechargeService rechargeService;

	@Autowired
	@Qualifier("rechargeService")
	public void setRechargeService(RechargeService rechargeService) {
		RechargeController.rechargeService = rechargeService;
	}
	
	@Security.Authenticated(Secured.class)
	public static Result create(){
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		String token = request().getHeader("token");
		Form<RechargeForm> form = form(RechargeForm.class).bindFromRequest();
		if (form.hasErrors()) {
			return badRequest();
		} 
		RechargeForm data = form.get();
		XStream xstream = new XStream();
		xstream.alias("request", RechargeForm.class);
		Logger.info("账户充值", xstream.toXML(data));
		BnsRecharge obj =new BnsRecharge();
		obj.setId(CryptTool.getUUID());
		obj.setCode(CryptTool.getCode("R"));
		obj.setActual(data.getActual());
		obj.setState(0);
		obj.setCreatedUser(BnsUtils.getId(token));
		obj.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		rechargeService.save(obj);
		AlipaydirectBean directBean =new AlipaydirectBean();
		directBean.setOut_trade_no(obj.getCode());
		directBean.setSubject("充值");
		directBean.setTotal_fee(String.valueOf(obj.getActual()));
		directBean.setBody("充值");
		String directHtmlText = new AlipaydirectHtmlText().getAlipaydirectHtmlText(directBean);
		vo.put("message", directHtmlText);
		vo.put("code", 1);
		return ok(Json.toJson(vo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result save(){
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		String token = request().getHeader("token");
		Form<RechargeForm> form = form(RechargeForm.class).bindFromRequest();
		if (form.hasErrors()) {
			return badRequest();
		} 
		RechargeForm data = form.get();
		XStream xstream = new XStream();
		xstream.alias("request", RechargeForm.class);
		Logger.info("充值到账", xstream.toXML(data));
		BnsRecharge obj =rechargeService.get(data.getId());
		if(obj==null){
			vo.put("message", "查无此记录");
			return ok(Json.toJson(vo));
		}
		obj.setState(1);
		obj.setAllowance(data.getAllowance());
		obj.setCheckedUser(BnsUtils.getId(token));
		obj.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		rechargeService.save(obj);
		//更新钱包账户
		WalletController.walletPlus(obj.getCreatedUser(), obj.getActual().add(obj.getAllowance()));
		vo.put("message", "操作成功");
		vo.put("code", 1);
		return ok(Json.toJson(vo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result list(){
		String token = request().getHeader("token");
		List<Object> list =new ArrayList<Object>();
		Iterable<BnsRecharge> itr =rechargeService.list();
		Iterator<BnsRecharge> it =itr.iterator();
		while(it.hasNext()){
			BnsRecharge obj=it.next();
			if(obj.getCreatedUser().equals(BnsUtils.getId(token))){
				list.add(obj);
			}
		}
		return ok(Json.toJson(list));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result all(){
		List<Object> list =new ArrayList<Object>();
		/*Map<String, BnsUser> userMap =UserController.userMap();
		Iterable<BnsRecharge> itr =rechargeService.list();
		Iterator<BnsRecharge> it =itr.iterator();
		while(it.hasNext()){
			BnsRecharge obj=it.next();
			obj.setCreatedUser(userMap.get(obj.getCreatedUser()).getUsername());
			obj.setCheckedUser(obj.getCheckedUser()==null?"":userMap.get(obj.getCheckedUser()).getUsername());
			list.add(obj);
		}*/
		return ok(Json.toJson(list));
	}
	
	//根据订单编号获取订单
	public static void DirectNotify(String code){
		BnsRecharge obj =rechargeService.findByCode(code);
		if(obj!=null&&obj.getState()==0){
			obj.setState(1);
			rechargeService.save(obj);
		}
	}
	

}
