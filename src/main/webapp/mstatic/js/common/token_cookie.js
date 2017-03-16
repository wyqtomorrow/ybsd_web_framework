$(function(){
    var token = $.cookie("cookie:formToken");
    console.log(token)
    $("#formToken").val(token);
});