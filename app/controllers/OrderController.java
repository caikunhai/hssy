package controllers;

import static play.data.Form.form;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.ArrayList;
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
import services.OrderService;
import system.log.Logger;
import utils.BnsUtils;
import utils.CryptTool;
import bean.OrderAddForm;
import bean.OrderImgForm;
import bean.OrderNextForm;

import com.thoughtworks.xstream.XStream;

import entities.BnsCompany;
import entities.BnsOrder;
import entities.BnsOrderChild;
import enumeration.OrderStatus;

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
		order.setId(CryptTool.getUUID());
		order.setCode(CryptTool.getCode("C"));
		order.setCity(data.getCity());
		order.setTakeTime(Timestamp.valueOf(data.getTakeTime()));
		BnsCompany creator =CompanyController.getByToken(token);
		order.setCreatedUser(creator.getId());
		order.setCreatedUserName(creator.getName());
		BnsCompany accept =CompanyController.Obj(data.getAcceptUser());
		order.setAcceptUser(data.getAcceptUser());
		order.setAcceptUserName(accept.getName());
		order.setMoney(data.getMoney());
		order.setState(OrderStatus.Wait_Pay.ordinal());
		order.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		xstream.alias("order", BnsOrder.class);
		Logger.info("order", xstream.toXML(order));
		orderService.saveOrder(order);
		BnsOrderChild children=new BnsOrderChild();
		//让子ID跟父ID相同
		children.setId(order.getId());
		children.setCustomer(data.getCustomer());
		children.setIdcard(data.getIdcard());
		children.setMobile(data.getMobile());
		children.setPeople(data.getPeople());
		children.setCloth(data.getCloth());
		children.setSite(data.getSite());
		children.setHotel(data.getHotel());
		children.setPickup(data.getPickup());
		children.setRemark(data.getRemark());
		children.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		orderService.saveOrderChildren(children);
		vo.put("code", 1);
		vo.put("id", order.getId());
		vo.put("orderCode", order.getCode());
		vo.put("money",order.getMoney());
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
			if("over".equals(progress)&&obj.getState()==OrderStatus.Game_Over.ordinal()){
				list.add(obj);
			}
			if("progress".equals(progress)&&obj.getState()==OrderStatus.Just_Doing.ordinal()){
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
			if("over".equals(progress)&&obj.getState()==OrderStatus.Game_Over.ordinal()){
				list.add(obj);
			}
			if("progress".equals(progress)&&obj.getState()==OrderStatus.Just_Doing.ordinal()){
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
	
	//根据订单编号获取订单
	public static void DirectNotify(String code){
		BnsOrder order =orderService.findByCode(code);
		if(order!=null&&order.getState()==OrderStatus.Wait_Pay.ordinal()){
			order.setState(OrderStatus.Just_Doing.ordinal());
			orderService.saveOrder(order);
		}
	}
	
	public static BnsOrder getOderObj(String id){
		return orderService.get(id);
	}
	
	public static List<BnsOrder> unFinish(String token){
		List<BnsOrder> list =new ArrayList<BnsOrder>();
		List<BnsOrder> all =orderService.listByServerToken(CompanyController.getByToken(token).getId());
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
