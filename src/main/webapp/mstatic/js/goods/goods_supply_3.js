$(function () {
    $(".wf_img").delegate(".d_del", "click", function () {
        var idx = $(".d_del").index(this);
        $(this).parent().parent().remove();
        var imgArray = $("img[class='mui-media-object']");
        if(imgArray.length<4){
            $("#upLi").show();
        }
    });

    $("#gzMin,#gzMax,#sgInput,#tcInput,#slInput").on('input paste', function () {
        this.value = this.value.replace(/\D/g, '')
    });

    $("#price").on('input paste', function () {
        this.value = this.value.replace(/[^0-9.]/g, '')
    });

});


function checkNull(keyVal) {
    if (keyVal == undefined || keyVal == "" || keyVal == null) {
        return true;
    } else {
        return false;
    }
}

/**
 * 发布信息
 */
$("#publish_info").on("tap", function () {
    //1、检查
    //品类
    var plValue = $("#peilei").val();
    if (checkNull(plValue)) {
        muiAlert("提示信息","品类不能为空!");
        return;
    }
    //体型
    var txValue = $("#tixing").val();
    if (checkNull(txValue)) {
        muiAlert("提示信息","体型不能为空!");
        return;
    }
    //性别
    var xbValue = $("#sex").val();
    if (checkNull(xbValue)) {
        muiAlert("提示信息","性别不能为空!");
        return;
    }
    //年龄
    var age = $("#age").val();
    if (checkNull(age)) {
        muiAlert("提示信息","年龄不能为空!");
        return;
    }

    //估重
    var gzMin = $("#gzMin").val();
    if (checkNull(gzMin)) {
        muiAlert("提示信息","估重最小值不能为空!");
        return;
    }

    var gzMax = $("#gzMax").val();
    if (checkNull(gzMax)) {
        muiAlert("提示信息","估重最大值不能为空!");
        return;
    }

    if (Number(gzMin) > Number(gzMax)) {
        muiAlert("提示信息", "估重最小值不能大于估重最大值!");
        return;
    }
    //数量
    var slInput = $("#slInput").val();
    if (checkNull(slInput)) {
        muiAlert("提示信息","数量不能为空!");
        return;
    }

    //价格
    var price = $("#price").val();
    if (checkNull(price)) {
        muiAlert("提示信息","价格不能为空!");
        return;
    }

    //有效期
    var infocheck = $("#infocheck").val();
    if (checkNull(infocheck)) {
        muiAlert("提示信息","信息有效期不能为空!");
        return;
    }

    //有效期不能小于当前时间
    var date = new Date(infocheck);
    var nowDate = new Date();
    if(date.getTime()<nowDate.getTime()){
        muiAlert("提示信息", "信息有效期不能小于当前时间!");
        return;
    }

    //交货地址
    var address = $("#address").val();
    if (checkNull(address)) {
        muiAlert("提示信息","交货地址不能为空!");
        return;
    }
    //配送方式
    var peisong = $("#peisong").val();
    if (checkNull(peisong)) {
        muiAlert("提示信息","配送方式不能为空!");
        return;
    }

    //2、赋值
    var param = {};
    //品类
    param.categoryId = $("#plInput").val();
    //供应类型
    param.type = "GY";
    //地址
    param.addrId = $("#tval2id").val();
    param.areaId = $("#addrAreaId").val();
    param.areaAxis = $("#addrAreaAxis").val();
    param.logistics = $("#tval7").val();
    param.expireTime = $("#infocheck").val();
    param.description = $("#description").val();

    var GG = new Object();
    GG.stockUnit = "TOU";
    GG.stockUnitTxt = "头";
    GG.stockUnitType="COMMON_NUM_UNIT";
    GG.numUnitTxt="公斤";
    GG.numUnit="GJ";
    GG.numUnitType="COMMON_WEIGHT_UNIT";
    GG.sellPrice = $("#price").val();
    GG.origStock = $("#slInput").val();
    param.goodsSpec = GG;

    var goodsAttr = new Array();
    var attrPz = new Object();
    attrPz.name = "品种";
    attrPz.valCode = $("#pzInput").val();
    attrPz.val = $("#pinzhong").val();
    attrPz.attrDefId="GAV_VARIETY";
    var attrTx = new Object();
    attrTx.name = "体型";
    attrTx.valCode = $("#txInput").val();
    attrTx.val = $("#tixing").val();
    attrTx.attrDefId="GAV_SHAPE";
    var attrXb = new Object();
    attrXb.name = "性别";
    attrXb.valCode = $("#xbInput").val();
    attrXb.val = $("#sex").val();
    attrXb.attrDefId="GAV_GENDER";
    var attrMs = new Object();
    attrMs.name = "毛色";
    attrMs.valCode = $("#msInput").val();
    attrMs.val = $("#maose").val();
    attrMs.attrDefId="GAV_HAIR_COLOR";
    var attrNl = new Object();
    attrNl.name = "年龄";
    attrNl.valCode = $("#nlInput").val();
    attrNl.val = $("#age").val();
    attrNl.attrDefId="GAV_YEAR_AGE";
    var attrGzMin = new Object();
    attrGzMin.name = "估重最小值";
    attrGzMin.val = $("#gzMin").val();
    attrGzMin.attrDefId="GAV_WEIGHT_MIN";
    var attrGzMx = new Object();
    attrGzMx.name = "估重最大值";
    attrGzMx.val = $("#gzMax").val();
    attrGzMx.attrDefId="GAV_WEIGHT_MAX";
    var attrSg = new Object();
    attrSg.name = "身高";
    attrSg.val = $("#sgInput").val();
    attrSg.attrDefId="GAV_HEIGHT";
    var attrTc = new Object();
    attrTc.name = "体长";
    attrTc.val = $("#tcInput").val();
    attrTc.attrDefId="GAV_LENGTH";
    goodsAttr.push(attrPz);
    goodsAttr.push(attrTx);
    goodsAttr.push(attrXb);
    goodsAttr.push(attrMs);
    goodsAttr.push(attrNl);
    goodsAttr.push(attrGzMin);
    goodsAttr.push(attrGzMx);
    goodsAttr.push(attrSg);
    goodsAttr.push(attrTc);
    param.goodsAttr = goodsAttr;
    param.form_token=$("#form_token").val();

    var imgArray = $("img[class='mui-media-object']");
    if (imgArray.length > 0) {
        var picArray = new Array();
        $(imgArray).each(function(index){
            picArray.push($(this).attr("src"))
        });
        if(picArray.length>4){
            muiAlert("提示信息", "上传图片不能超过4张!");
            return;
        }
        param.pics=picArray;
    }

    function successBack(data) {
        if (data.code == 0) {
            $("#loading,.mask1").hide();
            window.location.href = "/mob/goods/queryMyGoodsListView/supply_list";
        }
    }

    $("#loading,.mask1").show();
    $(".mask1").height($(window).height());
    muiReqJsonPost("mob/goods/insertGoodsEntity?formToken="+$("#formToken").val(), param, successBack)
});

(function (mui, doc) {
    mui.init();
    var sysId="1";
    mui.ready(function () {
        loadData();
        $('#refreshContainer').hide();
        $('#geshi1').hide();
        $('#dibu1').hide();
        $('#xinzeng').hide();
        $('#geshi2').hide();
        $('#dibu2').hide();
        $('#ha2').show();
        //品类
        var param={};
        muiGet("mob/category/queryGoodsCategoryListByParentId/1003", param, callbackCategory, errorBack);

        function errorBack(){
        }
        function callbackCategory(data) {
            var list = data.data;
            var array = new Array();

            $(list).each(function (index) {
                var dic = new Object();
                dic.value = this.id;
                dic.text = this.name;
                array.push(dic);
            });

            var userPicker1 = new mui.PopPicker();
            userPicker1.setData(array);
            var pl = doc.getElementById('pl');
            var peilei = doc.getElementById("peilei");
            var tval1 = doc.getElementById("plInput");

            var tsex=doc.getElementById("sex");
            var tsexValue=doc.getElementById("xbInput");
            pl.addEventListener('tap', function (event) {
                userPicker1.show(function (items) {
                    peilei.value = items[0].text;
                    tval1.value = items[0].value;
                    if(peilei.value=="种公驴"){
                        tsex.value="公驴";
                        tsexValue.value="GONG";
                    }else{
                        tsex.value="母驴";
                        tsexValue.value="MU";
                    }
                });
            }, false);
        }

        var pzModule = {dictParams: "GAV_VARIETY",sysId:sysId};
        //品种
        getDictionaryParams(pzModule, varietyFun1);

        function varietyFun1(data) {
            var variety = data.data.GAV_VARIETY;
            var array = new Array();

            $(variety).each(function (index) {
                var dic = new Object();
                dic.value = this.code;
                dic.text = this.value;
                array.push(dic);
            });

            var userPicker1 = new mui.PopPicker();
            userPicker1.setData(array);
            var pz = doc.getElementById('pz');
            var pinzhong = doc.getElementById("pinzhong");
            var tval1 = doc.getElementById("pzInput");

            pz.addEventListener('tap', function (event) {
                userPicker1.show(function (items) {
                    pinzhong.value = items[0].text;
                    tval1.value = items[0].value;
                });
            }, false);
        }

        //体型
        var txModule = {dictParams: "GAV_SHAPE",sysId:sysId};
        getDictionaryParams(txModule, varietyFun2);

        function varietyFun2(data) {
            var shape = data.data.GAV_SHAPE;
            var array = new Array();

            $(shape).each(function (index) {
                var dic = new Object();
                dic.value = this.code;
                dic.text = this.value;
                array.push(dic);
            });
            var userPicker2 = new mui.PopPicker();
            userPicker2.setData(array);
            var tx = doc.getElementById('tx');
            var tixing = doc.getElementById("tixing");
            var tval2 = doc.getElementById("txInput");
            tx.addEventListener('tap', function (event) {
                userPicker2.show(function (items) {
                    tixing.value = items[0].text;
                    tval2.value = items[0].value;
                });
            }, false);
        }


        //毛色
        var msModule = {dictParams: "GAV_HAIR_COLOR",sysId:sysId};
        getDictionaryParams(msModule, varietyFun4);

        function varietyFun4(data) {
            var hairColor = data.data.GAV_HAIR_COLOR;
            var array = new Array();

            $(hairColor).each(function (index) {
                var dic = new Object();
                dic.value = this.code;
                dic.text = this.value;
                array.push(dic);
            });
            var userPicker4 = new mui.PopPicker();
            userPicker4.setData(array);
            var ms = doc.getElementById('ms');
            var maose = doc.getElementById("maose");
            var tval4 = doc.getElementById("msInput");
            ms.addEventListener('tap', function (event) {
                userPicker4.show(function (items) {
                    maose.value = items[0].text;
                    tval4.value = items[0].value;
                });
            }, false);
        }

        //年龄
        var ylModule = {dictParams: "GAV_YEAR_AGE",sysId:sysId};
        getDictionaryParams(ylModule, varietyFun5);

        function varietyFun5(data) {
            var yearAge = data.data.GAV_YEAR_AGE;
            var array = new Array();

            $(yearAge).each(function (index) {
                var dic = new Object();
                dic.value = this.code;
                dic.text = this.value;
                array.push(dic);
            });
            var userPicker5 = new mui.PopPicker();
            userPicker5.setData(array);
            var nl = doc.getElementById('nl');
            var age = doc.getElementById("age");
            var tval5 = doc.getElementById("nlInput");
            nl.addEventListener('tap', function (event) {
                userPicker5.show(function (items) {
                    age.value = items[0].text;
                    tval5.value = items[0].value;
                });
            }, false);
        }


        //日期
        var result = mui('#infocheck')[0];
        var btns = mui('#date');
        btns.each(function (i, btn) {
            btn.addEventListener('tap', function () {
                var optionsJson = this.getAttribute('data-options') || '{}';
                var options = JSON.parse(optionsJson);
                var id = this.getAttribute('id');
                var picker = new mui.DtPicker(options);
                picker.show(function (rs) {
                    result.value = rs.text;
                    picker.dispose();
                });
            }, false);
        });

        //配送方式
        var psModule = {dictParams: "COMMON_LOGISTICS",sysId:"0"};
        getDictionaryParams(psModule, varietyFun7);

        function varietyFun7(data) {
            var deliveryStyle = data.data.COMMON_LOGISTICS;
            var array = new Array();

            $(deliveryStyle).each(function (index) {
                var dic = new Object();
                dic.value = this.code;
                dic.text = this.value;
                array.push(dic);
            });
            var userPicker7 = new mui.PopPicker();
            userPicker7.setData(array);
            var ps = doc.getElementById('ps');
            var peisong = doc.getElementById("peisong");
            var tval7 = doc.getElementById("tval7");
            ps.addEventListener('tap', function (event) {
                userPicker7.show(function (items) {
                    peisong.value = items[0].text;
                    tval7.value = items[0].value;
                });
            }, false);
        }
    });
})(mui, document);

$("body").on("tap", "#address", function () {
    $('#xinzeng').hide();
    $('#geshi2').hide();
    $('#dibu2').hide();
    $('#ha2').hide();
    $('#refreshContainer').show(700);
    $('#geshi1').show(700);
    $('#dibu1').show(700);
});
