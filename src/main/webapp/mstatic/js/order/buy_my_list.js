/**
 * Created by Administrator on 2016/12/6.
 */
var pageNum = Number($("#List").attr("current-page-no"));
var temp = "{{if items}}"
    + "{{each items}}"
    + '<ul class="mui-table-view ">'
    + '	<li class="mui-table-view-cell mui-media" data-id="{{$value.idStr}}">'
    + '	<div class="padd15_l" id="orderDetail">'
    + '{{if $value.goodsDetailResForm.thumbnailUrl != null}}'
    + '			<img class="mui-media-object  mui-pull-left" src="{{$value.goodsDetailResForm.thumbnailUrl}}">'
    + '{{else}}'
    + '			<img class="mui-media-object  mui-pull-left" src="/mstatic/img/defaulthead.png">'
    + '{{/if}}'
    + '				<div class="mui-media-body">'
    + '					<p class="d_blue">'
    + '{{if $value.goodsDetailResForm.shopResForm.shopName != null}}'
    + '						<span class="iconfont icon-zhifumaijiashu2 f20 valign"></span>卖家：{{$value.goodsDetailResForm.shopResForm.shopName}}'
    + '{{else}}'
    + '						<span class="iconfont icon-zhifumaijiashu2 f20 valign"></span>卖家：{{$value.goodsDetailResForm.shopResForm.linkman}}'
    + '{{/if}}'
    + '					</p>'
    + '					<p class="black3">'
    + '						<span>{{$value.goodsDetailResForm.mapAttr.GAV_VARIETY}}<em class="pad10-l"></em>{{$value.goodsDetailResForm.mapAttr.GAV_YEAR_AGE}}<em class="pad10-l"></em>{{$value.goodsDetailResForm.categoryName}}</span>'
    + '						<span class="mui-pull-right"><em class="d_blue  arial">{{$value.finalGoodsNum}}</em>{{$value.goodsNumUnitTxt}}</span>'
    + '					</p>'
    + '				</div>'
    + '			</div>'
    + '{{if $value.typeSign == 1}}'
    + '		<div class="d_line"></div>'
    + '		<div class="mui-media-body padd15_l">'
    + '			<p class="black3">'
    + '				<span class="mui-pull-right d_btn">'
    + '					<button  class="mui-btn mui-btn-danger alertBtn" id="cancel">取消订单</button>'
    + '					<button  class="mui-btn mui-btn-primary" id="submit">确认收货</button>'
    + '				</span>'
    + '			</p>'
    + '		</div>		'
    + '{{else if $value.typeSign == 2}}'
    + '{{/if}}'
    + '	</li>'
    + '</ul>'
    + "{{/each}}"
    + "{{/if}}";


mui.init({
    pullRefresh: {
        container: '#refreshContainer',
        // down: {
        // 	callback: pulldownRefresh
        // },
        up: {
            auto: true,
            contentrefresh: '正在加载...',
            contentnomore: '没有更多数据了',
            callback: function () {
                setTimeout(function () {
                    fullTo()
                }, 200);
            }
        }
    }
});

//if (mui.os.plus) {
//    mui.plusReady(function() {
//        setTimeout(function() {
//            mui('.mui-scroll-wrapper').pullRefresh().pullupLoading();
//        }, 1000);
//
//    });
//} else {
//    mui('.mui-scroll-wrapper').pullRefresh().pullupLoading();}


function fullTo() {
    var param = new Object();
    param.systemId = 1;
    param.role = "BUYER";
    param.pageNum = pageNum;
    param.pageSize = 10;
    if ($("#jinxing").hasClass("mui-active")) {
        param.type = "FORMAL";
    } else {
        param.type = "DONE";
    }
    var successCb = function (res) {
        var data = {};
        var html = "";
        var result = res.page.pages;
        if (result != "undefined" && result != "0") {
            currentPageNum = pageNum;
            data = {items: res.data};
            var render = template.compile(temp);
            html = render(data);
            $("#List").append(html);
        } else {
            //html1 = "<li class='mui-table-view-cell mui-media'>您暂时没有发布的商品</li>";
            //$("#List").append(html1)
        }
        if (result <= pageNum) {
            mui(".mui-scroll-wrapper").pullRefresh().endPullupToRefresh(true);
            //mui(".mui-scroll-wrapper").pullRefresh().disablePullupToRefresh();
        } else {
            mui(".mui-scroll-wrapper").pullRefresh().endPullupToRefresh(false);
        }
        pageNum++
        console.log(pageNum);
    }
    muiGet("mob/order/orderListShow.do", param, successCb, null)
}

mui("body").on("tap", "#wancheng", function () {
    self.location.href = "/mob/order/orderBuyList?sign=" + "1";
})

mui("body").on("tap", "#jinxing", function () {
    self.location.href = "/mob/order/orderBuyList";
})
//取消订单按钮
mui("body").on("tap", "#cancel", function () {
    var idOrder = $(this).parents("li").attr("data-id");
    var btnArray = ['取消', '确定'];
    mui.confirm('', '确定取消该订单吗?', btnArray, function (e) {
        if (e.index == 0) {
            return false;
        } else if (e.index == 1) {
            var param = {
                orderId:idOrder
            }
            var successCb = function (data) {
                self.location.href = "/mob/order/orderBuyList";
            }
            muiGet("mob/order/cancelOrder", param, successCb, null)
        }
    });
})
//确认收货按钮
mui("body").on("tap", "#submit", function () {
    var idOrder = $(this).parents("li").attr("data-id");
    var param = {
        orderId:idOrder
    }
    var successCb = function (data) {
        self.location.href = "/mob/order/orderBuyList?sign=" + "1";
    }
    muiGet("mob/order/confirmOrder", param, successCb, null)
})
//点击买家进入订单详情
mui("body").on("tap", "#orderDetail", function () {
    var idOrder = $(this).parents("li").attr("data-id");
    self.location.href = contextPath + "/mob/order/orderDetail?orderId=" + idOrder + "&sign=" + "2";
})
