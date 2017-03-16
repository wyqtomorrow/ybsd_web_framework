var pageNum = 1;

var temp = "{{if items}}"
    + "{{each items}}"
    + '<li class="mui-table-view-cell mui-media" id="sellDetail" data-id="{{$value.id}}">                                                     '
    + '        <a href="#">                                                                                                             '
    + '            {{if $value.picUrl==null}}                                                                                              '
    + '            <img class="mui-media-object mui_img mui-pull-left" src="/mstatic/img/defaulthead.png">                              '
    + '            {{else}}                                                                                                             '
    + '            <img class="mui-media-object mui_img mui-pull-left" src="{{$value.picUrl}}">                                            '
    + '            {{/if}}                                                                                                              '
    + '            <div class="mui-media-body">                                                                                         '
    + '                <p class="black3">                                                                                               '
    + '                    {{if $value.categoryId!="1002"}}                                                                                '
    + '                    <span class="f15">{{$value.mapAttr.GAV_VARIETY}}<em class="pad10-l"></em>{{$value.mapAttr.GAV_YEAR_AGE}}<em class="pad10-l"></em>{{$value.categoryName}}</span>       '
    + '                    {{else}}                                                                                                     '
    + '                    <span class="f15">{{$value.mapAttr.GAV_VARIETY}}<em class="pad10-l"></em>{{$value.mapAttr.GAV_MONTH_AGE}}<em class="pad10-l"></em>{{$value.categoryName}}</span>      '
    + '                    {{/if}}                                                                                                      '
    + '                    <span class="mui-pull-right "><em class="d_blue fb f15 arial">{{$value.price}}</em>元/{{$value                     '
    + '                        .unitText}}</span>                                                                                       '
    + '                </p>                                                                                                             '
    + '                <p class="black3"><em class="d_blue  arial">{{$value.currStock}}</em>{{$value.stockUnitTxt}}</p>                       '
    + '                <p class="gray_6"><span class="mui-pull-right f12">{{$value.addrResForm.areaDisplayName}}</p>    '
    + '            </div>                                                                                                               '
    + '        </a>                                                                                                                     '
    + '    </li>                                                                                                                        '
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

function fullTo() {
    var param = new Object();
    param.keyWords = $("#searchCon").val();
    param.pageNum = pageNum;
    param.pageSize = 10;
    var successCb = function (res) {
        var data = {};
        var html = "";
        var result = res.page.pages;
        if (result != "undefined" && result != "0") {
            currentPageNum = pageNum;
            data = {items: res.data};
            var render = template.compile(temp);
            html = render(data);
            $("#list").append(html);
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
        pageNum++;
        console.log(pageNum);
    }
    muiGet("mob/goods/goodsSearchList", param, successCb, null)
}



mui("body").on('tap', '#sellDetail', function () {
    var goodsId = $(this).attr("data-id");
    self.location.href = "/mob/goods/selectGoodsById/" + goodsId + "/supply";
});

mui("body").on('tap', '#searchBtn', function () {
    mui(".mui-scroll-wrapper").pullRefresh().endPullupToRefresh(false);
    mui('.mui-scroll-wrapper').scroll().scrollTo(0,0);
    pageNum = 1;
    $("#list").html("");
    fullTo();
});
