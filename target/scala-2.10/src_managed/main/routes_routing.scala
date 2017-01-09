// @SOURCE:D:/workspace/hssy/conf/routes
// @HASH:349b003e7211a1983100107d562f3a12235f7e86
// @DATE:Thu Jan 05 22:30:32 CST 2017


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix  
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" } 


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_Application_uptoken1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sys/uptoken"))))
        

// @LINE:8
private[this] lazy val controllers_Application_role2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("menu/role"))))
        

// @LINE:9
private[this] lazy val controllers_Application_listMenu3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("menu/list"))))
        

// @LINE:10
private[this] lazy val controllers_SysController_upload4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("file/upload"))))
        

// @LINE:11
private[this] lazy val controllers_SysController_listFile5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("file/list"))))
        

// @LINE:12
private[this] lazy val controllers_SysController_delFile6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("file/delete"))))
        

// @LINE:13
private[this] lazy val controllers_SysController_get7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("file/get"))))
        

// @LINE:14
private[this] lazy val controllers_SysController_download8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("file/download"))))
        

// @LINE:15
private[this] lazy val controllers_SysController_unFinish9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("file/doing"))))
        

// @LINE:18
private[this] lazy val controllers_SiteController_list10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("site/list"))))
        

// @LINE:19
private[this] lazy val controllers_SiteController_all11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("site/all"))))
        

// @LINE:20
private[this] lazy val controllers_SiteController_site12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("site/get"))))
        

// @LINE:21
private[this] lazy val controllers_SiteController_save13 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("site/save"))))
        

// @LINE:23
private[this] lazy val controllers_HotelController_list14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("hotel/list"))))
        

// @LINE:24
private[this] lazy val controllers_HotelController_all15 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("hotel/all"))))
        

// @LINE:25
private[this] lazy val controllers_HotelController_hotel16 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("hotel/get"))))
        

// @LINE:26
private[this] lazy val controllers_HotelController_save17 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("hotel/save"))))
        

// @LINE:28
private[this] lazy val controllers_ClothController_list18 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cloth/list"))))
        

// @LINE:29
private[this] lazy val controllers_ClothController_all19 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cloth/all"))))
        

// @LINE:30
private[this] lazy val controllers_ClothController_cloth20 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cloth/get"))))
        

// @LINE:31
private[this] lazy val controllers_ClothController_save21 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cloth/save"))))
        

// @LINE:33
private[this] lazy val controllers_UserController_menu22 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/menu"))))
        

// @LINE:34
private[this] lazy val controllers_UserController_login23 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/login"))))
        

// @LINE:35
private[this] lazy val controllers_UserController_password24 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/password"))))
        

// @LINE:36
private[this] lazy val controllers_UserController_code25 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/code"))))
        

// @LINE:37
private[this] lazy val controllers_UserController_save26 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/save"))))
        

// @LINE:38
private[this] lazy val controllers_UserController_list27 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/list"))))
        

// @LINE:39
private[this] lazy val controllers_UserController_get28 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/get"))))
        

// @LINE:41
private[this] lazy val controllers_CompanyController_save29 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("company/save"))))
        

// @LINE:42
private[this] lazy val controllers_CompanyController_list30 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("company/list"))))
        

// @LINE:43
private[this] lazy val controllers_CompanyController_simple31 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("company/simple"))))
        

// @LINE:44
private[this] lazy val controllers_CompanyController_search32 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("company/search"))))
        

// @LINE:45
private[this] lazy val controllers_CompanyController_get33 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("company/get"))))
        

// @LINE:46
private[this] lazy val controllers_CompanyController_info34 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("company/info"))))
        

// @LINE:47
private[this] lazy val controllers_CompanyController_change35 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("company/change"))))
        

// @LINE:49
private[this] lazy val controllers_CashController_save36 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cash/save"))))
        

// @LINE:50
private[this] lazy val controllers_CashController_list37 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cash/list"))))
        

// @LINE:51
private[this] lazy val controllers_CashController_all38 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cash/all"))))
        

// @LINE:52
private[this] lazy val controllers_CashController_check39 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cash/check"))))
        

// @LINE:53
private[this] lazy val controllers_CashController_delete40 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cash/delete"))))
        

// @LINE:55
private[this] lazy val controllers_WalletController_myWallet41 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("wallet/get"))))
        

// @LINE:57
private[this] lazy val controllers_RechargeController_create42 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recharge/create"))))
        

// @LINE:58
private[this] lazy val controllers_RechargeController_list43 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recharge/list"))))
        

// @LINE:60
private[this] lazy val controllers_RechargeController_rule44 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rule/list"))))
        

// @LINE:61
private[this] lazy val controllers_RechargeController_saveRule45 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rule/save"))))
        

// @LINE:62
private[this] lazy val controllers_RechargeController_delRule46 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rule/delete"))))
        

// @LINE:64
private[this] lazy val controllers_OrderController_save47 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("order/save"))))
        

// @LINE:65
private[this] lazy val controllers_OrderController_find48 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("order/find"))))
        

// @LINE:66
private[this] lazy val controllers_OrderController_detail49 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("order/detail"))))
        

// @LINE:67
private[this] lazy val controllers_OrderController_over50 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("order/over"))))
        

// @LINE:68
private[this] lazy val controllers_OrderController_file51 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("order/file"))))
        

// @LINE:69
private[this] lazy val controllers_OrderController_payment52 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("order/payment"))))
        

// @LINE:70
private[this] lazy val controllers_OrderController_zxr53 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("order/zxr"))))
        

// @LINE:73
private[this] lazy val controllers_NotifyController_direct54 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("notify/direct"))))
        

// @LINE:76
private[this] lazy val controllers_Assets_at55 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sys/uptoken""","""controllers.Application.uptoken()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """menu/role""","""controllers.Application.role()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """menu/list""","""controllers.Application.listMenu()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """file/upload""","""controllers.SysController.upload(filename:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """file/list""","""controllers.SysController.listFile(company:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """file/delete""","""controllers.SysController.delFile(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """file/get""","""controllers.SysController.get(name:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """file/download""","""controllers.SysController.download(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """file/doing""","""controllers.SysController.unFinish(token:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """site/list""","""controllers.SiteController.list()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """site/all""","""controllers.SiteController.all()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """site/get""","""controllers.SiteController.site(id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """site/save""","""controllers.SiteController.save()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """hotel/list""","""controllers.HotelController.list()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """hotel/all""","""controllers.HotelController.all()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """hotel/get""","""controllers.HotelController.hotel(id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """hotel/save""","""controllers.HotelController.save()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cloth/list""","""controllers.ClothController.list()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cloth/all""","""controllers.ClothController.all()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cloth/get""","""controllers.ClothController.cloth(id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cloth/save""","""controllers.ClothController.save()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/menu""","""controllers.UserController.menu()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/login""","""controllers.UserController.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/password""","""controllers.UserController.password()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/code""","""controllers.UserController.code()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/save""","""controllers.UserController.save()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/list""","""controllers.UserController.list()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/get""","""controllers.UserController.get(id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """company/save""","""controllers.CompanyController.save()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """company/list""","""controllers.CompanyController.list()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """company/simple""","""controllers.CompanyController.simple()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """company/search""","""controllers.CompanyController.search(city:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """company/get""","""controllers.CompanyController.get(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """company/info""","""controllers.CompanyController.info()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """company/change""","""controllers.CompanyController.change(id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cash/save""","""controllers.CashController.save()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cash/list""","""controllers.CashController.list()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cash/all""","""controllers.CashController.all()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cash/check""","""controllers.CashController.check()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cash/delete""","""controllers.CashController.delete(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """wallet/get""","""controllers.WalletController.myWallet()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recharge/create""","""controllers.RechargeController.create()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recharge/list""","""controllers.RechargeController.list()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rule/list""","""controllers.RechargeController.rule()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rule/save""","""controllers.RechargeController.saveRule()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rule/delete""","""controllers.RechargeController.delRule(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """order/save""","""controllers.OrderController.save()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """order/find""","""controllers.OrderController.find(identity:String, progress:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """order/detail""","""controllers.OrderController.detail(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """order/over""","""controllers.OrderController.over(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """order/file""","""controllers.OrderController.file(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """order/payment""","""controllers.OrderController.payment(id:String, type:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """order/zxr""","""controllers.OrderController.zxr(id:String, cameraman:String, dresser:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """notify/direct""","""controllers.NotifyController.direct()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
       
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """""", Routes.prefix + """"""))
   }
}
        

// @LINE:7
case controllers_Application_uptoken1(params) => {
   call { 
        invokeHandler(controllers.Application.uptoken(), HandlerDef(this, "controllers.Application", "uptoken", Nil,"GET", """""", Routes.prefix + """sys/uptoken"""))
   }
}
        

// @LINE:8
case controllers_Application_role2(params) => {
   call { 
        invokeHandler(controllers.Application.role(), HandlerDef(this, "controllers.Application", "role", Nil,"POST", """""", Routes.prefix + """menu/role"""))
   }
}
        

// @LINE:9
case controllers_Application_listMenu3(params) => {
   call { 
        invokeHandler(controllers.Application.listMenu(), HandlerDef(this, "controllers.Application", "listMenu", Nil,"GET", """""", Routes.prefix + """menu/list"""))
   }
}
        

// @LINE:10
case controllers_SysController_upload4(params) => {
   call(params.fromQuery[String]("filename", None)) { (filename) =>
        invokeHandler(controllers.SysController.upload(filename), HandlerDef(this, "controllers.SysController", "upload", Seq(classOf[String]),"GET", """""", Routes.prefix + """file/upload"""))
   }
}
        

// @LINE:11
case controllers_SysController_listFile5(params) => {
   call(params.fromQuery[String]("company", None)) { (company) =>
        invokeHandler(controllers.SysController.listFile(company), HandlerDef(this, "controllers.SysController", "listFile", Seq(classOf[String]),"GET", """""", Routes.prefix + """file/list"""))
   }
}
        

// @LINE:12
case controllers_SysController_delFile6(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.SysController.delFile(id), HandlerDef(this, "controllers.SysController", "delFile", Seq(classOf[Long]),"GET", """""", Routes.prefix + """file/delete"""))
   }
}
        

// @LINE:13
case controllers_SysController_get7(params) => {
   call(params.fromQuery[String]("name", None)) { (name) =>
        invokeHandler(controllers.SysController.get(name), HandlerDef(this, "controllers.SysController", "get", Seq(classOf[String]),"GET", """""", Routes.prefix + """file/get"""))
   }
}
        

// @LINE:14
case controllers_SysController_download8(params) => {
   call(params.fromQuery[String]("id", None)) { (id) =>
        invokeHandler(controllers.SysController.download(id), HandlerDef(this, "controllers.SysController", "download", Seq(classOf[String]),"GET", """""", Routes.prefix + """file/download"""))
   }
}
        

// @LINE:15
case controllers_SysController_unFinish9(params) => {
   call(params.fromQuery[String]("token", None)) { (token) =>
        invokeHandler(controllers.SysController.unFinish(token), HandlerDef(this, "controllers.SysController", "unFinish", Seq(classOf[String]),"GET", """""", Routes.prefix + """file/doing"""))
   }
}
        

// @LINE:18
case controllers_SiteController_list10(params) => {
   call { 
        invokeHandler(controllers.SiteController.list(), HandlerDef(this, "controllers.SiteController", "list", Nil,"GET", """Site""", Routes.prefix + """site/list"""))
   }
}
        

// @LINE:19
case controllers_SiteController_all11(params) => {
   call { 
        invokeHandler(controllers.SiteController.all(), HandlerDef(this, "controllers.SiteController", "all", Nil,"GET", """""", Routes.prefix + """site/all"""))
   }
}
        

// @LINE:20
case controllers_SiteController_site12(params) => {
   call(params.fromQuery[String]("id", None)) { (id) =>
        invokeHandler(controllers.SiteController.site(id), HandlerDef(this, "controllers.SiteController", "site", Seq(classOf[String]),"GET", """""", Routes.prefix + """site/get"""))
   }
}
        

// @LINE:21
case controllers_SiteController_save13(params) => {
   call { 
        invokeHandler(controllers.SiteController.save(), HandlerDef(this, "controllers.SiteController", "save", Nil,"POST", """""", Routes.prefix + """site/save"""))
   }
}
        

// @LINE:23
case controllers_HotelController_list14(params) => {
   call { 
        invokeHandler(controllers.HotelController.list(), HandlerDef(this, "controllers.HotelController", "list", Nil,"GET", """Hotel""", Routes.prefix + """hotel/list"""))
   }
}
        

// @LINE:24
case controllers_HotelController_all15(params) => {
   call { 
        invokeHandler(controllers.HotelController.all(), HandlerDef(this, "controllers.HotelController", "all", Nil,"GET", """""", Routes.prefix + """hotel/all"""))
   }
}
        

// @LINE:25
case controllers_HotelController_hotel16(params) => {
   call(params.fromQuery[String]("id", None)) { (id) =>
        invokeHandler(controllers.HotelController.hotel(id), HandlerDef(this, "controllers.HotelController", "hotel", Seq(classOf[String]),"GET", """""", Routes.prefix + """hotel/get"""))
   }
}
        

// @LINE:26
case controllers_HotelController_save17(params) => {
   call { 
        invokeHandler(controllers.HotelController.save(), HandlerDef(this, "controllers.HotelController", "save", Nil,"POST", """""", Routes.prefix + """hotel/save"""))
   }
}
        

// @LINE:28
case controllers_ClothController_list18(params) => {
   call { 
        invokeHandler(controllers.ClothController.list(), HandlerDef(this, "controllers.ClothController", "list", Nil,"GET", """Cloth""", Routes.prefix + """cloth/list"""))
   }
}
        

// @LINE:29
case controllers_ClothController_all19(params) => {
   call { 
        invokeHandler(controllers.ClothController.all(), HandlerDef(this, "controllers.ClothController", "all", Nil,"GET", """""", Routes.prefix + """cloth/all"""))
   }
}
        

// @LINE:30
case controllers_ClothController_cloth20(params) => {
   call(params.fromQuery[String]("id", None)) { (id) =>
        invokeHandler(controllers.ClothController.cloth(id), HandlerDef(this, "controllers.ClothController", "cloth", Seq(classOf[String]),"GET", """""", Routes.prefix + """cloth/get"""))
   }
}
        

// @LINE:31
case controllers_ClothController_save21(params) => {
   call { 
        invokeHandler(controllers.ClothController.save(), HandlerDef(this, "controllers.ClothController", "save", Nil,"POST", """""", Routes.prefix + """cloth/save"""))
   }
}
        

// @LINE:33
case controllers_UserController_menu22(params) => {
   call { 
        invokeHandler(controllers.UserController.menu(), HandlerDef(this, "controllers.UserController", "menu", Nil,"GET", """User""", Routes.prefix + """user/menu"""))
   }
}
        

// @LINE:34
case controllers_UserController_login23(params) => {
   call { 
        invokeHandler(controllers.UserController.login(), HandlerDef(this, "controllers.UserController", "login", Nil,"POST", """""", Routes.prefix + """user/login"""))
   }
}
        

// @LINE:35
case controllers_UserController_password24(params) => {
   call { 
        invokeHandler(controllers.UserController.password(), HandlerDef(this, "controllers.UserController", "password", Nil,"POST", """""", Routes.prefix + """user/password"""))
   }
}
        

// @LINE:36
case controllers_UserController_code25(params) => {
   call { 
        invokeHandler(controllers.UserController.code(), HandlerDef(this, "controllers.UserController", "code", Nil,"POST", """""", Routes.prefix + """user/code"""))
   }
}
        

// @LINE:37
case controllers_UserController_save26(params) => {
   call { 
        invokeHandler(controllers.UserController.save(), HandlerDef(this, "controllers.UserController", "save", Nil,"POST", """""", Routes.prefix + """user/save"""))
   }
}
        

// @LINE:38
case controllers_UserController_list27(params) => {
   call { 
        invokeHandler(controllers.UserController.list(), HandlerDef(this, "controllers.UserController", "list", Nil,"GET", """""", Routes.prefix + """user/list"""))
   }
}
        

// @LINE:39
case controllers_UserController_get28(params) => {
   call(params.fromQuery[String]("id", None)) { (id) =>
        invokeHandler(controllers.UserController.get(id), HandlerDef(this, "controllers.UserController", "get", Seq(classOf[String]),"GET", """""", Routes.prefix + """user/get"""))
   }
}
        

// @LINE:41
case controllers_CompanyController_save29(params) => {
   call { 
        invokeHandler(controllers.CompanyController.save(), HandlerDef(this, "controllers.CompanyController", "save", Nil,"POST", """Company""", Routes.prefix + """company/save"""))
   }
}
        

// @LINE:42
case controllers_CompanyController_list30(params) => {
   call { 
        invokeHandler(controllers.CompanyController.list(), HandlerDef(this, "controllers.CompanyController", "list", Nil,"GET", """""", Routes.prefix + """company/list"""))
   }
}
        

// @LINE:43
case controllers_CompanyController_simple31(params) => {
   call { 
        invokeHandler(controllers.CompanyController.simple(), HandlerDef(this, "controllers.CompanyController", "simple", Nil,"GET", """""", Routes.prefix + """company/simple"""))
   }
}
        

// @LINE:44
case controllers_CompanyController_search32(params) => {
   call(params.fromQuery[String]("city", None)) { (city) =>
        invokeHandler(controllers.CompanyController.search(city), HandlerDef(this, "controllers.CompanyController", "search", Seq(classOf[String]),"GET", """""", Routes.prefix + """company/search"""))
   }
}
        

// @LINE:45
case controllers_CompanyController_get33(params) => {
   call(params.fromQuery[String]("id", None)) { (id) =>
        invokeHandler(controllers.CompanyController.get(id), HandlerDef(this, "controllers.CompanyController", "get", Seq(classOf[String]),"GET", """""", Routes.prefix + """company/get"""))
   }
}
        

// @LINE:46
case controllers_CompanyController_info34(params) => {
   call { 
        invokeHandler(controllers.CompanyController.info(), HandlerDef(this, "controllers.CompanyController", "info", Nil,"GET", """""", Routes.prefix + """company/info"""))
   }
}
        

// @LINE:47
case controllers_CompanyController_change35(params) => {
   call(params.fromQuery[String]("id", None)) { (id) =>
        invokeHandler(controllers.CompanyController.change(id), HandlerDef(this, "controllers.CompanyController", "change", Seq(classOf[String]),"GET", """""", Routes.prefix + """company/change"""))
   }
}
        

// @LINE:49
case controllers_CashController_save36(params) => {
   call { 
        invokeHandler(controllers.CashController.save(), HandlerDef(this, "controllers.CashController", "save", Nil,"POST", """Cash""", Routes.prefix + """cash/save"""))
   }
}
        

// @LINE:50
case controllers_CashController_list37(params) => {
   call { 
        invokeHandler(controllers.CashController.list(), HandlerDef(this, "controllers.CashController", "list", Nil,"GET", """""", Routes.prefix + """cash/list"""))
   }
}
        

// @LINE:51
case controllers_CashController_all38(params) => {
   call { 
        invokeHandler(controllers.CashController.all(), HandlerDef(this, "controllers.CashController", "all", Nil,"GET", """""", Routes.prefix + """cash/all"""))
   }
}
        

// @LINE:52
case controllers_CashController_check39(params) => {
   call { 
        invokeHandler(controllers.CashController.check(), HandlerDef(this, "controllers.CashController", "check", Nil,"POST", """""", Routes.prefix + """cash/check"""))
   }
}
        

// @LINE:53
case controllers_CashController_delete40(params) => {
   call(params.fromQuery[String]("id", None)) { (id) =>
        invokeHandler(controllers.CashController.delete(id), HandlerDef(this, "controllers.CashController", "delete", Seq(classOf[String]),"GET", """""", Routes.prefix + """cash/delete"""))
   }
}
        

// @LINE:55
case controllers_WalletController_myWallet41(params) => {
   call { 
        invokeHandler(controllers.WalletController.myWallet(), HandlerDef(this, "controllers.WalletController", "myWallet", Nil,"GET", """Wallet""", Routes.prefix + """wallet/get"""))
   }
}
        

// @LINE:57
case controllers_RechargeController_create42(params) => {
   call { 
        invokeHandler(controllers.RechargeController.create(), HandlerDef(this, "controllers.RechargeController", "create", Nil,"POST", """Charge""", Routes.prefix + """recharge/create"""))
   }
}
        

// @LINE:58
case controllers_RechargeController_list43(params) => {
   call { 
        invokeHandler(controllers.RechargeController.list(), HandlerDef(this, "controllers.RechargeController", "list", Nil,"GET", """""", Routes.prefix + """recharge/list"""))
   }
}
        

// @LINE:60
case controllers_RechargeController_rule44(params) => {
   call { 
        invokeHandler(controllers.RechargeController.rule(), HandlerDef(this, "controllers.RechargeController", "rule", Nil,"GET", """Rule""", Routes.prefix + """rule/list"""))
   }
}
        

// @LINE:61
case controllers_RechargeController_saveRule45(params) => {
   call { 
        invokeHandler(controllers.RechargeController.saveRule(), HandlerDef(this, "controllers.RechargeController", "saveRule", Nil,"POST", """""", Routes.prefix + """rule/save"""))
   }
}
        

// @LINE:62
case controllers_RechargeController_delRule46(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.RechargeController.delRule(id), HandlerDef(this, "controllers.RechargeController", "delRule", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rule/delete"""))
   }
}
        

// @LINE:64
case controllers_OrderController_save47(params) => {
   call { 
        invokeHandler(controllers.OrderController.save(), HandlerDef(this, "controllers.OrderController", "save", Nil,"POST", """Order""", Routes.prefix + """order/save"""))
   }
}
        

// @LINE:65
case controllers_OrderController_find48(params) => {
   call(params.fromQuery[String]("identity", None), params.fromQuery[String]("progress", None)) { (identity, progress) =>
        invokeHandler(controllers.OrderController.find(identity, progress), HandlerDef(this, "controllers.OrderController", "find", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """order/find"""))
   }
}
        

// @LINE:66
case controllers_OrderController_detail49(params) => {
   call(params.fromQuery[String]("id", None)) { (id) =>
        invokeHandler(controllers.OrderController.detail(id), HandlerDef(this, "controllers.OrderController", "detail", Seq(classOf[String]),"GET", """""", Routes.prefix + """order/detail"""))
   }
}
        

// @LINE:67
case controllers_OrderController_over50(params) => {
   call(params.fromQuery[String]("id", None)) { (id) =>
        invokeHandler(controllers.OrderController.over(id), HandlerDef(this, "controllers.OrderController", "over", Seq(classOf[String]),"GET", """""", Routes.prefix + """order/over"""))
   }
}
        

// @LINE:68
case controllers_OrderController_file51(params) => {
   call(params.fromQuery[String]("id", None)) { (id) =>
        invokeHandler(controllers.OrderController.file(id), HandlerDef(this, "controllers.OrderController", "file", Seq(classOf[String]),"GET", """""", Routes.prefix + """order/file"""))
   }
}
        

// @LINE:69
case controllers_OrderController_payment52(params) => {
   call(params.fromQuery[String]("id", None), params.fromQuery[String]("type", None)) { (id, playframework_escape_type) =>
        invokeHandler(controllers.OrderController.payment(id, playframework_escape_type), HandlerDef(this, "controllers.OrderController", "payment", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """order/payment"""))
   }
}
        

// @LINE:70
case controllers_OrderController_zxr53(params) => {
   call(params.fromQuery[String]("id", None), params.fromQuery[String]("cameraman", None), params.fromQuery[String]("dresser", None)) { (id, cameraman, dresser) =>
        invokeHandler(controllers.OrderController.zxr(id, cameraman, dresser), HandlerDef(this, "controllers.OrderController", "zxr", Seq(classOf[String], classOf[String], classOf[String]),"GET", """""", Routes.prefix + """order/zxr"""))
   }
}
        

// @LINE:73
case controllers_NotifyController_direct54(params) => {
   call { 
        invokeHandler(controllers.NotifyController.direct(), HandlerDef(this, "controllers.NotifyController", "direct", Nil,"POST", """Notify""", Routes.prefix + """notify/direct"""))
   }
}
        

// @LINE:76
case controllers_Assets_at55(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """$file<.+>"""))
   }
}
        
}
    
}
        