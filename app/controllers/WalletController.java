package controllers;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import services.WalletService;
import entities.BnsWallet;

@Controller
public class WalletController extends play.mvc.Controller {
	
	public static WalletService walletService;
	
	@Autowired
	@Qualifier("walletService")
	public void setWalletService(WalletService walletService) {
		WalletController.walletService = walletService;
	}

	@Security.Authenticated(Secured.class)
	public static Result myWallet(){
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		String token = request().getHeader("token");
		BnsWallet wallet =walletService.getWalletByToken(token);
		if(wallet==null){
			vo.put("message", "查无此账户");
			return ok(Json.toJson(vo));
		}
		vo.put("code", 1);
		vo.put("message", wallet);
		return ok(Json.toJson(vo));
	}
	
	/**
	 * 创建钱包
	 * @param userId
	 */
	public static void createWallet(String company){
		BnsWallet wallet =new BnsWallet();
		wallet.setId(company);
		wallet.setHistory(new BigDecimal(0));
		wallet.setMoney(new BigDecimal(0));
		wallet.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		walletService.save(wallet);
	}
	
}
