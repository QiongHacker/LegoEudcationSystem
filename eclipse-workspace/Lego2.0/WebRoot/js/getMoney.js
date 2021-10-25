
$(document).ready(function(){
	
  $("#price").keyup(function(){
	  var a =$('#rate option:selected').val();
		
		var b =$('#price').val();
		var c =parseInt(a*b);
    document.getElementById('finalprice').value=c;
    
  })
  
  
})

function key(){
	var a =$('#rate option:selected').val();
	
	var b =$('#price').val();
	var c =parseInt(a*b);
	
document.getElementById('finalprice').value=c;
	
		
	
	
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
	    location.href="studentServlet?method=query2";
	}else{
		location.href="studentServlet?method=query2&"+cond;
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
    location.href="studentServlet?method=query2";
}else{
	location.href="studentServlet?method=query2&"+cond;
 }
}

function searchgo(){
	
	var page=$("#jumpNumTxt").val();
	
	if(checkRate(page)){
		searchpage(page);
	}
}
function getMoney(ID){
	
	location.href="getMoneyServlet?method=query2&ID="+ID;
}
function goback(){
	
	history.back();
	
}
$(function giveLesson(){

	 $("#give1").click(function(){
		 $("#things").val("");
		 $("#things2").val("");
		  $("#lesson").show();
		  $("#things").hide();
		  $("#things2").hide();
		  });
	 $("#give2").click(function(){
		 $("#lesson").val("");
		  $("#lesson").hide();
		  $("#things").show();
		  $("#things2").show();
		  });
	
	

});
function check(){
	
	
	var c = /^[\u4E00-\u9FA5\uf900-\ufa2d·s]{2,20}$/;

	if($("[name='teacher_id']").val()==""){
		
		$("#errmsg2").css("display","block");
		return false;
	}else{
		$("#errmsg2").css("display","none");
	}
	
	//业绩归属人名不规范
	if(c.test($("[name='teacher_id']").val()) === false) 
	  { 
		  $("#errmsg4").css("display","block");
			return false;
	  }	else{
		  $("#errmsg4").css("display","none");
		  
	  }	
	//价格不能为空
	if($("[name='price']").val()==""){
		
		$("#errmsg3").css("display","block");
		return false;
	}else{
		$("#errmsg3").css("display","none");
	}
	
	//赠品类型不能为空

	 if(document.getElementById("give1").checked || document.getElementById("give2").checked )
		{
			
		}else{
			alert("请选择赠品类型");
			return false;
		}
	 if(document.getElementById("give1").checked && $("[name='give_lesson_num']").val()!="" || document.getElementById("give2").checked && $("[name='give_money']").val()!=""  )
		{
			
		}else{
			alert("课时数/赠品价格不能为空，请输入");
			return false;
		}
	
	 
	 
	 
	 //状态不能为空
	 if(document.getElementById("state1").checked || document.getElementById("state2").checked )
		{
			
		}else{
			alert("请选择状态类型");
			return false;
		}
}