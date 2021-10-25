function searchpage(page){
	var startTime=$("#startTime").val();
	var endTime=$("#endTime").val();
	var cond="&page="+page;
	
	if(startTime!=""){
		cond+="&startTime="+startTime;
	}
	if(endTime!=""){
		cond+="&endTime="+endTime;
	}
	
	if(cond!=""){
		cond=cond.substr(1);
	}
	if(cond==""){
	    location.href="tongJiStudent?method=shoufeiquery";
	}else{
		location.href="tongJiStudent?method=shoufeiquery&"+cond;
	}	
}

function search(){
	var startTime=$("#startTime").val();
	var endTime=$("#endTime").val();
	var cond = "";
	
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
	location.href="tongJiStudent";
	
}if(cond==""){
    location.href="tongJiStudent?method=shoufeiquery";
}else{
	location.href="tongJiStudent?method=shoufeiquery&"+cond;
 }
}
function checkRate(nubmer) {
	var re = /^\+?[1-9][0-9]*$/;
	if (!re.test(nubmer)) {
		alert("«Î ‰»Î ˝◊÷");
		return false;
	}
		return true;
		}	
function searchgo(){
	
	var page=$("#jumpNumTxt").val();
	
	if(checkRate(page)){
		searchpage(page);
	}
}