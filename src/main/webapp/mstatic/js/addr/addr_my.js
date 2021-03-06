/**
 * Created by Administrator on 2016/12/2.
 */

$(document).ready(function () {
    loadData();
})

function addAddr() {
    $('#myAddrHead').hide();
    $('#refreshContainer').hide();
    $('#geshi1').hide();
    $('#dibu1').hide();
    $('#xinzeng').show();
    $('#geshi2').show();
    $('#dibu2').show();
}
function toPreviou(){
    $('#xinzeng').hide();
    $('#geshi2').hide();
    $('#dibu2').hide();
    $('#myAddrHead').show();
    $('#refreshContainer').show();
    $('#geshi1').show();
    $('#dibu1').show();
}

function saveAddr() {
    var isDefault = 0;
    var sign = 0;
    var boId;
    if ($("#name").val() == "") {
        muiAlert("提示", "您未填写联系人");
        return false;
    }
    if ($("#tel").val() == "") {
        muiAlert("提示", "您未填写电话号码");
        return false;
    }
    if ($("#tel").val().length != 11) {
        muiAlert("提示", "请您填写11位电话号码");
        return false;
    }
    if ($(".area").val() == "") {
        muiAlert("提示", "您未选择地区");
        return false;
    }
    if ($("#detailAddr").val() == "") {
        muiAlert("提示", "您未填写详细地址");
        return false;
    }
    if ($("#moren").hasClass("mui-active")) {
        isDefault = 1;
    } else {
        isDefault = 0;
    }
    if ($("#modifySign").val() == "") {
        sign = 0;
    } else {
        sign = 1;
        boId = $("#boId").val();
    }
    $("#saveBtn").attr("disabled", true);
    var params = {
        name: $("#name").val(),
        tel: $("#tel").val(),
        areaId: $("#countyId").val(),
        areaAxis: $("#axis").val(),
        addr: $("#detailAddr").val(),
        areaDisplayName: $("#fullName").val(),
        isDefault: isDefault,
        systemId: 1,
        sign: sign,
        id: boId
    };

    var successCb = function (data) {
        if(data.code == 0){
        loadData();
        $("#saveBtn").attr("disabled", false);
        $("#name").val("");
        $("#boId").val("");
        $("#tel").val("");
        $("#detailAddr").val("");
        $("#moren").removeClass("mui-active")
        $("#modifySign").val("");
        $("#area").val("");
        $("#axis").val("");
        $("#countyId").val("");
        }else if(data.code == 5){
            znt.zntLogOut();
        }else{
            muiAlert("提示",data.exception);
        }
    };
    muiPost("mob/memberAddr/submitAddAddr.do", params, successCb, null);
}

//点击列表事件
$("#myAddrList").on("tap", "#addrDeta", function () {
    var addrId = $(this).attr("data-id");
    console.log(addrId);
})

var myAddr_source = "{{if items}}"
    + "{{each items}}"
    + "<li class='mui-table-view-cell' >"
    + "<div class='mui-row clear padd15_r'id='addrDeta'data-id='{{$value.id}}'>"
    + '<p class="black3 f15 mui-row">'
    + "<span class='mui-col-xs-2'>{{$value.name}}</span>"
    + "<span class='gray_l'>{{$value.tel}}</span>"
    + '</p>'
    + '				<p class="gray_6 mui-row">                                                                  '
    + '{{if $value.isDefault == 1}}'
    + '					<span class="mui-col-xs-2"><em class="d_blue d_bl_bor f12">默认</em></span>                                       '
    + '{{else}}'
    + '<span class="mui-col-xs-2"><em class="d_blue f12" ></em></span>'
    + '{{/if}}'
    + '					<span class="mui-col-xs-10 gray_l">地址：{{$value.areaDisplayName}}{{$value.addr}}</span>                                   '
    + '				</p>                                                                                '
    + '			</div>                                                                                '
    + '	<div class="d_line"></div>                                                              '
    + '	<div class="mui-media-body">                                                     '
    + '		<p class="black3">                                                                      '
    + '			<span class="mui-pull-right d_btn mui_btnn">											                              '
    + '				<button  class="mui-btn mui-btn-danger alertBtn" type="button" onclick="delAddr({{$value.id}});">删除</button>          '
    + '				<button  class="mui-btn mui-btn-primary" type="button" onclick="modify({{$value.id}});">修改</button>                                '
    + '			</span>                                                                               '
    + '		</p>                                                                                    '
    + '	</div>									                                                                  '
    + '</li>                                                                                      '
    + '<div class="box10"></div>'
    + "{{/each}}"
    + "{{/if}}";

function loadData() {
    $('#myAddrHead').show();
    $('#refreshContainer').show();
    $('#geshi1').show();
    $('#dibu1').show();
    $('#addHead').hide();
    $('#xinzeng').hide();
    $('#geshi2').hide();
    $('#dibu2').hide();
    $('#modifyHead').hide();
    $('#dibu3').hide();
    var params = {
        systemId: 1
    };
    var successCb = function (data) {
        console.log(data.data);
        var html = "";
        var data = {items: data.data}
        var render = template.compile(myAddr_source);
        html = render(data);
        $("#myAddrList").html(html);
    };
    muiGet("mob/memberAddr/addrListShow.do", params, successCb, null);
}

function modify(obj) {
    var params = {
        id: obj
    };
    var successCb = function (data) {
        $('#myAddrHead').hide();
        $('#refreshContainer').hide();
        $('#geshi1').hide();
        $('#dibu1').hide();
        $('#addHead').hide();
        $('#xinzeng').show();
        $('#geshi2').show();
        $('#dibu2').show();
        $('#modifyHead').show();
        var obj = data.data;
        $("#name").val(obj.name);
        $("#boId").val(obj.id);
        $("#tel").val(obj.tel);
        $("#detailAddr").val(obj.addr);
        $("#area").val(obj.areaDisplayName);
        $("#fullName").val(obj.areaDisplayName);
        if (obj.isDefault == "1") {
            $("#moren").addClass("mui-active")
        }
        $("#modifySign").val(1);
        $("#axis").val(obj.areaAxis);
        $("#countyId").val(obj.areaId);
    };
    muiPost("mob/memberAddr/modifyAddr.do", params, successCb, null);
}

function delAddr(obj) {
    var btnArray = ['取消', '确定'];
    mui.confirm('', '确定删除该地址吗?', btnArray, function (e) {
        if (e.index == 0) {
            return false;
        } else if (e.index == 1) {
            var params = {
                id: obj
            };
            var successCb = function (data) {
                if (data.data == "1") {
                    loadData();
                }
            };
            muiPost("mob/memberAddr/submitDelAddr.do", params, successCb, null);
        }
    });
}

