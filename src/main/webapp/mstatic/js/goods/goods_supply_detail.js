mui("body").on("tap", "#jubao", function () {
    var busId = $("#busId").val();
    var deUserType = $("#deUserType").val();
    var deOperatorBoId = $("#deOperatorBoId").val();
    var deBoId = $("#deBoId").val();
    var goodsRole = "supply";
    var busType = "SPTS";
    self.location.href = contextPath + "/mob/help/toTips?busId=" + busId + "&deUserType=" + deUserType + "&deOperatorBoId=" + deOperatorBoId + "&deBoId=" + deBoId + "&busType=" + busType + "&goodsRole=" + goodsRole;
});

mui("body").on("tap", "#toShop", function () {
    var shopId =$(this).attr("data");
    self.location.href = contextPath + "/mob/shop/toShop?id=" + shopId;
});

/*$(".d_footer .mui-tab-item").each(function (i) {
    $(this).on("tap", function () {
        if (i == 0) {
        } else if (i == 1) {
            var tel = $(this).attr("data-id");
            console.log(tel);
            znt.openDial({
                phoneNo: tel // 电话号码
            });
        } else if (i == 2) {
            checkOrderButton();
        }
    });
});*/

mui("body").on("tap","#orderSubmit",function(){
    var param={};
    function successBack(data){
        if(data.code==0){
            if(data.data=="TG" || data.data=="DSH"){
                var btnArray = ['取消', '确定'];
                mui.prompt('请输入购买商品数量：', '数量', '下订单', btnArray, function (e) {
                    if (e.index == 1) {
                        checkOrder(e.value);
                    }
                });
                document.querySelector('.mui-popup-input input').type = 'number';
            }else if(data.data=="BTG"){
                window.location.href = contextPath + "/mob/member/auditReject";
            }else{
                window.location.href = contextPath + "/mob/member/auditUser";
            }
        }else if(data.code == 5){
            znt.zntLogOut();
        }else{
            muiAlert("提示",data.exception);
        }
    }
    function errorBack(){

    }
    muiGet("mob/goods/checkUserInfoComplete", param, successBack,errorBack);
})
var mask = mui.createMask(null);
function checkOrder(num) {
    mask.show();//显示遮罩
    if (!isNotEmpty(num) || num > parseInt($("#origStock").val())) {
        mui.toast("请输入购买正确数量;");
        return;
    }
    var busId = $("#busId").val();
    var obj = new Object();
    obj.goodsId = busId;
    obj.systemId = 1;
    obj.origGoodsNum = num;
    successback = function (data) {
        mask.close();//关闭遮罩
        if (data.code == 0) {
            window.location.href = contextPath + "/mob/order/orderBuyList";
        } else if (data.code == 5) {
            znt.zntLogOut();
        } else {
            mui.alert(data.exception);
        }
    },
        errorback = function (data) {
            mask.close();//关闭遮罩
            mui.alert(data);
        }
    muiGet("mob/order/addOrder?formToken="+$("#formToken").val(), obj, successback, errorback);
}


mui("body").on("tap","#phone", function(){
    var tel = $(this).attr("data-id");
    console.log(tel);
    znt.openDial({
        phoneNo: tel // 电话号码
    });
})

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
        imgUrl: url1, // 分享图标
        link: $("#llwUrl").val() + 'mob/goods/goodsShare?id=' + $("#busId").val() + '&type=' + 'supply', // 分享链接
        success: function (res) {

        },
        fail:function(res) {

        }
    });
});

mui("body").on("tap","#shangjia",function(){
    var btnArray = ['取消', '确定'];
    mui.confirm("您确认上架本条信息吗？", "上架提示", btnArray, function (e) {
        var param = {};
        param.id = $("#busId").val();
        param.status = 'SJ';
        function successBack(data) {
            if(data.code==0){
                //修改文字信息
                self.location.href="/mob/goods/queryMyGoodsListView/supply_list";
            }else if(data.code == 5){
                znt.zntLogOut();
            } else if(data.code == 10001){
            }else{
                muiAlert("提示",data.exception);
            }
        }
        if(e.index==1){
            muiReqJsonPost("mob/goods/updateStatusByOffAndOn", param, successBack);
        }

    });
});

mui("body").on("tap","#xiajia",function(){
    var btnArray = ['取消', '确定'];
    mui.confirm("您确认下架本条信息吗？", "下架提示", btnArray, function (e) {
        var param = {};
        param.id = $("#busId").val();
        param.status = 'XJ';
        function successBack(data) {
            if(data.code==0){
                //修改文字信息
                self.location.href="/mob/goods/queryMyGoodsListView/supply_list";
            }else if(data.code == 5){
                znt.zntLogOut();
            } else if(data.code == 10001){
            }else{
                muiAlert("提示",data.exception);
            }
        }
        if(e.index==1){
            muiReqJsonPost("mob/goods/updateStatusByOffAndOn", param, successBack);
        }
    });
});

mui("body").on("tap","#delete",function(){
    var btnArray = ['取消', '确定'];
    mui.confirm("您确认删除本条信息吗？", "删除提示", btnArray, function (e) {
        var param = {};
        var id = $("#busId").val();
        function successBack(data) {
            if(data.code==0){
                //修改文字信息
                self.location.href="/mob/goods/queryMyGoodsListView/supply_list";
            }else if(data.code == 5){
                znt.zntLogOut();
            } else if(data.code == 10001){
            }else{
                muiAlert("提示",data.exception);
            }
        }
        if(e.index==1){
            muiGet("mob/goods/deleteGoodsById/"+id, param, successBack);
        }
    });
});

mui("body").on('tap', '#addfav', function () {
    var goodsId = $(this).attr("data-id");
    addFav(goodsId,"GY");
});
mui("body").on('tap', '#delfav', function () {
    var id = $(this).attr("data-id");
    delFav(id);
});
