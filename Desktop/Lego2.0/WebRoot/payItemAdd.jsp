<%@page import="cn.bw.lego.domain.t_payitem"%>
<%@page import="cn.bw.lego.dao.payitemDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%
t_payitem payitem=(t_payitem)request.getAttribute("payItem");
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>添加/修改收费信息</title>
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
	<script type="text/javascript" src="js/payItem.js"></script> 
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
                        <a href="#"  class="active-menu-top"><i class="fa fa-desktop "></i>基本信息管理 <span class="fa arrow"></span></a>
                         <ul class="nav nav-second-level collapse in">
                            <li>
                               <a href="studentInformation.jsp"></i>学生信息管理</a>
                            </li>
                            <li>
                                <a href="teacherInformation.jsp"></i>教师信息管理</a>
                            </li>
                             <li>
                                <a class="active-menu" href="payItem.jsp"></i>收费信息管理</a>
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
                        <h1 class="page-head-line">添加/修改收费信息</h1>
                        

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
                
                
                <form id="submitForm" name="submitForm" action="${pageContext.request.contextPath}/PayitemEditServlet" method="post" onSubmit="return check();"/>              
                <input type="hidden" name="payitem_id" value="<%if (payitem!=null) out.print(payitem.getId());%>" />                
                                课程名称 ： <input type="text" name="payitem_course" size="15" value="<%if (payitem!=null) out.print(payitem.getCourse());%>" 
                                onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/g,'')"
                                 maxlength="25";
                               
                                />
                               <div>
                        <label id = "errmsg1" class="errmsg" >*课程名称不能为空</label>
                        </div>
                                <br>
                                课程类型 ： <select name="payitem_classtype"  >
                            
                            
                                        <option value="1"<%if (payitem!=null&&payitem.getClassType().equals("1")) out.print("selected");%>>幼儿3+</option>
                                        <option value="2"<%if (payitem!=null&&payitem.getClassType().equals("2")) out.print("selected");%>>幼儿4+</option>
                                        <option value="3"<%if (payitem!=null&&payitem.getClassType().equals("3")) out.print("selected");%>>幼儿5+</option>
                                        <option value="4"<%if (payitem!=null&&payitem.getClassType().equals("4")) out.print("selected");%>>幼儿6+</option>
                                        <option value="5"<%if (payitem!=null&&payitem.getClassType().equals("5")) out.print("selected");%>>小学9--12</option>
                                        <option value="6"<%if (payitem!=null&&payitem.getClassType().equals("6")) out.print("selected");%>>小学12--16</option>
                        </select>
                                        <br>
                                        <br>
                               
                                
                                        
                                
                                     
                        课时数 : <input type="text" name="payitem_coursenum"  size="15" value="<%if (payitem!=null) out.print(payitem.getCoursenum());%>"
                        onkeyup="this.value=this.value.replace(/\D/g,'')"
						onafterpaste="this.value=this.value.replace(/\D/g,'')"
						maxlength="4";
                        />
                               <div>
                        <label id = "errmsg2" class="errmsg" >*课时数不能为空</label>
                        </div><br>
                               原价 ： <input type="text"name="payitem_price" id="price"  size="15" value="<%if (payitem!=null) out.print(payitem.getPrice());%>"
                              onkeyup="this.value=this.value.replace(/\D/g,'')"
						onafterpaste="this.value=this.value.replace(/\D/g,'')"
						maxlength="10"/>元
                            
                               
                               <div>
                        <label id = "errmsg3" class="errmsg" >*原价不能为空</label>
                        </div><br>
                           折扣 ：     
                              <select name="payitem_rate" id="rate" onclick="key()">
                                    	
                                        <option value="1.00"<%if (payitem!=null&&payitem.getRate().equals("1.00")) out.print("selected");%>>不打折</option>
                                        <option value="0.90"<%if (payitem!=null&&payitem.getRate().equals("0.90")) out.print("selected");%>>9折</option>
                                        <option value="0.80"<%if (payitem!=null&&payitem.getRate().equals("0.80")) out.print("selected");%>>8折</option>
                                        <option value="0.70"<%if (payitem!=null&&payitem.getRate().equals("0.70")) out.print("selected");%>>7折</option>
                                        <option value="0.60"<%if (payitem!=null&&payitem.getRate().equals("0.60")) out.print("selected");%>>6折</option>
                                        <option value="0.50"<%if (payitem!=null&&payitem.getRate().equals("0.50")) out.print("selected");%>>5折</option>
                                       
           </select>                
                                       
                                       
                                       
                                        <br><br>
               	最终价格： <input type="text"name="payitem_finalprice" id="finalprice"   readonly="readonly" size="15" value="<%if (payitem!=null) out.print(payitem.getFinalprice());%>">元                 
                                <br>
                                <br>
                                &nbsp;
                                <button id="submitbutton" type="submit" class="btn btn-success">提交</button>
						&nbsp;<button type="button" class="btn btn-success" onclick="goback();">取消</button>
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

