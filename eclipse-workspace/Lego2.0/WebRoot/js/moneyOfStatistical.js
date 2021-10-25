function searchpage(page){
	var startTime=$("#startTime").val();
	var endTime=$("#endTime").val();
	var cond="&page="+page;
	
	if(startTime!=""){
		cond+="&startTime=" +startTime;
	}
	if(endTime!=""){
		cond+="&endTime=" +endTime;
	}
	
	if(cond!=""){
		cond=cond.substr(1);
	}
	if(cond==""){
	    location.href="moneyOfStatisticalServlet?method=query";
	}else{
		location.href="moneyOfStatisticalServlet?method=query&"+cond;
	}	
}
function search(){
	
	var startTime=$("#startTime").val();
	var endTime=$("#endTime").val();
	var cond = "";
	//��һ��page����
	
	if(startTime!=""){
		cond+="&startTime=" +startTime;
	}
	if(endTime!=""){
		cond+="&endTime=" +endTime;
	}
if(cond !="" ){
	cond=cond.substr(1);
}
if(cond !="" ){
	location.href="moneyOfStatisticalServlet";
	
}if(cond==""){
    location.href="moneyOfStatisticalServlet?method=query";
}else{
	location.href="moneyOfStatisticalServlet?method=query&"+cond;
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
