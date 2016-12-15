package controllers;

import static play.data.Form.form;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.thoughtworks.xstream.XStream;

import bean.OrderAddForm;
import bean.OrderImgForm;
import bean.OrderNextForm;
import bean.OrderStatus;
import bean.PayForm;
import entities.BnsCompany;
import entities.BnsOrder;
import external.alipay.alipaydirect.util.AlipaydirectBean;
import external.alipay.alipaydirect.util.AlipaydirectHtmlText;
import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import services.OrderService;
import system.log.Logger;
import utils.BnsUtils;
import utils.CryptTool;

@Controller
public class OrderController extends play.mvc.Controller {
	
	private static OrderService orderService;
	
	@Autowired
	@Qualifier("orderService")
	public void setOrderService(OrderService orderService) {
		OrderController.orderService = orderService;
	}
	
	@Security.Authenticated(Secured.class)
	public static Result save() throws IllegalAccessException, InvocationTargetException, IOException{
		String token = request().getHeader("token");
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		Form<OrderAddForm> form = form(OrderAddForm.class).bindFromRequest();
		if (form.hasErrors()) {
			Logger.error("保存订单", form.toString());
			return status(403,Json.toJson(form.toString()));
		}
		OrderAddForm data =form.get();
		XStream xstream = new XStream();
		xstream.alias("request", OrderAddForm.class);
		Logger.info("保存订单", xstream.toXML(data));
		BnsOrder order =new BnsOrder();
		BeanUtils.copyProperties(order, data);
		order.setId(CryptTool.getUUID());
		order.setCode(CryptTool.getCode("C"));
		order.setCreatedUser(BnsUtils.getId(token));
		order.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		order.setState(OrderStatus.Wait_Pay.ordinal());
		xstream.alias("order", BnsOrder.class);
		Logger.info("order", xstream.toXML(order));
		orderService.saveOrder(order);
		vo.put("code", 1);
		vo.put("id", order.getId());
		vo.put("orderCode", order.getCode());
		vo.put("money",order.getMoney());
		return ok(Json.toJson(vo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result pay() throws IllegalAccessException, InvocationTargetException, IOException{
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		Form<PayForm> form = form(PayForm.class).bindFromRequest();
		if (form.hasErrors()) {
			Logger.error("订单支付", form.toString());
			return status(403,Json.toJson(form.toString()));
		}
		PayForm data =form.get();
		XStream xstream = new XStream();
		xstream.alias("request", PayForm.class);
		Logger.info("订单支付", xstream.toXML(data));
		BnsOrder obj =orderService.get(data.getId());
		if(obj==null){
			vo.put("message", "查无此订单");
			return ok(Json.toJson(vo));
		}
		obj.setPayment(data.getPayment());
		if("支付宝".equals(data.getPayment())){
			//待支付
			obj.setState(OrderStatus.Wait_Pay.ordinal());
			AlipaydirectBean directBean =new AlipaydirectBean();
			directBean.setOut_trade_no(obj.getCode());
			directBean.setSubject("测试");
			directBean.setTotal_fee(String.valueOf(obj.getMoney()));
			directBean.setBody("测试");
			String directHtmlText = new AlipaydirectHtmlText().getAlipaydirectHtmlText(directBean);
			vo.put("message", directHtmlText);
		}
		if("余额".equals(data.getPayment())){
			obj.setState(OrderStatus.Wait_Receive.ordinal());
			if(!WalletController.walletMinus(obj.getCreatedUser(), obj.getMoney())){
				vo.put("message", "余额不足");
				return ok(Json.toJson(vo));
			}
			vo.put("message", "支付成功");
		}
		vo.put("code", 1);
		orderService.saveOrder(obj);
		return ok(Json.toJson(vo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result accept(String orderId){
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		String token = request().getHeader("token");
		String id =BnsUtils.getId(token);
		BnsOrder obj =orderService.get(orderId);
		if(obj==null){
			vo.put("message", "查无此订单");
			return ok(Json.toJson(vo));
		}
		if(!obj.getAcceptUser().equals(id)){
			vo.put("message", "无效操作");
			return ok(Json.toJson(vo));
		}
		//状态变更为进行中
		obj.setState(OrderStatus.Just_Doing.ordinal());
		orderService.saveOrder(obj);
		vo.put("code", 1);
		vo.put("message", "操作成功");
		return ok(Json.toJson(vo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result cancel(String orderId){
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		String token = request().getHeader("token");
		String id =BnsUtils.getId(token);
		BnsOrder obj =orderService.get(orderId);
		if(obj==null){
			vo.put("message", "查无此订单");
			return ok(Json.toJson(vo));
		}
		//状态变更为进行中
		obj.setState(OrderStatus.Game_Close.ordinal());
		orderService.saveOrder(obj);
		//账户金额累加
		WalletController.walletPlus(id, obj.getMoney());
		vo.put("code", 1);
		vo.put("message", "操作成功");
		return ok(Json.toJson(vo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result next(){
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		Form<OrderNextForm> form = form(OrderNextForm.class).bindFromRequest();
		if (form.hasErrors()) {
			Logger.error("更新状态", form.toString());
			return status(403,Json.toJson(form.toString()));
		}
		OrderNextForm data =form.get();
		XStream xstream = new XStream();
		xstream.alias("request", OrderNextForm.class);
		Logger.info("更新状态", xstream.toXML(data));
		BnsOrder order =orderService.get(data.getId());
		if(order==null){
			vo.put("message", "查无此订单");
			return ok(Json.toJson(vo));
		}
		order.setState(data.getState());
		xstream.alias("order", BnsOrder.class);
		Logger.info("order", xstream.toXML(order));
		orderService.saveOrder(order);
		vo.put("code", 1);
		vo.put("message", "操作成功");
		return ok(Json.toJson(vo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result imgs(){
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		Form<OrderImgForm> form = form(OrderImgForm.class).bindFromRequest();
		if (form.hasErrors()) {
			Logger.error("添加照片", form.toString());
			return status(403,Json.toJson(form.toString()));
		}
		OrderImgForm data =form.get();
		XStream xstream = new XStream();
		xstream.alias("request", OrderImgForm.class);
		Logger.info("添加照片", xstream.toXML(data));
		BnsOrder order =orderService.get(data.getId());
		if(order==null){
			vo.put("message", "查无此订单");
			return ok(Json.toJson(vo));
		}
		xstream.alias("order", BnsOrder.class);
		Logger.info("order", xstream.toXML(order));
		orderService.saveOrder(order);
		vo.put("code", 1);
		vo.put("message", "添加成功");
		return ok(Json.toJson(vo));
	}
	
	
	@Security.Authenticated(Secured.class)
	public static Result find(String identity,String progress){
		String token = request().getHeader("token");
		if("host".equals(identity)){
			return host(token,progress);
		}
		if("server".equals(identity)){
			return server(token,progress);
		}
		return ok();
	}
	
	//服务商订单查询
	public static Result server(String token,String progress){
		List<Object> list =new ArrayList<Object>();
		List<BnsOrder> all =orderService.listByServerToken(token);
		for(BnsOrder obj:all){
			if("over".equals(progress)&&(obj.getState()==OrderStatus.Game_Over.ordinal()||obj.getState()==OrderStatus.Game_Close.ordinal())){
				list.add(obj);
			}
			if("process".equals(progress)&&obj.getState()<3){
				list.add(obj);
			}
			
		}
		return ok(Json.toJson(list));
	}
	
	//服务商订单查询
	public static Result host(String token,String progress){
		List<Object> list =new ArrayList<Object>();
		List<BnsOrder> all =orderService.listByHostToken(token);
		for(BnsOrder obj:all){
			if("over".equals(progress)&&(obj.getState()==OrderStatus.Game_Over.ordinal()||obj.getState()==OrderStatus.Game_Close.ordinal())){
				list.add(obj);
			}
			if("process".equals(progress)&&obj.getState()<3){
				list.add(obj);
			}
				
		}
		return ok(Json.toJson(list));
	}
	
	
	@Security.Authenticated(Secured.class)
	public static Result over(String orderId){
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		String token = request().getHeader("token");
		String id =BnsUtils.getId(token);
		BnsOrder obj =orderService.get(orderId);
		if(obj==null){
			vo.put("message", "查无此订单");
			return ok(Json.toJson(vo));
		}
		if(!obj.getCreatedUser().equals(id)){
			vo.put("message", "无效操作");
			return ok(Json.toJson(vo));
		}
		if(obj.getState()!=OrderStatus.Wait_Download.ordinal()){
			vo.put("message", "无效操作");
			return ok(Json.toJson(vo));
		}
		//状态变更为交易完成
		obj.setState(OrderStatus.Game_Over.ordinal());
		orderService.saveOrder(obj);
		//服务公司成交订单+1
		CompanyController.companyHistoryOrderPlus(obj.getAcceptUser());
		//账户金额累加
		WalletController.walletPlus(obj.getAcceptUser(), obj.getMoney());
		vo.put("code", 1);
		vo.put("message", "操作成功");
		return ok(Json.toJson(vo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result detail(String id){
		return ok(Json.toJson(orderService.detail(id)));
	}
	
	
	
	private static Map<String,Object> Obj2Map4List(BnsOrder obj){
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("id", obj.getId());
		map.put("code", obj.getCode());
		map.put("city", obj.getCity());
		map.put("takeTime", new SimpleDateFormat("yyyy-MM-dd").format(obj.getTakeTime()));
		/*map.put("customer", obj.getCustomer());
		map.put("idcard", obj.getIdcard());
		map.put("mobile", obj.getMobile());
		map.put("people", obj.getPeople());
		map.put("pickup", obj.getPickup()==1?"接送":"不接送");
		map.put("state", BnsUtils.stateName(obj.getState()));
		map.put("remark", obj.getRemark());*/
		map.put("money", obj.getMoney());
		map.put("createdTime", new SimpleDateFormat("yyyy-MM-dd").format(obj.getCreatedTime()));
		return map;
	}
	
	private static Map<String,Object> Obj2Map4Detail(BnsOrder obj){
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("id", obj.getId());
		map.put("code", obj.getCode());
		map.put("city", obj.getCity());
		map.put("takeTime", new SimpleDateFormat("yyyy-MM-dd").format(obj.getTakeTime()));
		BnsCompany company =CompanyController.Obj(obj.getCreatedUser());
		/*map.put("createdUser", company.getCompany());
		map.put("createdAddress", company.getAddress());
		map.put("createdMobile", company.getMobile());
		map.put("customer", obj.getCustomer());
		map.put("idcard", obj.getIdcard());
		map.put("mobile", obj.getMobile());
		map.put("people", obj.getPeople());
		map.put("cloth", obj.getCloth());
		map.put("site", obj.getSite());
		map.put("hotel", obj.getHotel());*/
		map.put("money", obj.getMoney());
		map.put("payment", obj.getPayment());
		/*map.put("pickup", obj.getPickup()==1?"接送":"不接送");
		BnsCompany accept =CompanyController.Obj(obj.getAcceptUser());
		map.put("acceptUser", accept.getCompany());
		map.put("acceptAddress", accept.getAddress());
		map.put("acceptMobile", accept.getMobile());
		map.put("state", obj.getState());
		map.put("remark", obj.getRemark());*/
		map.put("createdTime", new SimpleDateFormat("yyyy-MM-dd").format(obj.getCreatedTime()));
		return map;
	}
	
	//根据订单编号获取订单
	public static void DirectNotify(String code){
		BnsOrder order =orderService.findByCode(code);
		if(order!=null&&order.getState()==OrderStatus.Wait_Pay.ordinal()){
			order.setState(OrderStatus.Wait_Receive.ordinal());
			orderService.saveOrder(order);
		}
	}
	
	public static BnsOrder getOderObj(String id){
		return orderService.get(id);
	}
	
	public static List<BnsOrder> unFinish(String token){
		List<BnsOrder> list =new ArrayList<BnsOrder>();
		List<BnsOrder> all =orderService.listByServerToken(UserController.companyId(token));
		for(BnsOrder obj:all){
			if(obj.getState()==0){
				continue;
			}
			if(obj.getState()>3){
				continue;
			}
			if(!obj.getAcceptUser().equals(BnsUtils.getId(token))){
				continue;
			}
			list.add(obj);
		}
		return list;
	}
	
	
}
