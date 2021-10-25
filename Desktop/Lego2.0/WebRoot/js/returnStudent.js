function returnMoney(sf_id){
	var a=$("#returnMoney").val();
	var b=parseInt(a);
	
	location.href="returnMoneyServlet?&money="+a+"&sf_id="+sf_id;
}
function goback(){
	
	window.history.back();
	
}