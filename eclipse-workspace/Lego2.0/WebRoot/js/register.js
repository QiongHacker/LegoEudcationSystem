function register(){

    
    
    	window.location.href='registerServlet?method=register';
    
	
}
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
			url : "/Lego2.0/registerServlet",
			data :{username:$("[name='username']").val(),pwd:$("[name='password2']").val()},
			success : function(sss) {
				if(sss=="ok"){
					//��֤ͨ��
					alert("ע��ɹ���");
					location.href="login.html";
				}if(sss=="nothing"){
					//��֤ͨ��
					alert("�û��������벻��Ϊ�գ�������");
					return;
				}
				else{
					
					alert("�û����ظ������ԣ�");
					return;
				}
			},
			error : function(data) {
				location.href="error.html";
			}
			
			
		});
		
		
		
		
	});
	
	
	
	
});
