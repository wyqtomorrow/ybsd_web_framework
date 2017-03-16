function scroll(obj) {
	var tmp = (obj.scrollLeft)++;
	//当滚动条到达右边顶端时
	if (obj.scrollLeft==tmp) obj.innerHTML += obj.innerHTML;
	//当滚动条滚动了初始内容的宽度时滚动条回到最左端
	if (obj.scrollLeft>=obj.firstChild.offsetWidth) obj.scrollLeft=0;
}
var a =	setInterval("scroll(document.getElementById('scrollobj'))",50);
function aa(){
	clearInterval(a);
}
function b(){
	a=setInterval("scroll(document.getElementById('scrollobj'))",30);
}

function ajaxJson(url, param, callback, method) {
	if (!isNotEmpty(method) || method == 'GET') {
		$.ajax({
			type : "GET",
			url : url,
			data : param,
			dataType : 'json',
			success : function(data) {
				callback(data);
			}
		});
	} else {
//		$.post(contextPath + '/' + url, param, function(data) {
//			callback(data);
//		}, "json");
//
		$.ajax({
			type : "POST",
			url : url,
			data : param,
//			contentType:'application/json',
			dataType : 'json',
			success : function(data) {
				callback(data);
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
