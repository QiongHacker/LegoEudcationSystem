$(function(){
	
	$("#class_id").bind("change",function(){
		querystudent($(this).val());
	});
	
})

function searchpage(page){
	var classname=$("#xm").val();
	
	var startTime=$("#start").val();
	var endTime=$("#end").val();
	var cond="&page="+page;
	

	if(classname !="" ){
		cond+="&classname="+classname;	
	}
	if(startTime!=""){
		cond+="&startTime="+startTime;
	}
	if(endTime!=""){
		cond+="&endTime="+endTime;
	}
if(cond !="" ){
	cond=cond.substr(1);
	
}
if(cond !="" ){
	location.href="swipeDo";
	
}if(cond==""){
    location.href="swipeDo?method=query";
}else{
	location.href="swipeDo?method=query&"+cond;
 }
}

function searchgo(){
	
	var page=$("#jumpNumTxt").val();
	
	if(checkRate(page)){
		searchpage(page);
	}
}
function checkRate(nubmer) {
	var re = /^\+?[1-9][0-9]*$/;
	if (!re.test(nubmer)) {
		alert("请输入数字");
		return false;
	}
		return true;
		}	





function search(){
	
	var classname=$("#xm").val();
	var startTime=$("#start").val();
	var endTime=$("#end").val();
	var cond = "";
	//��һ��page����
	
	if(classname !="" ){
		cond+="&classname="+classname;	
	}
	if(startTime!=""){
		cond+="&startTime="+startTime;
	}
	if(endTime!=""){
		cond+="&endTime="+endTime;
	}
if(cond !="" ){
	cond=cond.substr(1);
	
}
if(cond !="" ){
	location.href="swipeDo";
	
}if(cond==""){
    location.href="swipeDo?method=query";
}else{
	location.href="swipeDo?method=query&"+cond;
 }
}
function del(){
	
	obj = document.getElementsByName("chk_student");
	student = [];
	for(k in obj){
				if(obj[k].checked){
			student.push(obj[k].value);
				}
	}
	
	location.href="swipeDo?method=del&sid="+student;
}
//根据教学班id查找选课学生信息
function querystudent(classid){
	
	if(classid==""|| classid=="undefined") {
		return;
	}
	
	$.ajax({ url:"/Lego2.0/swipe",
		     type:"post",
		     data:{c_id:classid},
		     dataType:'json',
		     success:function(data){
		    	 
		    	 //追加之前先把页面上以后的学生列表清空
		    	 $("#studentidlist").empty();
		    	 $("#studentidlist").append("<tr><th>选择</th><th>姓名</th><th>性别</th><th>来自学校</th><th>家长联系方式</th><th>备注</th></tr>");
		    	 //从后台拿回数据后 使用js方法添加到页面， 可能用到的方式有  Append，
		    $.each(data.person, function(i, item) {
		         $("#studentidlist").append("<tr><td><input type='checkbox' name='chk_student' value="+item.id+"></td><td>"+item.name+"</td>	<td>"+item.sex+"</td><td>"+item.school+"</td><td>"+item.tele+"</td><td>"+item.remark+"</td></tr>");
		    });
		    	
		     }
		
	})
    
}
function sid(){
	var cid = $("#class_id").val();
	obj = document.getElementsByName("chk_student");
	student = [];
	for(k in obj){
				if(obj[k].checked){
			student.push(obj[k].value);
				}
	}
	
	location.href="swipeDo?method=getS&cid="+cid+"&sid="+student;
};