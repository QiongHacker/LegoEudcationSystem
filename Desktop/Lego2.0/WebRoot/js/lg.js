
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
			url : "/Lego2.0/LoginServlet",
			data :{username:$("[name='username']").val(),pwd:$("[name='password2']").val()},
			success : function(sss) {
				if(sss=="ok"){
					//验证通过
					location.href="index.html";
				}else{
					
					alert("用户名或者密码错误！请重试！");
					return;
				}
			},
			error : function(data) {
				location.href="error.html";
			}
			
			
		});
		
		
		
		
	});
	
	

	
	
});



