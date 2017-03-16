/**
 *
 * @jsName: muiglobal
 * @Description: mui提交
 * @author YS
 * @createTime 2016/12/1 17:48
 */
function muiGet(url, param, successBack,errorBack){
    $.ajax({
        type : "GET",
        url : contextPath + '/' + url,
        data : param,
        timeout:5000,
        dataType : 'json',
        /*beforeSend: function (xhr) {
            // json格式传输，后台应该用@RequestBody方式接受
            var token = $.cookie("ticketCookie");
            if (token) {
                xhr.setRequestHeader("X-Access-Auth-Token", token);
            }
        },*/
        success : function(data) {
            if(isNotEmpty(successBack)){
                successBack(data);
            }
        },
        error:function(xhr,type,errorThrown){
            mui.alert("提示","网络超时，请检查网络");
            //异常处理；
            /*if(isNotEmpty(errorBack)){
                errorBack(errorThrown);
            }else{
                mui.alert(errorThrown,"操作失败","确认",function(){});
            }*/
        }
    });
}
function muiPost(url, param, successBack,errorBack){
    $.ajax({
        type : "POST",
        url : contextPath + '/' + url,
        data : param,
        timeout:5000,
        //contentType : 'application/json;charset=utf-8',
        dataType : 'json',
        /*beforeSend: function (xhr) {
            // json格式传输，后台应该用@RequestBody方式接受
            var token = $.cookie("ticketCookie");
            if (token) {
                xhr.setRequestHeader("X-Access-Auth-Token", token);
            }
        },*/
        success : function(data) {
            if(isNotEmpty(successBack)){
                successBack(data);
            }
        },
        error:function(xhr,type,errorThrown){
            mui.alert("提示","网络超时，请检查网络");
            //异常处理；
            /*if(isNotEmpty(errorBack)){
                errorBack(errorThrown);
            }else{
                mui.alert(errorThrown,"操作失败","确认",errorBack);
            }*/
        }
    });
}

function muiReqJsonPost(url, param, successBack){
    function errorBack(error){
        //alert(error);
    }
    $.ajax({
        type : "POST",
        url : contextPath + '/' + url,
        data : JSON.stringify(param),
        timeout:5000,
        contentType : 'application/json;charset=utf-8',
        dataType : 'json',
        /*beforeSend: function (xhr) {
            // json格式传输，后台应该用@RequestBody方式接受
            var token = $.cookie("ticketCookie");
            if (token) {
                xhr.setRequestHeader("X-Access-Auth-Token", token);
            }
        },*/
        success : function(data) {
            if(isNotEmpty(successBack)){
                successBack(data);
            }
        },
        error:function(xhr,type,errorThrown){
            mui.alert("提示","网络超时，请检查网络");
            //异常处理；
            /*if(isNotEmpty(errorBack)){
                errorBack(errorThrown);
            }else{
                mui.alert(errorThrown,"操作失败","确认",function(){});
            }*/
        }
    });
}


// 变量不为空的判断
function isNotEmpty(v) {
    if (v != undefined && v != null && v != "" && v != "null") {
        return true;
    } else {
        return false;
    }
}
