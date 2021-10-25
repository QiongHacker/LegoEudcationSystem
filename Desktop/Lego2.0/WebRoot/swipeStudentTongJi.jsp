<%@page import="cn.bw.lego.domain.tongJiStudent"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>学生打卡信息统计</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script src="js/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="js/laydate/laydate.js"></script> 
	<script>
	 window.onload = function (){
	       $("#startTime").val("${startTime}");
	       $("#endTime").val("${endTime}");
	    }
	 laydate.render({
    	  elem: '#startTime' //指定元素
    	});
    laydate.render({
    	  elem: '#endTime' //指定元素
    	});
    </script>
    <!-- BOOTSTRAP STYLES-->
    <link href=" css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href=" css/font-awesome.css" rel="stylesheet" />
    <!--CUSTOM BASIC STYLES-->
    <link href=" css/basic.css" rel="stylesheet" />
    <!--CUSTOM MAIN STYLES-->
    <link href=" css/custom.css" rel="stylesheet" />
    
    <!-- GOOGLE FONTS-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
    <div id="wrapper">
        <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <img src=" img/Logo/LEGO.jpg"  height="75px">
            </div>

            
        </nav>
        <!-- /. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                   

                    <li>
                        <a href="index.html"><i class="fa fa-dashboard "></i>主页</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-desktop "></i>基本信息管理 <span class="fa arrow"></span></a>
                         <ul class="nav nav-second-level">
                            <li>
                                <a href="studentInformation.jsp"></i>学生信息管理</a>
                            </li>
                            <li>
                                <a  href="teacherInformation.jsp"></i>教师信息管理</a>
                            </li>
                             <li>
                                 <a href="payItem.jsp"></i>收费信息管理</a>
                            </li>
                             
                              <li>
                                <a href="listening.jsp"></i>试听信息管理</a>
                            </li>
                             <li>
                                <a href="addClass.jsp" ></i>班级管理</a>
                            </li>
                             
                            
                           
                        </ul>
                    </li>
                     <li>
                        <a href="#"><i class="fa fa-yelp "></i>收费退费模块 <span class="fa arrow"></span></a>
                         <ul class="nav nav-second-level">
                            <li>
                                <a href="getMoneyInformation.jsp"><i class="fa fa-coffee"></i>收费</a>
                            </li>
                            <li>
                                <a href="returnMoney.jsp"><i class="fa fa-flash "></i>退费</a>
                            </li>
                            <li>
                                <a href="moneyOfStatistical.jsp"><i class="fa fa-flash "></i>收费统计 </a>
                            </li>
                            
                           
                        </ul>
                    </li>
                    <li>
                        <a href="swipe.jsp" ><i class="fa fa-flash "></i>打卡</a>
                        
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-bicycle "></i>统计报表 <span class="fa arrow"></span></a>
                         <ul class="nav nav-second-level collapse in">
                           
                             <li>
                                <a href="statisticalStudent.jsp" ><i class="fa fa-desktop "></i>学生信息统计 </a>
                            </li>
                             <li>
                                <a href="shouFeiTongJi.jsp" ><i class="fa fa-code "></i>缴费信息统计</a>
                            </li>
                             <li>
                                <a href="tuiFeiTongJi.jsp"><i class="fa fa-code "></i>退费信息统计</a>
                            </li>
                            <li>
                        <a href="#"><i class="fa fa-bicycle "></i>打卡信息统计 <span class="fa arrow"></span></a>
                         <ul class="nav nav-second-level collapse in">
                           
                             <li>
                                <a href="swipeTongJi.jsp" ><i class="fa fa-desktop "></i>教师打卡统计 </a>
                            </li>
                             <li>
                                <a href="swipeStudentTongJi.jsp" class="active-menu"><i class="fa fa-code "></i>学生打卡统计</a>
                            </li>
                             
                           
                        </ul>
                    </li>
                          
                              <li>
                                <a href="keShiTongJi.jsp" ><i class="fa fa-code "></i>课时信息统计</a>
                            </li>
                        </ul>
                    </li>
                     
                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-head-line">学生打卡统计</h1>
                        

                    </div>
                </div>
                <!-- /. ROW  -->
                 <div class="row">
                <div class="col-md-6" style="width: 1200px">
                  <!--   Kitchen Sink -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            基本信息
                        </div>
                        
                        <div class="panel-body">
                        
                            <div class="form-group" style="text-align:center;">
                                
                              
                 	  姓名: <input type="text" id="name" size="10px" value="${name}" onkeyup="value=value.replace(/[^\a-zA-Z\u4E00-\u9FA5]/g,'')" 
                                onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\a-zA-Z\u4E00-\u9FA5]/g,''))"
                                 maxlength="20";></input>  
                                
                               
                               打卡时间: <input type="text" id="startTime" style="height: 30px;" size="10px" value="${startTime}" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,maxDate:'#F{$dp.$D(\'edate\')}'})"onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" maxlength="10"/>
                 至：       <input type="text" id="endTime" style="height: 30px;" size="10px" value="${endTime}" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,minDate:'#F{$dp.$D(\'sdate\')}',startDate:'#F{$dp.$D(\'sdate\',{d:+1})}'})" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" maxlength="10"/>               
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="button" class="btn btn-success" onclick="searchstudent()" value="查询"/>
                               <%--<input type="button" class="btn btn-success" onclick="searchstudent()" value="按学生查询"/>
                              
                                
                               
                               
      		
                            --%></div>
                           
                            <div class="table-responsive">
                            <table id="studentidlist" class="table table-striped table-bordered table-hover">
                                
                                   
                                        <tr>
							</th>
							<th>序号</th>
							<th>学生姓名</th>
							<th>性别</th>
							<th>来自学校</th>
							<th>电话</th>
							<th>状态</th>
							<th>出生日期</th>
							<th>打卡次数</th>
							
							
						</tr>
						
						
						 <%
                                    if(request.getAttribute("studentList")!=null){
                                    %>
						 <%
      			//实例化
     			int a=0;
      			for(tongJiStudent u : (List <tongJiStudent>) request.getAttribute("studentList")){
      			a++;
      				%>
						
						
        			      <tr>
        			      	<th><%=a%></th>
        			      	<th><%=u.getName() %></th>
        			      	<th><%=u.getSex() %></th>
        			      	<th><%=u.getSchool() %></th>
        			      	<th><%=u.getTele() %></th>
        			      	<th><%=u.getState() %></th>
        			      	<th><%=u.getBirth() %></th>
        			      	
        			      	<th><%=u.getSwipenum() %></th>
        			      	
        			      	
                                 
							  <%} %>
                                 <%} %> 
        			      	
        			      </tr> 
        			      
        			    
        			                                                                                                         
        </table>
        
                            </div>
                            <br>
                            
                            <br>
                            
					
                     </div>
                    
                    </div>
                     <!-- End  Kitchen Sink -->
                </div>
                
            </div>
                  
                   <!-- /. ROW  -->
            
                    <!-- /. ROW  -->
            
                    <!-- /. ROW  -->
            
                    <!-- /. ROW  -->
            
                    <!-- /. ROW  -->
            
                    <!-- /. ROW  -->
                    
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    
    <!-- /. WRAPPER  -->
    <div id="footer-sec">
        LEGO, the LEGO logo, the Minifigure, DUPLO and MINDSTORMS are trademarks and/or copyrights of the LEGO Group. ©2017 The LEGO Group. All rights reserved. 
    </div>
    <!-- /. FOOTER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="js/jquery-1.10.2.js"></script>
    
    <script type="text/javascript" src="js/WdatePicker.js"></script> 
    
    <script type="text/javascript"charset="GBK"  src="js/swipeStudent.js"></script>  
    <!-- BOOTSTRAP SCRIPTS -->
    <script src="js/bootstrap.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="js/jquery.metisMenu.js"></script>
    <script src="js/custom.js"></script>
    <!-- CUSTOM SCRIPTS -->
   

</body>
</html>
