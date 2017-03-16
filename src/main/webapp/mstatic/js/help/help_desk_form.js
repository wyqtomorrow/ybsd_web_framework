$(document).ready(function () {
    var helpdeskInformReasonType = {dictParams: "HELPDESK_INFORM_REASON_TYPE", sysId: "0"};
    //品种
    getDictionaryParams(helpdeskInformReasonType, userTypeFun);
    function userTypeFun(data) {
        var a = data;
        var userType = data.data.HELPDESK_INFORM_REASON_TYPE;

        $(userType).each(function (index) {
            var id = "#" + "jubao" + index;
            var code = "#" + "code" + index;
            $(id).append(this.value);
            $(code).attr("data-id", this.code);
            if (index == "0") {
                $("#codeValue").val(this.code);
                console.log($("#codeValue").val());
            }
        });
    }
})

$(".ip_href").each(function (index) {
    var li = $(this).find("li");
    var t = $(this).find(".radio");
    li.click(function () {
        t.val(li.index(this));
        $(this).addClass("cur").siblings().removeClass("cur");
        var idCode = $(this).attr("data-id");
        $("#codeValue").val(idCode);
        console.log($("#codeValue").val());
    })
});

mui("body").on("tap", "#submit", function () {
    var btnArray = ['取消', '确定'];
    mui.confirm('', '确定提交举报吗?', btnArray, function (e) {
        if (e.index == 0) {
            return false;
        } else if (e.index == 1) {
            if ($("#jubao0").parent())
                var param = {
                    'deBoId': $("#deBoId").val(),
                    'deOperatorBoId': $("#deOperatorBoId").val(),
                    'deUserType': $("#deUserType").val(),
                    'proBoId': $("#proBoId").val(),
                    'proOperatorBoId': $("#proOperatorBoId").val(),
                    'proUserType': $("#proUserType").val(),
                    'busId': $("#busId").val(),
                    'busType': $("#busType").val(),
                    'reasonType': $("#codeValue").val(),
                    'description': $("#reason").val(),
                    'status': "DCL",
                    'type': "JB"
                };
            var successCb = function (res) {
                var busId = $("#busId").val();
                if(res.code == 0){

                mui.alert("您已成功提交举报信息，我们将尽快处理", "提示", function () {
                    var goodsRole = $("#goodsRole").val();
                    self.location.href = contextPath + "/mob/goods/selectGoodsById/"+ busId + "/"+ goodsRole;
                });
                }
                else if(res.code == 5){
                    znt.zntLogOut();
                } else if(data.code == 10001){
                }else{
                    muiAlert("提示",res.exception);
                }
            }
            muiGet("mob/help/submit", param, successCb, null);
        }
    });
})
