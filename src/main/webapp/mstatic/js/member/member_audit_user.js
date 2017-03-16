var currentPageNum = 1;
var pages = 1;
var array = new Array();
array.push("DSH");
var tagFlag = "newUser";
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
                    queryMemberAuditList(currentPageNum, array, tagFlag);
                }, 200);
            }
        }
    }
});

$(function () {
    $("#sliderSegmentedControl").on("tap", "#new_user", function () {
        tagFlag = 'newUser';
        array.length = 0;
        array.push("DSH");
        currentPageNum=1;
        $("#content").html("");
        mui('#refreshContainer').pullRefresh().refresh(true);
        queryMemberAuditList(1, array, tagFlag);
    });
    $("#sliderSegmentedControl").on("tap", "#audited_user", function () {
        tagFlag = 'audited';
        array.length = 0;
        array.push("TG");
        array.push("BTG");
        currentPageNum=1;
        $("#content").html("");
        mui('#refreshContainer').pullRefresh().refresh(true);
        queryMemberAuditList(1, array, tagFlag);
    });

    $("#seachDiv").on("tap","#seachMembers", function () {
        $("#content").html("");
        mui("#refreshContainer").pullRefresh().endPullupToRefresh(false);
        mui('#refreshContainer').pullRefresh().refresh(true);
        queryMemberAuditList(1, array, tagFlag);
    });
    /**
     * 修改用户状态
     */
    $("#content").on("tap", "#updateMemberStatus", function () {
        var obj = $(this);
        var id = $(this).attr("data-id");
        var status = $(this).attr("data-status");
        var url = "mob/member/updateMemberStatus/" + id + "/" + status;
        var param = {};
        var successBack = function (result) {
            if (result.code == "0") {
                obj.parents(".mui-table-view-cell.mui-media").remove();
            }
        }
        muiGet(url, param, successBack);
    });
});


function queryMemberAuditList(pageNum, array, flag) {
    var param = {};
    param.pageNum = pageNum;
    param.keywords = $("#keywords").val();
    param.listStatus = array;
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
            if (flag == 'newUser') {
                html = template('memberListTpl', data);
            } else {
                html = template('memberAuditedListTpl', data);
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

    muiReqJsonPost("mob/member/queryUserAuditList", param, successBack, errorBack);
}


function dateFormat(date, format) {
    date = new Date(date);
    var map = {
        "M": date.getMonth() + 1, //月份
        "d": date.getDate(), //日
        "h": date.getHours(), //小时
        "m": date.getMinutes(), //分
        "s": date.getSeconds(), //秒
        "q": Math.floor((date.getMonth() + 3) / 3), //季度
        "S": date.getMilliseconds() //毫秒
    };

    format = format.replace(/([yMdhmsqS])+/g, function (all, t) {
        var v = map[t];
        if (v !== undefined) {
            if (all.length > 1) {
                v = '0' + v;
                v = v.substr(v.length - 2);
            }
            return v;
        }
        else if (t === 'y') {
            return (date.getFullYear() + '').substr(4 - all.length);
        }
        return all;
    });
    return format;
}
template.helper("getCreateTime", dateFormat);
