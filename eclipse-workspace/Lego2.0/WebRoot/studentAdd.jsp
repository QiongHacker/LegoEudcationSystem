<%@page import="cn.bw.lego.domain.t_student"%>
<%@page import="cn.bw.lego.dao.StudentDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%
t_student student=(t_student)request.getAttribute("student");
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>添加/修改学生信息</title>
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
	<script type="text/javascript" charset="utf-8" src="js/student.js"></script>
	<script type="text/javascript" src="js/laydate/laydate.js"></script> 
	<script>
lay('#version').html('-v'+ laydate.v);

//执行一个laydate实例
laydate.render({
  elem: '#birth' //指定元素
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
                               <a class="active-menu" href="studentInformation.jsp"></i>学生信息管理</a>
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
                        <h1 class="page-head-line">添加/修改学生信息</h1>
                        

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
                
                
                <form id="submitForm" name="submitForm" action="${pageContext.request.contextPath}/StudentEditServlet" method="post" onSubmit="return check();"/>              
                <input type="hidden" name="student_id" value="<%if (student!=null) out.print(student.getId());%>" id="fyID"/>                
                                姓名 ： <input type="text" name="student_name" class="required" size="15" value="<%if (student!=null) out.print(student.getName());%>" onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/g,'')" onpaste="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/g,'')" oncontextmenu = "value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/g,'')" maxlength=20 />
                        <div>
                        <label id = "errmsg1" class="errmsg" >*姓名不能为空</label>
                        <label id = "errmsg7" class="errmsg" >*姓名不符合规范</label>
                        </div>      
                               
                          <br>        
                                性别 ： <select name="student_sex" id="fyXq" >
                           
                            <option value="男" <%if (student!=null &&student.getSex().equals("男")) out.print("selected");%>>男</option>
                            <option value="女" <%if (student!=null &&student.getSex().equals("女")) out.print("selected");%>>女</option>
                        </select>
                        
                                        <br>
                                        <br>  
                               
                                
                                        
                                
                                     
                                来自学校 : <input type="text" name="student_School"  size="15" value="<%if (student!=null) out.print(student.getSchool());%>" onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/g,'')" onpaste="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/g,'')" oncontextmenu = "value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/g,'')"  maxlength="20"/>
              <div>
               <label id = "errmsg3" class="errmsg" >*学校不能为空</label>
              
               </div>                
                              
                               <br>
                               家长联系方式 ： <input type="text"name="student_tele"  size="15" value="<%if (student!=null) out.print(student.getTele());%>"
                               onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,minDate:'#F{$dp.$D(\'sdate\')}',startDate:'#F{$dp.$D(\'sdate\',{d:+1})}'})" 
                               onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"  maxlength="11"/>
                      <div>
                       <label id = "errmsg4" class="errmsg" >*联系方式不能为空</label>
						<label id = "errmsg8" class="errmsg" >*联系方式不符合规范</label>        
                        </div>      
                               <br>
                               学生状态 ： <select name="student_state" >
                                    	
                                        <option value="1"<%if (student!=null&&student.getState().equals("1")) out.print("selected");%>>在读</option>
                                        <option value="2"<%if (student!=null&&student.getState().equals("2")) out.print("selected");%>>停课</option>
                                        <option value="3"<%if (student!=null&&student.getState().equals("3")) out.print("selected");%>>结课</option>
                                        
                                        </select>
                                        
                                        <br><br>
                 出生日期：        <input type="text"name="student_birth" id="birth"  size="15" placeholder="请选择日期" value="<%if (student!=null) out.print(student.getBirth());%>"
                  maxlength="10"/>                
                	<div>
                	<label id = "errmsg6" class="errmsg" >*出生日期不能为空</label>
                	<label id = "errmsg9" class="errmsg" >*出生日期不符合规范</label>
                	</div>	
                	<br>
                	 学生来源：        <label>
                           <input type="radio"name="student_from" id="zhifang" size="15" value="1" <%if (student!=null&&student.getFrom().equals("1")) out.print("checked");%> /> 
                           	直访
                           </label> 
                           &nbsp;&nbsp;&nbsp;   
                         <label>
                           <input type="radio"name="student_from"  id="rexian" size="15" value="2" <%if (student!=null&&student.getFrom().equals("2")) out.print("checked");%>/> 
                           	热线
                           </label>
                           &nbsp;&nbsp;&nbsp;
                            <label>
                           <input type="radio"name="student_from" id="shichang" size="15" value="3" <%if (student!=null&&student.getFrom().equals("3")) out.print("checked");%>/> 
                           	市场
                           </label> 
                           &nbsp;&nbsp;&nbsp;
                           <label>
                           <input type="radio"name="student_from" id="qita"  size="15" value="4" <%if (student!=null&&student.getFrom().equals("4")) out.print("checked");%>/> 
                           	其他
                           </label> 

                <br><br>                
                                备注 ：
                                <br>    
                                <textarea name="student_remark" id="tremark" style="width:300px; height:100px;" value="<%if (student!=null) out.print(student.getRemark());%>"></textarea> 
                                <br><br>
                                &nbsp;<button id="send" type="submit" class="btn btn-success">提交</button>
						&nbsp;<button id="cancelbutton" type="button" class="btn btn-success" onclick="goback();">取消</button>
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

