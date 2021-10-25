function searchpage(page){
	var name=$("#xm").val();
	var classType=$("#classtype").val();
	var teacher=$("#teacher").val();
	var cond="&page="+page;
	if(name !="" ){
		cond+="&name="+name;	
	}
	if(classType !="" ){
		cond+="&classtype="+classType;	
	}
	if(teacher !="" ){
		cond+="&teacher="+teacher;	
	}
if(cond !="" ){
	cond=cond.substr(1);
	
}
if(cond !="" ){
	location.href="listeningServlet";
	
}if(cond==""){
    location.href="listeningServlet?method=query";
}else{
	location.href="listeningServlet?method=query&"+cond;
 }
}


function search(){
	
	var name=$("#xm").val();
	var classType=$("#classtype").val();
	var teacher=$("#teacher").val();
	var cond = "";
	if(name !="" ){
		cond+="&name="+name;	
	}
	if(classType !="" ){
		cond+="&classtype="+classType;	
	}
	if(teacher !="" ){
		cond+="&teacher="+teacher;	
	}
if(cond !="" ){
	cond=cond.substr(1);
	
}
if(cond !="" ){
	location.href="listeningServlet";
	
}if(cond==""){
    location.href="listeningServlet?method=query";
}else{
	location.href="listeningServlet?method=query&"+cond;
 }
}
function update(ID){
	
	location.href="listeningServlet?method=update&ID="+ID;
}

function del(ID){
	
	location.href="listeningServlet?method=del&ID="+ID;
}
function review(ID){
	
	location.href="listeningServlet?method=update&ID="+ID;
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
			
function addListen(){

    
    
    	window.location.href='listeningServlet?method=add';
    
	
}
function followState(ID){

    
    
	window.location.href='followStateServlet?method=select&ID='+ID;


}

function goback(){
	
	window.history.back();
	
}
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
		
		
		if($("[name='listen_teacher']").val()==""){
			//教师不为空
			
				$("#errmsg2").css("display","block");
				return false;
		}else{
			$("#errmsg2").css("display","none");
		}
		
		
		if($("[name='student_tele']").val()==""){
			
			//手机不为空
				$("#errmsg4").css("display","block");
				return false;
		}else{
			$("#errmsg4").css("display","none");
		}
		
		
		if($("[name='listen_visitor']").val()==""){
			
			//课程顾问不为空
				$("#errmsg5").css("display","block");
		
			return false;
			
		}else{
			$("#errmsg5").css("display","none");
		}
		
		if($("[name='listen_dtin']").val()==""){
			
			//日期不为空
				$("#errmsg9").css("display","block");
		
			return false;
			
		}else{
			$("#errmsg9").css("display","none");
		}
		
		
		
		
		
		if(c.test($("[name='student_name']").val()) === false) 
		  { 
			//验证学生姓名是否合法
			  $("#errmsg7").css("display","block");
				return false;
		  }	else{
			  $("#errmsg7").css("display","none");
			  
		  }	
		if(c.test($("[name='listen_teacher']").val()) === false) 
		  { 
			//验证教师姓名是否合法
			  $("#errmsg3").css("display","block");
				return false;
		  }else{
			  $("#errmsg3").css("display","none");
			  
		  }	
		
		if(b.test($("[name='student_tele']").val()) === false) 
		  { 
			//联系方式验证
			  $("#errmsg8").css("display","block");
				return false;
		  }else{
			  $("#errmsg8").css("display","none");
			  
		  }	
		
		if(c.test($("[name='listen_visitor']").val()) === false) 
		  { 
			//课程顾问姓名是否合法
			  $("#errmsg6").css("display","block");
				return false;
		  }else{
			  $("#errmsg6").css("display","none");
			  
		  }	
		if(a.test($("[name='listen_dtin']").val()) === false) 
		  { 
			
			//试听时间是否合法
			  $("#errmsg10").css("display","block");
				return false;
		  }else{
			  $("#errmsg10").css("display","none");
			  
		  }	

			if(document.getElementById("zhifang").checked || document.getElementById("rexian").checked || document.getElementById("shichang").checked || document.getElementById("qita").checked)
			{
				
			}else{
				alert("请选择学生来源");
				return false;
			}
		
			return true;
			
				
}