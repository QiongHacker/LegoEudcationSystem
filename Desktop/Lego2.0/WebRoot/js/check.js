$(function(){
		
	$("form :input.required").each(function(){				//动态地添加页面元素
		
		var	$aaa = $("<strong class = 'high'>*</strong>");  //将html字符串转换成jquery对象
		$(this).parent().append($aaa);



		});
			
		
		})