<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style>
	.int{ height: 30px; text-align: left; width: 600px; }
     	.errmsg{
     	color:red;
     	font-size:13px;
     display:none;
     }
     .high{ color: red; }
     .msg{ font-size: 13px; }
     .onError{ color: red; }
     .onSuccess{ color: green; }

		</style>
<script type = "text/javascript" src = "js/jquery.min.js"></script>
<script type="text/javascript" charset="GBK" src="js/register.js"></script> 
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>注册</title>

    <!-- BOOTSTRAP STYLES-->
    <link href="css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="css/font-awesome.css" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
	 
</head>
<body style="background-color: #E2E2E2;">
    <div class="container">
        <div class="row text-center " style="padding-top:100px;">
            <div class="col-md-12">
                <img src="img/Logo/LEGO.jpg"  height="140px" />
            </div>
        </div>
         <div class="row ">
               
                <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
                           
                            <div class="panel-body">
                                
                                    <hr />
                                    <h5>欢迎您，请注册</h5>
                                       <br />
                                      
                                       <label id = "errmsg1" class="errmsg" >*用户名不能为空</label>
                                     <div class="form-group input-group">
                                            <span class="input-group-addon"><i class="fa fa-tag"  ></i></span>
                                            
                                          <input type="text"  class="form-control" id="username" name="username"  placeholder="请输入用户名 " />
                                        </div>
                                        <label id = "errmsg2" class="errmsg">*密码不能为空</label>
                                            <div class="form-group input-group">
                                           
                                            <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                    		 
                    		 <input type="password"  class="form-control" id="passwords" name="password2"  placeholder="请输入密码" />
                                        </div>
                                    
                                     
                                     <button type = "button" class="btn btn-primary" id = "send">注册</button>
                                  <a href="login.html"><button type = "button" class="btn btn-primary" id = "login">立即登录</button></a>
                                    <hr />
                                    
                                  
                            </div>
                           
                        </div>
                
                
        </div>
    </div>

</body>
</html>

