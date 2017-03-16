/**
 * @Description:
 * @jsName:favorite_my
 * @author YS
 * @create 2017-01-16 10:49
 */
mui.init({
    pullRefresh: {
        container: '#pullrefresh',
        down: {
            callback: reloadTab
        },
        up: {
            auto: true,
            callback: loadTab
        }
    }
});

source_GY =
    '{{if list}}' +
    '{{each list}}' +
    '<li class="mui-table-view-cell mui-media gy" data-id="{{$value.goodsId}}">' +
    '{{if $value.isOut == 0}}<div class="m_gq"><img src="/mstatic/img/gq.png" width="45" /></div>{{/if}}' +
    '    <a href="javascript:;">' +
    '{{if $value.thumbnailUrl != null}}' +
    '        <img class="mui-media-object mui_img mui-pull-left " src="{{$value.thumbnailUrl}}">' +
    '{{else}}' +
    '        <img class="mui-media-object mui_img mui-pull-left " src="/mstatic/img/defaulthead.png">' +
    '{{/if}}' +
    '        <div class="mui-media-body clear">' +
    '            <div class="box5"></div>' +
    '            <p class="black3 clear">' +
    '                <span class="f15">{{$value.gavVariety}}-{{$value.gavAge}}-{{$value.categoryName}}</span>' +
    '                <span class="mui-pull-right "><em class="d_blue fb f15 arial">{{$value.sellPrice}}</em>元/{{$value.numUnitTxt}}</span>'
    +
    '            </p>' +
    '            <p class="gray_6 clear">' +
    '                <span><em class="d_blue  arial">{{$value.origStock}}</em>{{$value.stockUnitTxt}}</span>' +
    '                <span class="mui-pull-right ">{{$value.areaDisplayName}}</span>' +
    '            </p>' +
    '            <p class="gray_6 mui-pull-right"><span class="mui-badge nobj sc" id="{{$value.id}}"><i class="iconfont icon-apphengsandian f18 c_gray94"></i></span></p>'
    +
    '        </div>' +
    '    </a>' +
    '</li>' +
    '{{/each}}' +
    '{{/if}}';
source_QG =
    '{{if list}}' +
    '{{each list}}' +
    '<li class="mui-table-view-cell mui-media qg" data-id="{{$value.goodsId}}">' +
    '{{if $value.isOut == 0}}<div class="m_gq"><img src="/mstatic/img/gq.png" width="45" /></div>{{/if}}' +
    '	<a href="javascript:;">' +
    '		<div class="mui-media-body">						' +
    '			<p class="black3">' +
    '				<span class="f15 ">{{$value.gavVariety}}-{{$value.gavAge}}-{{$value.categoryName}}</span>' +
    '				<span class="pad10-l"><em class="d_blue  arial">{{$value.origStock}}</em>{{$value.stockUnitTxt}}</span>'
    +
    '				<span class="mui-pull-right "><em class="d_blue fb f15 arial">{{$value.sellPrice}}</em>元/{{$value.numUnitTxt}}</span>'
    +
    '			</p>' +
    '			<div class="box5"></div>' +
    '			<p class="gray_6">估重：<em class="d_blue  arial">{{$value.gavWeightMin}}-{{$value.gavWeightMax}}</em>{{$value.valUnitTxt}}</p>'
    +
    '			<p class="gray_6">' +
    '				产地：{{$value.areaDisplayName}}' +
    '				<span class="mui-pull-right "><em class="mui-badge nobj sc" id="{{$value.id}}"><i class="iconfont icon-apphengsandian f18 c_gray94"></i></em></span>'
    +
    '			</p>' +
    '			<p class="gray_6 mui-pull-right"></p>' +
    '		</div>' +
    '	</a>' +
    '</li>' +
    '{{/each}}' +
    '{{/if}}';
source_SHOP =
    '{{if list}}' +
    '{{each list}}' +
    '<li class="mui-table-view-cell mui-media shop" data-id="{{$value.shopId}}">' +
    '	<a href="javascript:;">' +
    '{{if $value.logo != null}}' +
    '		<img class="mui-media-object mui-pull-left" src="{{$value.logo}}">' +
    '{{else}}' +
    '		<img class="mui-media-object mui-pull-left" src="/mstatic/img/defaulthead.png">' +
    '{{/if}}' +
    '		<div class="mui-media-body">					' +
    '			<p class="mui-ellipsis black3 f15">{{$value.shopName}}</p>	' +
    '			<p class="mui-ellipsis1 gray_l f12"><em class="d_blue d_borr">{{$value.userTypeCn}}</em></p>	' +
    '		</div>' +
    '		<span class="mui-badge nobj sc" id="{{$value.id}}"><i class="iconfont icon-apphengsandian f18 c_gray94"></i></span>'
    +
    '	</a>' +
    '</li>' +
    '{{/each}}' +
    '{{/if}}';
source_WZ =
    '{{if list}}' +
    '{{each list}}' +
    '<li class="mui-table-view-cell mui-media wz" data-id="{{$value.artId}}" data-title="{{$value.title}}" data-colName="{{$value.colName}}">'
    +
    '	<a href="javascript:;">' +
    '		<img class="mui-media-object mui-pull-left mui_img" src="{{$value.picUrl}}">' +
    '		<div class="mui-media-body">' +
    '			<div class="box5"></div>' +
    '			<p class="mui-ellipsis black3 f15">{{$value.title}}</p>	' +
    '			<p class="mui-ellipsis1 gray_l f12"><em class="d_blue">{{$value.colName}}</em></p>	' +
    '		</div>' +
    '		<span class="mui-badge nobj sc" id="{{$value.id}}"><i class="iconfont icon-apphengsandian f18 c_gray94"></i></span>'
    +
    '	</a>' +
    '</li>' +
    '{{/each}}' +
    '{{/if}}';
index1 = 0;
pageNum = 1;
pageSize = 10;
type = 'GY';
sourceType = source_GY;
function loadTab(index) {
    index1 = index;
    pageNum = 1;
    if (index == 0) {
        type = "GY";
        sourceType = source_GY;
    } else if (index == 1) {
        type = "QG";
        sourceType = source_QG;
    } else if (index == 2) {
        type = "SHOP";
        sourceType = source_SHOP;
    } else if (index == 3) {
        type = "WZ";
        sourceType = source_WZ;
    }
    loadContent();
}
function reloadTab() {
    mui('#pullrefresh').pullRefresh().endPulldownToRefresh(true);
    loadTab(index1);
    mui('#pullrefresh').pullRefresh().endPulldownToRefresh(false);
}
function loadContent() {
    var param = new Object();
    param.pageNum = pageNum;
    param.pageSize = pageSize;
    param.type = type;
    var back = function (e) {
        var render = template.compile(sourceType);
        var tatal = e.page.total;
        e = {list: e.data};
        var html = render(e);
        if (pageNum == 1) {
            $("#pullrefresh").find("ul").html(html);
        } else {
            $("#pullrefresh").find("ul").append(html);
        }
        mui("#pullrefresh").pullRefresh().endPullupToRefresh(tatal <= pageNum);
        pageNum++;
        param.pageNum = pageNum;
    }
    muiGet("mob/memberFavorite/selFavByType", param, back, null);
}
$(".mui-scroll").on("tap", ".gy", function (e) {
    var id = this.getAttribute("data-id");
    if (isNotEmpty(id)) {
        window.location.href = '/mob/goods/selectGoodsById/' + id + '/supply';
    }
});
$(".mui-scroll").on("tap", ".qg", function (e) {
    var id = this.getAttribute("data-id");
    if (isNotEmpty(id)) {
        window.location.href = '/mob/goods/selectGoodsById/' + id + '/purchase';
    }
});
$(".mui-scroll").on("tap", ".shop", function (e) {
    var id = this.getAttribute("data-id");
    if (isNotEmpty(id)) {
        window.location.href = '/mob/shop/toShop?id=' + id;
    }
});
$(".mui-scroll").on("tap", ".wz", function (e) {
    var id = this.getAttribute("data-id");
    var title = this.getAttribute("data-title");
    var colName = this.getAttribute("data-colName");
    if (isNotEmpty(id)) {
        window.location.href = '/mob/cms/toArticleContent.do?articleId=' + id + '&title='+ title
                               +'&colName='+colName+'&backArticle=fromFav';
    }
});
$(".mui-scroll").on("tap", ".sc", function (e) {
    e.stopPropagation();
    $(".shoucang").removeClass("hied");
    $(".db_sc").addClass("d_blue");
    $(".db_sc .iconfont").attr("class", "iconfont icon-favoriteselected block f20");
    $(".db_sc  .em").text("取消收藏");
    var id = this.getAttribute("id");
    $(".db_sc").on("tap", function () {
        delFav(id);
    });
});
$(".cancel,body").on("tap", function (e) {
    $(".shoucang").addClass("hied");
});
$(".mui-control-item").each(function (i) {
    $(this).on("tap", function () {
        $(".mui-control-item").removeClass("mui-active");
        $(this).addClass("mui-active");
        loadTab(i);
    });
});
