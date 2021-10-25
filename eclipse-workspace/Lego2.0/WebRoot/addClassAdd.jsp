<%@page import="cn.bw.lego.domain.t_payitem"%>
<%@page import="cn.bw.lego.service.addClassService"%>
<%@page import="cn.bw.lego.domain.addClass"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
addClass student=(addClass)request.getAttribute("addclass");
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>添加/修改班级信息</title>
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
<script type="text/javascript" src="js/laydate/laydate.js"></script> 
<script type="text/javascript" src="js/addClass.js"></script>
	<script>

//执行一个laydate实例
laydate.render({
  elem: '#start' //指定元素
});
</script> 
<script>

//执行一个laydate实例
laydate.render({
  elem: '#end' //指定元素
});
</script> 
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
                                <a href="listening.jsp"class="active-menu-top"></i>试听信息管理</a>
                            </li>
                             <li>
                                <a href="addClass.jsp" class="active-menu" ></i>班级管理</a>
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
                        <h1 class="page-head-line">添加/修改班级信息</h1>
                        

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
                
                <form id="submitForm" name="submitForm" action="${pageContext.request.contextPath}/addClassEditServlet" method="post" onSubmit="return check();"> 
                 <input type="hidden" name="student_id" value="<%if (student!=null) out.print(student.getId());%>" id="fyID"/>            
                                
                               班级名称 ： <input type="text" name="class_name" size="15" value="<%if (student!=null) out.print(student.getClassName());%>"onkeyup="value=value.replace(/[^\a-zA-Z\u4E00-\u9FA5]/g,'')" 
                                onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\a-zA-Z\u4E00-\u9FA5]/g,''))"
                                 maxlength="20" />
                                 <div>
                        <label id = "errmsg1" class="errmsg" >*班级名称不能为空</label>
                        
                        </div> 
                                <br>
                                
                                      
                               
                                
                                        
                                
                                     
                        收费项目： <select name="class_payItem" id="class_id">
                        
                        <%
                            	addClassService classService = new addClassService();
                            	List<t_payitem> list = classService.getItemById();
                            	for(t_payitem tPayitem:list){
                            %>
                           
                            
                                        <option value="<%=tPayitem.getId() %>"><%=tPayitem.getCourse() %></option>
                                        
                            <%} %>            
                        </select>
                               <br><br>
                               开课时间： <input type="text"name="class_startLesson" id="start" placeholder="请选择日期" maxlength="10" size="15" value="<%if (student!=null) out.print(student.getStartLesson());%>"maxlength=10/>
                               <div>                 
     <label id = "errmsg3" class="errmsg" >*开课时间不能为空</label>
                        <label id = "errmsg4" class="errmsg" >*时间不符合规范</label>
                        </div> <br>
                  结课时间： <input type="text"name="class_endLesson" id="end" size="15" placeholder="请选择日期" maxlength="10" value="<%if (student!=null) out.print(student.getEndLesson());%>"maxlength=10/>            
                   <div>                 
     <label id = "errmsg5" class="errmsg" >*结课时间不能为空</label>
                        <label id = "errmsg6" class="errmsg" >*时间不符合规范</label>
                        </div> <br>
          课程状态： 
          <select name="class_state" >
                                    	
                                        <option value="1"<%if (student!=null&&student.getState()=="开课中") out.print("selected");%>>开课中</option>
                                        <option value="2"<%if (student!=null&&student.getState()=="暂停中") out.print("selected");%>>暂停中</option>
                                        <option value="3"<%if (student!=null&&student.getState()=="已结束") out.print("selected");%>>已结束</option>
                                        
                               </select>
          
                        
        <br><br>
        教师名称：     <input type="text"name="class_teacher"  size="15" value="<%if (student!=null) out.print(student.getTeacher());%>"onkeyup="value=value.replace(/[^\a-zA-Z\u4E00-\u9FA5]/g,'')" 
                                onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\a-zA-Z\u4E00-\u9FA5]/g,''))"
                                 maxlength="20"/>
                                 <div>                 
     <label id = "errmsg7" class="errmsg" >*指导老师不能为空</label>
                        <label id = "errmsg8" class="errmsg" >*姓名不符合规范</label>
                        </div> 
                        <br>
                        <div id="num">
     课时数：        <input type="text"name="class_num"   size="15" value="<%if (student!=null) out.print(student.getClassNum());%>"onkeyup="this.value=this.value.replace(/\D/g,'')"
onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="3"/>
</div>
<div>                 
     <label id = "errmsg9" class="errmsg" >*课时数不能为空</label>
                      
                        </div>      
<br>
     班级容量：        <input type="text"name="class_capacity" id="class_capacity" size="15" value="<%if (student!=null) out.print(student.getCapacity());%>"onkeyup="this.value=this.value.replace(/\D/g,'')"
onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="3"/>
             		 <div>                 
     <label id = "errmsg10" class="errmsg" >*班级容量不能为空</label>
                      
                        </div>      <br>
                                &nbsp;<button id="submitbutton" type="submit" class="btn btn-success">提交</button>
					
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-success" onclick="goback();">取消</button>
                  	
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