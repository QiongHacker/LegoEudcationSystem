

function check(){
	//身份证
	var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
	//日期
	var a = /^(\d{4})-(\d{2})-(\d{2})$/;
	//姓名
	var b = /^[\u4E00-\u9FA5\uf900-\ufa2d·s]{2,20}$/;
		if($("[name='teacher_name']").val()==""){
			
			//姓名验证
			$("#errmsg1").css("display","block");
			return false;
		}else{
			$("#errmsg1").css("display","none");
		}
		
		if($("[name='teacher_idcard']").val()==""){
		
			//身份证验证
			 
			$("#errmsg2").css("display","block");
			return false;
				
		}else{
			$("#errmsg2").css("display","none");
		}
		if($("[name='teacher_dtin']").val()==""){
			
			//性别验证
				$("#errmsg3").css("display","block");
				return false;
		
		}else{
			$("#errmsg3").css("display","none");
		}
		if(reg.test($("[name='teacher_idcard']").val()) === false) 
		  { 
			  $("#errmsg4").css("display","block");
				return false;
		  }else{
			  $("#errmsg4").css("display","none");
		  }   
		if(a.test($("[name='teacher_dtin']").val()) === false) 
		  { 
			  $("#errmsg5").css("display","block");
				return false;
		  }else{
			  $("#errmsg5").css("display","none");
		  }  	
		if(b.test($("[name='teacher_name']").val()) === false) 
		  { 
			  $("#errmsg6").css("display","block");
				return false;
		  }else{
			  $("#errmsg6").css("display","none");
		  } 
		if(document.getElementById("qianTai").checked || document.getElementById("keChengGuWen").checked || document.getElementById("jiaoXueZhuGuan").checked || document.getElementById("guanLiYuan").checked)
		{
			
		}else{
			alert("请选择角色");
			return false;
		}
	
		return true;
}
function searchpage(page){
	var name=$("#xm").val();
	
	
	var cond="&page="+page;
	
	if(name!=""){
		cond+="&name=" +name;
	}
	
	if(cond!=""){
		cond=cond.substr(1);
	}
	if(cond==""){
	    location.href="teacherServlet?method=query";
	}else{
		location.href="teacherServlet?method=query&"+cond;
	}	
}

function search(){
	
	var name=$("#xm").val();
	
	var cond = "";
	if(name !="" ){
		cond+="&name="+name;	
	}


if(cond !="" ){
	cond=cond.substr(1);
	
}
if(cond !="" ){
	location.href="teacherServlet";
	
}
if(cond==""){
    location.href="teacherServlet?method=query";
}else{
	location.href="teacherServlet?method=query&"+cond;
 }
}
function update(ID){
	
	location.href="teacherServlet?method=update&ID="+ID;
}

function del(ID){
	var msg = "您真的确定要删除吗？";
	if (confirm(msg)==true){
		
		location.href="teacherServlet?method=del&ID="+ID;
		return true;
	}else{
		
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
function addTeacher(){

    
    
    	window.location.href='teacherServlet?method=add';
    
	
}
