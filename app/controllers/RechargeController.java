package controllers;
import static play.data.Form.form;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import services.RechargeService;
import system.log.Logger;
import utils.CryptTool;
import bean.RechargeForm;
import bean.RuleForm;

import com.thoughtworks.xstream.XStream;

import entities.BnsRecharge;
import entities.BnsRule;
import entities.BnsWallet;
import external.alipay.alipaydirect.util.AlipaydirectBean;
import external.alipay.alipaydirect.util.AlipaydirectHtmlText;

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
		obj.setCreatedUser(CompanyController.getByToken(token).getId());
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
	public static Result saveRule(){
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		Form<RuleForm> form = form(RuleForm.class).bindFromRequest();
		if (form.hasErrors()) {
			return badRequest();
		} 
		RuleForm data = form.get();
		XStream xstream = new XStream();
		xstream.alias("request", RechargeForm.class);
		Logger.info("充值规则", xstream.toXML(data));
		BnsRule obj =new BnsRule();
		obj.setCz(data.getCz());
		obj.setZs(data.getZs());
		obj.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		rechargeService.saveRule(obj);
		vo.put("message", "保存成功");
		vo.put("code", 1);
		return ok(Json.toJson(vo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result list(){
		String token = request().getHeader("token");
		return ok(Json.toJson(rechargeService.listByToken(token)));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result rule(){
		return ok(Json.toJson(rechargeService.listRuleDesc()));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result delRule(Long id){
		rechargeService.delRule(id);
		return ok();
	}
	
	//根据订单编号获取订单
	public static void DirectNotify(String code){
		BnsRecharge obj =rechargeService.findByCode(code);
		if(obj!=null&&obj.getState()==0){
			obj.setState(1);
			//赠送金额
			BigDecimal vice =new BigDecimal(0);
			List<BnsRule> list =rechargeService.listRuleDesc();
			for(BnsRule t:list){
				if(obj.getActual().compareTo(t.getCz())==1){
					vice=t.getZs();
					break;
				}
			}
			obj.setAllowance(vice);
			rechargeService.save(obj);
			//获取对应机构钱包
			BnsWallet wallet =WalletController.walletService.get(obj.getCreatedUser());
			wallet.setHistory(wallet.getHistory().add(obj.getActual()).add(obj.getAllowance()));
			wallet.setMoney(wallet.getMoney().add(obj.getActual()));
			wallet.setVice(wallet.getVice().add(obj.getAllowance()));
			WalletController.walletService.save(wallet);
		}
	}
	

}
