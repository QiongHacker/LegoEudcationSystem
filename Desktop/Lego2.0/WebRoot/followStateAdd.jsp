<%@page import="cn.bw.lego.domain.followState"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
followState student=(followState)request.getAttribute("follow");
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>添加/修改跟进状态</title>
<script type = "text/javascript" src = "js/jquery.min.js"></script>
	<script type="text/javascript" src="js/followState.js"></script> 
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
                <img src=" img/Logo/LEGO.jpg"   height="75px">
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
                        <a href="studentInformation.jsp"  ><i class="fa fa-desktop "></i>基本信息管理 <span class="fa arrow"></span></a>
                         <ul class="nav nav-second-level collapse in">
                            <li>
                               <a href="studentInformation.jsp"></i>学生信息管理</a>
                            </li>
                            <li>
                                <a href="teacherInformation.jsp"></i>教师信息管理</a>
                            </li>
                             <li>
                                <a  href="payItem.jsp"></i>收费信息管理</a>
                            </li>
                             
                             <li>
                                <a href="listening.jsp"class="active-menu" class="active-menu-top"></i>试听信息管理</a>
                            </li>
                             <li>
                                <a href="addClass.jsp"></i>班级管理</a>
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
                        <a href="swipe.jsp"><i class="fa fa-flash "></i>打卡 </a>
                        
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-bicycle "></i>统计报表 <span class="fa arrow"></span></a>
                         <ul class="nav nav-second-level">
                           
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
                        <h1 class="page-head-line">添加/修改跟进状态</h1>
                        

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
                            <div class="form-group" >
                
                <form id="submitForm" name="submitForm" action="${pageContext.request.contextPath}/followStateEditServlet" method="post"> 
                            
                                
                               跟进日期 ： <input type="text" name="follow_date" size="15" value="<%if (student!=null) out.print(student.getDate());%>" >
                                <br>
                                <br>
                                
                                      
                               
                          学生ID ： <input type="text" name="student_id" size="15" value="<%=request.getParameter("ID") %><%if (student!=null) out.print(student.getStudent_id());%>" >
                                <br>
                                <br>     
                                        
           	                    
                                     
                        跟进人： <input type="text" name="follower"  size="15" value="<%if (student!=null) out.print(student.getFollow());%>"/>
                               <br><br>
                               跟进内容： <input type="text"name="follow_content"  size="15" value="<%if (student!=null) out.print(student.getContent());%>"/>
                               <br><br>
                             
                  
                        
                               
             
             		
                                &nbsp;<button id="submitbutton" type="submit" class="btn btn-success">提交</button>
					
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button id="cancelbutton" type="button" class="btn btn-success" onclick="goback()">返回上一页</button>
                  	
                  </form>               
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
    <script src=" js/jquery-1.10.2.js"></script>
    <!-- BOOTSTRAP SCRIPTS -->
    <script src=" js/bootstrap.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src=" js/jquery.metisMenu.js"></script>
    <!-- CUSTOM SCRIPTS -->
    <script src=" js/custom.js"></script>


</body>
</html>