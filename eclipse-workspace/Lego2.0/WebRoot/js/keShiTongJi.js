function search(){
	var startYear=$("#startYear").val();
	var startMonth=$("#startMonth").val();
	var endYear=$("#endYear").val();
	var endMonth=$("#endMonth").val();
	var cond = "";
	
	if(startYear!=""){
		cond+="&startYear="+startYear;
	}
	if(startMonth!=""){
		cond+="&startMonth="+startMonth;
	}
	if(endYear!=""){
		cond+="&endYear="+endYear;
		
	}
	if(endMonth!=""){
		cond+="&endMonth="+endMonth;
		
	}
if(cond !="" ){
	cond=cond.substr(1);
}
if(cond !="" ){
	location.href="tongJiStudent";
	
}if(cond==""){
    location.href="tongJiStudent?method=keshiquery";
}else{
	location.href="tongJiStudent?method=keshiquery&"+cond;
 }
}
window.onload=function(){ 
	//设置年份的选择 
	var myDate= new Date(); 
	var startYear=myDate.getFullYear()-20;//起始年份 
	var endYear=myDate.getFullYear()+20;//结束年份 
	var obj=document.getElementById('startYear') 
	for (var i=startYear;i<=endYear;i++) 
	{ 
	obj.options.add(new Option(i,i)); 
	} 
	obj.options[obj.options.length-21].selected=1; 
} 
$(function(){ 
	//设置年份的选择 
	var myDate2= new Date(); 
	var startYear2=myDate2.getFullYear()-20;//起始年份 
	var endYear2=myDate2.getFullYear()+20;//结束年份 
	var obj2=document.getElementById('endYear') 
	for (var i=startYear2;i<=endYear2;i++) 
	{ 
	obj2.options.add(new Option(i,i)); 
	} 
	obj2.options[obj2.options.length-21].selected=1; 
}) 
$(function(){
	var d=new Date();
	m = d.getMonth() + 1;
	document.getElementById("startMonth").value = m;
	document.getElementById("endMonth").value = m;	
})

	//设置年份的选择 
	
	