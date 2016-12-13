/*global Qiniu */
/*global plupload */
/*global FileProgress */
/*global hljs */

$(function() {
	bns.company_info(company_info_html);
		$("a").click(function() {
			if($(this).text()!='提交保存'){
				return;
			}
			var obj = new Object();
			obj.id =$("input[name=id]").val();
			var state =$('#state').combobox('getValue');
			obj.state =state;
			var company =$("#company").textbox('getValue');
			if(company==''){
				msgShow("系统提示","公司名称不能为空","warning");
				return;
			}
			obj.company =company;
			var address =$("#address").textbox('getValue');
			if(address==''){
				msgShow("系统提示","公司地址不能为空","warning");
				return;
			}
			obj.address =address;
			var frName =$("#frName").textbox('getValue');
			if(frName==''){
				msgShow("系统提示","法人姓名不能为空","warning");
				return;
			}
			obj.frName =frName;
			var frMobile =$("#frMobile").textbox('getValue');
			if(frMobile==''){
				msgShow("系统提示","法人电话不能为空","warning");
				return;
			}
			obj.frMobile =frMobile;
			var linkman =$("#linkman").textbox('getValue');
			if(linkman==''){
				msgShow("系统提示","负责人姓名不能为空","warning");
				return;
			}
			obj.linkman =linkman;
			var mobile =$("#mobile").textbox('getValue');
			if(mobile==''){
				msgShow("系统提示","负责人电话不能为空","warning");
				return;
			}
			obj.mobile =mobile;
			var gos =$("#gos").textbox('getValue');
			if(gos==''){
				msgShow("系统提示","业务范围不能为空","warning");
				return;
			}
			obj.gos =gos;
			var num =$("#num").textbox('getValue');
			if(num==''){
				msgShow("系统提示","每天接单数不能为空","warning");
				return;
			}
			obj.num =num;
			obj.logo=$("input[name=logo]").val();
			console.log('============='+JSON.stringify(obj));
			bns.company_save(JSON.stringify(obj),common_html);
		});
    var uploader = Qiniu.uploader({
        runtimes: 'html5,flash,html4',
        browse_button: 'pickfiles',
        max_file_size: '100mb',
        flash_swf_url: 'qiniu/bower_components/plupload/js/Moxie.swf',
        dragdrop: true,
        chunk_size: '4mb',
        multi_selection: !(mOxie.Env.OS.toLowerCase()==="ios"),
        uptoken_url: '/sys/uptoken',
        domain: core.qiniu,
        get_new_uptoken: false,
        unique_names: false,
        save_key: false,
        auto_start: true,
        log_level: 5,
        init: {
        	'Key': function(up, file) {
        		return uuid()+'.jpg';
        	},
            'FileUploaded': function(up, file, info) {
            	var res = $.parseJSON(info);
            	var img_src=core.qiniu+res.key+'?imageView2/1/w/100/h/100';
            	$("#logo").attr("src",img_src);
            }
        }
    });



});


function company_info_html(result){
		if(result==''){
			return;
		}
		var xhrObj = JSON.parse(result);
		if(xhrObj.code==101){
			$('#w').window('close');
			$.messager.confirm('系统提示', xhrObj.message, function(r) {
			    if (r) {
			        parent.$("#login").window('open');
			    }
			});
			return;
		}
		console.log(JSON.stringify(xhrObj));
		$("input[name=id]").val(xhrObj.id);
		$("#city").textbox('setValue',xhrObj.cityName);
		$("#state").combobox('setValue',xhrObj.state);
		$("#rank").textbox('setValue',xhrObj.rank==0?'普通商家':(xhrObj.rank==1?'升级中':'高级商家'));
		$("#company").textbox('setValue',xhrObj.company);
		$("#address").textbox('setValue',xhrObj.address);
		$("#frName").textbox('setValue',xhrObj.frName);
		$("#frMobile").textbox('setValue',xhrObj.frMobile);
		$("#linkman").textbox('setValue',xhrObj.linkman);
		$("#mobile").textbox('setValue',xhrObj.mobile);
		$("#gos").textbox('setValue',xhrObj.gos);
		$("#num").textbox('setValue',xhrObj.num);
		$("input[name=logo]").val(xhrObj.logo);
		
		if(xhrObj.logo!=null&&xhrObj.logo!=''){
			$("#logo_").empty().append('<img src="'+img_src(xhrObj.logo)+'" width=120px height=100px>');
		}
	}




