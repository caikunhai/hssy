var bns = {};
	
	//无token执行AJAX请求
	bns.ajax_public = function (params, callback) {
		var xhr = new XMLHttpRequest();
		xhr.open(params.method, params.url, true);
		xhr.setRequestHeader("Content-type", "application/json");
		xhr.send(params.data);
		xhr.onreadystatechange = function () {
			if (xhr.readyState == 4 && xhr.status == 200) {
				if(callback==undefined){
					return;
				}
				callback(xhr.responseText);
			}
		};
	};

	//需要token执行AJAX请求
	bns.ajax_private = function (params, callback) {
		var xhr = new XMLHttpRequest();
		xhr.open(params.method, params.url, true);
		xhr.setRequestHeader("Content-type", "application/json");
		xhr.setRequestHeader("token", window.localStorage.getItem("token"));
		xhr.send(params.data);
		xhr.onreadystatechange = function () {
			if (xhr.readyState == 4 && xhr.status == 200) {
				//console.log('---------'+(function==typeof callback));
				callback(xhr.responseText);
			}
		};
	};
	
	//景点查询（客商）
	bns.site_list = function (callback) {
	    var params =new Object();
	    params.url=core.host + '/site/list';
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	
	//景点详情
	bns.site_get = function (id,callback) {
	    var params =new Object();
	    params.url=core.host + '/site/get?id='+id;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//景点搜索
	bns.site_search = function (company,callback) {
	    var params =new Object();
	    params.url=core.host + '/site/search?company='+company;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//景点保存
	bns.site_save = function (data,callback) {
	    var params =new Object();
	    params.url=core.host + '/site/save';
	    params.method='POST';
	    params.data=data;
	    bns.ajax_private(params, callback);
	};
	
	//住宿保存
	bns.hotel_save = function (data,callback) {
	    var params =new Object();
	    params.url=core.host + '/hotel/save';
	    params.method='POST';
	    params.data=data;
	    bns.ajax_private(params, callback);
	};
	
	//住宿查询（客商）
	bns.hotel_list = function (callback) {
	    var params =new Object();
	    params.url=core.host + '/hotel/list';
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//住宿详情
	bns.hotel_get = function (id,callback) {
	    var params =new Object();
	    params.url=core.host + '/hotel/get?id='+id;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//住宿搜索
	bns.hotel_search = function (company,callback) {
	    var params =new Object();
	    params.url=core.host + '/hotel/search?company='+company;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//住宿照片
	bns.list_hotel_image = function (hotel,callback) {
	    var params =new Object();
	    params.url=core.host + '/hotel/image?hotel='+hotel;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//保存住宿照片
	bns.save_hotel_image = function (hotel,filename,callback) {
	    var params =new Object();
	    params.url=core.host + '/hotel/saveImg?hotel='+hotel+'&&filename='+filename;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//删除住宿照片
	bns.del_hotel_image = function (id,callback) {
	    var params =new Object();
	    params.url=core.host + '/hotel/delImg?id='+id;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//套餐查询（客商）
	bns.business_list = function (callback) {
	    var params =new Object();
	    params.url=core.host + '/business/list';
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//套餐详情
	bns.business_get = function (id,callback) {
	    var params =new Object();
	    params.url=core.host + '/business/get?id='+id;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	
	//套餐保存
	bns.business_save = function (data,callback) {
	    var params =new Object();
	    params.url=core.host + '/business/save';
	    params.method='POST';
	    params.data=data;
	    bns.ajax_private(params, callback);
	};
	
	//获取菜单
	bns.user_menu = function (callback) {
	    var params =new Object();
	    params.url=core.host + '/user/menu';
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//用户登录
	bns.user_login = function (data,callback) {
	    var params =new Object();
	    params.url=core.host + '/user/login';
	    params.method='POST';
	    params.data=data;
	    bns.ajax_private(params, callback);
	};
	
	//修改登录密码
	bns.user_password = function (data,callback) {
	    var params =new Object();
	    params.url=core.host + '/user/password';
	    params.method='POST';
	    params.data=data;
	    bns.ajax_private(params, callback);
	};
	
	//修改支付密码
	bns.user_code = function (data,callback) {
	    var params =new Object();
	    params.url=core.host + '/user/code';
	    params.method='POST';
	    params.data=data;
	    bns.ajax_private(params, callback);
	};
	
	//保存用户
	bns.user_save = function (data,callback) {
	    var params =new Object();
	    params.url=core.host + '/user/save';
	    params.method='POST';
	    params.data=data;
	    bns.ajax_private(params, callback);
	};
	
	//保存用户
	bns.user_list = function (callback) {
	    var params =new Object();
	    params.url=core.host + '/user/list';
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//用户详情
	bns.user_get = function (id,callback) {
	    var params =new Object();
	    params.url=core.host + '/user/get?id='+id;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//保存公司
	bns.company_save = function (data,callback) {
	    var params =new Object();
	    params.url=core.host + '/company/save';
	    params.method='POST';
	    params.data=data;
	    bns.ajax_private(params, callback);
	};
	
	//公司查询
	bns.company_list = function (callback) {
	    var params =new Object();
	    params.url=core.host + '/company/list';
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//公司简单查询
	bns.company_simple = function (callback) {
	    var params =new Object();
	    params.url=core.host + '/company/simple';
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//公司搜索
	bns.company_search = function (city,callback) {
	    var params =new Object();
	    params.url=encodeURI(core.host + '/company/search?city='+city);
	    params.method='GET';
	    params.data=null;
	    bns.ajax_public(params, callback);
	};
	
	//公司详情
	bns.company_get = function (id,callback) {
	    var params =new Object();
	    params.url=core.host + '/company/get?id='+id;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//我的公司
	bns.company_info = function (callback) {
	    var params =new Object();
	    params.url=core.host + '/company/info';
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//保存提现
	bns.cash_save = function (data,callback) {
	    var params =new Object();
	    params.url=core.host + '/cash/save';
	    params.method='POST';
	    params.data=data;
	    bns.ajax_private(params, callback);
	};
	
	//我的提现
	bns.cash_list = function (callback) {
	    var params =new Object();
	    params.url=core.host + '/cash/list';
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//全部提现
	bns.cash_all = function (callback) {
	    var params =new Object();
	    params.url=core.host + '/cash/all';
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//提现审核
	bns.cash_check = function (data,callback) {
	    var params =new Object();
	    params.url=core.host + '/cash/check';
	    params.method='POST';
	    params.data=data;
	    bns.ajax_private(params, callback);
	};
	
	//提现记录删除
	bns.cash_del = function (id,callback) {
	    var params =new Object();
	    params.url=core.host + '/cash/delete?id='+id;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//我的钱包
	bns.wallet_get = function (callback) {
	    var params =new Object();
	    params.url=core.host + '/wallet/get';
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//创建充值
	bns.recharge_create = function (data,callback) {
	    var params =new Object();
	    params.url=core.host + '/recharge/create';
	    params.method='POST';
	    params.data=data;
	    bns.ajax_private(params, callback);
	};
	
	//我的充值
	bns.recharge_list = function (callback) {
	    var params =new Object();
	    params.url=core.host + '/recharge/list';
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//保存临时订单
	bns.temp_save = function (data,callback) {
	    var params =new Object();
	    params.url=core.host + '/temp/save';
	    params.method='POST';
	    params.data=data;
	    bns.ajax_private(params, callback);
	};
	
	//获取临时订单
	bns.get_temp = function (id,callback) {
	    var params =new Object();
	    params.url=core.host + '/temp/get?id='+id;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	
	//保存订单
	bns.order_save = function (data,callback) {
	    var params =new Object();
	    params.url=core.host + '/order/save';
	    params.method='POST';
	    params.data=data;
	    bns.ajax_private(params, callback);
	};
	
	//保存订单
	bns.order_check = function (company,time,callback) {
	    var params =new Object();
	    params.url=core.host + '/order/check?company='+company+'&&time='+time;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//订单支付
	bns.order_pay = function (id,type,callback) {
	    var params =new Object();
	    params.url=core.host + '/order/payment?id='+id+'&&type='+type;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//接单
	bns.order_accept = function (orderId,callback) {
	    var params =new Object();
	    params.url=core.host + '/order/accept?orderId='+orderId;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//订单取消
	bns.order_cancel = function (orderId,callback) {
	    var params =new Object();
	    params.url=core.host + '/order/cancel?orderId='+orderId;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//订单查找
	bns.order_find = function (identity,progress,callback) {
	    var params =new Object();
	    params.url=core.host + '/order/find?progress='+progress+'&&identity='+identity;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//订单详情
	bns.order_detail = function (id,callback) {
	    var params =new Object();
	    params.url=core.host + '/order/detail?id='+id;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//订单完成
	bns.order_over = function (id,callback) {
	    var params =new Object();
	    params.url=core.host + '/order/over?id='+id;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//公司改变事件
	bns.company_change = function (id,callback) {
	    var params =new Object();
	    params.url=core.host + '/company/change?id='+id;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//菜单列表
	bns.menu_list = function (callback) {
	    var params =new Object();
	    params.url=core.host + '/menu/list';
	    params.method='GET';
	    params.data=null;
	    bns.ajax_public(params, callback);
	};
	
	//保存权限
	bns.menu_role = function (data,callback) {
	    var params =new Object();
	    params.url=core.host + '/menu/role';
	    params.method='POST';
	    params.data=data;
	    bns.ajax_public(params, callback);
	};
	
	//订单添加附件
	bns.upload = function (id,callback) {
	    var params =new Object();
	    params.url=core.host + '/order/file?id='+id;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//保存执行人
	bns.save_zxr = function (id,cameraman,dresser,callback) {
	    var params =new Object();
	    params.url=core.host + '/order/zxr?id='+id+'&&cameraman='+cameraman+"&&dresser="+dresser;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//保存规则
	bns.save_rule = function (data,callback) {
	    var params =new Object();
	    params.url=core.host + '/rule/save';
	    params.method='POST';
	    params.data=data;
	    bns.ajax_private(params, callback);
	};
	
	//规则列表
	bns.rule_list = function (callback) {
	    var params =new Object();
	    params.url=core.host + '/rule/list';
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//规则列表
	bns.rule_del = function (id,callback) {
	    var params =new Object();
	    params.url=core.host + '/rule/delete?id='+id;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//机构申请附件
	bns.apply_info = function (company,callback) {
	    var params =new Object();
	    params.url=core.host + '/file/list?company='+company;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//删除一个附件
	bns.apply_del = function (id,callback) {
	    var params =new Object();
	    params.url=core.host + '/file/delete?id='+id;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//新增一个附件
	bns.save_file = function (filename,callback) {
	    var params =new Object();
	    params.url=core.host + '/file/upload?filename='+filename;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//保存作品
	bns.save_work = function (filename,callback) {
	    var params =new Object();
	    params.url=core.host + '/work/save?filename='+filename;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//删除作品
	bns.del_work = function (id,callback) {
	    var params =new Object();
	    params.url=core.host + '/work/delete?id='+id;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//查询作品
	bns.list_work = function (company,callback) {
	    var params =new Object();
	    params.url=core.host + '/work/list?company='+company;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//查询机构下面住宿和景点
	bns.list_hotel_site = function (company,callback) {
	    var params =new Object();
	    params.url=core.host + '/company/hotelSite?company='+company;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_public(params, callback);
	};
	
	//查询机构下面住宿和景点
	bns.register = function (data,callback) {
	    var params =new Object();
	    params.url=core.host + '/user/register';
	    params.method='POST';
	    params.data=data;
	    bns.ajax_public(params, callback);
	};
	
	//查询申请资料
	bns.apply_get = function (company,callback) {
	    var params =new Object();
	    params.url=core.host + '/apply/get?company='+company;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//查询申请资料
	bns.apply_save = function (data,callback) {
	    var params =new Object();
	    params.url=core.host + '/apply/save';
	    params.method='POST';
	    params.data=data;
	    bns.ajax_public(params, callback);
	};
	
	//保存申请照片
	bns.apply_Img_save = function (filename,callback) {
	    var params =new Object();
	    params.url=core.host + '/apply/saveImg?filename='+filename;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_public(params, callback);
	};
	
	//删除申请照片
	bns.apply_Img_del = function (id,callback) {
	    var params =new Object();
	    params.url=core.host + '/apply/delImg?id='+id;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_public(params, callback);
	};
	
