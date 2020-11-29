//加载事件
$(function(){
	$.get("xiaoming/loadCity.do",function(data){
		//字符串拼接的变量
		var html="";
		for(var i=0;i<data.length;i++){
			html += "<option value='"+data[i]+"'>"+data[i]+"</option>";
		}
		//添加到id=proNameOne的元素的html元素变量
		$("#proNameOne").html(html);
		$("#confirmArea").html(html);
		$("#curedArea").html(html);
		$("#deadArea").html(html);
	})
})