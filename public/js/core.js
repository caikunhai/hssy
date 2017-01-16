var core = {
	host : "http://"+window.location.host
};
core.qiniu='http://7xr5um.com1.z0.glb.clouddn.com/';
core.cache_menu=window.localStorage.getItem("menu");
core.menu_list='';
core.Just_Doing=1;
core.Game_Over=3;
core.Wait_Pay=5;

core.notify_direct_url=core.host+"/notify/direct";

function getQueryParam(name) {
    var strURL = window.location.search;
    return new RegExp( "(^|\\?|&)" + name + "=([^&]*)(\\s|&|$)", "i" ).test( strURL ) ?
        decodeURIComponent( RegExp.$2.replace( /\+/g, " " ) ) : "";
}


//新打开窗口 title:标题 url:窗口页面地址
function newOpen(title,url){    
	var jq = top.jQuery;    
	if (jq("#tabs").tabs('exists', title)){    
        jq("#tabs").tabs('select', title);    
    } else {  
        var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';     
        jq("#tabs").tabs('add',{    
                                title:title,    
                                content:content,    
                                closable:true    
                         });    
        }    
} 


//弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
function msgShow(title, msgString, msgType) {
	$.messager.alert(title, msgString, msgType);
}

//公用返回格式
function common_html(data) {
	var xhrObj = JSON.parse(data);
	if(xhrObj.code==101){
		$('#w').window('close');
		$.messager.confirm('系统提示', xhrObj.message, function(r) {
			if (r) {
			    parent.$("#login").window('open');
			}
		});
		return;
	}
	if(xhrObj.code==0){
		msgShow("系统提示",xhrObj.message,"warning");
		return;
	}
	msgShow("系统提示",xhrObj.message,"info");
}

//公用返回刷新页面
function refresh_href(data) {
	window.location.href =window.location.href;
}


//分页列表
function pagerFilter(data){
    if (typeof data.length == 'number' && typeof data.splice == 'function'){    // 判断数据是否是数组
        data = {
            total: data.length,
            rows: data
        }
    }
    var dg = $(this);
    var opts = dg.datagrid('options');
    var pager = dg.datagrid('getPager');
    pager.pagination({
        onSelectPage:function(pageNum, pageSize){
            opts.pageNumber = pageNum;
            opts.pageSize = pageSize;
            pager.pagination('refresh',{
                pageNumber:pageNum,
                pageSize:pageSize
            });
            dg.datagrid('loadData',data);
        }
    });
    if (!data.originalRows){
        data.originalRows = (data.rows);
    }
    var start = (opts.pageNumber-1)*parseInt(opts.pageSize);
    var end = start + parseInt(opts.pageSize);
    data.rows = (data.originalRows.slice(start, end));
    return data;
} 


function area_html(data){
	var result = JSON.parse(data);
	var city_data =new Array();
	city_data.push({text:"请选择",value:"-1"});
	for(var i=0;i<result.length;i++){
		var obj =new Object();
		obj.text =result[i].name;
		obj.value=result[i].name;
		city_data.push(obj);
	}
	$("#city").combobox("loadData",city_data);
	$("#city").combobox('setValue','-1');
}
	


//公司option
function company_html(data){
	var result = JSON.parse(data);
	var company_data =new Array();
	company_data.push({text:"请选择",value:"-1"});
	for(var i=0;i<result.length;i++){
		var obj =new Object();
		obj.text =result[i].name;
		obj.value=result[i].name;
		company_data.push(obj);
	}
	console.log(JSON.stringify(company_data));
	$("#company").combobox("loadData",company_data);
	$("#company").combobox('setValue','-1');
}


function img_src(name){
	return core.file_get_url+'?name='+name;
}

function randomCode(){
	var timestamp = new Date().getTime();
	var str=Math.random().toString(36).substr(2);
	alert((timestamp+str).length);
	return str+timestamp;
}

//安全退出
function loginOut(){
	window.localStorage.clear();
    window.parent.location.href="login.html";
}

function nav_html(){
	var token =window.localStorage.getItem("token");
    var nav_html='';
    if(token!=null&&token!=''){
        nav_html+='<li><a href="center.html">商户中心</a></li>';
        nav_html+='<li><a href="login.html">申请代拍</a></li>';
        nav_html+='<li><a href="JavaScript:loginOut();">安全退出</a></li>';
    }else{
        nav_html+='<li><a href="login.html">登录</a></li>';
        nav_html+='<li><a href="register.html">注册</a></li>';
        nav_html+='<li><a href="login.html">商户中心</a></li>';
        nav_html+='<li><a href="apply.html">申请代拍</a></li>';
    }
    $("#topnav").empty().append(nav_html);
}
