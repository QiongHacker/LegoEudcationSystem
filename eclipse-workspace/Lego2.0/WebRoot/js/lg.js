
$(function(){
	
	
	
	$("#send").click(function(){
		
		if($("[name='username']").val()==""){
			
			//�û�����֤
		
			$("#errmsg1").css("display","block");
			
			
			
		}if($("[name='password2']").val()==""){
			
			
			//������֤
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
					//��֤ͨ��
					location.href="index.html";
				}else{
					
					alert("�û�������������������ԣ�");
					return;
				}
			},
			error : function(data) {
				location.href="error.html";
			}
			
			
		});
		
		
		
		
	});
	
	

	
	
});



