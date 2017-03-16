function queryAllCitys(){
    var successBack = function (data) {
        if (data.code == 0) {
            var html = "<li class='mui-table-view-cell t_center' data='0'>全部</li>";
            var array = data.data;
            for (var i = 0; i < array.length; i++) {
                for (var key in array[i]) {
                    var obj = array[i][key];
                    html+="<li class='mui-table-view-cell t_center' data='"+key+"' data_1='"+obj.axis+"'>"+obj.areaName+"</li>"
                }
            }
            $(".i_city").html(html);
        }
    }

    allProvince(successBack);
}

function queryCitysByAreaId(areaId,level){
    var successBack = function (data) {
        if (data.code == 0) {
            var html = "";
            var array = data.data;
            for (var i = 0; i < array.length; i++) {
                for (var key in array[i]) {
                    var obj = array[i][key];
                    html+="<li class='mui-table-view-cell t_center' data='"+key+"' data_1='"+obj.axis+"'>"+obj.areaName+"</li>"
                }
            }
            html="<li class='mui-table-view-cell t_center' data='0'>全部</li>"+html;
            if(level==2){
                $(".ic_qy").html("");
                $(".ic_qy").html(html);
            }else{
                $(".ic_area").html("");
                $(".ic_area").html(html);
            }

        }
    }

    citysByProvinceId(areaId,successBack);
}