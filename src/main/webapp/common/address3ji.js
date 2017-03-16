/**
 * Created by Administrator on 2016/12/3.
 */
// 地区插件
var areaFullName = null;

mui("body").on('tap','#area',function(){
    var cityPicker3 = new mui.PopPicker({
        layer: 3
    });
    cityPicker3.setData(cityData3);
    var _this=$(this)
    cityPicker3.show(function(items) {
        if((items[0] || {}).value == "$1" || (items[0] || {}).value == "$23" ||(items[0] || {}).value == "$635" ||(items[0] || {}).value=="$4654"){
            areaFullName = (items[0] || {}).text   + (items[2] || {}).text;
            _this.val(areaFullName)
        }else{
            areaFullName = (items[0] || {}).text +  (items[1] || {}).text  + (items[2] || {}).text;
            _this.val(areaFullName)
        }
        document.getElementById("provinceId").value = (items[0] || {}).value;
        document.getElementById("cityId").value = (items[1] || {}).value;
        var string = document.getElementById("countyId").value = (items[2] || {}).value;
        var arr = string.split("$");
        //arr = ["", "495", "496", "3128"]
        $("#provinceId").val(arr[1]);
        $("#cityId").val(arr[2]);
        $("#countyId").val(arr[3]);
        $("#axis").val(string);
        $("#axisPur").val(string);
        $("#fullName").val(areaFullName);
        $("#fullNamePur").val(areaFullName);
        //console.log(arr[1]);
        //console.log(document.getElementById("provinceId").value);
        //console.log(document.getElementById("cityId").value);
        //console.log(document.getElementById("countyId").value);
        //console.log(document.getElementById("axis").value);
        //console.log(document.getElementById("fullName").value);
    });
})
