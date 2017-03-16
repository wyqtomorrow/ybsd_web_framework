$("#phone").click(function(){
    var tel = $(this).attr("data-id");
    if ($("#boId").val() == $("#sellId").val()){
        muiAlert("提示", "你无法拨打自己的电话");
        return false;
    }
    znt.openDial({
        phoneNo: tel // 电话号码
    });
    console.log(tel);
});
function cancel(obj){
    var orderId = $("#orderId").val();
    var btnArray = ['取消', '确定'];
    mui.confirm('', '确定取消该订单吗?', btnArray, function (e) {
        if (e.index == 0) {
            return false;
        } else if (e.index == 1) {
            var param = {
                orderId:orderId
            }
            var successCb = function (data) {
                self.location.href = contextPath + "/mob/order/orderDetail?orderId=" + orderId + "&sign=" + obj;
                if(data.code == 0){

                }
                else if (data.code == 5) {
                    znt.zntLogOut();
                } else if(data.code == 10001){
                } else {
                    muiAlert("提示",data.exception);
                }
            }
            muiGet("mob/order/cancelOrder", param, successCb, null)
        }
    });
}

function submit(){
    var orderId = $("#orderId").val();
    var param = {
        orderId:orderId
    }
    var successCb = function (data) {
        if (data.code == 0) {
            self.location.href = contextPath + "/mob/order/orderDetail?orderId=" + orderId + "&sign=" + "2";
        }else if (data.code == 5) {
            znt.zntLogOut();
        } else if(data.code == 10001){
        } else {
            muiAlert("提示",data.exception);
        }
    }
    muiGet("mob/order/confirmOrder", param, successCb, null)
}
