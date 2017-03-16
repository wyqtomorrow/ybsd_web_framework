/**
 * Created by Administrator on 2016/12/5.
 */
var userPicker1 = new mui.PopPicker();
$(document).ready(function () {
    var memberTagTags = {dictParams: "MEMBER_TAG_TAGS", sysId: "1"};
    //品种
    getDictionaryParams(memberTagTags, userTypeFun);
    function userTypeFun(data) {
        var a = data;
        var userType = data.data.MEMBER_TAG_TAGS;
        var array = new Array();

        $(userType).each(function (index) {
            var dic = new Object();
            dic.value = this.code;
            dic.text = this.value;
            array.push(dic);
        });
        userPicker1.setData(array);
    }
})

mui("body").on('tap', '#userType', function () {
    var _this = $(this);
    userPicker1.show(function (items) {
        _this.val((items[0] || {}).text);
        document.getElementById("tval").value = (items[0] || {}).value;
        document.getElementById("tvalContent").value = (items[0] || {}).text;
        console.log(document.getElementById("tval").value);
        console.log(document.getElementById("tvalContent").value);
    });
})

$("#xieyi").on("tap", function () {
    self.location.href = "/mob/member/buySellProtocal"
})

$(".agree").click(function () {
    if ($(this).hasClass("cur")) {
        $(this).attr("class", "iconfont icon-xuanzhong f20 d_blue agree ");
        $(".tjbtn").attr("disabled", true).attr("class", "tjbtn mui-btn mui-btn-block  white d_nobor d_gray29");
    } else {
        $(this).attr("class", "iconfont icon-xuanzhong1 f20 d_blue agree cur");
        $(".tjbtn").attr("disabled", false).attr("class", "tjbtn mui-btn mui-btn-block  white d_nobor d_bl");
    }
});

function submit() {
    if ($("#name").val() == "") {
        muiAlert("提示", "您未填写联系人");
        return false;
    }
    if ($("#userType").val() == "") {
        muiAlert("提示", "您未选择用户类型");
        return false;
    }
    if ($("#area").val() == "") {
        muiAlert("提示", "您未选择地区");
        return false;
    }
    if ($(".agree").hasClass("iconfont icon-xuanzhong1 f20 d_blue agree cur")) {
    } else {
        muiAlert("提示", "您还未同意协议");
        return false;
    }
    var btnArray = ['取消', '确定'];
    mui.confirm('', '确定提交审核吗?', btnArray, function (e) {
        if (e.index == 0) {
            return false;
        } else if (e.index == 1) {
            var params = {
                areaId: $("#countyId").val(),
                areaAxis: $("#axis").val(),
                tags: $("#tvalContent").val(),
                tagsCode: $("#tval").val(),
                CompanyName: $("#coName").val(),
                realName: $("#name").val(),
                areaDisplayName: $("#fullName").val(),
                userName: $("#name").val(),
                systemId: "1"
            }
            var successCb = function (data) {
                if (data.code == 0) {
                    $("#loading,.mask1").hide();
                    mui.alert("您已成功提交审核信息，我们将尽快处理", "温馨提示", function () {
                        if($("#signMember").val() == "1"){
                            window.history.go(-2);
                        }else{
                            window.history.go(-1);
                        }
                    });
                } else if (data.code == 5) {
                    znt.zntLogOut();
                } else if(data.code == 10001){
                } else {
                    muiAlert("提示",data.exception);
                }

            };
            muiPost("mob/member/submitAudit.do", params, successCb, null);
        }
    });

}
