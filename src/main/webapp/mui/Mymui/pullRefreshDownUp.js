/**
 * 继承mui temple
 *
 * Created by YS on 2016/11/1.
 */
    var url="";
    var param = new Object();
    var temp="";
    var reqType="get";
    var pageNum = param.pageNum != undefined && param.pageNum != null && param.pageNum != "" ?param.pageNum:1;
    param.pageNum = pageNum;
    back = function(e){
        var render = template.compile(temp);
        var data={items:e.data}
        var html = render(data);
        if(pageNum == 1){
            $("#pullrefresh").find("ul").html(html);
        }else{
            $("#pullrefresh").find("ul").append(html);
        }
        mui("#pullrefresh").pullRefresh().endPullupToRefresh(e.data.totalPage <= pageNum);
        pageNum ++;
        param.pageNum = pageNum;
    }
    /**
     * 上拉加载具体业务实现
     */
    pullupRefresh = function() {
        if(reqType == "POST" || reqType == "post"){
            mui.post(url,param,back,"json");
        }else {
            mui.get(url,param,back,"json");
        };
    };
    /**
     * 下拉刷新具体业务实现
     */
    pulldownRefresh = function(){
        mui('#pullrefresh').pullRefresh().endPulldownToRefresh();
        location.replace(location.href)
    }
    mui.init({
        pullRefresh: {
            container: '#pullrefresh',
            down: {
                contentrefresh: '正在刷新...',
                callback: pulldownRefresh
            },
            up: {
                contentrefresh: '正在加载...',
                callback: pullupRefresh
            }
        }
    });
    if (mui.os.plus) {
        mui.plusReady(function() {
            setTimeout(function() {
                mui('#pullrefresh').pullRefresh().pullupLoading();
            }, 1000);

        });
    } else {
        mui.ready(function() {
            mui('#pullrefresh').pullRefresh().pullupLoading();
        });
    }

