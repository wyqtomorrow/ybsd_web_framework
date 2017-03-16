var currentPageNum = 1;
var pages = 1;
var array = new Array();
array.push("CS");
array.push("WSH");
var tagFlag = "newGoods";
mui('.mui-slider').slider().setStopped(true);

mui.init({
    pullRefresh: {
        container: '#refreshContainer',
        up: {
            auto: true,
            contentrefresh: '正在加载...',
            contentnomore: '没有更多数据了',
            callback: function () {
                setTimeout(function () {
                    queryGoodsAuditList(currentPageNum, array, tagFlag);
                }, 200);
            }
        }
    }
});

$(function () {
    $("#sliderSegmentedControl").on("tap", "#new_goods", function () {
        tagFlag = 'newGoods';
        array.length = 0;
        array.push("CS");
        array.push("WSH");
        currentPageNum=1;
        $("#content").html("");
        mui('#refreshContainer').pullRefresh().refresh(true);
        queryGoodsAuditList(1, array, tagFlag);
    });
    $("#sliderSegmentedControl").on("tap", "#audited_goods", function () {
        tagFlag = 'audited';
        array.length = 0;
        array.push("TG");
        array.push("BTG");
        array.push("SJ");
        array.push("XJ");
        array.push("YS");
        currentPageNum=1;
        $("#content").html("");
        mui('#refreshContainer').pullRefresh().refresh(true);
        queryGoodsAuditList(1, array, tagFlag);
    });

    $("#seachDiv").on("tap","#seachGoods", function () {
        $("#content").html("");
        mui("#refreshContainer").pullRefresh().endPullupToRefresh(false);
        mui('#refreshContainer').pullRefresh().refresh(true);
        queryGoodsAuditList(1, array, tagFlag);
    });

    $("#content").on("tap", "#updateGoodsStatus", function () {
        var obj = $(this);
        var id = $(this).attr("data-id");
        var status = $(this).attr("data-status");
        var url = "mob/goods/updateStatusByOffAndOn";
        var param = {};
        param.id=id;
        param.status=status;
        var successBack = function (result) {
            if (result.code == "0") {
                obj.parents(".mui-table-view-cell.mui-media").remove();
            }
        }
        muiReqJsonPost(url, param, successBack);
    });
});

//点击查看详情
$("#content").on("tap","#liModel",function(){
    var id=$(this).attr("data-id");
    self.location.href="/mob/goods/selectAuditGoodsById/"+id+"/goods_audit_purchase_detail";
});


function queryGoodsAuditList(pageNum, array, flag) {
    var param = {};
    param.pageNum = pageNum;
    param.keywords = $("#keywords").val();
    param.listStatus = array;
    param.type="QG";
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
            var html = "";
            if (flag == 'newGoods') {
                html = template('goodsListTpl', data);
            } else {
                html = template('goodsAuditedListTpl', data);
            }
            $("#content").append(html);
            if (isLastPage) {
                mui("#refreshContainer").pullRefresh().endPullupToRefresh(true);
            } else {
                currentPageNum=currentPageNum+1;
                mui("#refreshContainer").pullRefresh().endPullupToRefresh(false);
            }
        } else if (data.code == 5) {
            znt.zntLogOut();
        } else {
            muiAlert("提示", data.exception);
        }
    }

    function errorBack() {

    }

    muiReqJsonPost("mob/goods/queryUserAuditGoodsList", param, successBack, errorBack);
}