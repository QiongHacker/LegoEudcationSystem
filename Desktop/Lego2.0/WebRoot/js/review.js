function searchpage(page){
	var studentId=$("#xm").val();
	
	
	var cond="&page="+page;
	
	if(studentId!=""){
		cond+="&ID=" +studentId;
	}
	
	if(cond!=""){
		cond=cond.substr(1);
	}
	if(cond==""){
	    location.href="reviewServlet?method=query";
	}else{
		location.href="reviewServlet?method=query&"+cond;
	}	
}
function search(){
	
var studentId=$("#xm").val();
	
var cond = "";
	
	if(studentId!=""){
		cond+="&ID=" +studentId;
	}
	
	if(cond!=""){
		cond=cond.substr(1);
	}
	if(cond==""){
	    location.href="reviewServlet?method=query";
	}else{
		location.href="reviewServlet?method=query&"+cond;
	}	
}
function review(){
		
	var studentId=$("#xm").val();
    
    	window.location.href='reviewServlet?method=review&ID='+studentId;
    
	
}


function goback(){
	
	history.back();
	
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
	

