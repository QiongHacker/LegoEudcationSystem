<%@page import="cn.bw.lego.domain.t_teacher"%>
<%@page import="cn.bw.lego.dao.TeacherDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <%
t_teacher teacher=(t_teacher)request.getAttribute("teacher");
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>教师信息管理</title>
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
	 <script type="text/javascript" src="js/laydate/laydate.js"></script> 
	<script>

//执行一个laydate实例
laydate.render({
  elem: '#dtin' //指定元素
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
                                <a href="studentInformation.jsp"></i>学生信息管理</a>
                            </li>
                            <li>
                                <a class="active-menu" href="teacherInformation.jsp"></i>教师信息管理</a>
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
                    </li>
                   
                   
                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-head-line">添加/修改教师信息</h1>
                        

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
                                <form id="submitForm" name="submitForm" action="${pageContext.request.contextPath}/TeacherEditServlet" onSubmit="return check();" method="post">
                                <input type="hidden" name="teacher_id" value="<%if (teacher!=null) out.print(teacher.getId());%>" id="fyID"/>
                                姓名 ： <input type="text"id="name" name="teacher_name" size="15"value="<%if (teacher!=null) out.print(teacher.getName());%>" onkeyup="value=value.replace(/[^\a-zA-Z\u4E00-\u9FA5]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\a-zA-Z\u4E00-\u9FA5]/g,''))" maxlength="10";/>
                                <div>
                        <label id = "errmsg1" class="errmsg" >*姓名不能为空</label>
                        <label id = "errmsg6" class="errmsg" >*输入姓名不符合规范</label>
                        </div>
                                <br>
                                
                           性别 ：     <select name="teacher_sex" id="fyXq" >
                                 		
                             
                            <option value="男" <%if (teacher!=null &&teacher.getSex().equals("男")) out.print("selected");%>>男</option>
                            <option value="女" <%if (teacher!=null &&teacher.getSex().equals("女")) out.print("selected");%>>女</option>
                      </select>          
                                        <br>
                                        <br>
                             
                               
                                
                                身份证号 : <input type="text"id="idcard" name="teacher_idcard" size="18" value="<%if (teacher!=null) out.print(teacher.getIdcard());%>" maxlength="18"/>
                               <div>
                        <label id = "errmsg2" class="errmsg" >*身份证号不能为空</label>
                        <label id = "errmsg4" class="errmsg" >*身份证号不符合规范</label>
                        </div><br>
                               入职时间： <input type="text" name="teacher_dtin"id="dtin" size="20" value="<%if (teacher!=null) out.print(teacher.getDtin());%>" placeholder="请选择日期" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,maxDate:'#F{$dp.$D(\'edate\')}'})"onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,minDate:'#F{$dp.$D(\'sdate\')}',startDate:'#F{$dp.$D(\'sdate\',{d:+1})}'})" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" maxlength="10"/>
                               <div>
                        <label id = "errmsg3" class="errmsg" >*入职时间不能为空</label>
                        <label id = "errmsg5" class="errmsg" >*输入日期不符合规范</label>
                        </div><br>
                            角色：<input type="radio" id="qianTai"  name="teacher_role" value="1" <%if(teacher!=null && teacher.getRolename()==1) out.print("checked"); %>/> 前台   
                            <input type="radio" id="keChengGuWen" name="teacher_role" value="2" <%if(teacher!=null && teacher.getRolename()==2) out.print("checked"); %>/>课程顾问   
                            <input type="radio" id="jiaoXueZhuGuan"  name="teacher_role" value="3" <%if(teacher!=null && teacher.getRolename()==3) out.print("checked"); %>/> 教学主管 
                            <input type="radio" id="guanLiYuan" name="teacher_role" value="4" <%if(teacher!=null && teacher.getRolename()==4) out.print("checked"); %>/> 管理员 


                            <br>
                            <br>
                                
                                <button type="submit" id="send"class="btn btn-success">提交</button>
                                &nbsp;&nbsp;&nbsp;
                         <a href="teacherInformation.jsp">     <button id="cancelbutton" type="button" class="btn btn-success">取消</button>  </a>        
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
	<script type="text/javascript" src="js/teacher.js"></script>
	<script type="text/javascript" src="js/check.js"></script>

</body>
</html>
