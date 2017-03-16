/**
 *
 * @jsName:
 * @Description: 找回密码第二步
 * @author YS
 * @createTime 2016/12/1 17:39
 */
$(function () {
    $("input").keyup(function () {
        checkVerification();
    })
    $('input').bind('input propertychange', function () {
        checkVerification();
    });
    var timer = null;
    $("#pwd").on({
        keyup: function(){
            clearTimeout(timer);
            timer = setTimeout(function(){
                if($("#sign").val() == "1"){
                    mui.alert("您输入的密码不符合规范，请修改<br/>(密码:8位-20位)","提示信息",function(){
                    });
                    return false;
                }
            }, 1000);
        }
    });
});
/**
 * @author YS  @Description: 判断确定
 */
function checkVerification() {
    if ($("#pwd").val().length > 7 && $("#pwdagain").val().length > 7) {
        $("#submitPassword").removeClass("mui-btn-grey").addClass("mui-btn-blue");
        $("#submitPassword").unbind("click");
        $("#submitPassword").click(function () {
            submitPassword();
        })
    } else {
        $("#submitPassword").removeClass("mui-btn-blue").addClass("mui-btn-grey");
        $("#submitPassword").unbind("click");
        $("#submitPassword").click(function () {
            return false;
        })
    }
    if ($("#pwd").val().length > 20 || $("#pwdagain").val().length > 20){
        $("#sign").val(1);
    }else{
        $("#sign").val(0);
    }
}
/**
 * @author YS  @Description: 确定按钮点击
 */
function submitPassword() {
    if($("#pwd").val() != $("#pwdagain").val()){
        mui.alert("新密码俩次输入不一致，请重新输入","提示信息",function(){
        });
        return false;
    }
    if ($("#pwd").val().length > 20 || $("#pwdagain").val().length > 20){
        mui.alert("您输入的密码不符合规范，请修改<br/>(密码:8位-20位)","提示信息",function(){
        });
        return false;
    }
    var obj = new Object();
    var mobilePhone = $("#tel").val();
    var pwd = $("#pwd").val();
    var passwordStr = hex_sha1(pwd)
    obj.mobilePhone = mobilePhone;
    obj.password = passwordStr;
    successback = function(data){
        if(data.code == 0){
            mui.alert("密码修改成功！","恭喜您",function(){
                znt.toLogin();
            });
        }else{
            mui.toast(data.exception);
        }
    }
    muiPost("mob/memberLogin/resettingPwd.do", obj, successback, null);
}
