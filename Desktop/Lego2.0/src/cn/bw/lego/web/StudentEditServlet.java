package cn.bw.lego.web;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bw.lego.domain.t_student;
import cn.bw.lego.service.StudentService;

public class StudentEditServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
       String id=request.getParameter("student_id");
       
       String name= request.getParameter("student_name");
       name=new String(name.getBytes("ISO-8859-1"), "UTF-8");
       
       String sex=request.getParameter("student_sex");
       sex=new String(sex.getBytes("ISO-8859-1"), "UTF-8");
       
       String school=request.getParameter("student_School");
       school=new String(school.getBytes("ISO-8859-1"), "UTF-8");
       
       String tele=request.getParameter("student_tele");
       String remark=request.getParameter("student_remark");
       String state=request.getParameter("student_state");
       String birth = request.getParameter("student_birth");
       String from =request.getParameter("student_from");
	   t_student t=new  t_student();
	   t.setName(name);
	   t.setSex(sex);
	   t.setSchool(school);
	   t.setTele(tele);
	   t.setRemark(remark);
	   t.setState(state);
	   t.setBirth(birth);
	   t.setFrom(from);
	   StudentService ss=new  StudentService();
	   Boolean bol=false;
       if(id==null || id==""){
    	   //添加
    	  
    	  bol=  ss.addStudent(t);
    	   
       }else{
    	   //修改
    	   t.setId(Integer.parseInt(id));
    	   bol= ss.updateStudent(t);
       }
      
       //name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
      // System.out.println(name);
		if(bol!=false){
          response.sendRedirect("/Lego2.0/studentInformation.jsp");
       }else{
    	   response.sendRedirect("/Lego2.0/errorAdd.html");
       }
	}

}
