$(function(){
	//返回顶部
	$("#returnTop").click(function () {
		var speed=200;//滑动的速度
		// $('body,html').scroll(0,0);
		// $(".mui-scroll").addClass("d_trans");
		$(".mui-scroll").removeAttr("style");
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
})
function checkBottomTab(index){
	$(".d_footer a:eq("+index+")").addClass("mui-active").siblings().removeClass("mui-active");
}
$(".mui-search input").focus(function(){
	$(this).css("text-align","left");
	$(".mui-placeholder").addClass("mui-pactive");
});
