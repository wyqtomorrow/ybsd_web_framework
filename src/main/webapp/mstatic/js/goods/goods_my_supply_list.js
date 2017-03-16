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
                    auto: true,//可选,默认false.自动上拉加载一次
                    contentrefresh: "正在加载...",//可选，正在加载状态时，上拉加载控件上显示的标题内容
                    contentnomore: '没有更多数据了',//可选，请求完毕若没有更多数据时显示的提醒内容；
                    callback: function () {
                        var self = this;
                        setTimeout(function () {
                            if (isLastPage) {
                                self.endPullUpToRefresh(true);
                            } else {
                                queryGoodsList('GY', currentPageNum + 1, self);
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

    //初始化列表
    //queryGoodsList('GY', currentPageNum);

    //上下架
    $("#content").on('tap', '#offGoods,#onGoods', function () {
        var currentObj = $(this);
        var id = $(this).parent().attr("id");
        var status = $(this).attr("data");
        var btnArray = ['取消', '确定'];
        var temp = "";
        var title = "";
        if (status == 'SJ') {
            temp = "您确认上架本条信息吗？";
            title = "上架提示";
        } else {
            temp = "您确认下架本条信息吗？下架后，别人将无法看到该信息";
            title = "下架提示";
        }
        var btncon = temp;
        mui.confirm(btncon, title, btnArray, function (e) {
            var param = {};
            param.id = id;
            param.status = status;
            function successBack(data) {
                if (data.code == 0) {
                    //修改文字信息
                    if (status == 'SJ') {
                        $(currentObj).parent().prev().html('上架');
                        $(currentObj).html('下架');
                        $(currentObj).attr("data", "XJ");
                    } else {
                        $(currentObj).html('上架');
                        $(currentObj).attr("data", "SJ");
                        $(currentObj).parent().prev().html('下架');
                    }
                } else if (data.code == 5) {
                    znt.zntLogOut();
                } else {
                    muiAlert("提示", data.exception);
                }
            }

            function errorBack(XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            }

            muiReqJsonPost("mob/goods/updateStatusByOffAndOn", param, successBack, errorBack);
        });
    });


    //删除
    $("#content").on('tap', '#delete', function () {
        var id = $(this).parent().attr("id");
        var btnArray = ['确定','取消'];
        var btncon = "确定删除该条商品吗?";
        mui.confirm(btncon, "删除商品", btnArray, function (e) {

            if(e.index==0){
                var param = {};

                function successBack(data) {
                    if (data.code == 0) {
                        window.location.href = "/mob/goods/queryMyGoodsListView/supply_list";
                    } else if (data.code == 5) {
                        znt.zntLogOut();
                    } else {
                        muiAlert("提示", data.exception);
                    }
                }

                function errorBack() {

                }

                muiGet("mob/goods/deleteGoodsById/" + id, param, successBack, errorBack);
            }

        });
    });

    $("#content").on('tap', '#update', function () {
        var id = $(this).parent().attr("id");
        var btnArray = ['取消', '确定'];
        var btncon = "确定修改该条商品吗?";
        mui.confirm(btncon, "修改商品", btnArray, function (e) {
            if(e.index==1){
                window.location.href = "/mob/goods/updateGoodsById/" + id + "/supply";
            }

        });
    });

    $("#purchase_id").on('tap', function () {
        window.location.href = "/mob/goods/queryMyGoodsListView/purchase_list";
    });
});

function queryGoodsList(type, pageNum, self) {
    var param = {};
    param.type = type;
    param.selfType = "my";
    param.pageNum = pageNum;
    param.pageSize = 10;
    function successBack(resp) {
        console.log(resp);
        var data = {};
        if (resp.code == 0) {
            //赋值
            currentPageNum = pageNum;
            pages = resp.page.pages;
            isLastPage = resp.page.isLastPage;
            data = {items: resp.data};

            var html = template('goodsListTpl', data);
            $("#content").append(html);
            if (isLastPage) {
                self.endPullUpToRefresh(true);
            } else {
                self.endPullUpToRefresh(false);
            }
        } else if (data.code == 5) {
            znt.zntLogOut();
        } else {
            muiAlert("提示", data.exception);
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
template.helper("getAttr", function (attrList, attrKey) {
    $(attrList).each(function (index) {
        if ($(this).attrDefId == attrKey) {
            return $(this).val;
        }
    });
});
