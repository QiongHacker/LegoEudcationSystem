<%@page import="cn.bw.lego.domain.t_teacher"%>
<%@page import="cn.bw.lego.service.TeacherService"%>
<%@page import="cn.bw.lego.domain.getMoney"%>
<%@page import="cn.bw.lego.service.PayItemService"%>
<%@page import="cn.bw.lego.domain.addClass"%>
<%@page import="cn.bw.lego.service.addClassService"%>
<%@page import="cn.bw.lego.domain.t_student"%>
<%@page import="cn.bw.lego.domain.t_payitem"%>
<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
<%@page import="cn.bw.lego.service.StudentService"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>收费</title>
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
		
    <!-- BOOTSTRAP STYLES-->
    <link href="css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="css/font-awesome.css" rel="stylesheet" />
     <!--PAGE LEVELC STYLES-->
    <link href="css/invoice.css" rel="stylesheet" />
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
                        <a  href="index.html"><i class="fa fa-dashboard "></i>主页</a>
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
                                <a class="active-menu" href="#"><i class="fa fa-coffee"></i>收费</a>
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
                        <h1 class="page-head-line">收费 </h1>

                    </div>
                </div>
                <!-- /. ROW  -->
                <div class="row">
                    <div class="col-md-12">
                       <div >
   
    <br>
    
                    
      
     
      <div class="row">
                <div class="col-md-6" style="width: 1200px">
                  <!--   Kitchen Sink -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            收费信息
                        </div>
                        <div class="panel-body">
                            <div class="form-group" >
                
                <form id="submitForm" name="submitForm" action="${pageContext.request.contextPath}/getMoneyEditServlet" onSubmit="return check();" method="post"> 
                          
                                <%
                                    if(request.getAttribute("studentList")!=null){
                                    %>
                                   <%
      			//实例化
     			
      			for(getMoney u : (List <getMoney>) request.getAttribute("studentList")){
      			
      				%>
      				<input name="student_id" type="hidden" size="15" value="<%=u.getId() %>"/>
                               学生姓名： <%=u.getName() %>
                                    	
                                    
                                   
          <%} %>
   <%} %>  
                                <br>
                                <br>                        
                               班级名称： <select name="class_id"  >
                                    	
                                        <%
                            	addClassService classService = new addClassService();
                            	List<addClass> list2 = classService.getClasses();
                            	for(addClass tClass:list2){
                            %>
                           
                            
                                        <option value="<%=tClass.getId() %>"><%=tClass.getClassName() %></option>
                                        
                            <%} %> 
                                        
                                       
           </select>
           <br><br>
           状态：	<input name="state1" id="state1" type="radio" value="0" />新生 </label> 
			<input name="state1" id="state2" type="radio" value="1" />续费 </label> 
			<br><br>
           业绩归属人：<input type="text" name="teacher_id" class="required" size="15" value=""  maxlength=20 />
           <br><br>
        <label id = "errmsg2" class="errmsg" >*业绩归属人不能为空</label>  
        <label id = "errmsg4" class="errmsg" >*业绩归属人名不符合规范</label>
                        
           赠送：
            <input id="give1" type="radio" name="give"   value="1"/>课时 
	&nbsp;&nbsp;&nbsp;
	<input style="display:none" class="required" name="give_lesson_num" id="lesson" placeholder="节数" type="text"  size="10" value=""onkeyup="value=value.replace(/[^\d\.]/g,'')" maxlength="5"/>
&nbsp;&nbsp;&nbsp;
<input id="give2" type="radio" value="2" name="give"  />物品

 <input style="display:none" class="required" name="give_money" id="things" type="text" size="10" placeholder="物品价格"  value=""onkeyup="value=value.replace(/[^\d\.]/g,'')" maxlength="8"/>
		&nbsp;&nbsp;&nbsp;
		
		<input style="display:none" name="give_remarks" id="things2" type="text" size="20"  placeholder="备注" maxlength="50"  value=""/>
        	<br><br>           
                  应收金额： <input name="price" id="price" type="text" size="15" value=""onkeyup="value=value.replace(/[^\d\.]/g,'')" maxlength="8"/>
           <div>                 
     <label id = "errmsg3" class="errmsg" >*应收金额不能为空</label>
                        
                        </div><br>
          折扣： 
          <select name="rate" id="rate" onclick="key()">
                                    	
                                        <option value="1.0">不打折</option>
                                        <option value="0.9">9折</option>
                                        <option value="0.8">8折</option>
                                        <option value="0.7">7折</option>
                                        <option value="0.6">6折</option>
                                        <option value="0.5">5折</option>
                                       
           </select>
          
                        
        <br><br>
        实收金额：     <input type="text" id= "finalprice"  readonly="readonly"  name="final_price"  size="15" value="" />                  
    <br><br>
    
                              <hr />
             <button  type="submit" class="btn btn-primary btn-lg" >提交</button>
              <button  type="button" class="btn btn-primary btn-lg" onclick="goback()" >返回</button>    	
                  </form>               
                            </div>

                            <br>
                            
                            <br>
                            
                        </div>
                    </div>
                     <!-- End  Kitchen Sink -->
                </div>
                
            </div>
      
 
                    </div>
     
  </form>
 </div>
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
    <script type="text/javascript" charset="utf-8" src="js/getMoney.js"></script> 
     
    <!-- BOOTSTRAP SCRIPTS -->
    <script src="js/bootstrap.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="js/jquery.metisMenu.js"></script>
    <!-- CUSTOM SCRIPTS -->
    <script src="js/custom.js"></script>
	

</body>
</html>