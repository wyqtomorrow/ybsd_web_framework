function sellLv(page,categoryId){
    var param={};
    function successBack(data){
        if(data.code==0){
            if(data.data=="TG" || data.data=="DSH"){
                window.location.href = contextPath + "/mob/goods/supplyGoodsPublish/"+page+"/"+categoryId;
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
}
