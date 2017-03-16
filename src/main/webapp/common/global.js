var ajaxGet = function (url, param, callback, method,errorback) {
	if (!isNotEmpty(method) || method == 'GET') {
		$.ajax({
			type : "GET",
			url : contextPath + '/' + url,
			data : param,
			dataType : 'json',
			success : function(data) {
				callback(data);
			},
			error:function(xhr,type,errorThrown){
				//异常处理；
				errorback(errorThrown);
			}
		});
	}
var ajaxPost = function(){
		$.ajax({
			type : "POST",
			url : contextPath + '/' + url,
			data : param,
			dataType : 'json',
			success : function(data) {
				callback(data);
			},
			error:function(xhr,type,errorThrown){
				//异常处理；
				errorback(errorThrown);
			}
		});
	}
}

// 变量不为空的判断
function isNotEmpty(v) {
	if (v != undefined && v != null && v != "") {
		return true;
	} else {
		return false;
	}
}

/**
 * 对Date的扩展，将 Date 转化为指定格式的String 月(M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q)
 * 可以用 1-2 个占位符 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) eg: (new
 * Date()).pattern("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 (new
 * Date()).pattern("yyyy-MM-dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04 (new
 * Date()).pattern("yyyy-MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04 (new
 * Date()).pattern("yyyy-MM-dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04 (new
 * Date()).pattern("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18
 */     
Date.prototype.pattern=function(fmt) {      
    var o = {
    "M+" : this.getMonth()+1, // 月份
    "d+" : this.getDate(), // 日
    "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, // 小时
    "H+" : this.getHours(), // 小时
    "m+" : this.getMinutes(), // 分
    "s+" : this.getSeconds(), // 秒
    "q+" : Math.floor((this.getMonth()+3)/3), // 季度
    "S" : this.getMilliseconds() // 毫秒
    };      
    var week = {      
    "0" : "/u65e5",      
    "1" : "/u4e00",      
    "2" : "/u4e8c",      
    "3" : "/u4e09",      
    "4" : "/u56db",      
    "5" : "/u4e94",      
    "6" : "/u516d"     
    };      
    if(/(y+)/.test(fmt)){      
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));      
    }      
    if(/(E+)/.test(fmt)){      
        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[this.getDay()+""]);      
    }      
    for(var k in o){      
        if(new RegExp("("+ k +")").test(fmt)){      
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));      
        }      
    }      
    return fmt;      
}

// 点击后将焦点定位于内部的input元素中
function clickFocus(clickObj){
	$(clickObj).find('input:first').focus();
}

// 点击智农通左上角关闭按钮， 智农通调用H5页面的js方法获取该页面公共账号ID，打开对话页
function getPublicID(fun) {
    var publicId = '96';
    if (/(iPhone|iPad|iPod|iOS)/.test(navigator.userAgent)) {
        return publicId;
    } else{
        window.location.href = "javascript:window.oatongJSBridge." + fun + "('" + publicId + "')";
    }
}

// 判断是否移动端
function isMobile()
{
	var pda_user_agent_list = new Array("2.0 MMP", "240320", "AvantGo","BlackBerry", "Blazer",
			"Cellphone", "Danger", "DoCoMo", "Elaine/3.0", "EudoraWeb", "hiptop", "IEMobile", "KYOCERA/WX310K", "LG/U990",
			"MIDP-2.0", "MMEF20", "MOT-V", "NetFront", "Newt", "Nintendo Wii", "Nitro", "Nokia",
			"Opera Mini", "Opera Mobi",
			"Palm", "Playstation Portable", "portalmmm", "Proxinet", "ProxiNet",
			"SHARP-TQ-GX10", "Small", "SonyEricsson", "Symbian OS", "SymbianOS", "TS21i-10", "UP.Browser", "UP.Link",
			"Windows CE", "WinWAP", "Android", "iPhone", "iPod", "iPad", "Windows Phone", "HTC");
	var pda_app_name_list = new Array("Microsoft Pocket Internet Explorer");
	var user_agent = navigator.userAgent.toString();
	for (var i=0; i<pda_user_agent_list.length; i++) {
		if (user_agent.indexOf(pda_user_agent_list[i]) >= 0) {
			return true;
		}
	}
	var appName = navigator.appName.toString();
	for (var i=0; i<pda_app_name_list.length; i++) {
		if (user_agent.indexOf(pda_app_name_list[i]) >= 0) {
			return true;
		}
	}
	return false;
}
//数组索引
Array.prototype.indexOf = function(val) {
    for (var i = 0; i < this.length; i++) {
        if (this[i] == val) return i;
    }
    return -1;
};
//删除指定元素
Array.prototype.remove = function(val) {
    var index = this.indexOf(val);
    if (index > -1) {
        this.splice(index, 1);
    }
};
