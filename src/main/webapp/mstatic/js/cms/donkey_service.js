/**
 * 搜索文章列表
 */
function searchArticleInfo(){
    var articleName=$("#articleName").val();
    if($.trim(articleName)==""){
        muiAlert("提示",data.exception);
    }else{
        window.location.href="toSearchArticle?articleName="+articleName;
    }
}

$("#industyInfo").on("tap",function(){
    window.location.href="/mob/cms/toArticleColumnList?columnName=行业快讯";
});

$("#cultrueInfo").on("tap",function(){
    window.location.href="/mob/cms/toArticleColumnList?columnName=养殖技术";
});

$("#illnessInfo").on("tap",function(){
    window.location.href="/mob/cms/toArticleColumnList?columnName=疾病防治";
});