
function Dsy(){
	this.Items = {};
}
Dsy.prototype.add = function(id,iArray){
	this.Items[id] = iArray;
}
var dsy = new Dsy();

dsy.add("0",["北京","上海","杭州","广州","深圳","厦门","丽江"]);
dsy.add("1",["纽约","伦敦","巴黎"]);

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

function area_data(type){
	return dsy.Items[type];
}