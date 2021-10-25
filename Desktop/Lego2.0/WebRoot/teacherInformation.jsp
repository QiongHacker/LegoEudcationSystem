
<%@page import="java.util.List"%>
<%@page import="cn.bw.lego.domain.pageBean"%>
<%@page import="cn.bw.lego.domain.t_teacher"%>
<%@page import="cn.bw.lego.dao.TeacherDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>教师信息管理</title>
    <script src=" js/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="js/teacher.js"></script> 
	<script>
    //设置默认值
    window.onload = function (){
       $("#name").val("${name}");
       
    }
    
    $(function(){
    	var a="${requestScope.pageBean }";
    	if(a==""){
    		search();
    	}

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
                                <a  class="active-menu" href="#"></i>教师信息管理</a>
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
                        <h1 class="page-head-line">教师信息管理</h1>
                       

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
                  
                            
                                教师姓名: <input type="text" id="xm" size="10px" value="${teachername}"onkeyup="value=value.replace(/[^\a-zA-Z\u4E00-\u9FA5]/g,'')" 
                                onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\a-zA-Z\u4E00-\u9FA5]/g,''))"
                                 maxlength="20";></input>
                                
                                
                                
                                 
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                   
                                <input type="button" class="btn btn-success" onclick="search();" value="查询"/>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="button" id="addBth" class="btn btn-success" onclick="addTeacher();" value="添加教师信息"/>
                                
                               
                               
                               
                            </div>
                            <div class="table-responsive"><table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>序号</th>
                                            <th>教师姓名</th>
                                            <th>性别</th>
                                            
                                            <th>身份证号</th>
                                            <th>入职时间</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                              
                                  <%
                                  pageBean pagebean = (pageBean)request.getAttribute("pageBean");
                                    if(request.getAttribute("teacherList")!=null){
                                    %>
                                   <%
      			//实例化
     			int a=0;
      			for(t_teacher u : (List <t_teacher>) pagebean.getData()){
      			a++;
      				%>  
                                    
                                    
                                    
                                    
                                        <tr>
                                             <td><%=a%></td>
                                             
                                            <td><%=u.getName() %></td>
                                        	<td><%=u.getSex() %></td>
                                            <td><%=u.getIdcard() %></td>
                                            <td><%=u.getDtin() %></td>
                                           <td>
                                         <a href="javascript:update(<%=u.getId()%>)" onclick="update(<%=u.getId()%>);" >        	
                                        <button type="button" class="btn btn-success">修改</button> 
                                        </a> 
                                        &nbsp; &nbsp; &nbsp;
            									
            								
            									
            									 <a  onclick="del(<%=u.getId()%>);" > 
              <button type="button" class="btn btn-success" >删除</button>
              </a>
            									
													
                                           </td>
                                        </tr>
                                                
                                            <%} %>
                                 <%} %>     

                                        
                                        
                                   
                                </table>
                            </div>
                            
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
        Copyright &copy; 2016.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
    </div>
    <!-- /. FOOTER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    
    <!-- BOOTSTRAP SCRIPTS -->
    <script src=" js/bootstrap.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src=" js/jquery.metisMenu.js"></script>
    <!-- CUSTOM SCRIPTS -->
    <script src=" js/custom.js"></script>


</body>
</html>
