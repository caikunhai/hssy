package external.alipay;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import system.log.Logger;
import utils.HttpResult;
import utils.HttpUtils;

import external.alipay.alipaydirect.config.AlipayConfig;

public class AlipayNotify {
	/*
	* HTTPS形式消息验证地址  
    */  
   private static final String HTTPS_VERIFY_URL = "https://www.alipay.com/cooperate/gateway.do?service=notify_verify&"; 
   
   /**  
    * 获取远程服务器ATN结果,验证返回URL
    * @param notify_id 通知校验ID 
    * @return 服务器ATN结果
    * 验证结果集：
    * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空
    * true 返回正确信息
    * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
    */  
   public static String verifyResponse(String notify_id) {
        //获取远程服务器ATN结果，验证是否是支付宝服务器发来的请求  
        String partner = AlipayConfig.partner;
        String url =HTTPS_VERIFY_URL+"partner=" + partner + "&notify_id=" + notify_id;
        System.out.println(url);
		try {
			HttpResult httpResult = HttpUtils.get(url);
			return httpResult.getMessage();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			Logger.error("AlipayNotify", e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Logger.error("AlipayNotify", e.getMessage());
		}
		Logger.error("AlipayNotify", notify_id+"未经过验证");
		return null;
    } 

}
