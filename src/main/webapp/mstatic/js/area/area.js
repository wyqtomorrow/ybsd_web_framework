var allProvince = function(successFun){
    var param={};
    muiGet("area/getAllProvinces",param,successFun);
}

var citysByProvinceId = function(areaId,successFun){
    var param={};
    muiGet("area/getAllCitysByProvinceId/"+areaId,param,successFun);
}