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
    <title>课时统计</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script>
	
	window.onload = function (){
	       $("#startYear").val("${startTime}");
	       $("#startMonth").val("${startMonth}");
	    }
	
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
                                <a href="tuiFeiTongJi.jsp" ><i class="fa fa-code "></i>退费信息统计</a>
                            </li>
                          <li>
                        <a href="#"><i class="fa fa-bicycle "></i>打卡信息统计 <span class="fa arrow"></span></a>
                         <ul class="nav nav-second-level collapse in">
                           
                             <li>
                                <a href="swipeTongJi.jsp" ><i class="fa fa-desktop "></i>教师打卡统计 </a>
                            </li>
                             <li>
                                <a href="swipeStudentTongJi.jsp" ><i class="fa fa-code "></i>学生打卡统计</a>
                            </li>
                             
                           
                        </ul>
                    </li>
                             <li>
                                <a href="keShiTongJi.jsp" class="active-menu"><i class="fa fa-code "></i>课时信息统计</a>
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
                        <h1 class="page-head-line">课时信息统计</h1>
                        

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
                                
                              
                   
                                
                               
                               时间：<select id="startYear" ></select>
                               年 <select  id="startMonth" >
　　<option value="1">1月</option>
　　<option value="2">2月</option>
　　<option value="3">3月</option>
　　<option value="4">4月</option>
　　<option value="5">5月</option>
　　<option value="6">6月</option>
　　<option value="7">7月</option>
　　<option value="8">8月</option>
　　<option value="9">9月</option>
　　<option value="10">10月</option>
　　<option value="11">11月</option>
　　<option value="12">12月</option>
    </select>
     
               &nbsp;至：   <select id="endYear"  ></select>               
                 年     <select  id="endMonth"   >
                 
               　<option value="1">1月</option>
　　<option value="2">2月</option>
　　<option value="3">3月</option>
　　<option value="4">4月</option>
　　<option value="5">5月</option>
　　<option value="6">6月</option>
　　<option value="7">7月</option>
　　<option value="8">8月</option>
　　<option value="9">9月</option>
　　<option value="10">10月</option>
　　<option value="11">11月</option>
　　<option value="12">12月</option>  
            
                 </select>
            	
            	<script tpye="text/javascript">

</script>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="button" class="btn btn-success" onclick="search()" value="查询"/>
                               
                              
                                
                               
                               
      		
                            </div>
                           
                            <div class="table-responsive">
                            <table id="studentidlist" class="table table-striped table-bordered table-hover">
                                
                                  <thead>
                                        <tr>
							</th>
							<th>序号</th>
							<th>年</th>
							<th>月</th>
							<th>月初余额</th>
							<th>本月新增</th>
							<th>本月消费课时</th>
							<th>月末结余</th>
							
							
						</tr>
						
						</thead> 
						 <%
                                    if(request.getAttribute("studentList")!=null){
                                    %>
                                   <%
      			//实例化
     			int a =0;
      			for(tongJiStudent u : (List <tongJiStudent>) request.getAttribute("studentList")){
      			a++;
      				%>
						
						
        			      <tr>
        			      	<th><%=a %></th>
        			      	<th><%=u.getYear() %></th>
        			      	<th><%=u.getMon() %></th>
        			      	<th><%=u.getAmount() %></th>
        			      	<th><%=u.getXznum() %></th>
        			      	<th><%=u.getXcnum() %></th>
        			      	<th><%=u.getByxznum() %></th>
        			      	
							
        			      	
        			      </tr> 
        			          
                                       <%} %>
                                 <%} %>                                                                                                   
        </table>
       
                            
					
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
    <script type="text/javascript" src="js/keShiTongJi.js"></script> 
    <!-- BOOTSTRAP SCRIPTS -->
    <script src="js/bootstrap.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="js/jquery.metisMenu.js"></script>
    <script src="js/custom.js"></script>
    <!-- CUSTOM SCRIPTS -->
   

</body>
</html>
