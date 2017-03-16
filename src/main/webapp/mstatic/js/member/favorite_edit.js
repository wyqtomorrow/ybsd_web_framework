/**
 * @Description: 收藏操作js
 * @jsName:favorite_edit
 * @author YS
 * @create 2017-01-17 19:49
 */
function addFav(resId,type){

    var param = new Object();
    param.resId = resId;
    param.type = type;
    param.isEnabled = 1;
    back = function(e){
        mui.alert("收藏成功","提示",function(){
            window.location.reload();
        });
    }
    muiGet("mob/memberFavorite/updFavStatus",param,back,null);
}
function delFav(id){
    var param = new Object();
    param.id = id;
    param.isEnabled = 0;
    back = function(e){
        mui.alert("取消收藏成功","提示",function(){
            window.location.reload();
        });
    }
    muiGet("mob/memberFavorite/updFavStatus",param,back,null);
}
