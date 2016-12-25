package controllers;
import static play.data.Form.form;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import services.CashService;
import system.log.Logger;
import utils.BnsUtils;
import utils.CryptTool;
import utils.MD5Util;
import bean.CashCheckForm;
import bean.CashForm;

import com.thoughtworks.xstream.XStream;

import entities.BnsCash;
import entities.BnsUser;
import entities.BnsWallet;

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
		//验证支付密码
		BnsUser userObj =UserController.userService.findByToken(token);
		if(userObj==null){
			vo.put("message", "非法操作");
			return ok(Json.toJson(vo));
		}
		if(!userObj.getSecret().equals(MD5Util.encode(data.getCode()))){
			vo.put("message", "支付密码错误");
			return ok(Json.toJson(vo));
		}
		//调出对应机构钱包
		BnsWallet wallet =WalletController.walletService.get(userObj.getCompany());
		if(data.getMoney().compareTo(wallet.getMoney())==1){
			vo.put("message", "提取金额不足");
			return ok(Json.toJson(vo));
		}
		wallet.setMoney(wallet.getMoney().subtract(data.getMoney()));
		WalletController.walletService.save(wallet);
		//插入提现记录
		BnsCash obj =new BnsCash();
		obj.setId(CryptTool.getUUID());
		obj.setCode(CryptTool.getCode("C"));
		obj.setMoney(data.getMoney());
		obj.setType(0);
		obj.setCreatedUser(userObj.getCompany());
		obj.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		cashService.save(obj);
		vo.put("code", 1);
		vo.put("message", "保存成功");
		return ok(Json.toJson(vo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result list(){
		String token = request().getHeader("token");
		return ok(Json.toJson(cashService.listByToken(token)));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result all(){
		return ok(Json.toJson(cashService.listByAdmin()));
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
		obj.setType(data.getType());
		//提现审核人存储用户ID
		obj.setCheckedUser(BnsUtils.getId(token));
		obj.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		cashService.save(obj);
		//审核失败对应机构账户提现金额回滚
		if(data.getType()==2){
			BnsWallet wallet =WalletController.walletService.get(obj.getCreatedUser());
			wallet.setMoney(wallet.getMoney().add(obj.getMoney()));
			WalletController.walletService.save(wallet);
		}
		vo.put("code", 1);
		vo.put("message", "操作成功");
		return ok(Json.toJson(vo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result delete(String id){
		cashService.delete(id);
		return ok();
	}
	

}
