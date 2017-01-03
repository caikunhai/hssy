// @SOURCE:D:/workspace/hssy/conf/routes
// @HASH:63031ce7cdbe1875883e7b7340d0bedf63bcb939
// @DATE:Sun Dec 25 17:24:14 CST 2016

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._
import java.net.URLEncoder

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:76
// @LINE:73
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:58
// @LINE:57
// @LINE:55
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:76
class ReverseAssets {
    

// @LINE:76
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
class ReverseCashController {
    

// @LINE:52
def check(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "cash/check")
}
                                                

// @LINE:53
def delete(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cash/delete" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("id", id)))))
}
                                                

// @LINE:50
def list(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cash/list")
}
                                                

// @LINE:49
def save(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "cash/save")
}
                                                

// @LINE:51
def all(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cash/all")
}
                                                
    
}
                          

// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
class ReverseCompanyController {
    

// @LINE:42
def list(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "company/list")
}
                                                

// @LINE:41
def save(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "company/save")
}
                                                

// @LINE:43
def simple(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "company/simple")
}
                                                

// @LINE:45
def get(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "company/get" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("id", id)))))
}
                                                

// @LINE:46
def info(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "company/info")
}
                                                

// @LINE:44
def search(city:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "company/search" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("city", city)))))
}
                                                

// @LINE:47
def change(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "company/change" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
class ReverseSysController {
    

// @LINE:12
def delFile(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "file/delete" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:15
def unFinish(token:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "file/doing" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("token", token)))))
}
                                                

// @LINE:10
def upload(filename:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "file/upload" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("filename", filename)))))
}
                                                

// @LINE:11
def listFile(company:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "file/list" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("company", company)))))
}
                                                

// @LINE:14
def download(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "file/download" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("id", id)))))
}
                                                

// @LINE:13
def get(name:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "file/get" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("name", name)))))
}
                                                
    
}
                          

// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
class ReverseClothController {
    

// @LINE:30
def cloth(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cloth/get" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("id", id)))))
}
                                                

// @LINE:31
def save(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "cloth/save")
}
                                                

// @LINE:29
def all(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cloth/all")
}
                                                

// @LINE:28
def list(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cloth/list")
}
                                                
    
}
                          

// @LINE:73
class ReverseNotifyController {
    

// @LINE:73
def direct(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "notify/direct")
}
                                                
    
}
                          

// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
class ReverseUserController {
    

// @LINE:36
def code(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "user/code")
}
                                                

// @LINE:34
def login(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "user/login")
}
                                                

// @LINE:33
def menu(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "user/menu")
}
                                                

// @LINE:38
def list(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "user/list")
}
                                                

// @LINE:35
def password(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "user/password")
}
                                                

// @LINE:37
def save(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "user/save")
}
                                                

// @LINE:39
def get(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "user/get" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:7
def uptoken(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "sys/uptoken")
}
                                                

// @LINE:8
def role(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "menu/role")
}
                                                

// @LINE:9
def listMenu(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "menu/list")
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
class ReverseOrderController {
    

// @LINE:67
def over(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "order/over" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("id", id)))))
}
                                                

// @LINE:70
def zxr(id:String, doUser:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "order/zxr" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("id", id)), Some(implicitly[QueryStringBindable[String]].unbind("doUser", doUser)))))
}
                                                

// @LINE:68
def file(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "order/file" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("id", id)))))
}
                                                

// @LINE:65
def find(identity:String, progress:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "order/find" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("identity", identity)), Some(implicitly[QueryStringBindable[String]].unbind("progress", progress)))))
}
                                                

// @LINE:64
def save(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "order/save")
}
                                                

// @LINE:66
def detail(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "order/detail" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("id", id)))))
}
                                                

// @LINE:69
def payment(id:String, playframework_escape_type:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "order/payment" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("id", id)), Some(implicitly[QueryStringBindable[String]].unbind("type", playframework_escape_type)))))
}
                                                
    
}
                          

// @LINE:55
class ReverseWalletController {
    

// @LINE:55
def myWallet(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "wallet/get")
}
                                                
    
}
                          

// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
class ReverseSiteController {
    

// @LINE:21
def save(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "site/save")
}
                                                

// @LINE:19
def all(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "site/all")
}
                                                

// @LINE:20
def site(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "site/get" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("id", id)))))
}
                                                

// @LINE:18
def list(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "site/list")
}
                                                
    
}
                          

// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:58
// @LINE:57
class ReverseRechargeController {
    

// @LINE:57
def create(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "recharge/create")
}
                                                

// @LINE:61
def saveRule(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rule/save")
}
                                                

// @LINE:58
def list(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "recharge/list")
}
                                                

// @LINE:60
def rule(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rule/list")
}
                                                

// @LINE:62
def delRule(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rule/delete" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
class ReverseHotelController {
    

// @LINE:25
def hotel(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "hotel/get" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("id", id)))))
}
                                                

// @LINE:26
def save(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "hotel/save")
}
                                                

// @LINE:24
def all(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "hotel/all")
}
                                                

// @LINE:23
def list(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "hotel/list")
}
                                                
    
}
                          
}
                  


// @LINE:76
// @LINE:73
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:58
// @LINE:57
// @LINE:55
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:76
class ReverseAssets {
    

// @LINE:76
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
class ReverseCashController {
    

// @LINE:52
def check : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CashController.check",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "cash/check"})
      }
   """
)
                        

// @LINE:53
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CashController.delete",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cash/delete" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:50
def list : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CashController.list",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cash/list"})
      }
   """
)
                        

// @LINE:49
def save : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CashController.save",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "cash/save"})
      }
   """
)
                        

// @LINE:51
def all : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CashController.all",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cash/all"})
      }
   """
)
                        
    
}
              

// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
class ReverseCompanyController {
    

// @LINE:42
def list : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CompanyController.list",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "company/list"})
      }
   """
)
                        

// @LINE:41
def save : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CompanyController.save",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "company/save"})
      }
   """
)
                        

// @LINE:43
def simple : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CompanyController.simple",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "company/simple"})
      }
   """
)
                        

// @LINE:45
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CompanyController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "company/get" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:46
def info : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CompanyController.info",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "company/info"})
      }
   """
)
                        

// @LINE:44
def search : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CompanyController.search",
   """
      function(city) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "company/search" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("city", city)])})
      }
   """
)
                        

// @LINE:47
def change : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CompanyController.change",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "company/change" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        
    
}
              

// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
class ReverseSysController {
    

// @LINE:12
def delFile : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SysController.delFile",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "file/delete" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:15
def unFinish : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SysController.unFinish",
   """
      function(token) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "file/doing" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("token", token)])})
      }
   """
)
                        

// @LINE:10
def upload : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SysController.upload",
   """
      function(filename) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "file/upload" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("filename", filename)])})
      }
   """
)
                        

// @LINE:11
def listFile : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SysController.listFile",
   """
      function(company) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "file/list" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("company", company)])})
      }
   """
)
                        

// @LINE:14
def download : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SysController.download",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "file/download" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:13
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SysController.get",
   """
      function(name) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "file/get" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("name", name)])})
      }
   """
)
                        
    
}
              

// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
class ReverseClothController {
    

// @LINE:30
def cloth : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClothController.cloth",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cloth/get" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:31
def save : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClothController.save",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "cloth/save"})
      }
   """
)
                        

// @LINE:29
def all : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClothController.all",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cloth/all"})
      }
   """
)
                        

// @LINE:28
def list : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClothController.list",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cloth/list"})
      }
   """
)
                        
    
}
              

// @LINE:73
class ReverseNotifyController {
    

// @LINE:73
def direct : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NotifyController.direct",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "notify/direct"})
      }
   """
)
                        
    
}
              

// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
class ReverseUserController {
    

// @LINE:36
def code : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UserController.code",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/code"})
      }
   """
)
                        

// @LINE:34
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UserController.login",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/login"})
      }
   """
)
                        

// @LINE:33
def menu : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UserController.menu",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/menu"})
      }
   """
)
                        

// @LINE:38
def list : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UserController.list",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/list"})
      }
   """
)
                        

// @LINE:35
def password : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UserController.password",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/password"})
      }
   """
)
                        

// @LINE:37
def save : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UserController.save",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/save"})
      }
   """
)
                        

// @LINE:39
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UserController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/get" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        
    
}
              

// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:7
def uptoken : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.uptoken",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sys/uptoken"})
      }
   """
)
                        

// @LINE:8
def role : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.role",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "menu/role"})
      }
   """
)
                        

// @LINE:9
def listMenu : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.listMenu",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "menu/list"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              

// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
class ReverseOrderController {
    

// @LINE:67
def over : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.OrderController.over",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "order/over" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:70
def zxr : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.OrderController.zxr",
   """
      function(id,doUser) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "order/zxr" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("id", id), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("doUser", doUser)])})
      }
   """
)
                        

// @LINE:68
def file : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.OrderController.file",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "order/file" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:65
def find : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.OrderController.find",
   """
      function(identity,progress) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "order/find" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("identity", identity), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("progress", progress)])})
      }
   """
)
                        

// @LINE:64
def save : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.OrderController.save",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "order/save"})
      }
   """
)
                        

// @LINE:66
def detail : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.OrderController.detail",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "order/detail" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:69
def payment : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.OrderController.payment",
   """
      function(id,type) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "order/payment" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("id", id), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("type", type)])})
      }
   """
)
                        
    
}
              

// @LINE:55
class ReverseWalletController {
    

// @LINE:55
def myWallet : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.WalletController.myWallet",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "wallet/get"})
      }
   """
)
                        
    
}
              

// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
class ReverseSiteController {
    

// @LINE:21
def save : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SiteController.save",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "site/save"})
      }
   """
)
                        

// @LINE:19
def all : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SiteController.all",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "site/all"})
      }
   """
)
                        

// @LINE:20
def site : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SiteController.site",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "site/get" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:18
def list : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SiteController.list",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "site/list"})
      }
   """
)
                        
    
}
              

// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:58
// @LINE:57
class ReverseRechargeController {
    

// @LINE:57
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RechargeController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "recharge/create"})
      }
   """
)
                        

// @LINE:61
def saveRule : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RechargeController.saveRule",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rule/save"})
      }
   """
)
                        

// @LINE:58
def list : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RechargeController.list",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recharge/list"})
      }
   """
)
                        

// @LINE:60
def rule : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RechargeController.rule",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rule/list"})
      }
   """
)
                        

// @LINE:62
def delRule : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RechargeController.delRule",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rule/delete" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        
    
}
              

// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
class ReverseHotelController {
    

// @LINE:25
def hotel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.HotelController.hotel",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "hotel/get" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:26
def save : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.HotelController.save",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "hotel/save"})
      }
   """
)
                        

// @LINE:24
def all : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.HotelController.all",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "hotel/all"})
      }
   """
)
                        

// @LINE:23
def list : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.HotelController.list",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "hotel/list"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:76
// @LINE:73
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:58
// @LINE:57
// @LINE:55
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {

// @LINE:76
class ReverseAssets {
    

// @LINE:76
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """$file<.+>""")
)
                      
    
}
                          

// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
class ReverseCashController {
    

// @LINE:52
def check(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CashController.check(), HandlerDef(this, "controllers.CashController", "check", Seq(), "POST", """""", _prefix + """cash/check""")
)
                      

// @LINE:53
def delete(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CashController.delete(id), HandlerDef(this, "controllers.CashController", "delete", Seq(classOf[String]), "GET", """""", _prefix + """cash/delete""")
)
                      

// @LINE:50
def list(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CashController.list(), HandlerDef(this, "controllers.CashController", "list", Seq(), "GET", """""", _prefix + """cash/list""")
)
                      

// @LINE:49
def save(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CashController.save(), HandlerDef(this, "controllers.CashController", "save", Seq(), "POST", """Cash""", _prefix + """cash/save""")
)
                      

// @LINE:51
def all(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CashController.all(), HandlerDef(this, "controllers.CashController", "all", Seq(), "GET", """""", _prefix + """cash/all""")
)
                      
    
}
                          

// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
class ReverseCompanyController {
    

// @LINE:42
def list(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CompanyController.list(), HandlerDef(this, "controllers.CompanyController", "list", Seq(), "GET", """""", _prefix + """company/list""")
)
                      

// @LINE:41
def save(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CompanyController.save(), HandlerDef(this, "controllers.CompanyController", "save", Seq(), "POST", """Company""", _prefix + """company/save""")
)
                      

// @LINE:43
def simple(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CompanyController.simple(), HandlerDef(this, "controllers.CompanyController", "simple", Seq(), "GET", """""", _prefix + """company/simple""")
)
                      

// @LINE:45
def get(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CompanyController.get(id), HandlerDef(this, "controllers.CompanyController", "get", Seq(classOf[String]), "GET", """""", _prefix + """company/get""")
)
                      

// @LINE:46
def info(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CompanyController.info(), HandlerDef(this, "controllers.CompanyController", "info", Seq(), "GET", """""", _prefix + """company/info""")
)
                      

// @LINE:44
def search(city:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CompanyController.search(city), HandlerDef(this, "controllers.CompanyController", "search", Seq(classOf[String]), "GET", """""", _prefix + """company/search""")
)
                      

// @LINE:47
def change(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CompanyController.change(id), HandlerDef(this, "controllers.CompanyController", "change", Seq(classOf[String]), "GET", """""", _prefix + """company/change""")
)
                      
    
}
                          

// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
class ReverseSysController {
    

// @LINE:12
def delFile(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SysController.delFile(id), HandlerDef(this, "controllers.SysController", "delFile", Seq(classOf[Long]), "GET", """""", _prefix + """file/delete""")
)
                      

// @LINE:15
def unFinish(token:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SysController.unFinish(token), HandlerDef(this, "controllers.SysController", "unFinish", Seq(classOf[String]), "GET", """""", _prefix + """file/doing""")
)
                      

// @LINE:10
def upload(filename:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SysController.upload(filename), HandlerDef(this, "controllers.SysController", "upload", Seq(classOf[String]), "GET", """""", _prefix + """file/upload""")
)
                      

// @LINE:11
def listFile(company:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SysController.listFile(company), HandlerDef(this, "controllers.SysController", "listFile", Seq(classOf[String]), "GET", """""", _prefix + """file/list""")
)
                      

// @LINE:14
def download(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SysController.download(id), HandlerDef(this, "controllers.SysController", "download", Seq(classOf[String]), "GET", """""", _prefix + """file/download""")
)
                      

// @LINE:13
def get(name:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SysController.get(name), HandlerDef(this, "controllers.SysController", "get", Seq(classOf[String]), "GET", """""", _prefix + """file/get""")
)
                      
    
}
                          

// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
class ReverseClothController {
    

// @LINE:30
def cloth(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ClothController.cloth(id), HandlerDef(this, "controllers.ClothController", "cloth", Seq(classOf[String]), "GET", """""", _prefix + """cloth/get""")
)
                      

// @LINE:31
def save(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ClothController.save(), HandlerDef(this, "controllers.ClothController", "save", Seq(), "POST", """""", _prefix + """cloth/save""")
)
                      

// @LINE:29
def all(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ClothController.all(), HandlerDef(this, "controllers.ClothController", "all", Seq(), "GET", """""", _prefix + """cloth/all""")
)
                      

// @LINE:28
def list(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ClothController.list(), HandlerDef(this, "controllers.ClothController", "list", Seq(), "GET", """Cloth""", _prefix + """cloth/list""")
)
                      
    
}
                          

// @LINE:73
class ReverseNotifyController {
    

// @LINE:73
def direct(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.NotifyController.direct(), HandlerDef(this, "controllers.NotifyController", "direct", Seq(), "POST", """Notify""", _prefix + """notify/direct""")
)
                      
    
}
                          

// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
class ReverseUserController {
    

// @LINE:36
def code(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UserController.code(), HandlerDef(this, "controllers.UserController", "code", Seq(), "POST", """""", _prefix + """user/code""")
)
                      

// @LINE:34
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UserController.login(), HandlerDef(this, "controllers.UserController", "login", Seq(), "POST", """""", _prefix + """user/login""")
)
                      

// @LINE:33
def menu(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UserController.menu(), HandlerDef(this, "controllers.UserController", "menu", Seq(), "GET", """User""", _prefix + """user/menu""")
)
                      

// @LINE:38
def list(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UserController.list(), HandlerDef(this, "controllers.UserController", "list", Seq(), "GET", """""", _prefix + """user/list""")
)
                      

// @LINE:35
def password(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UserController.password(), HandlerDef(this, "controllers.UserController", "password", Seq(), "POST", """""", _prefix + """user/password""")
)
                      

// @LINE:37
def save(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UserController.save(), HandlerDef(this, "controllers.UserController", "save", Seq(), "POST", """""", _prefix + """user/save""")
)
                      

// @LINE:39
def get(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UserController.get(id), HandlerDef(this, "controllers.UserController", "get", Seq(classOf[String]), "GET", """""", _prefix + """user/get""")
)
                      
    
}
                          

// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:7
def uptoken(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.uptoken(), HandlerDef(this, "controllers.Application", "uptoken", Seq(), "GET", """""", _prefix + """sys/uptoken""")
)
                      

// @LINE:8
def role(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.role(), HandlerDef(this, "controllers.Application", "role", Seq(), "POST", """""", _prefix + """menu/role""")
)
                      

// @LINE:9
def listMenu(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.listMenu(), HandlerDef(this, "controllers.Application", "listMenu", Seq(), "GET", """""", _prefix + """menu/list""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """""", _prefix + """""")
)
                      
    
}
                          

// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
class ReverseOrderController {
    

// @LINE:67
def over(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.OrderController.over(id), HandlerDef(this, "controllers.OrderController", "over", Seq(classOf[String]), "GET", """""", _prefix + """order/over""")
)
                      

// @LINE:70
def zxr(id:String, doUser:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.OrderController.zxr(id, doUser), HandlerDef(this, "controllers.OrderController", "zxr", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """order/zxr""")
)
                      

// @LINE:68
def file(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.OrderController.file(id), HandlerDef(this, "controllers.OrderController", "file", Seq(classOf[String]), "GET", """""", _prefix + """order/file""")
)
                      

// @LINE:65
def find(identity:String, progress:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.OrderController.find(identity, progress), HandlerDef(this, "controllers.OrderController", "find", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """order/find""")
)
                      

// @LINE:64
def save(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.OrderController.save(), HandlerDef(this, "controllers.OrderController", "save", Seq(), "POST", """Order""", _prefix + """order/save""")
)
                      

// @LINE:66
def detail(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.OrderController.detail(id), HandlerDef(this, "controllers.OrderController", "detail", Seq(classOf[String]), "GET", """""", _prefix + """order/detail""")
)
                      

// @LINE:69
def payment(id:String, playframework_escape_type:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.OrderController.payment(id, playframework_escape_type), HandlerDef(this, "controllers.OrderController", "payment", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """order/payment""")
)
                      
    
}
                          

// @LINE:55
class ReverseWalletController {
    

// @LINE:55
def myWallet(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.WalletController.myWallet(), HandlerDef(this, "controllers.WalletController", "myWallet", Seq(), "GET", """Wallet""", _prefix + """wallet/get""")
)
                      
    
}
                          

// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
class ReverseSiteController {
    

// @LINE:21
def save(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SiteController.save(), HandlerDef(this, "controllers.SiteController", "save", Seq(), "POST", """""", _prefix + """site/save""")
)
                      

// @LINE:19
def all(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SiteController.all(), HandlerDef(this, "controllers.SiteController", "all", Seq(), "GET", """""", _prefix + """site/all""")
)
                      

// @LINE:20
def site(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SiteController.site(id), HandlerDef(this, "controllers.SiteController", "site", Seq(classOf[String]), "GET", """""", _prefix + """site/get""")
)
                      

// @LINE:18
def list(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SiteController.list(), HandlerDef(this, "controllers.SiteController", "list", Seq(), "GET", """Site""", _prefix + """site/list""")
)
                      
    
}
                          

// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:58
// @LINE:57
class ReverseRechargeController {
    

// @LINE:57
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RechargeController.create(), HandlerDef(this, "controllers.RechargeController", "create", Seq(), "POST", """Charge""", _prefix + """recharge/create""")
)
                      

// @LINE:61
def saveRule(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RechargeController.saveRule(), HandlerDef(this, "controllers.RechargeController", "saveRule", Seq(), "POST", """""", _prefix + """rule/save""")
)
                      

// @LINE:58
def list(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RechargeController.list(), HandlerDef(this, "controllers.RechargeController", "list", Seq(), "GET", """""", _prefix + """recharge/list""")
)
                      

// @LINE:60
def rule(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RechargeController.rule(), HandlerDef(this, "controllers.RechargeController", "rule", Seq(), "GET", """Rule""", _prefix + """rule/list""")
)
                      

// @LINE:62
def delRule(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RechargeController.delRule(id), HandlerDef(this, "controllers.RechargeController", "delRule", Seq(classOf[Long]), "GET", """""", _prefix + """rule/delete""")
)
                      
    
}
                          

// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
class ReverseHotelController {
    

// @LINE:25
def hotel(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.HotelController.hotel(id), HandlerDef(this, "controllers.HotelController", "hotel", Seq(classOf[String]), "GET", """""", _prefix + """hotel/get""")
)
                      

// @LINE:26
def save(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.HotelController.save(), HandlerDef(this, "controllers.HotelController", "save", Seq(), "POST", """""", _prefix + """hotel/save""")
)
                      

// @LINE:24
def all(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.HotelController.all(), HandlerDef(this, "controllers.HotelController", "all", Seq(), "GET", """""", _prefix + """hotel/all""")
)
                      

// @LINE:23
def list(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.HotelController.list(), HandlerDef(this, "controllers.HotelController", "list", Seq(), "GET", """Hotel""", _prefix + """hotel/list""")
)
                      
    
}
                          
}
                  
      