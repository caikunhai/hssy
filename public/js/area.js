
function Dsy(){
	this.Items = {};
}
Dsy.prototype.add = function(id,iArray){
	this.Items[id] = iArray;
}
var dsy = new Dsy();

dsy.add("0",["北京市","上海市","杭州市","广州市","深圳市","厦门市","丽江市"]);
dsy.add("1",["纽约市","伦敦","巴黎"]);

//城市列表
function list_city(type){
	var data=dsy.Items[type];
	var vo =new Array();
	vo.push({text:"请选择",value:"-1"});
	for(var i=0;i<data.length;i++){
		vo.push({text:data[i],value:data[i]});
	}
	$("#city").combobox("loadData",vo);
	$("#city").combobox('setValue','-1');
}

