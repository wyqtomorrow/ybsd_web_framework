$(document).ready(function () {
    $("#chushou").hide();
});

var pageNum = 1;
var temp = "{{if items}}"
    + "{{each items}}"
    + '	<li class="mui-table-view-cell mui-media" id="sellDetail" data-id="{{$value.id}}">'
    + '{{if $value.picUrl == null}}'
    + '			<img class="mui-media-object mui_img mui-pull-left" src="/mstatic/img/defaulthead.png">'
    + '{{else}}'
    + '			<img class="mui-media-object mui_img mui-pull-left" src="{{$value.picUrl}}">'
    + '{{/if}}'
    + '			<div class="mui-media-body">'
    + '				<p class="black3">'
    + '					<span class="f15">{{$value.mapAttr.GAV_VARIETY}}<em class="pad10-l"></em>{{$value.mapAttr.GAV_YEAR_AGE}}<em class="pad10-l"></em>{{$value.categoryName}}</span>'
    + '					<span class="mui-pull-right "><em class="d_blue fb f15 arial">{{$value.price}}</em>元/{{$value.unitText}}</span>'
    + '				</p>'
    + '				<p class="black3"><em class="d_blue  arial">{{$value.currStock}}</em>{{$value.stockUnitTxt}}</p>'
    + '				<p class="gray_6"><span class="mui-pull-right f12">{{$value.addrText}}</span></p>'
    + '			</div>'
    + '	</li>'
    + "{{/each}}"
    + "{{/if}}";


mui.init({
    pullRefresh: {
        container: '#chushou',
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

function fullTo() {
    var param = {};
    param.pageNum = pageNum;
    param.pageSize = 10;
    param.shopId = $("#shopId").val();
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
    muiGet("mob/goods/selShopGoodsList", param, successCb, null)
}


mui("body").on('tap', '#selling', function () {
    $("#selling").removeClass("mui-control-item").addClass("mui-control-item mui-active");
    $("#sellData").removeClass("mui-control-item mui-active").addClass("mui-control-item");
    $("#ziliao").hide();
    $("#chushou").show();
});

mui("body").on('tap', '#sellData', function () {
    $("#sellData").removeClass("mui-control-item").addClass("mui-control-item mui-active");
    $("#selling").removeClass("mui-control-item mui-active").addClass("mui-control-item");
    $("#chushou").hide();
    $("#ziliao").show();
});
mui("body").on('tap', '#sellDetail', function () {
    var goodsId = $(this).attr("data-id");
    self.location.href = "/mob/goods/selectGoodsById/"+goodsId+"/supply";
});
mui("body").on('tap', '#addfav', function () {
    var shopId = $(this).attr("data-id");
    addFav(shopId,"SHOP");
});
mui("body").on('tap', '#delfav', function () {
    var id = $(this).attr("data-id");
    delFav(id);
});
