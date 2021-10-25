function register(){

    
    
    	window.location.href='registerServlet?method=register';
    
	
}
$(function(){
	
	
	
	
	
	$("#send").click(function(){
		
		if($("[name='username']").val()==""){
			
			//用户名验证
		
			$("#errmsg1").css("display","block");
			
		
			
		}if($("[name='password2']").val()==""){
			
			
			//密码验证
				$("#errmsg2").css("display","block");
			
			
			
			return;
			
		}
		$.ajax({
			type : "post",
			dataType: "text",
			url : "/Lego2.0/registerServlet",
			data :{username:$("[name='username']").val(),pwd:$("[name='password2']").val()},
			success : function(sss) {
				if(sss=="ok"){
					//验证通过
					alert("注册成功！");
					location.href="login.html";
				}if(sss=="nothing"){
					//验证通过
					alert("用户名或密码不能为空，请重试");
					return;
				}
				else{
					
					alert("用户名重复请重试！");
					return;
				}
			},
			error : function(data) {
				location.href="error.html";
			}
			
			
		});
		
		
		
		
	});
	
	
	
	
});
