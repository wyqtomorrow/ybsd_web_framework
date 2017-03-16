$(function(){
	/*$(document).on("tap",function(e){
		e.stopPropagation();
		$(".pop_alert,.mask").hide();
		$(".icon-shangsanjiao-copy").attr("class","iconfont icon-xiasanjiao-copy f18 black3");
		$(".t_nav a").removeClass("cur");
	});
	$("input").on("tap",function(e){
		e.stopPropagation();
	});*/
	//返回顶部
	$("#returnTop").click(function () {
		var speed=200;//滑动的速度
		$('body,html').animate({ scrollTop: 0 }, speed);
		$("div").scrollTop(0);
		return false;
	});
	//
	/*$('body').on('tap', 'a', function(){
		var href = $(this).attr('href');
		if(typeof href === 'undefined'){
			return false;
		}
		if($(this).attr('target') === '_blank'){
			window.open(href);
		}
		if(href.indexOf('#') < 0 || href.indexOf('#') > 1){
			window.open(href,'_self');
		}
	});
	//单选
	$(".ip_href").each(function(index){
		var li=$(this).find("li");
		var t=$(this).find(".radio");
		li.click(function(){
		  t.val(li.index(this));
			$(this).addClass("cur").siblings().removeClass("cur");
		})
	});*/
	//
	if($(".mui-bar-nav").is(":visible")){
		$(".pop_alert").css("top","90px");
	}else{
		$(".pop_alert").css("top","40px");
	}
})
