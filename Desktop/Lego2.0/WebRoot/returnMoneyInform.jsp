<%@page import="cn.bw.lego.domain.returnMoney"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>退费</title>
	<script type="text/javascript" charset="utf-8" src="js/returnStudent.js"></script> 
	
    <!-- BOOTSTRAP STYLES-->
    <link href="css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="css/font-awesome.css" rel="stylesheet" />
     <!--PAGE LEVEL STYLES-->
    <link href="css/pricing.css" rel="stylesheet" />
    <!--CUSTOM BASIC STYLES-->
    <link href="css/basic.css" rel="stylesheet" />
    <!--CUSTOM MAIN STYLES-->
    <link href="css/custom.css" rel="stylesheet" />
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
               <img src="img/Logo/LEGO.jpg"   height="75px">
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
                                <a href="teacherInformation.jsp"></i>教师信息管理</a>
                            </li>
                             <li>
                                <a href="payItem.jsp"></i>收费信息管理</a>
                            </li>
                            
                             <li>
                                <a href="listening.jsp"></i>试听信息管理</a>
                            </li>
                             <li>
                                 <a href="addClass.jsp"></i>班级管理</a>
                            </li>
                             
                           
                        </ul>
                    </li>
                     <li>
                        <a class="active-menu-top" href="#"><i class="fa fa-yelp "></i>收费退费模块 <span class="fa arrow"></span></a>
                         <ul class="nav nav-second-level collapse in">
                            <li>
                                <a  href="getMoneyInformation.jsp"><i class="fa fa-coffee"></i>收费</a>
                            </li>
                            <li>
                                <a class="active-menu" href="returnMoney.jsp"><i class="fa fa-flash "></i>退费</a>
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
                        <h1 class="page-head-line">退费</h1>
                        

                    </div>
                </div>
                <!-- /. ROW  -->
                
                       



                   <div class="row text-center pad-row">
                <div class="col-md-3">
                   
                </div>
               
                
                

            </div>

			<div class="row">
                <div class="col-md-6" style="width: 1200px">
                  <!--   Kitchen Sink -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            退费学生信息
                        </div>
                        <div class="panel-body">
                            <div class="form-group" style="text-align:center;">
              
                                
                               
                                
                              
                                
                               
                               
      		
                            </div>
                            <div class="table-responsive">
                            
                                
                                   
                                        
                                            
                                           
                                        
                                       <%
        if (request.getAttribute("studentList") != null) {
    %>
    <%for (returnMoney u : (List<returnMoney>) request.getAttribute("studentList")) {%>
                                        
                                        
                                        
                                    <h4>学生姓名：	<%=u.getName() %></h4>
                                    <h4>性别：	<%=u.getSex() %></h4>	
                                    <h4>联系电话：	<%=u.getTele() %></h4>	
                                    <h4>来自学校：	<%=u.getSchool() %></h4>	
                                    <h4>出生日期：	<%=u.getBirth() %></h4>	
                                    <h4>	班级名称：	<%=u.getClassname() %></h4>
                                    <h4>	课程名称：	<%=u.getCoursename() %></h4>
                                    <h4>	课时数：	<%=u.getCoursenum() %></h4>
                                    <h4>	应收金额：	<%=u.getPrice() %></h4>
                                    <h4>	折扣：	<%=u.getRate() %></h4>
                                    <h4>	实收金额：	<%=u.getFinalprice() %></h4>
                                    <h4>	收费时间：	<%=u.getPricetime() %></h4>
                                    <h4>    赠品类型：<%=u.getGive() %> 所赠课时：<%=u.getGive_lesson_num() %> 赠品价格：<%=u.getGive_money() %>元  赠品备注：<%=u.getGive_remarks() %></h4>
                                  		
                                    
                                    
                                   
                                        <%} %>
                                      <%} %>

                                        
                                    
                                
                                 <br>
                            
                            <br>
                                请输入退费金额:      <input type="text" id="returnMoney" value="" onkeyup="value=value.replace(/[^\d\.]/g,'')" maxlength=10/> 元
                                            
                                                     	
                               	        <a href="javascript:returnMoney(<%=request.getParameter("sf_id")%>)" onclick="returnMoney(<%=request.getParameter("sf_id")%>);" > 
              <button type="button" class="btn btn-success" >退费</button>
              </a>
                               	          <button type="button" class="btn btn-success" onclick="goback()">返回上一页</button>
                            </div>
                            
                            
					
                     </div>
                    </div>
                     <!-- End  Kitchen Sink -->
                </div>
                
            </div>
	



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
    <script type="text/javascript" charset="utf-8" src="js/returnStudent.js"></script> 
    <!-- BOOTSTRAP SCRIPTS -->
    <script src="js/bootstrap.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="js/jquery.metisMenu.js"></script>
    <!-- CUSTOM SCRIPTS -->
    <script src="js/custom.js"></script>


</body>
</html>