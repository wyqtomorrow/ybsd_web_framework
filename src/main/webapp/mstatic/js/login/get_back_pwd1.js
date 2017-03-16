/**
 *
 * @jsName:
 * @Description: 注册
 * @author YS
 * @createTime 2016/12/1 17:39
 */
$(function () {
    $(".ver_telnub").keyup(function () {
        if ($(this).val().length == 11) {
            addGetVerification();
        } else {
            removeGetVerification();
        }
    })
    $("input").keyup(function () {
        checkVerification();
    })
    $('input').bind('input propertychange', function () {
        checkVerification();
    });
});
/**
 * @author YS  @Description: 移除验证码样式
 */
function removeGetVerification() {
    $("#getVerification").removeClass('mui-btn-blue').addClass('mui-btn-grey');
    $("#getVerification").unbind("click");
    $("#getVerification").click(function () {
        return false;
    })
}
/**
 * @author YS  @Description: 添加验证码样式
 */
function addGetVerification() {
    $("#getVerification").addClass('mui-btn-blue').removeClass('mui-btn-grey');
    $("#getVerification").unbind("click");
    $("#getVerification").click(function () {
        sendMsgToMob();
        setTimeMile();
    });
}
/**
 * @author YS  @Description: 判断确认验证码
 */
function checkVerification() {
    if ($("#tel").val().length == 11 && $("#verification").val().length == 6) {
        $("#sendVerification").removeClass("mui-btn-grey").addClass("mui-btn-blue");
        $("#sendVerification").unbind("click");
        $("#sendVerification").click(function () {
            judgeVerification();
        })
    } else {
        $("#sendVerification").removeClass("mui-btn-blue").addClass("mui-btn-grey");
        $("#sendVerification").unbind("click");
        $("#sendVerification").click(function () {
            return false;
        })
    }
}
/**
 * @author YS  @Description: 下一步按钮点击
 */
function judgeVerification() {
    var obj = new Object();
    var mobilePhone = $("#tel").val();
    var verification = $("#verification").val();
    obj.mobilePhone = mobilePhone;
    obj.identifyingCode = verification;
    successback = function(data){
        if(data.code=="0"){
            location.href = contextPath+'/mob/memberLogin/getBackPwd2.do?mobilePhone='+mobilePhone;
        } else if(data.code == 10001){
        }else{
            muiAlert("提示信息",data.exception);
        }
    }
    muiPost("mob/memberLogin/judgeVerification.do", obj, successback, null);
}
/**
 * @author YS  @Description: 发送验证码
 */
function sendMsgToMob() {
    var mobilePhone = $("#tel").val();
    var obj = new Object();
    obj.mobilePhone = mobilePhone;
    var successFun = function(res){
        if(res.code!=0){
            muiAlert("提示信息",res.exception);
        }
    }
    muiGet("mob/memberLogin/sendMsgRegister.do", obj, successFun, null);
}
/**
 * @author YS  @Description: 验证码时间
 */
function setTimeMile() {
    var getVerification = document.getElementById("getVerification"),
        autoTime = null;
    var timeNum = 60;
    autoTime = setInterval(function () {
        timeNum--;
        if (timeNum == 0) {
            addGetVerification();
            getVerification.innerHTML = "获取验证码";
            clearInterval(autoTime);
        } else {
            removeGetVerification();
            getVerification.innerHTML = "重新发送" + timeNum + "s";
        }
        ;
    }, 1000);
}
