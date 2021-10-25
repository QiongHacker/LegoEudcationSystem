<%@page import="cn.bw.lego.utils.ExcelUtil3"%>
<%@page import="cn.bw.lego.dao.tuiFeiTongJiExcelDao"%>
<%@page import="cn.bw.lego.domain.getMoney"%>
<%@page import="cn.bw.lego.domain.pageBean"%>
<%@page import="cn.bw.lego.domain.swipe"%>
<%@page import="cn.bw.lego.service.swipeService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>退费</title>
    <script src="js/jquery-1.10.2.js"></script>
	<script type="text/javascript" charset="utf-8" src="js/returnMoney.js"></script> 
	<script>
    //设置默认值
    window.onload = function (){
       $("#name").val("${name}");
       $("#student_id").val("${student_id}");
       $("#class_id").val("${class_id}");
    }
    
    $(function(){
    	var a="${requestScope.pageBean }";
    	if(a==""){
    		search();
    	}

    });
   

    </script>
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
                        <h1 class="page-head-line">退费信息</h1>
                        

                    </div>
                </div>
                <!-- /. ROW  -->
                
                       



                   <div class="row text-center pad-row">
                <div class="col-md-3">
                   
                </div>
               
                   <%
               	swipeService cs = new swipeService();
               List<swipe> list = cs.getOpenClass();
               pageContext.setAttribute("classList",list);
               %>        
                

            </div>

			<div class="row">
                <div class="col-md-6" style="width: 1200px">
                  <!--   Kitchen Sink -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            基本信息
                        </div>
                        <div class="panel-body">
                            <div class="form-group" style="text-align:center;">
                                
                                学生编号: <input type="text" id="student_id" style="height: 30px;" size="10px" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5"/>
                                 教学班名称:<select style="height: 30px;" id="class_id" name="c_name"  >
                                  <option value="">------请选择----</option>
                                  <c:forEach var ="item" items="${pageScope.classList}">
                                   <option value="${item.id}">${item.classname}</option>
                          		 </c:forEach>
                                                               
                         </select>
                               学生姓名: <input type="text" id="name" style="height: 30px;" size="10px" onkeyup="value=value.replace(/[\W]/g,'') "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"maxlength="25"/>
                                
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="button" class="btn btn-success" onclick="search()" value="查询"/>
                                
                              
                                
                               
                               
      		
                            </div>
                            <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover">
                                
                                    <thead>
                                        <tr>
                                            <th>序号</th>
                                            <th>学生姓名</th>
                                            <th>学生编号</th>
                                            <th>班级编号</th>
                                            <th>课程名称</th>
                                            <th>应收金额</th>
                                            <th>折扣</th>
                                            <th>实收金额</th>
                                            <th>收费时间</th>
                                            <th>操作(输入退费钱数)</th>
                                        </tr>
                                    </thead>
                                    
     <%
                                    pageBean pagebean = (pageBean)request.getAttribute("pageBean");
                                    
                                    
                                    //if(request.getAttribute("studentList")!=null){
                                    	if(pagebean!=null && pagebean.getData()!=null){
                                    	
                                    %>
                                   <%
      			//实例化
     			int a =0;
      			for(getMoney u : (List <getMoney>) pagebean.getData()){
      			a++;
      				%>
                                    
                                   
                                   
      			
                                    
                                        <tr>
                                        <td><%=a%></td>
                                        <td><%=u.getName() %></td>
                                        <td><%=u.getStudent_id() %></td>
                                        <td><%=u.getClass_id() %></td>                         
                                        <td><%=u.getCourse() %></td>
                                        <td><%=u.getPrice() %></td> 
                                        <td><%=u.getRate() %></td>
                                        <td><%=u.getFinalprice() %></td>
                                        <td><%=u.getPricetime() %></td>
                                      
                                            <td> 
                                            <input type="hidden" id="student_id" value="<%=u.getId()%>"/>
                                            
                                                     	
                               	     <a href="javascript:getStudentInform(<%=u.getSf_id() %>)" onclick="getStudentInform(<%=u.getSf_id() %>);" > 
              <button type="button" class="btn btn-success" >退费</button>
              </a>
                                        
                                        
                                        
                                 
                                            </td>
                                        </tr>

                                       <%} %>
                                 <%} %>
                                       
                                        
                                    
                                </table>
                            </div>
                           
                            <br>
                            
                            <br>
                            
					
                     </div>
                    </div>
                     <!-- End  Kitchen Sink -->
                </div>
                
            </div>
		<div class="ui_tb_h30">
					<div class="ui_flt" style="height: 30px; line-height: 30px;">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						共有
						<span class="ui_txt_bold04"><% if(pagebean!=null ) out.print(pagebean.getTotalCount()); %></span>
						条记录，当前第
						<span class="ui_txt_bold04"><% if(pagebean!=null) out.print(pagebean.getCurPage()); %>
						/
						<% if(pagebean!=null) out.print(pagebean.getTotalPage()); %></span>
						页
							
						<!--    如果是第一页，则只显示下一页、尾页 -->
						
							<input type="button" value="首页" class="btn btn-success"  onclick="search()" />
							<input type="button" value="上一页" class="btn btn-success"  style="display:<%if (pagebean!=null &&pagebean.getCurPage()==1) out.print("none"); %>" 
							
							onclick="searchpage(<% if (pagebean!=null &&pagebean.getCurPage()>1) out.print(pagebean.getCurPage()-1); %>);" />
							
							<input type="button" value="下一页" class="btn btn-success"  style="display:<%if (pagebean!=null &&pagebean.getCurPage()==pagebean.getTotalPage()) out.print("none");%>"
								onclick="searchpage(<% if (pagebean!=null &&pagebean.getCurPage()<pagebean.getTotalPage()) out.print(pagebean.getCurPage()+1); %>);" />
							<input type="button" value="尾页" class="btn btn-success"
								onclick="searchpage(<% if(pagebean!=null) out.print(pagebean.getTotalPage()); %>);";/>
						
						
						
						<!--     如果是最后一页，则只显示首页、上一页 -->
						
						转到第<input type="text" id="jumpNumTxt"width="10px;" class="ui_input_txt01" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5"/>页
							 <input type="button" class="btn btn-success" value="跳转" onclick="searchgo();" />
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
    
    <!-- BOOTSTRAP SCRIPTS -->
    <script src="js/bootstrap.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="js/jquery.metisMenu.js"></script>
    <!-- CUSTOM SCRIPTS -->
    <script src="js/custom.js"></script>


</body>
</html>
