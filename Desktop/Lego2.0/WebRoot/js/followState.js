function update(ID){
	
	location.href="followStateServlet?method=update&ID="+ID;
}
function goback(){
	
	history.back();
	
}
function addFollowState(ID){

    
    
	window.location.href='followStateServlet?method=add&ID='+ID;


}