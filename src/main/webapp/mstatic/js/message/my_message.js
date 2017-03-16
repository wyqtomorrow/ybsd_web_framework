var pageNum = 1;

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
    param.systemId = 1;
    param.channelType = "INTERNAL_MAIL";
    param.pageNum = pageNum;
    param.pageSize = 10;
    var successCb = function (res) {
        var data = {};
        var html = "";
        var result = res.page.pages;
        if (result != "undefined" && result != "0") {
            currentPageNum = pageNum;
            data = {items: res.data};
            html = template('messageList', data)
            $("#list").append(html);
        } else {
        }
        if (result <= pageNum) {
            mui(".mui-scroll-wrapper").pullRefresh().endPullupToRefresh(true);
        } else {
            mui(".mui-scroll-wrapper").pullRefresh().endPullupToRefresh(false);
        }
        pageNum++
        console.log(pageNum);
    }
    muiGet("mob/message/myMessageListShow", param, successCb, null)
}

//删除
mui("body").on("tap", "#delMes", function () {
    var mesId = $(this).parents("li").attr("data-id1");
    var param = {
        id:mesId
    }
    var successCb = function (data) {
        window.location.href = "/mob/message/myMessage";
    }
    muiGet("mob/message/delMyMessage", param, successCb, null)
})

//点击详情
mui("body").on("tap", "#toDetail", function () {
    var mesId = $(this).parents("li").attr("data-id1");
    var url = $(this).parents("li").attr("data-id2");
    if(isNotEmpty(url)){
        window.location.href = "/mob/" + url;
    }else{
        return false;
    }
})

//点击该条信息
mui("body").on("tap", "#detailMes", function () {
    var mesId = $(this).parents("li").attr("data-id1");
    var url = $(this).parents("li").attr("data-id2");
    if(isNotEmpty(url)){
        window.location.href = "/mob/" + url;
    }else{
        return false;
    }
})
