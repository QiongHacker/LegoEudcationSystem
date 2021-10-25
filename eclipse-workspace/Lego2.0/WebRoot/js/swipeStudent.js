function searchstudent(){
	
	var startTime=$("#startTime").val();
	var endTime=$("#endTime").val();
	var name=$("#name").val();
	var cond = "";
	
	if(startTime!=""){
		cond+="&startTime="+startTime;
	}
	if(endTime!=""){
		cond+="&endTime="+endTime;
	}
	if(name!=""){
		cond+="&name="+name;
	}
if(cond !="" ){
	cond=cond.substr(1);
}
if(cond !="" ){
	location.href="tongJiStudent";
	
}if(cond==""){
    location.href="tongJiStudent?method=swipestudentquery";
}else{
	location.href="tongJiStudent?method=swipestudentquery&"+cond;
 }
}