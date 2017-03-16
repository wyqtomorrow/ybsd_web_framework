$(function(){
    $(".t_nav a").click(function(e){
        e.stopPropagation();
        var _this=$(this);
        $(".pop_alert").hide();
        $(".mask").height($(window).height()).show();
        if($(this).hasClass("qy")){
            $("#yzjs").show();
        }else{
            $("#paixu").show();
        }
        var idx=$(this).index();
        $(this).addClass("cur").siblings().removeClass("cur");
        $("i",_this).attr("class","iconfont icon-shangsanjiao-copy f18");
    });
    $('body').on('tap', 'a', function(){
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

    $("#yzjs").each(function(index){
        var li=$(this).find("li");
        var yzjs=$(".yzjs");
        li.click(function(){
            yzjs.text($(this).text());
            $(".mask,.pop_alert").hide();
            $(".t_nav i").attr("class","iconfont icon-xiasanjiao-copy f18 black3");
        })
    });
    $("#paixu").each(function(index){
        var li=$(this).find("li");
        var t=$(".pxn");
        li.click(function(){
            t.text($(this).text());
            $(".mask,.pop_alert").hide();
            $(".t_nav i").attr("class","iconfont icon-xiasanjiao-copy f18 black3");
        })
    });
});
var pageNum = 1;
var temp = "{{if items}}"
    + "{{each items}}"
    + "<li class='mui-table-view-cell mui-media'>"
    +"<a href='toArticleContent.do?articleId={{$value.articleId}}&title={{$value.title}}&colName={{$value.colName}}&backArticle={{$value.articleName}}'>"
    + "{{if $value.picUrl!= 'null' && $value.picUrl!= ''&& $value.picUrl!= null}}"
    + "<img class='mui-media-object mui-pull-left mui_img1' src='{{$value.picUrl}}'>"
    +"{{/if}}"
    +"<div class='mui-media-body black3'>"
    +"{{$value.title}}"
    +"<p class='mui-ellipsis d_blue'>{{$value.colName}}</p>"
    +"</div></a></li>"
    + "{{/each}}"
    +"{{/if}}";
var deceleration = mui.os.ios?0.003:0.0009;

mui('.mui-scroll-wrapper').scroll({
    bounce: false,
    indicators: true, //是否显示滚动条
    deceleration:deceleration
});

mui.init({
    pullRefresh: {
        container: '#refreshContainer',
        up: {
            auto: true,
            //height:5,
            contentrefresh: '正在加载...',
            contentnomore: '没有更多数据了',
            callback: function () {
                var self = this;
                muiGet("mob/cms/searchColumnArticle.do", {
                    pageNum: pageNum,
                    pageSize: 5,
                    columnName: $("#columnsName").val()
                }, function(res){
                    var data = {};
                    var html = "";
                    var result = res.page.pages;
                    if (result != "undefined" && result != "0") {
                        currentPageNum = pageNum;
                        data = {items: res.data};
                        var render = template.compile(temp);
                        html = render(data);
                        if(pageNum == 1){
                            $("#cmsListTpl").empty();
                            $("#cmsListTpl").append(html);
                            mui('#refreshContainer').pullRefresh().refresh(true);

                        }else{
                            $("#cmsListTpl").append(html);
                        }
                        if (result <= pageNum) {
                            self.endPullupToRefresh(true);
                        }else{
                            self.endPullupToRefresh(false);
                        }
                        pageNum++;
                    }else{
                        $("#cmsListTpl").empty();
                        $(".hk_list").css("transform","translate3d(0px, 0px, 0px) translateZ(0px)");
                        self.endPullupToRefresh(true);
                    }
                }, null);
            }
        }
    }
});
//切换栏目
function changeColumn(colName){
    if($("#columnsName").val()!=colName){
        $("#columnsName").val(colName);
        pageNum=1;
        //刷新框架内容
        mui('#refreshContainer').pullRefresh().pullupLoading();
    }
}