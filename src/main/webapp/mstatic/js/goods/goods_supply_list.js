mui.init({
    swipeBack: true//启用右滑关闭功能
});
var currentPageNum = 1;
var pages = 1;
var isLastPage = false;
(function ($) {
    //阻尼系数
    var deceleration = mui.os.ios ? 0.003 : 0.0009;
    $('.mui-scroll-wrapper').scroll({
        bounce: false,
        indicators: true, //是否显示滚动条
        deceleration: deceleration
    });
    $.ready(function () {
        //循环初始化所有下拉刷新，上拉加载。
        $.each(document.querySelectorAll('.mui-slider-group .mui-scroll'), function (index, pullRefreshEl) {
            $(pullRefreshEl).pullToRefresh({
                up: {
                    height: 50,//可选.默认50.触发上拉加载拖动距离
                    auto: false,//可选,默认false.自动上拉加载一次
                    contentrefresh: "正在加载...",//可选，正在加载状态时，上拉加载控件上显示的标题内容
                    contentnomore: '没有更多数据了',//可选，请求完毕若没有更多数据时显示的提醒内容；
                    callback: function () {
                        var self = this;
                        setTimeout(function () {
                            if (isLastPage) {
                                self.endPullUpToRefresh(true);
                            } else {
                                queryGoodsList('GY', currentPageNum + 1);
                                self.endPullUpToRefresh();
                            }
                        }, 1000);
                    }
                }
            });
        });
    });
})(mui);

$(function () {

    //初始化页面
    initPage();
    //初始化列表
    queryGoodsList('GY', currentPageNum);
    //初始化area_list
    //查询省市
    queryAllCitys();


});

function initPage(){
    $(document).on("tap",function(e){
        e.stopPropagation();
        $(".pop_alert,.mask").hide();
        $(".icon-shangsanjiao-copy").attr("class","iconfont icon-xiasanjiao-copy f18 black3");
        $(".t_nav a").removeClass("cur");
        return false;
    });
    $("input").on("tap",function(e){
        e.stopPropagation();
        return false;
    });
    //点击筛选内容
    $('.t_nav').on('tap', 'a', function(e){
        e.stopPropagation();
        var _this=$(this);
        $(".pop_alert").hide();
        $(".mask").height($(window).height()).show();
        if($(this).hasClass("qy")){
            $(".ic_area").hide();
            $(".i_city").show();
            if($(this).hasClass("cur")){
                $("#area,.mask").hide();
                $(this).removeClass("cur");
                $(" i",_this).attr("class","iconfont icon-xiasanjiao-copy f18 black3");
            }else{
                $("#area,.mask").show();
                $(this).addClass("cur");
                $(" i",_this).attr("class","iconfont icon-shangsanjiao-copy f18 d_blue");
            }
        }else if($(this).hasClass("px")){
            if($(this).hasClass("cur")){
                $("#paixu,.mask").hide();
                $(this).removeClass("cur");
                $(" i",_this).attr("class","iconfont icon-xiasanjiao-copy f18 black3");
            }else{
                $("#paixu,.mask").show();
                $(this).addClass("cur");
                $(" i",_this).attr("class","iconfont icon-shangsanjiao-copy f18 d_blue");
            }
        }else{
            if($(this).hasClass("cur")){
                $("#shaixuan,.mask").hide();
                $(this).removeClass("cur");
                $(" i",_this).attr("class","iconfont icon-xiasanjiao-copy f18 black3");
            }else{
                $("#shaixuan,.mask").show();
                $(this).addClass("cur");
                $(" i",_this).attr("class","iconfont icon-shangsanjiao-copy f18 d_blue");
            }
        }
    });

    //city
    //city
    $("body").on("tap",".i_city li",function(e){
        //获取省名字
        var provinceName=$(this).text();
        //赋值
        $(".sheng").val(provinceName);
        var areaId = $(this).attr("data");
        var areaAxis = $(this).attr("data_1");
        if(areaId==0){
            $(".pop_alert,.mask").hide();
            $(".t_nav i").attr("class","iconfont icon-xiasanjiao-copy f18 black3");
            $(".qy").removeClass("cur");
            $("#q_area").val("");
            $("#content_list").html("");
            queryGoodsList('GY', 1);
        }else{
            $("#q_area").val(areaId);
            //2级遍历
            $("#q_leavl").val(2);
            queryCitysByAreaId($(this).attr("data"),2);
            $("#content_list").html("");
            queryGoodsList('GY', 1);
        }
        $(".area").html(provinceName);
        $(".i_city").hide();
        $(".ic_qy").show();
        e.stopPropagation();
    });
    $("body").on("tap",".ic_qy li",function(e){
        var cityName=$(this).text();
        var provinceName=$(".sheng").val();
        $(".shi").val(cityName);
        var areaId = $(this).attr("data");
        var areaAxis = $(this).attr("data_1");
        if(areaId==0){
            $(".pop_alert,.mask").hide();
            $(".t_nav i").attr("class","iconfont icon-xiasanjiao-copy f18 black3");
            $(".qy").removeClass("cur");
            $(".area").html(provinceName);
        }else{
            $(".area").html(cityName+provinceName);
            $("#q_area").val(areaId);
            //2级遍历
            $("#q_leavl").val(1);
            queryCitysByAreaId($(this).attr("data"),3);
        }
        $("#content_list").html("");
        queryGoodsList('GY', 1);
        $(".ic_qy").hide();
        $(".ic_area").show();
        e.stopPropagation();
    });
    $("body").on("tap",".ic_area li",function(e){
        e.stopPropagation();
        var provinceName=$(".sheng").val();
        var cityName=$(".shi").val();
        var areaName=$(this).text();
        var areaId = $(this).attr("data");
        var areaAxis = $(this).attr("data_1");
        if(areaId==0){
            $(".area").html(provinceName+cityName);
        }else{
            $("#q_area").val(areaId);
            //2级遍历
            $("#q_leavl").val(0);
            queryCitysByAreaId($(this).attr("data"),3);
            $(".area").html(areaName+cityName+provinceName);
        }
        $("#content_list").html("");
        queryGoodsList('GY', 1);
        $(".pop_alert,.mask").hide();
        $(".t_nav i").attr("class","iconfont icon-xiasanjiao-copy f18 black3");
        $(".qy").removeClass("cur");
    });














    /*$("body").on("tap",".i_city li",function(e){
        //获取省名字
        var provinceName=$(this).text();
        //赋值
        $(".sheng").val(provinceName);
        var areaId = $(this).attr("data");
        var areaAxis = $(this).attr("data_1");
        if(areaId==0){
            $(".pop_alert,.mask").hide();
            $(".t_nav i").attr("class","iconfont icon-xiasanjiao-copy f18 black3");
            $(".qy").removeClass("cur");
        }else{
            $("#q_area").val(areaAxis);
            queryCitysByAreaId($(this).attr("data"),2);
            $("#content_list").html("");
            queryGoodsList('GY', 1);
        }
        $(".area").html(provinceName);
        $(".i_city").hide();
        $(".ic_qy").show();
        $("body").on("tap",".ic_qy li",function(e){
            var cityName=$(this).text();
            var provinceName=$(".sheng").val();
            $(".shi").val(cityName);
            var areaId = $(this).attr("data");
            var areaAxis = $(this).attr("data_1");
            if(areaId==0){
                $(".pop_alert,.mask").hide();
                $(".t_nav i").attr("class","iconfont icon-xiasanjiao-copy f18 black3");
                $(".qy").removeClass("cur");
                $(".area").html(provinceName);
            }else{
                $(".area").html(cityName+provinceName);
                $("#q_area").val(areaAxis);
                queryCitysByAreaId($(this).attr("data"),3);
            }
            $("#content_list").html("");
            queryGoodsList('GY', 1);
            $(".ic_qy").hide();
            $(".ic_area").show();
            e.stopPropagation();
            $("body").on("tap",".ic_area li",function(e){
                e.stopPropagation();
                var provinceName=$(".sheng").val();
                var cityName=$(".shi").val();
                var areaName=$(this).text();
                var areaId = $(this).attr("data");
                var areaAxis = $(this).attr("data_1");
                if(areaId==0){
                    $(".area").html(provinceName+cityName);
                }else{
                    $("#q_area").val(areaAxis);
                    queryCitysByAreaId($(this).attr("data"),3);
                    $(".area").html(areaName+cityName+provinceName);
                }
                $("#content_list").html("");
                queryGoodsList('GY', 1);
                $(".pop_alert,.mask").hide();
                $(".t_nav i").attr("class","iconfont icon-xiasanjiao-copy f18 black3");
                $(".qy").removeClass("cur");
            });
        });
        e.stopPropagation();
    });*/

    //排序
    $(".tlist").each(function(index){
        var pxli=$(this).find("li");
        var t=$(".pxn");
        pxli.on("tap",function(e){
            e.stopPropagation();
            var number_obj = $(this).attr("data_number");
            if(!checkNull(number_obj)){
                $("#q_order_num_column").val(number_obj);
                $("#q_order_price_column").val("");
            }
            var price_obj = $(this).attr("data_price");
            if(!checkNull(price_obj)){
                $("#q_order_num_column").val("");
                $("#q_order_price_column").val(price_obj);
            }
            t.text($(this).text());
            $(".mask,.pop_alert").hide();
            $(".t_nav i").attr("class","iconfont icon-xiasanjiao-copy f18 black3");
            $(".t_nav a").removeClass("cur");
            //清空列表
            $("#content_list").html("");
            queryGoodsList('GY', 1);
        });
    });

    //排序切换
    $(".sider").each(function(index){
        var pxqh=$(this).find("li");
        pxqh.on("tap",function(e){
            e.stopPropagation();
            var idx=$(this).index();
            $(this).addClass("cur").siblings().removeClass("cur");
            $("#tCont").children().eq(idx).show().siblings().hide();
        })
    });
    //重置
    $("#chongzhi").on("tap",function(e){
        e.stopPropagation();
        $("input").val("");
        $(".sxlei a").removeClass("cur");
        $(".sxlei .all").addClass("cur");
    });
    //确定
    $("#qrBtn").on("tap",function(e){
        e.stopPropagation();
        $(".mask,.pop_alert").hide();
        $(".t_nav i").attr("class","iconfont icon-xiasanjiao-copy f18 black3");
        //清空列表
        $("#content_list").html("");
        queryGoodsList('GY', 1);
    });
    //筛选
    $(".sxlei").each(function(index){
        var li=$(this).find("a");
        var t=$(this).find(".radio");
        li.on("tap",function(e){
            if(typeof($(this).attr("data_category"))!="undefined"){
                $("#q_goods_category").val($(this).attr("data_category"));
            }
            if(typeof($(this).attr("data_kinds"))!="undefined"){
                $("#q_goods_kinds").val($(this).attr("data_kinds"));
            }
            if(typeof($(this).attr("data_gender"))!="undefined"){
                $("#q_goods_gender").val($(this).attr("data_gender"));
            }
            e.stopPropagation();
            li.removeClass("cur");
            $(this).addClass("cur").siblings().removeClass("cur");
        });
    });
    //点击更多
    // $(".d_pz").delegate(".dmore","click",function(e){
    $(".dmore").on("tap",function(e){
        e.stopPropagation();
        var _parent=$(this).parent().parent();
        if($(".sxlei1",_parent).is(":hidden")){
            $(".sxlei1",_parent).show();
            $(this).removeClass("cur").hide();
        }else{
            $(".sxlei1",_parent).hide();
            $(".dmore").removeClass("cur").show();
        }
    });
}

function checkNull(keyVal) {
    if (keyVal == undefined || keyVal == "" || keyVal == null) {
        return true;
    } else {
        return false;
    }
}

function queryGoodsList(type, pageNum) {
    var param = {};
    param.type = type;
    param.selfType = "other";
    param.pageNum = pageNum;
    param.pageSize = 10;

    //构造查询条件
    var queryConditionForm = new Object();
    queryConditionForm.qArea = $("#q_area").val();
    queryConditionForm.qAreaLevel = $("#q_leavl").val();
    queryConditionForm.orderNumColumn = $("#q_order_num_column").val();
    queryConditionForm.orderPriceColumn = $("#q_order_price_column").val();
    queryConditionForm.goodsCategory = $("#q_goods_category").val()=="ALL"?"":$("#q_goods_category").val();
    queryConditionForm.goodsKinds = $("#q_goods_kinds").val()=="ALL"?"":$("#q_goods_kinds").val();
    queryConditionForm.goodsGender = $("#q_goods_gender").val()=="ALL"?"":$("#q_goods_gender").val();
    queryConditionForm.goodsMaxWeight = $("#q_goods_max_weight").val();
    queryConditionForm.goodsMinWeight = $("#q_goods_min_weight").val();

    param.queryConditionForm=queryConditionForm;
    function successBack(resp) {
        var data = {};
        if (resp.code == 0) {
            //赋值
            currentPageNum = pageNum;
            pages = resp.page.pages;
            isLastPage = resp.page.isLastPage;
            data = {items: resp.data};

            var html = template('goodsListTpl', data);
            $("#content_list").append(html);
        }
    }

    function errorBack(XMLHttpRequest, textStatus, errorThrown) {
        alert(errorThrown);
    }

    muiReqJsonPost("mob/goods/selectGoodsList", param, successBack, errorBack);
}



template.helper("getStatus", function (status) {
    switch (status) {
        case "CS":
            return "初始";
        case "WSH":
            return "未审核";
        case "TG":
            return "审核通过";
        case "BTG":
            return "审核不通过";
        case "DS":
            return "等待出售";
        case "SJ":
            return "上架";
        case "XJ":
            return "下架";
        case "YS":
            return "已售";
    }
});

//点击查看详情
$("#content_list").on("tap","li",function(){
    var id=$(this).attr("data");
    self.location.href="/mob/goods/selectGoodsById/"+id+"/supply";
});
