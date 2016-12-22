package controllers;
import static play.data.Form.form;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.thoughtworks.xstream.XStream;

import bean.DirectForm;
import entities.NotifyAlipay;
import play.data.Form;
import play.mvc.Result;
import services.NotifyService;
import system.log.Logger;

@Controller
public class NotifyController extends play.mvc.Controller {
	
	private static NotifyService notifyService;
	
	@Autowired
	@Qualifier("notifyService")
	public void setNotifyService(NotifyService notifyService) {
		NotifyController.notifyService = notifyService;
	}

	public static Result direct(){
		Logger.info("支付宝回调", "支付宝支付后回调");
		Form<DirectForm> form = form(DirectForm.class).bindFromRequest();
		if (form.hasErrors()) {
			return badRequest();
		} 
		DirectForm data = form.get();
		XStream xstream = new XStream();
		xstream.alias("request", DirectForm.class);
		Logger.info("支付宝回调", xstream.toXML(data));
		NotifyAlipay notify =new NotifyAlipay();
		notify.setOutTradeNo(data.getOut_trade_no());
		notify.setTradeNo(data.getTrade_no());
		notify.setTradeStatus(data.getTrade_status());
		notify.setBuyerEmail(data.getBuyer_email());
		notify.setBuyerId(data.getBuyer_id());
		notify.setNotifyId(data.getNotify_id());
		notify.setTotalFee(data.getTotal_fee());
		notify.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		notifyService.saveDirect(notify);
		//订单支付后回调
		OrderController.DirectNotify(data.getOut_trade_no());
		//充值后回调
		RechargeController.DirectNotify(data.getOut_trade_no());
		return ok();
	}
	

}
