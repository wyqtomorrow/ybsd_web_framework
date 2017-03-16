//母驴受孕率情况比较
function minChart(obj,valueX,valueY,minValue,maxValue){
	obj.highcharts({
		chart: {
			zoomType: 'xy',
			backgroundColor:'transparent'	
		},
    title: {
			text: '头',
			align: 'left',
			x:10,
			y:20,
			style: {
				color: '#fff',
				fontSize:"12px"
			}
		},
    xAxis: {
			categories:valueX,
			labels:{
				style:{
					color:"#fafafa",
					fontFamily:"Microsoft YaHe",
					fontSize:"12px"
				}
			},
			endOnTick: true,
			showLastLabel: true,
			startOnTick: true,
			tickmarkPlacement: 'on'			
		},
		yAxis: [{ // Primary yAxis
			labels:{
				style:{
					color:"#fafafa",
					fontFamily:"Microsoft YaHe",
					fontSize:"12px"
				}
			},
			title: {enabled: false},
			lineWidth: 1,
			gridLineWidth: 0,
		}, { // Secondary yAxis
			title: {
				enabled: false
			},
			labels:{
			style:{
				color:"#fafafa",
				fontFamily:"Microsoft YaHe",
				fontSize:"12px"
			}
		},
		lineWidth: 1,
		 gridLineWidth: 0,
		opposite: true
		}],
		tooltip: {
			shared: true
		},

		labels: {
			items: [{
				style: {
					left: '100px',
					top: '18px',
					color:'#fff'
				}
			}]
		},
		legend: {
			itemStyle: {
				color: '#fff',
				fontWeight: 'bold'
			},
			itemHoverStyle: {
				color: '#00bfff'
			},
			verticalAlign: 'top',
			align:'right'			 
		},
		plotOptions: {
			series: {
				marker: {
					enabled: false,
					states:{  
						hover:{  
							enabled:false  
						}  
					}
				}
			},
			column: {
				borderWidth: "0"
			}
		},	
		credits: {
			enabled: false
		},
    series:valueY
	});
};
//每月产驹头数
function minChart1(obj,valueX,valueY,minValue,maxValue){
	obj.highcharts({
		chart: {
			type: 'column',
			backgroundColor:'transparent'
		},
		title: {
			text: '头',
			align: 'left',
			x:5,
			y:20,
			style: {
				color: '#fff',
				fontSize:"12px"
			}
		},
		xAxis: {
			categories:valueX,
			endOnTick: true,
			showLastLabel: true,
			startOnTick: true,
			tickmarkPlacement: 'on',
			labels:{
				style:{
					color:"#fafafa",
					fontFamily:"Microsoft YaHe",
					fontSize:"12px"
				}
			},
		},
		yAxis: {
			allowDecimals: false,
			min: 0,
			title: {
				enabled: false
			},
			reversed: false,
			lineWidth: 1,
			gridLineWidth: 0,
			labels:{
				style:{
					color:"#fafafa",
					fontFamily:"Microsoft YaHe",
					fontSize:"12px"
				}
			},
		},
		tooltip: {
			formatter: function () {
				return '<span>' + this.x + '</span><br/>' +	this.series.name + ': <span style="font-weight:bold;">' + this.y + '</span><br/>' +'共计:<span style="font-weight:bold;"> ' + this.point.stackTotal+'</span>';
			}
		},
		plotOptions: {
			column: {
				stacking: 'normal',
				borderWidth: "0"
			}
		},
		legend: {
			itemStyle: {
				color: '#fff',
				fontWeight: 'bold'
			},
			verticalAlign: 'top',
			align:'right',
			itemHoverStyle: {
				color: '#00bfff'
			}	
		},
		credits: {
			enabled: false
		},
		series:valueY
	});
};
//春季驴驹每月日增重生长趋势
function minChart3(obj,valueX,valueY,minValue,maxValue){
	obj.highcharts({
		chart: {
			type: 'line',
			backgroundColor:'transparent'				
		},
		title: {
			text: 'kg',
			align: 'left',
			x:20,
			y:20,
			style: {
				color: '#fff',
				fontSize:"12px"
			}
		},
		xAxis: {
				categories:valueX,
				labels:{
				style:{
					color:"#fafafa",
					fontFamily:"Microsoft YaHe",
					fontSize:"12px"
				}
			},
			endOnTick: true,
			showLastLabel: true,
			startOnTick: true,
			tickmarkPlacement: 'on'						
		},
		yAxis: {
				title:{text:""},
					labels:{
				style:{
					color:"#fafafa",
					fontFamily:"Microsoft YaHe",
					fontSize:"12px"
				}
			},
			reversed: false,
			lineWidth: 1,
			 gridLineWidth: 0
		},
		plotOptions: {
			series: {
				marker: {
					enabled: false,
					states:{  
							hover:{  
									enabled:false  
							}  
					}
				}
			}
		},
		tooltip: {
			pointFormat: '<span style="color:#333;">{series.name}</span>: <b>{point.y}</b>kg<br/>',
			shared: true
		},
		labels: {
			items: [{
					style: {
							left: '100px',
							top: '18px',
							color:'#fff'
					}
			}]
		},
		legend: {
			itemStyle: {
				color: '#fff',
				fontWeight:'bold'
			},
			verticalAlign:'top',
			align:'right',
			itemHoverStyle: {
				color: '#00bfff'
			}	
		},
		credits: {
			enabled:false
		},
		series:valueY
	});
};
//每月淘汰情况
function minChart5(obj,valueX,valueY,minValue,maxValue){
	obj.highcharts({
		chart: {
			type: 'line',
			backgroundColor:'transparent'				
		},
		title: {
			text: '头',
			align: 'left',
			x:5,
			y:20,
			style: {
				color: '#fff',
				fontSize:"12px"
			}
		},
		xAxis: {
			categories:valueX,
			labels:{
				style:{
					color:"#fafafa",
					fontFamily:"Microsoft YaHe",
					fontSize:"12px"
				}
			},
			endOnTick: true,
			showLastLabel: true,
			startOnTick: true,
			tickmarkPlacement: 'on'
		},
		yAxis: {
			title:{text:""},
			labels:{
				style:{
					color:"#fafafa",
					fontFamily:"Microsoft YaHe",
					fontSize:"12px"
				}
			},
			reversed: false,
			lineWidth: 1,
			gridLineWidth: 0
		},
		plotOptions: {
			series: {
				marker: {
					enabled: false,
					 states:{  
							hover:{  
									enabled:false  
							}  
					}
				}
			}
		},
		tooltip: {
			pointFormat: '<span style="color:#333">{series.name}</span>: <b>{point.y}</b> 头<br/>',
			shared: true
    },
		labels: {
			items: [{
				style: {
					left: '100px',
					top: '18px',
					color:'#fff'
				}
			}]
		},
		legend: {
			itemStyle: {
				color: '#fff',
				fontWeight: 'bold'
			},
			verticalAlign: 'top',
			align:'right',
			itemHoverStyle: {
				color: '#00bfff'
			}	
		},
		credits: {
			enabled: false
		},
		series:valueY
	});
};
//每月情期受孕率情况
function minChart2(obj,valueX,valueY,minValue,maxValue){
	obj.highcharts({
		chart: {
			type: 'line',
			backgroundColor:'transparent'				
		},
		title: {
			text: '%',
			align: 'left',
			x:10,
			y:20,
			style: {
				color: '#fff',
				fontSize:"12px"
			}
		},
		xAxis: {
				categories:valueX,
				labels:{
				style:{
					color:"#fafafa",
					fontFamily:"Microsoft YaHe",
					fontSize:"12px"
				}
			},
			endOnTick: true,
			showLastLabel: true,
			startOnTick: true,
			tickmarkPlacement: 'on'						
		},
		yAxis: {
				title:{text:""},
					labels:{
				style:{
					color:"#fafafa",
					fontFamily:"Microsoft YaHe",
					fontSize:"12px"
				}
			},
			reversed: false,
			lineWidth: 1,
			 gridLineWidth: 0
		},
		plotOptions: {
			series: {
				marker: {
						enabled: false,
						 states:{  
								hover:{  
										enabled:false  
								}  
						}
				}
			}
		},
		tooltip: {
			pointFormat: '<span style="color:#333">{series.name}</span>: <b>{point.y}</b>%<br/>',
			shared: true
		},
		labels: {
			items: [{
				style: {
					left: '100px',
					top: '18px',
					color:'#fff'
				}
			}]
		},
		legend: {
			itemStyle: {
				color: '#fff',
				fontWeight: 'bold'
			},
			verticalAlign: 'top',
			align:'right',
			itemHoverStyle: {
				color: '#00bfff'
			}	
		},
		credits: {
			enabled: false
		},
		series:valueY
	});
};
//饼图
function pChart(id,data,color){
	$(id).highcharts({
		chart: {
			plotBackgroundColor: null,
			plotBorderWidth: null,
			plotShadow: true,	
			borderRadius: 160,
			spacing:[0,0,0,0],
			backgroundColor:'transparent'		
		},
		title: {
			text: '',						
		},
		tooltip: {
			pointFormat: '<span style="color:{series.color}"><b>{point.y}</b> ({point.percentage:.0f}%)<br/>',
			shared: true
		},
		legend: {
			itemStyle: {
				color:'#fff',
				fontWeight:'bold'
			},
			verticalAlign: 'top',
			align:'left', 
			itemHoverStyle: {
				color: '#00bfff'
			}	
		},
		exporting: {
			enabled: false
		},
		credits: {
			enabled: false
		},
		plotOptions: {
			pie: {
				allowPointSelect: true,
				cursor: 'pointer',
				dataLabels: {
					enabled: false
				},
				showInLegend: true,
				center: ['35%', '50%'],
				dataLabels: {
					enabled: true,
					distance: -50,
					style: {
						color: '#333'
					}
				},
				borderWidth: "0"
			},
			series: {
				dataLabels: {
					enabled: true,
					format: '{point.y}'
				}
			}								
		},
		exporting: {
				enabled: false
		},
		series: [{
				type: 'pie',
				colors:color, 
				data: [
					['种母驴',   433],
					['种公驴',   107],
					['后备母驴', 29],
					['＞6月驴驹',165],
					['＜6月驴驹',100]
				]
		}]
	});	
}

