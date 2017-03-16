function uploadImg() {
    znt.chooseImage({
        sizeType: 1, // 1.原图 2.根据设备分辨率压缩图 3.H5自定义尺寸(如果是3，需要写maxWidth、maxHeight)
        sourceType: 3, // 1相机 2图库 3客户端交给用户选择
        success: function (res) {
            var fileUrl = res.uploadUrl; // 实际上传的图片路径
            var html = "<li class='mui-table-view-cell mui-media mui-col-xs-3'>" +
                "<a href='#'>" +
                "<img class='mui-media-object' src='"+fileUrl+"?imageView2/1/w/376/h/360'>" +
                "<div class='d_del f14 d_red' onclick='" +
                "'><i class='iconfont icon-shanchu'></i>删除</div></a></li>";
            $(html).prependTo("#upImg");
            //判断图片上传张数
            var imgArray = $("img[class='mui-media-object']");
            if(imgArray.length==4){
                $("#upLi").hide();
            }
        },
        cancel: function (res) {
        },
        fail: function (res) {
            mui.alert(res.msg);
        }
    });
}
function deleteImg(obj) {
    $(obj).parent().parent().remove();
}