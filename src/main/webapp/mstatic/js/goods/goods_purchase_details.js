mui("body").on("tap", "#jubao", function () {
    var busId = $("#busId").val();
    var deUserType = $("#deUserType").val();
    var deOperatorBoId = $("#deOperatorBoId").val();
    var deBoId = $("#deBoId").val();
    var goodsRole = "purchase";
    var busType = "SPTS";
    self.location.href = contextPath + "/mob/help/toTips?busId=" + busId + "&deUserType=" + deUserType + "&deOperatorBoId=" + deOperatorBoId + "&deBoId=" + deBoId + "&busType=" + busType + "&goodsRole=" + goodsRole;
});

mui("body").on("tap", "#updateGoods", function () {
    var id = $("#busId").val();
    var btnArray = ['取消', '确定'];
    var btncon = "确定修改该条商品吗?";
    mui.confirm(btncon, "修改商品",btnArray, function (e) {
        if (e.index == 1) {
            window.location.href="/mob/goods/updateGoodsById/"+id+"/purchase";
        }
    });
});


$("body").on('tap', '#deleteGoods', function () {
    var id = $("#busId").val();
    var btnArray = ['取消', '确定'];
    var btncon = "确定删除该条商品吗?";
    mui.confirm(btncon, "删除商品",btnArray, function (e) {

        var param = {};
        function successBack(data) {

            if(data.code==0){
                window.location.href="/mob/goods/queryMyGoodsListView/purchase_list";
            }else if(data.code == 5){
                znt.zntLogOut();
            } else if(data.code == 10001){
            }else{
                muiAlert("提示",data.exception);
            }
        }
        function errorBack() {

        }
        if (e.index == 1) {
            muiGet("mob/goods/deleteGoodsById/"+id, param, successBack, errorBack);
        }
    });
});

mui("body").on('tap', '#phone', function () {
    var tel = $(this).attr("data-id");
    console.log(tel);
    znt.openDial({
        phoneNo: tel // 电话号码
    });
});

mui("body").on("tap","#share",function(){
    var strTitle = $("#variety").val()+$("#age").val()+$("#categoryName").val();
    console.log($("#llwUrl").val());
    var des1 = $("#description").val();
    var url1 =$("#llwUrl").val() +  "mstatic/img/defaulthead.png";
    var urlPic = $("#urlPic").val();
    if (urlPic == null || urlPic == ""){
        urlPic = url1;
    }
    if (des1 == null || des1 == ""){
        des1= "无";
    }
    znt.openSharePanel({
        title: strTitle, // 分享标题
        desc: des1, // 分享描述
        imgUrl: urlPic, // 分享图标
        link: $("#llwUrl").val() + 'mob/goods/goodsShare?id=' + $("#busId").val() + '&type=' + 'purchase', // 分享链接
        success: function (res) {

        },
        fail:function(res) {

        }
    });
})

mui("body").on('tap', '#addfav', function () {
    var goodsId = $(this).attr("data-id");
    addFav(goodsId,"QG");
});
mui("body").on('tap', '#delfav', function () {
    var id = $(this).attr("data-id");
    delFav(id);
});
