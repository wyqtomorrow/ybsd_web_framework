/**
 *
 * @jsName: 登录
 * @Description:
 * @author YS
 * @createTime 2016/12/2 15:41
 */
$(function () {
    $("input").keyup(function () {
        checkLogin();
    })
    $('input').bind('input propertychange', function () {
        checkLogin();
    });
})
/**
 * @author YS  @Description: 判断登录按钮
 */
function checkLogin() {
    if ($("#tel").val().length == 11 && $("#password").val().length > 1) {
        $("#sendLogin").removeClass("mui-btn-grey").addClass("mui-btn-blue");
        $("#sendLogin").unbind("click");
        $("#sendLogin").click(function () {
            sendLogin();
        })
    } else {
        $("#sendLogin").removeClass("mui-btn-blue").addClass("mui-btn-grey");
        $("#sendLogin").unbind("click");
        $("#sendLogin").click(function () {
            return false;
        })
    }
}
/**
 * @author YS  @Description: 登录按钮点击
 */
var mask = mui.createMask(false);//callback为用户点击蒙版时自动执行的回调；
function sendLogin() {
    console.log("登录");
    mask.show();//显示遮罩
    var obj = new Object();
    var mobilePhone = $("#tel").val();
    var password = $("#password").val();
    var passwordStr = hex_sha1(password)
    obj.mobilePhone = mobilePhone;
    obj.password = passwordStr;
    successback = function(data){
        console.log(data);
        if(data.code==0){
            console.log(data.data);
            var token = data.data.token;
            $.cookie("ticketCookie", token, { expires: 7, path: '/' });
            mui.alert("登录成功！", '恭喜您', function() {
                //设置cookie
                location.href = contextPath+'/mob/goods/goodsSupplyHome';
            });
        }else{
            mui.alert(data.exception,"操作失败","确认",function(){});
            mask.close();//显示遮罩
        }

    }
    muiPost("mob/memberLogin/sendLogin.do", obj, successback, null);
}
