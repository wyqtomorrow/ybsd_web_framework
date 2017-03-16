/**
 *
 * @jsName:
 * @Description: 注册
 * @author YS
 * @createTime 2016/12/1 17:39
 */
var isCheckedA = true;
$(function () {
    $(".ver_telnub").keyup(function () {
        if ($(this).val().length == 11) {
            addGetVerification();
        } else {
            removeGetVerification();
        }
    })
    $("input").keyup(function () {
        checkRegister();
    })
    $('input').bind('input propertychange', function () {
        checkRegister();
    });
    document.getElementById("checkAgreement").addEventListener("toggle",function(event){
        isCheckedA = event.detail.isActive;
        checkRegister();
    })
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
 * @author YS  @Description: 判断注册按钮
 */
function checkRegister() {
    if ($("#tel").val().length == 11 && $("#verification").val().length == 6 && $("#password").val().length > 7
        && $("#password").val().length < 13 && isCheckedA) {
        $("#sendRegister").removeClass("mui-btn-grey").addClass("mui-btn-blue");
        $("#sendRegister").unbind("click");
        $("#sendRegister").click(function () {
            sendRegister();
        })
    } else {
        $("#sendRegister").removeClass("mui-btn-blue").addClass("mui-btn-grey");
        $("#sendRegister").unbind("click");
        $("#sendRegister").click(function () {
            return false;
        })
    }
}
/**
 * @author YS  @Description: 注册按钮点击
 */
var mask = mui.createMask(false);//callback为用户点击蒙版时自动执行的回调；
function sendRegister() {
    mask.show();
    console.log("注册");
    var obj = new Object();
    var mobilePhone = $("#tel").val();
    var verification = $("#verification").val();
    var password = $("#password").val();
    var passwordStr = hex_sha1(password)
    obj.mobilePhone = mobilePhone;
    obj.password = passwordStr;
    obj.identifyingCode = verification;
    successback = function(data){
        mask.close();
        if(data.code == 0){
            mui.alert("注册成功！", '恭喜您', function() {
                znt.toLogin();
            });
        }else{
            mui.toast(data.exception);
        }
    },
    errorback = function(data){
        mask.close();
        mui.alert(data.exception);
    }
    muiPost("mob/memberLogin/sendRegister.do", obj, successback, errorback);
}
/**
 * @author YS  @Description: 发送验证码
 */
function sendMsgToMob() {
    console.log("验证码");
    var mobilePhone = $("#tel").val();
    var obj = new Object();
    obj.mobilePhone = mobilePhone;
    muiGet("mob/memberLogin/sendMsgRegister.do", obj, null, null);
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
