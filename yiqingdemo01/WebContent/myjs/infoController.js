//定义文档加载事件
$(function(){
	//定义ajax操作
	$.get("xiaoming/hongshaorou.do",function(data){
		//设置id=allcount的html元素的文本值
		$("#allcount").text(data);
	})
})