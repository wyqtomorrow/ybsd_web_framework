$(document).ready(function () {
    var params={
        systemId:1,
        channelType:"INTERNAL_MAIL"
    };
    var successCb = function (res) {
        if(res.data){
            $("#messId").append("<a class='dm_xx'></a>");
        }
    }
    muiGet("mob/message/queryIsRead.do", params, successCb, null)
});

$("#messId").click(function(){
    $("#messId").attr("disabled", true);
    var param = {
        systemId:"1",
        channelType:"INTERNAL_MAIL"
    };
    var successCb = function (res) {
        window.location.href = "/mob/message/myMessage";
    }
    muiGet("mob/message/changeToIsRead.do", param, successCb, null)
});
