/**
 * mui单按钮
 * @param title
 * @param content
 * @param btnFun
 */
function muiAlert(title, content, btnFun) {
	if (title == null || title == "undefined" || title == "") {
		title = "操作成功!";
	}
	if (content == null || content == "undefined" || content == "") {
		content = "恭喜你，操作完成";
	}
	var btnCb = function() {};
	if(btnFun != null && btnFun != "undefined") {
		btnCb = function() {
			eval(btnFun);
		}
	}
	mui.alert(content,title, btnCb);
}

/**
 * mui左右双按钮
 * @param title
 * @param content
 * @param submitFun
 * @param cancleFun
 */
function muiConfirm(title, content, submitFun, cancleFun) {
	if (title == null || title == "undefined" || title == "") {
		title = "确认操作!";
	}
	if (content == null || content == "undefined" || content == "") {
		content = "确认完成当前操作";
	}
	var btnArray = ['取消', '确定'];
	mui.confirm(content, title , btnArray, function(e) {
		if (e.index == 1) {
			eval(submitFun);
		} else {
			if($(".mui-popup-backd1rop")!=null)
			$(".mui-popup-backdrop").attr("style","display:none");
			eval(cancleFun);
			
		}
	});
}
/**
 * mui左右双按钮（包含按钮内容）
 * @param title
 * @param content
 * @param leftBtnCnt左按钮名称
 * @param rightBntCnt右按钮名称
 * @param submitFun右按钮事件
 * @param cancleFun左按钮事件
 */
function muiConfirmCnt(title, content, rightBtnCnt,leftBntCnt,submitFun, cancleFun) {
	if (title == null || title == "undefined" || title == "") {
		title = "确认操作!";
	}
	if (content == null || content == "undefined" || content == "") {
		content = "确认完成当前操作";
	}
	var btnArray = [leftBntCnt,rightBtnCnt];
	mui.confirm(content, title , btnArray, function(e) {
		if (e.index == 1) {
			eval(submitFun);
		} else {
			if($(".mui-popup-backd1rop")!=null)
			$(".mui-popup-backdrop").attr("style","display:none");
			eval(cancleFun);
			
		}
	});
}

function muiPrompt(title, content,input,submitFun,type) {
	var btnArray = ['取消', '确定'];
	mui.prompt(content, input, title, btnArray, function(e) {
		if (e.index == 1) {
			eval(submitFun+"('"  + e.value + "')");
		} else {
			if($(".mui-popup-backd1rop")!=null)
			$(".mui-popup-backdrop").attr("style","display:none");
		}
	});
	document.querySelector('.mui-popup-input input').type=type;
}
