
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



function check(){
	
		if($("[name='payitem_course']").val()==""){
			
			//姓名验证
			$("#errmsg1").css("display","block");
			return false;
			
		}if($("[name='payitem_coursenum']").val()==""){
		
			//性别验证
				$("#errmsg2").css("display","block");
				return false;
		
		}if($("[name='payitem_price']").val()==""){
			
			//性别验证
				$("#errmsg3").css("display","block");
				return false;
		}
	return true;
}
function searchpage(page){
	var name=$("#coursename").val();
	var classtype=$("#classtype").val();
	var cond="&page="+page;
	
	if(name !="" ){
		cond+="&coursename="+name;	
	}
if(classtype !="" ){
	cond+="&classtype="+classtype;
		
	}

if(cond !="" ){
	cond=cond.substr(1);
	
}
if(cond !="" ){
	location.href="payItemServlet";
	
}if(cond==""){
    location.href="payItemServlet?method=query";
}else{
	location.href="payItemServlet?method=query&"+cond;
 }
}


function search(){
	
	var name=$("#coursename").val();
	var classtype=$("#classtype").val();
	
	var cond = "";
	if(name !="" ){
		cond+="&coursename="+name;	
	}
if(classtype !="" ){
	cond+="&classtype="+classtype;
		
	}

if(cond !="" ){
	cond=cond.substr(1);
	
}
if(cond !="" ){
	location.href="payItemServlet";
	
}if(cond==""){
    location.href="payItemServlet?method=query";
}else{
	location.href="payItemServlet?method=query&"+cond;
 }
}
function update(ID){
	
	location.href="payItemServlet?method=update&ID="+ID;
}

function del(ID){
	
	location.href="payItemServlet?method=del&ID="+ID;
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
function addPayItem(){

    
    
    	window.location.href='payItemServlet?method=add';
    
	
}
function goback(){
	
	history.back();
	
}

