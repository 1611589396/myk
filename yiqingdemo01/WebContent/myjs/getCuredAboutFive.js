//加载事件
$(function(){
	
	test2("湖北");
	
})

function selectAreaByCured(){
	
	var name=$("#curedArea").val();
	test2(name);
	
}

function test2(pname){
	
	$.get("xiaoming/getCuredAboutFive.do",{name:pname},function(data){
		
		var pie_fanzui =echarts.init(document.getElementById("curedCount"),'infographic'); 
	       option = {
	         
	         tooltip: {
			        trigger: 'axis',
			        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
			            type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
	           grid: {
	                     left:40,
	                     right:20,
	                     top:30,
	                     bottom:0,
	                     containLabel: true
	                   },

	                 xAxis: {
	                     type: 'value',
	                     axisLine:{
	                      lineStyle:{
	                        color:'rgba(255,255,255,0)'
	                      }
	                    },
	                    splitLine:{
	                      lineStyle:{
	                        color:'rgba(255,255,255,0)'
	                      }
	                    },
	                    axisLabel:{
	                        color:"rgba(255,255,255,0)"
	                    },
	                     boundaryGap: [0, 0.01]
	                 },
	                 yAxis: {
	                     type: 'category',
	                     axisLine:{
	                      lineStyle:{
	                        color:'rgba(255,255,255,5)'
	                      }
	                    },
	                    splitLine:{
	                      lineStyle:{
	                        color:'rgba(255,255,255,1)'
	                      }
	                    },
	                    axisLabel:{
	                        color:"red"
	                    },
	                     data: data[0],
	                 },
	                 series: [
	                     {
	                         name: 'number: ',
	                         type: 'bar',
	                         barWidth :20,
	                         itemStyle: {
	                             normal: {
	                                 color:'blue',
	                                 opacity: 1,
	                 				barBorderRadius: 5,
	                             }
	                         },
	                         data:data[1],
	                     }
	                 ]
	             };
	      
		pie_fanzui.setOption(option);
	})
}