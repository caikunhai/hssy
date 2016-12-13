package controllers;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import entities.BnsWallet;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import services.WalletService;

@Controller
public class WalletController extends play.mvc.Controller {
	
	private static WalletService walletService;
	
	@Autowired
	@Qualifier("walletService")
	public void setWalletService(WalletService walletService) {
		WalletController.walletService = walletService;
	}

	@Security.Authenticated(Secured.class)
	public static Result myWallet(){
		String token = request().getHeader("token");
		return ok(Json.toJson(getWallet(token.substring(0,64))));
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
		wallet.setState(0);
		wallet.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		walletService.save(wallet);
	}
	
	/**
	 * 获取钱包信息
	 * @param request
	 * @return
	 */
	public static BnsWallet getWallet(String userId){
		return walletService.get(userId);
	}
	
	/**
	 * 更新钱包
	 * @param userId
	 * @param money
	 * @return
	 */
	public static BnsWallet walletPlus(String userId,BigDecimal money){
		BnsWallet wallet = walletService.get(userId);
		if(wallet==null){
			return null;
		}
		wallet.setHistory(wallet.getHistory().add(money));
		wallet.setMoney(wallet.getMoney().add(money));
		walletService.save(wallet);
		return wallet;
	}
	
	public static Boolean walletMinus(String userId,BigDecimal money){
		BnsWallet wallet = walletService.get(userId);
		if(wallet==null){
			return false;
		}
		if(wallet.getMoney().compareTo(money)==-1){
			return false;
		}
		wallet.setMoney(wallet.getMoney().subtract(money));
		walletService.save(wallet);
		return true;
	}

}
