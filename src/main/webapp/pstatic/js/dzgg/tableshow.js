
//json注意  data数据中每个数组的第一个元素是用来控制生成内容颜色
//1 绿     3 红  2黄   传递时间在本页面最下面
var pageNum1 = 1;
var data0 = {data:[]};
var timer;
$(document).ready(function () {
    hengTiao();
	qg();
});
var indexA=0;
var tabBody=$(".tabbody")
$(function(){
	$(".t_nav a").click(function(){

		var idx=$(this).index();
		indexA=idx;
		$("#qgSign").val(0);
		data0 = {data:[]};
		pageNum1 = 1;
		$(this).addClass("cur").siblings().removeClass("cur");
		if(indexA == 0){
			qg()
		}
		if(indexA == 1){
			gy()
		}
		if(indexA == 2){
			cj()
		}

		if(tabBody.eq(idx).html()==""){
			//firstAddTR();
			$("#tCon").children().eq(idx).show().siblings().hide();
		}else{
			$("#tCon").children().eq(idx).show().siblings().hide();
		}
	});
});
//初始化数据
function firstAddTR(){
	console.log(indexA)
	//$.getJSON(data0,function(date){
	//var dateTrList=date.data;
		var dateTrList=data0.data;
		var trSting=[]
		for(var i=0,dataLength=dateTrList.length;i<dataLength;i++){
			if(dateTrList[i][0]=="1"){
				dateTrList[i].shift()
				trSting += '<tr class="green"><td><span>' + dateTrList[i].join('</span></td><td><span> ') + '</td></tr>';
			}
			else if(dateTrList[i][0]=="2"){
				dateTrList[i].shift()
				trSting += '<tr class="green"><td><span>' + dateTrList[i].join('</span></td><td><span> ') + '</td></tr>';
			}else if(dateTrList[i][0]=="3"){
				dateTrList[i].shift()
				trSting += '<tr class="green"><td><span>' + dateTrList[i].join('</span></td><td><span> ') + '</td></tr>';
			}
		}
		$(".tabbody"+indexA).html(trSting)
}
//})
/*setTimeout(function(){
	firstAddTR();
},1000)*/

//var jsonNo=1
setInterval(function() {
	if(indexA == 0){
		qg()
	}
	if(indexA == 1){
		gy()
	}
	if(indexA == 2){
		cj()
	}
},8000)

setInterval(function() {
	hengTiao();
},600000)

function nige(){
	var tabbody=$(".tabbody"+indexA);
	var dateTr=data0.data;
	var dateLen=0;
	clearInterval(timer);
	timer=setInterval(function(){
		if(dateLen<dateTr.length){
			if(dateTr[dateLen][0]=="1"){
				tabbody.find("tr").eq(dateLen).attr("class","green")
			}else if(dateTr[dateLen][0]=="2"){
				tabbody.find("tr").eq(dateLen).attr("class","green")
			}else if(dateTr[dateLen][0]=="3"){
				tabbody.find("tr").eq(dateLen).attr("class","green")
			}
			dateTr[dateLen].shift()
			tabbody.find("tr").eq(dateLen).find("span").each(function(i,e){
				$(this).html();
				$(this).css("opacity",0)
				$(this).animate({"opacity":1},1000);
				$(this).html(dateTr[dateLen][i]);
			})
		}else{
			clearInterval(timer)
		}
		dateLen++
	},300)
}


var hengtiao = 	'	<span>                                   '
	+'		<em>肉驴在售头数：{{rouLvTotal}}头</em>                '
	+'		<em>成交头数：{{totalCount1}}头</em>				           '
	+'		<em>成交金额：{{totalMoney1}}元</em>                '
	+'	</span>                                  '
	+'	<span>                                   '
	+'		<em>驴驹在售头数：{{lvJuTotal}}头</em>                 '
	+'		<em>成交头数：{{totalCount2}}头</em>                    '
	+'		<em>成交金额：{{totalMoney2}}元</em>                   '
	+'	</span>                                  '
	+'	<span>                                   '
	+'		<em>种驴在售头数：{{zhongLvTotal}}头</em>                 '
	+'		<em>成交头数：{{totalCount3}}头</em>                    '
	+'		<em>成交金额：{{totalMoney3}}元</em>                   '
	+'	</span>                                  ';

function hengTiao(){
    var param = {
    };
    var successCb = function (res) {
        var html = "";
        var render = template.compile(hengtiao);
        html = render(res.data);
        $("#scrollobj").html(html);
    }
    ajaxJson("/pc/dzgg/hengTiao", param, successCb, "POST");
}

function qg(){
	if(pageNum1 == 2){
		$("#qgSign").val(1);
	}
	var param = {
		pageNum:pageNum1,
		pageSize:12,
		type:"QG"
	};
	var successCb = function (res) {
		var result = res.page.pages;
		var entity = res.data;
		if (result != "undefined" && result != "0") {
			$(entity).each(function(index,item) {
				var oneData = [
					1,
					item.id,
					item.categoryName,
					item.pzName,
					item.mapAttr.GAV_ORIG_PLACE,
					item.age,
					item.guzhong,
					item.price,
					item.currStock,
					item.logistStr,
					item.addrResForm.name,
					item.addrResForm.tel,
					item.expireTimeStr
				];
				data0.data.push(oneData);
			})
			if(pageNum1 == 1){
				firstAddTR();
				data0 = {data:[]};
				console.log("1");
			}
			if (result <= pageNum1) {
				pageNum1 = 1;
			}else{
				pageNum1++;
			}
			if($("#qgSign").val()==1){
				nige();
				data0 = {data:[]};
				console.log("2");
			}
		}
	}
	ajaxJson("/pc/dzgg/qiuGouGongYing", param, successCb, "POST");
}

function gy(){
	if(pageNum1 == 2){
		$("#qgSign").val(1);
	}
	var param = {
		pageNum:pageNum1,
		pageSize:12,
		type:"GY"
	};
	var successCb = function (res) {
		var result = res.page.pages;
		var entity = res.data;
		if (result != "undefined" && result != "0") {
			$(entity).each(function(index,item) {
				var oneData = [
					1,
					item.id,
					item.categoryName,
					item.pzName,
					item.age,
					item.guzhong,
					item.price,
					item.currStock,
					item.logistStr,
					item.addrResForm.name,
					item.addrResForm.tel,
					item.addrResForm.areaDisplayName,
					"在售"
				];
				data0.data.push(oneData);
			})
			if(pageNum1 == 1){
				firstAddTR();
				data0 = {data:[]};
				console.log("1");
			}
			if (result <= pageNum1) {
				pageNum1 = 1;
			}else{
				pageNum1++;
			}
			if($("#qgSign").val()==1){
				nige();
				data0 = {data:[]};
				console.log("2");
			}
		}
	}
	ajaxJson("/pc/dzgg/qiuGouGongYing", param, successCb, "POST");
}

function cj(){
	if(pageNum1 == 2){
		$("#qgSign").val(1);
	}
	var param = {
		pageNum:pageNum1,
		pageSize:12
	};
	var successCb = function (res) {
		var result = res.page.pages;
		var entity = res.data;
		if (result != "undefined" && result != "0") {
			$(entity).each(function(index,item) {
				var oneData = [
					1,
					item.id,
					item.memberResForm.realName,
					item.goodsDetailResForm.shopResForm.linkman,
					item.goodsDetailResForm.categoryName,
					item.pz,
					item.age,
					item.guzhong,
					item.goodsDealMoney,
					item.finalGoodsNum,
					item.logitStr,
					item.finishTimeStr,
					"成交"
				];
				data0.data.push(oneData);
			})
			if(pageNum1 == 1){
				firstAddTR();
				data0 = {data:[]};
				console.log("1");
			}
			if (result <= pageNum1) {
				pageNum1 = 1;
			}else{
				pageNum1++;
			}
			if($("#qgSign").val()==1){
				nige();
				data0 = {data:[]};
				console.log("2");
			}
		}
	}
	ajaxJson("/pc/dzgg/orderFinished", param, successCb, "POST");
}
