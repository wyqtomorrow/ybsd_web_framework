/**
 * Created by chenrd on 2016/12/15.
 */
function shareContent() {
    var strTitle = $("#contentTitle").text();
    var articleId = $("#shareArticleId").val();
    var colName=$("#colName").val();
    znt.openSharePanel({
        title: strTitle, // 分享标题
        desc: "文章内容", // 分享描述
        imgUrl: $("#llwUrl").val()+'mstatic/img/defaulthead.png', // 分享图标
        link: $("#llwUrl").val() + 'mob/cms/contentShare?articleId=' + articleId+"&colName="+colName,// 分享链接
        success: function (res) {

        },
        fail: function (res) {

        }
    });
}

mui("body").on('tap', '#addfav', function () {
    var artId = $(this).attr("data-id");
    addFav(artId,"WZ");
});
mui("body").on('tap', '#delfav', function () {
    var id = $(this).attr("data-id");
    delFav(id);
});
