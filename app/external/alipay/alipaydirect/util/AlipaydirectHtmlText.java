package external.alipay.alipaydirect.util;

import java.util.HashMap;
import java.util.Map;

import system.init.Const;

import external.alipay.alipaydirect.config.AlipayConfig;

public class AlipaydirectHtmlText {
	
	public String getAlipaydirectHtmlText(AlipaydirectBean bean){
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", "create_direct_pay_by_user");
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
        //默认值为：1（商品购买）。
		sParaTemp.put("payment_type", "1");
		sParaTemp.put("notify_url", Const.NotifyUrl+"/notify/direct");
		sParaTemp.put("return_url", Const.NotifyUrl+"/pc_pay.html");
		sParaTemp.put("seller_email", "huangyz8@gdtel.com.cn");
		sParaTemp.put("out_trade_no", bean.getOut_trade_no());
		sParaTemp.put("subject", bean.getSubject());
		sParaTemp.put("total_fee",bean.getTotal_fee() );
		sParaTemp.put("body", bean.getBody());
		sParaTemp.put("show_url", Const.NotifyUrl);
		//防钓鱼时间戳  文档写可以为空
		sParaTemp.put("anti_phishing_key", "");
		sParaTemp.put("exter_invoke_ip", bean.getExter_invoke_ip());
		//建立请求支付
		return AlipaySubmit.buildRequest(sParaTemp,"post","确认");
	}

}
