package controllers;

import static play.data.Form.form;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
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
import bean.TempForm;

import com.thoughtworks.xstream.XStream;

import entities.BnsCompany;
import entities.BnsOrder;
import entities.BnsOrderChild;
import entities.BnsOrderTemp;
import entities.BnsService;
import entities.BnsWallet;
import enumeration.OrderStatus;
import external.alipay.alipaydirect.util.AlipaydirectBean;
import external.alipay.alipaydirect.util.AlipaydirectHtmlText;

@Controller
public class OrderController extends play.mvc.Controller {
	
	private static OrderService orderService;
	
	@Autowired
	@Qualifier("orderService")
	public void setOrderService(OrderService orderService) {
		OrderController.orderService = orderService;
	}
	
	@Security.Authenticated(Secured.class)
	public static Result temp() throws IllegalAccessException, InvocationTargetException, IOException{
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		Form<TempForm> form = form(TempForm.class).bindFromRequest();
		if (form.hasErrors()) {
			Logger.error("保存临时订单", form.toString());
			return status(403,Json.toJson(form.toString()));
		}
		TempForm data =form.get();
		XStream xstream = new XStream();
		xstream.alias("request", TempForm.class);
		Logger.info("保存临时订单", xstream.toXML(data));
		BnsOrderTemp temp =new BnsOrderTemp();
		BeanUtils.copyProperties(temp, data);
		temp.setId(CryptTool.getUUID());
		temp.setToken(request().getHeader("token"));
		temp.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		xstream.alias("temp", BnsOrderTemp.class);
		Logger.info("temp", xstream.toXML(temp));
		orderService.saveOrderTemp(temp);
		vo.put("code", 1);
		vo.put("message",temp.getId());
		return ok(Json.toJson(vo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result view(String id){
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		BnsOrderTemp temp =orderService.getOrderTemp(id);
		if(temp==null){
			vo.put("message", "查无此数据");
			return ok(Json.toJson(vo));
		}
		BnsCompany company =CompanyController.companyService.get(temp.getCompany());
		BnsService business =ServController.servService.get(temp.getBusiness());
		vo.put("city", company.getCity());
		vo.put("company", company.getName());
		vo.put("company_", company.getId());
		vo.put("business", business.getRemark());
		vo.put("site", temp.getSite());
		vo.put("hotel", temp.getHotel());
		vo.put("code", 1);
		vo.put("message", "success");
		return ok(Json.toJson(vo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result check(String company,String time){
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		BnsCompany obj =CompanyController.companyService.get(company);
		List<BnsOrder> list =orderService.findByCompanyAndTime(company,time);
		System.out.println("========"+list.size());
		vo.put("code", 1);
		vo.put("message", obj.getNum()>list.size()?true:false);
		return ok(Json.toJson(vo));
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
		BnsOrderTemp temp =orderService.getOrderTemp(data.getId());
		if(temp==null){
			vo.put("message", "数据验证失败");
			return ok(Json.toJson(vo));
		}
		BnsCompany company =CompanyController.companyService.get(temp.getCompany());
		BnsService business =ServController.servService.get(temp.getBusiness());
		BnsOrder order =new BnsOrder();
		order.setId(data.getId());
		order.setCode(CryptTool.getCode("C"));
		order.setCity(company.getCity());
		order.setTakeTime(Timestamp.valueOf(data.getTakeTime()));
		BnsCompany creator =CompanyController.getByToken(token);
		order.setCreatedUser(creator.getId());
		order.setCreatedUserName(creator.getName());
		order.setAcceptUser(company.getId());
		order.setAcceptUserName(company.getName());
		BigDecimal money =new BigDecimal(0);
		//加住宿费用
		money=money.add(temp.getHotelMoney());
		//景点费用
		money=money.add(temp.getSiteMoney());
		//套餐基本费用
		money=money.add(business.getMoney());
		//附加套餐费用
		BigDecimal fujia =business.getPrice().multiply(new BigDecimal(data.getNum()));
		order.setMoney(money.add(fujia));
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
		StringBuffer tc=new StringBuffer();
		tc.append("服装套数："+(business.getUnit()+data.getNum()));
		tc.append(",底片数量："+(business.getNum()+data.getNum()*business.getAdditional()));
		children.setCloth(tc.toString());
		children.setSite(temp.getSite());
		children.setHotel(temp.getHotel());
		children.setPickup(data.getPickup());
		children.setRemark(data.getRemark());
		children.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		orderService.saveOrderChildren(children);
		vo.put("code", 1);
		vo.put("orderCode", order.getCode());
		vo.put("money",order.getMoney());
		vo.put("tc", children.getCloth());
		vo.put("tcMoney", business.getMoney().add(fujia));
		vo.put("site", children.getSite());
		vo.put("siteMoney", temp.getSiteMoney());
		vo.put("hotel", children.getHotel());
		vo.put("hotelMoney", temp.getHotelMoney());
		return ok(Json.toJson(vo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result payment(String id,String type){
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		vo.put("type", type);
		BnsOrder order =orderService.get(id);
		if("余额".equals(type)){
			order.setPayment(type);
			order.setState(OrderStatus.Just_Doing.ordinal());
			BnsWallet wallet =WalletController.walletService.get(order.getAcceptUser());
			if(wallet.getMoney().compareTo(order.getMoney())==-1){
				vo.put("message", "余额不足");
				return ok(Json.toJson(vo));
			}
			wallet.setMoney(wallet.getMoney().subtract(order.getMoney()));
			WalletController.walletService.save(wallet);
		}
		if("支付宝".equals(type)){
			order.setPayment(type);
			order.setState(OrderStatus.Wait_Pay.ordinal());
			AlipaydirectBean bean =new AlipaydirectBean();
			bean.setExter_invoke_ip(BnsUtils.getClientIP(request()));
			bean.setOut_trade_no(order.getCode());
			bean.setTotal_fee(String.valueOf(order.getMoney()));
			bean.setSubject("服务费用");
			bean.setBody("服务费用");
			vo.put("message", new AlipaydirectHtmlText().getAlipaydirectHtmlText(bean));
		}
		vo.put("code", 1);
		orderService.saveOrder(order);
		//删除临时表对应记录
		orderService.delOrderTemp(id);
		return ok(Json.toJson(vo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result file(String id){
		BnsOrderChild  children =orderService.detail(id);
		if(children.getImgs()==null||"".equals(children.getImgs())){
			//附件名称跟订单ID订单子表ID相同
			children.setImgs(id);
			orderService.saveOrderChildren(children);
		}
		return ok();
	}
	
	@Security.Authenticated(Secured.class)
	public static Result zxr(String id,String cameraman,String dresser){
		Map<String,Object> vo =new HashMap<String,Object>();
		BnsOrder order =orderService.get(id);
		order.setCameraman(cameraman);
		order.setDresser(dresser);
		orderService.saveOrder(order);
		vo.put("code", 1);
		vo.put("message", "保存成功");
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
	public static Result over(String id){
		Map<String,Object> vo =new HashMap<String,Object>();
		vo.put("code", 0);
		String token = request().getHeader("token");
		BnsCompany company =CompanyController.getByToken(token);
		BnsOrder obj =orderService.get(id);
		if(obj==null){
			vo.put("message", "查无此订单");
			return ok(Json.toJson(vo));
		}
		if(!obj.getCreatedUser().equals(company.getId())){
			vo.put("message", "无效操作");
			return ok(Json.toJson(vo));
		}
		//状态变更为交易完成
		obj.setState(OrderStatus.Game_Over.ordinal());
		orderService.saveOrder(obj);
		//服务公司成交订单+1
		BnsCompany acceptCompany =CompanyController.companyService.get(obj.getAcceptUser());
		acceptCompany.setHistory(acceptCompany.getHistory()+1);
		CompanyController.companyService.save(acceptCompany);
		//更新服务公司账户金额
		BnsWallet wallet = WalletController.walletService.get(obj.getAcceptUser());
		wallet.setHistory(wallet.getHistory().add(obj.getMoney()));
		wallet.setMoney(wallet.getMoney().add(obj.getMoney()));
		WalletController.walletService.save(wallet);
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
