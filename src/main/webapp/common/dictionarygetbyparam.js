/**
 * Created by Administrator on 2016/12/2.
 */
function  getDictionaryParams(obj,defineFunc){
    var successCb = function(data) {
        defineFunc(data);
    };
    muiGet("mob/dictionary/getDictParams.do", obj, successCb, null);

}
