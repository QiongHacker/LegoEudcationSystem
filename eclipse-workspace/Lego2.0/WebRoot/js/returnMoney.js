function searchpage(page){
	var name=$("#name").val();
	var student_id=$("#student_id").val();
	var class_id=$("#class_id").val();
	
	var cond="&page="+page;
	
	if(name!=""){
		cond+="&name=" +name;
	}
	if(student_id!=""){
		cond+="&student_id=" +student_id;
	}
	if(class_id!=""){
		cond+="&class_id=" +class_id;
	}
	if(cond!=""){
		cond=cond.substr(1);
	}
	if(cond==""){
	    location.href="getMoneyServlet?method=query";
	}else{
		location.href="getMoneyServlet?method=query&"+cond;
	}	
}
function search(){
	
	var name=$("#name").val();
	var student_id=$("#student_id").val();
	var class_id=$("#class_id").val();
	var cond = "";
	//��һ��page����
	
	if(name!=""){
		cond+="&name=" +name;
	}
	if(student_id!=""){
		cond+="&student_id=" +student_id;
	}
	if(class_id!=""){
		cond+="&class_id=" +class_id;
	}
	if(cond!=""){
		cond=cond.substr(1);
	}

if(cond !="" ){
	location.href="getMoneyServlet";
	
}if(cond==""){
	location.href="getMoneyServlet?method=query";
}else{
	location.href="getMoneyServlet?method=query&"+cond;
 }
}
function returnMoney(ID){
	var a=$("#returnMoney").val();
	var b=parseInt(a);
	var c=$("#sf_id").val();
	location.href="returnMoneyServlet?ID="+ID+"&money="+a+"&sf_id="+c;
}
function getStudentInform(sf_id){
	
	location.href="returnMoneyStudentInformation?sf_id="+sf_id;
	
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
function goback(){
	
	window.history.back();
	
}