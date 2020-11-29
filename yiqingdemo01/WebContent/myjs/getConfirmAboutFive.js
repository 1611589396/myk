//加载事件
$(function(){
	
	test1("湖北");
	
})

function selectAreaByConfirm(){
	
	var name = $("#confirmArea").val();
	test1(name);
}

function test1(pname){
	
	$.get("xiaoming/getConfirmAboutFive.do",{name:pname},function(data){
		
		
		var pie_fanzui =echarts.init(document.getElementById("confirmCount"),'infographic'); 
		 option = {
				  //  backgroundColor: '#00265f',
				    tooltip: {
				        trigger: 'axis',
				        axisPointer: { type: 'shadow'}
				    },
				    grid: {
				        left: '0%',
						top:'10px',
				        right: '0%',
				        bottom: '4%',
				       containLabel: true
				    },
				    xAxis: [{
				        type: 'category',
				      	data: data[0],
				        axisLine: {
				            show: true,
				         lineStyle: {
				                color: "rgba(255,255,255,.1)",
				                width: 1,
				                type: "solid"
				            },
				        },
						
				        axisTick: {
				            show: false,
				        },
						axisLabel:  {
				                interval: 0,
				               // rotate:50,
				                show: true,
				                splitNumber: 15,
				                textStyle: {
				 					color: "rgba(255,255,255,.6)",
				                    fontSize: '12',
				                },
				            },
				    }],
				    yAxis: [{
				        type: 'value',
				        axisLabel: {
				           //formatter: '{value} %'
							show:true,
							 textStyle: {
				 					color: "red",
				                    fontSize: '12',
				                },
				        },
				        axisTick: {
				            show: false,
				        },
				        axisLine: {
				            show: true,
				            lineStyle: {
				                color: "black",
				                width: 1,
				                type: "solid"
				            },
				        },
				        splitLine: {
				            lineStyle: {
				               color: "black",
				            }
				        }
				    }],
				    series: [
						{
				       
				        type: 'bar',
				        data: data[1],
				        barWidth:'35%', //柱子宽度
				       // barGap: 1, //柱子之间间距
				        itemStyle: {
				            normal: {
				                color:'red',
				                opacity: 1,
								barBorderRadius: 5,
				            }
				        }
				    }
						
					]
				};
						
						pie_fanzui.setOption(option);
		
	})	
}
