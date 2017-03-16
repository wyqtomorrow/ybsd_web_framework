/**
 * Created by Administrator on 2016/12/6.
 */
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
            height:5,
            contentrefresh: '正在加载...',
            contentnomore: '没有更多数据了',
            callback: function () {
                var self = this;
                muiGet("mob/cms/searchArticle.do", {
                    pageNum: pageNum,
                    pageSize: 5,
                    articleName: $("#artiTitle").val()
                }, function(res){
                    var data = {};
                    var html = "";
                    var result = res.page.pages;
                    if (result != "undefined" && result != "0") {
                        currentPageNum = pageNum;
                        data = {items: res.data};
                        var render = template.compile(temp);
                        html = render(data);
                        $("#cmsListTpl").append(html);
                    }
                    if (result <= pageNum) {
                        self.endPullupToRefresh(true);
                    }else{
                        self.endPullupToRefresh();
                    }
                    pageNum++;
                    console.log(pageNum);
                }, null);
            }
        }
    }
});
