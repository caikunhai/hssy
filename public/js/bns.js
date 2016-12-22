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
	
	//景点查询（管理员）
	bns.site_all = function (callback) {
	    var params =new Object();
	    params.url=core.host + '/site/all';
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
	
	//住宿查询（客商）
	bns.hotel_list = function (callback) {
	    var params =new Object();
	    params.url=core.host + '/hotel/list';
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//住宿查询（管理员）
	bns.hotel_all = function (callback) {
	    var params =new Object();
	    params.url=core.host + '/hotel/all';
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
	
	//住宿保存
	bns.hotel_save = function (data,callback) {
	    var params =new Object();
	    params.url=core.host + '/hotel/save';
	    params.method='POST';
	    params.data=data;
	    bns.ajax_private(params, callback);
	};
	
	//服饰查询（客商）
	bns.cloth_list = function (callback) {
	    var params =new Object();
	    params.url=core.host + '/cloth/list';
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//服饰查询（管理员）
	bns.cloth_all = function (callback) {
	    var params =new Object();
	    params.url=core.host + '/cloth/all';
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//服饰详情
	bns.cloth_get = function (id,callback) {
	    var params =new Object();
	    params.url=core.host + '/cloth/get?id='+id;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//服饰搜索
	bns.cloth_search = function (company,callback) {
	    var params =new Object();
	    params.url=core.host + '/cloth/search?company='+company;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
	//服饰保存
	bns.cloth_save = function (data,callback) {
	    var params =new Object();
	    params.url=core.host + '/cloth/save';
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
	    bns.ajax_private(params, callback);
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
	
	//充值到账
	bns.recharge_save = function (data,callback) {
	    var params =new Object();
	    params.url=core.host + '/recharge/save';
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
	
	//全部充值
	bns.recharge_all = function (callback) {
	    var params =new Object();
	    params.url=core.host + '/recharge/all';
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
	
	//订单支付
	bns.order_pay = function (data,callback) {
	    var params =new Object();
	    params.url=core.host + '/order/pay';
	    params.method='POST';
	    params.data=data;
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
	bns.save_zxr = function (id,doUser,callback) {
	    var params =new Object();
	    params.url=core.host + '/order/zxr?id='+id+'&&doUser='+doUser;
	    params.method='GET';
	    params.data=null;
	    bns.ajax_private(params, callback);
	};
	
