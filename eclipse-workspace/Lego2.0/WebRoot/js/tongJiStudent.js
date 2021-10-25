
function searchpage(page){
	var month=$("#month").val();
	
	
	var cond="&page="+page;
	
	if(name!=""){
		cond+="&month=" +month;
	}
	
	if(cond!=""){
		cond=cond.substr(1);
	}
	if(cond==""){
	    location.href="tongJiStudent?method=query";
	}else{
		location.href="tongJiStudent?method=query&"+cond;
	}	
}

function search(){
	
	var month=$("#month").val();
	
	var cond = "";
	if(month !="" ){
		cond+="&month="+month;	
	}


if(cond !="" ){
	cond=cond.substr(1);
	
}
if(cond !="" ){
	location.href="tongJiStudent";
	
}
if(cond==""){
    location.href="tongJiStudent?method=query";
}else{
	location.href="tongJiStudent?method=query&"+cond;
 }
}
function searchgo(){
	
	var page=$("#jumpNumTxt").val();
	
	if(checkRate(page)){
		searchpage(page);
	}
}