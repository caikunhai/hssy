var time = {
	/**
     * 当前时间
     */
    nowDate: function () {
        return formatDate(new Date(),"yyyy-MM-dd hh:mm:ss");
    },
    /**
     * 格式化日期（不含时间）
     */
    formatterDate: function (now) {
        if (now == undefined) {
            return "";
        }
        var year=now.getFullYear();     
	    var month=now.getMonth()+1;     
	    var date=now.getDate();     
	    var hour=now.getHours();     
	    var minute=now.getMinutes();     
	    var second=now.getSeconds();     
	    return year+"-"+month+"-"+date;    
    },
    
    /**
     * 格式化日期（不含时间）
     */
    formatterDate2: function (now) {
	    return time.formatterDate(new Date(now));    
    },
    /**
     * 格式化去日期（含时间）
     */
    formatterDateTime: function (now) {
        if (now == undefined) {
            return "";
        }
        var year=now.getFullYear();     
	    var month=now.getMonth()+1;     
	    var date=now.getDate();     
	    var hour=now.getHours();     
	    var minute=now.getMinutes();     
	    var second=now.getSeconds(); 
	    return year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
	},
	/**
     * 格式化去日期（含时间）
     */
    formatterDateTime2: function (now) {
	    return time.formatterDateTime(new Date(now));
	},
};