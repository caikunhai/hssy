
function Dsy(){
	this.Items = {};
}
Dsy.prototype.add = function(id,iArray){
	this.Items[id] = iArray;
}
var dsy = new Dsy();

dsy.add("0",["北京市","上海市","杭州市","广州市","深圳市","厦门市","丽江市"]);
dsy.add("1",["纽约市","伦敦","巴黎"]);

//省份列表
function list_province(obj){
	var opt_html='<ul class=\"list_main\">';
	var province=dsy.Items["0"];
	for(var i=0;i<province.length;i++){
		if(province[i]!=undefined){
			opt_html +='<li title='+i+'><strong>'+province[i]+'</strong></li>';
		}
	}

}

