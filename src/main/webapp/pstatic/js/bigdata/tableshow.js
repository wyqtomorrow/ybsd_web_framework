//json注意  data数据中每个数组的第一个元素是用来控制生成内容颜色
//1 绿     3 红  2黄   传递时间在本页面最下面
(function(){
	function tableShow(timer){
		this.totaltime=timer.totaltime;  //多久更新一次
		this.ratetime=timer.ratetime;   //每条表格更新的频率
		this.evertdtime=timer.evertdtime; //每条表格需要的替换数据的时长
		this.pagetime=timer.pagetime; //翻页时间
		this.dateArray="";
		this.first=true;
		this.timerz=null;
		this.timerpg=null;
		this.timerajax=null;
		this.pageCnt=0;
		this.indexNow=0;
		var _this=this;
		_this.getJson();
		_this.timerajax = setInterval(function(){
			_this.getJson();
		},this.totaltime);
	}
	tableShow.prototype={
		getJson:function(){
			var _this=this;
			var param = {"lineNo":$('#lineNo').val()};

			jQuery.ajax({
				url:'/bigdata/getBulletinInfo',
				type:'get',
				async:false,
				data:param,
				dataType:'JSON',
				success:function(date){
					//没取到数就不进行下面处理
					if(!date || !date.data || date.data.length==0){
						return;
					}

					//取到数之后把翻页和翻行定时器停掉
					if(_this.timerz != null){
						clearInterval(_this.timerz);
					}
					if(_this.timerpg != null){
						clearInterval(_this.timerpg);
					}

					_this.dateArray=date.data;

					//第一次加载第一页时直接加载数据
					if (_this.first) {
						_this.appleDataToTable(_this.dateArray[_this.pageCnt++])
					}
					//翻页定时
					_this.timerpg = setInterval(function () {
						//新翻页时把翻行定时停掉
						if (_this.timerz != null) {
							clearInterval(_this.timerz);
						}
						//翻到最后一页时置成第一页
						if (_this.pageCnt == _this.dateArray.length) {
							_this.pageCnt = 0;
						}
						_this.appleDataToTable(_this.dateArray[_this.pageCnt++])
					}, _this.pagetime)
				}
			});
			//$.getJSON("/bigdata/getBulletinData", param, function(date){
            //
			//	//没取到数就不进行下面处理
			//	if(!date || !date.data || date.data.length==0){
			//		return;
			//	}
            //
			//	//取到数之后把翻页和翻行定时器停掉
			//	if(_this.timerz != null){
			//		clearInterval(_this.timerz);
			//	}
			//	if(_this.timerpg != null){
			//		clearInterval(_this.timerpg);
			//	}
            //
			//	_this.dateArray=date.data;
            //
			//	//第一次加载第一页时直接加载数据
			//	if (_this.first) {
			//		_this.appleDataToTable(_this.dateArray[_this.pageCnt++])
			//	}
			//	//翻页定时
			//	_this.timerpg = setInterval(function () {
			//		//新翻页时把翻行定时停掉
			//		if (_this.timerz != null) {
			//			clearInterval(_this.timerz);
			//		}
			//		//翻到最后一页时置成第一页
			//		if (_this.pageCnt == _this.dateArray.length) {
			//			_this.pageCnt = 0;
			//		}
			//		_this.appleDataToTable(_this.dateArray[_this.pageCnt++])
			//	}, _this.pagetime)
            //
			//})

		},
		appleDataToTable:function(dateArrayPage){
			var _this=this;

			if(_this.first) {
				_this.first = false;

				for (var i = 0; i < dateArrayPage.length; i++) {
					var datalist = dateArrayPage[i]
					var mTdString = ''
					for (var j = 1; j < datalist.length; j++) {
						mTdString += '<td><span>' + datalist[j] + '</span></td>'
					}
					if (datalist[0] == "1") {
						var mytr = '<tr class="green"><span>' + mTdString + '</span></tr>';
					} else if (datalist[0] == "2") {
						var mytr = '<tr class="yellow"><span>' + mTdString + '</span></tr>';
					} else if (datalist[0] == "3") {
						var mytr = '<tr class="red"><span>' + mTdString + '</span></tr>';
					} else {
						var mytr = '<tr><span>' + mTdString + '</span></tr>';
					}
					$("#tabbody").append(mytr);
				}

			}else{
				//翻行处理
				_this.timerz=setInterval(function(){
					_this.replaceTr(dateArrayPage)
				},_this.ratetime)
			}
		},
		replaceTr:function(list){
			var _this=this;
			if(_this.indexNow<list.length){
				if(list[_this.indexNow][0]=="1"){
					$("#tabbody").find("tr").eq(_this.indexNow).attr("class","green");
				}else if(list[_this.indexNow][0]=="2"){
					$("#tabbody").find("tr").eq(_this.indexNow).attr("class","yellow");
				}else if(list[_this.indexNow][0]=="3"){
					$("#tabbody").find("tr").eq(_this.indexNow).attr("class","red");
				}

				$("#tabbody").find("tr").eq(_this.indexNow).find("span").each(function(i,e){
					$(this).html();
					$(this).css("opacity",0);
					$(this).animate({"opacity":1},_this.evertdtime);

					$(this).html(list[_this.indexNow][i+1]);
				})
				_this.indexNow++;
			}else{
				_this.indexNow=0
				clearInterval(_this.timerz)
			}
		}
	}
	window.tableShow=tableShow;
})()
