/**
 *
 * @jsName: 登录
 * @Description:
 * @author YS
 * @createTime 2016/12/2 15:41
 */
$(function () {
})

/**
 * @author YS  @Description: 登录按钮点击
 */
$("#sendLogin").on("click",function(){
    var tel = $("#tel").val();
    var password = $("#password").val();
    if(tel==""){
        alert("手机号码不能为空");
        return false;
    }
    if(password==""){
        alert("密码不能为空");
        return false;
    }
    console.log("登录");
    var mobilePhone = $("#tel").val();
    var password = $("#password").val();
    var passwordStr = hex_sha1(password)

    $.ajax({
        url:'/mob/memberLogin/sendLogin.do',
        type:'POST', //GET
        async:true,    //或false,是否异步
        data:{
            mobilePhone:mobilePhone,
            password:passwordStr
        },
        dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
        success:function(data){
            if(data.code==0){
                var token = data.data.token;
                $.cookie("ticketCookie", token, { expires: 7, path: '/' });
                location.href = contextPath+'/bigdata/dsjPortal';
            }else{
                alert(data.exception);
            }
        }
    })
});

$("#logout").on("click",function(){
    //清空cookie
    $.cookie("ticketCookie", null,{path:"/"});
    //跳转页面
    location.href = contextPath+'/bigdata/dsjLogin';
});
