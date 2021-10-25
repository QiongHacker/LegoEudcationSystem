function searchpage(page){
	var name=$("#xm").val();
	var teacher=$("#teacher").val();
	var state=$("#state").val();
	
	var cond="&page="+page;
	
	if(name!=""){
		cond+="&classname=" +name;
	}
	if(teacher!=""){
		cond+="&teacher=" +teacher;
	}
	if(state!=""){
		cond+="&state=" +state;
	}
	if(cond!=""){
		cond=cond.substr(1);
	}
	if(cond==""){
	    location.href="addClassServlet?method=query";
	}else{
		location.href="addClassServlet?method=query&"+cond;
	}	
}
function search(){
	
	var name=$("#xm").val();
	var teacher=$("#teacher").val();
	var state=$("#state").val();
	var cond = "";
	//��һ��page����
	
	if(name!=""){
		cond+="&classname=" +name;
	}
	if(teacher!=""){
		cond+="&teacher=" +teacher;
	}
	if(state!=""){
		cond+="&state=" +state;
	}
	if(cond!=""){
		cond=cond.substr(1);
	}

if(cond !="" ){
	location.href="addClassServlet";
	
}if(cond==""){
	location.href="addClassServlet?method=query";
}else{
	location.href="addClassServlet?method=query&"+cond;
 }
}
function update(ID){
	
	location.href="addClassServlet?method=update&ID="+ID;
}
$(function(){
	
	$("#class_id").bind("change",function(){
		querystudent($(this).val());
	});
	
})

function querystudent(classid){
	
	if(classid==""|| classid=="undefined") {
		return;
	}
	
	$.ajax({ url:"/Lego2.0/swipeTongJi",
		     type:"post",
		     data:{c_id:classid},
		     dataType:'json',
		     success:function(data){
		    	 
		    	 //追加之前先把页面上以后的学生列表清空
		    	 $("#num").empty();
		    	
		    	 //从后台拿回数据后 使用js方法添加到页面， 可能用到的方式有  Append，
		    $.each(data.person, function(i, item) {
		         $("#num").append("课时数：<input type='text' size='15'onkeyup='this.value=this.value.replace(/\D/g,'')'onafterpaste='this.value=this.value.replace(/\D/g,'')' maxlength='3' name='class_num' value="+item.coursenum+">");
		    });
		    	
		     }
		
	})
    
}

//��ҳ


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
	
function addClass(){

    
    
    	window.location.href='addClassServlet?method=add';
    
	
}
function goback(){
	
	history.back();
	
}
function check(){
	//日期
	var a = /^(\d{4})-(\d{2})-(\d{2})$/;

	//姓名
	var c = /^[\u4E00-\u9FA5\uf900-\ufa2d·s]{2,20}$/;
	
		if($("[name='class_name']").val()==""){
			
			//班级不为空
			$("#errmsg1").css("display","block");
			return false;
		}else{
			
			$("#errmsg1").css("display","none");
		}
		
		
		if($("[name='listen_teacher']").val()==""){
			//教师不为空
			
				$("#errmsg2").css("display","block");
				return false;
		}else{
			$("#errmsg2").css("display","none");
		}
		
		
		if($("[name='class_startLesson']").val()==""){
			
			//开课时间不为空
				$("#errmsg3").css("display","block");
				return false;
		}else{
			$("#errmsg3").css("display","none");
		}
		
		
		if($("[name='class_endLesson']").val()==""){
			
			//结课时间不为空
				$("#errmsg5").css("display","block");
		
			return false;
			
		}else{
			$("#errmsg5").css("display","none");
		}
		if($("[name='class_teacher']").val()==""){
			
			//教师不为空
				$("#errmsg7").css("display","block");

			return false;
			
		}else{
			$("#errmsg7").css("display","none");
		}		
if($("[name='class_num']").val()==""){
			
			//课时数不为空
				$("#errmsg9").css("display","block");
		
			return false;
			
		}else{
			$("#errmsg9").css("display","none");
		}
if($("[name='class_capacity']").val()==""){
	
	
		$("#errmsg10").css("display","block");

	return false;
	
}else{
	$("#errmsg10").css("display","none");
}	
		
	
		if(c.test($("[name='class_teacher']").val()) === false) 
		  { 
			//验证教师姓名是否合法
			  $("#errmsg8").css("display","block");
				return false;
		  }else{
			  $("#errmsg8").css("display","none");
			  
		  }	
		
	
		
		
		if(a.test($("[name='class_startLesson']").val()) === false) 
		  { 
			
			//试听时间是否合法
			  $("#errmsg4").css("display","block");
				return false;
		  }else{
			  $("#errmsg4").css("display","none");
			  
		  }	
		if(a.test($("[name='class_endLesson']").val()) === false) 
		  { 
			
			//试听时间是否合法
			  $("#errmsg6").css("display","block");
				return false;
		  }else{
			  $("#errmsg6").css("display","none");
			  
		  }	
		
		return true;
	
				
}