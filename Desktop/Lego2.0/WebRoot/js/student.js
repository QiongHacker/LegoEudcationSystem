

function check(){
	//日期
	var a = /^(\d{4})-(\d{2})-(\d{2})$/;
	//手机号码
	var b = /^1[34578]\d{9}$/;
	//姓名
	var c = /^[\u4E00-\u9FA5\uf900-\ufa2d·s]{2,20}$/;
	
		if($("[name='student_name']").val()==""){
			
			//姓名不为空
			$("#errmsg1").css("display","block");
			return false;
		}else{
			
			$("#errmsg1").css("display","none");
		}
		if($("[name='student_School']").val()==""){
			//学校不为空
			
				$("#errmsg3").css("display","block");
				return false;
		}else{
			$("#errmsg3").css("display","none");
		}
		if($("[name='student_tele']").val()==""){
			
			//手机不为空
				$("#errmsg4").css("display","block");
				return false;
		}else{
			$("#errmsg4").css("display","none");
		}
		if($("[name='student_birth']").val()==""){
			
			//日期不为空
				$("#errmsg6").css("display","block");
		
			return false;
			
		}else{
			$("#errmsg6").css("display","none");
		}
		
		
		if(c.test($("[name='student_name']").val()) === false) 
		  { 
			  $("#errmsg7").css("display","block");
				return false;
		  }	else{
			  $("#errmsg7").css("display","none");
			  
		  }	
		if(b.test($("[name='student_tele']").val()) === false) 
		  { 
			  $("#errmsg8").css("display","block");
				return false;
		  }else{
			  $("#errmsg8").css("display","none");
			  
		  }	
		if(a.test($("[name='student_birth']").val()) === false) 
		  { 
			  $("#errmsg9").css("display","block");
				return false;
		  }else{
			  $("#errmsg9").css("display","none");
		  }
		if(document.getElementById("zhifang").checked || document.getElementById("rexian").checked || document.getElementById("shichang").checked || document.getElementById("qita").checked)
		{
			
		}else{
			alert("请选择学生来源");
			return false;
		}
		
		return true;
		
}
function searchpage(page){
	var name=$("#xm").val();
	var sex=$("#sex").val();
	var state=$("#state").val();
	
	var cond="&page="+page;//��һ��page����
	
	if(name!=""){
		cond+="&name=" +name;
	}
	if(sex!=""){
		cond+="&sex=" +sex;
	}
	if(state!=""){
		cond+="&state=" +state;
	}
	if(cond!=""){
		cond=cond.substr(1);
	}
	if(cond==""){
	    location.href="studentServlet?method=query";
	}else{
		location.href="studentServlet?method=query&"+cond;
	}	
}
function search(){
	
	var name=$("#xm").val();
	var sex=$("#sex").val();
	var state=$("#state").val();
	var cond = "";
	//��һ��page����
	
	if(name !="" ){
		cond+="&name="+name;	
	}
	if(sex !="" ){
		cond+="&sex="+sex;	
	}
	if(state !="" ){
		cond+="&state="+state;	
	}
if(cond !="" ){
	cond=cond.substr(1);
	
}
if(cond !="" ){
	location.href="studentServlet";
	
}if(cond==""){
    location.href="studentServlet?method=query";
}else{
	location.href="studentServlet?method=query&"+cond;
 }
}
function update(ID){
	
	location.href="studentServlet?method=update&ID="+ID;
}

function del(ID){
	var msg = "您确定要删除吗？";
	if (confirm(msg)==true){
		
		location.href="studentServlet?method=del&ID="+ID;
		return true;
	}else{
		
	}
	
}
function review(ID){
	
	location.href="reviewServlet?method=query&ID="+ID;
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
	
function addStudent(){

    
    
    	window.location.href='studentServlet?method=add';
    
	
}
function goback(){
	
	history.back();
	
}