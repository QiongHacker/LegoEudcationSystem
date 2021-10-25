package cn.bw.lego.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bw.lego.domain.t_student;
import cn.bw.lego.domain.t_teacher;
import cn.bw.lego.service.StudentService;
import cn.bw.lego.service.TeacherService;

public class TeacherEditServlet extends HttpServlet {

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
		
	       String id=request.getParameter("teacher_id");
	       
	       String name= request.getParameter("teacher_name");
	       name=new String(name.getBytes("ISO-8859-1"), "UTF-8");
	       
	       String idcard=request.getParameter("teacher_idcard");
	       idcard=new String(idcard.getBytes("ISO-8859-1"), "UTF-8");
	       String dtin=request.getParameter("teacher_dtin");

	       
	       String sex=request.getParameter("teacher_sex");
	       sex=new String(sex.getBytes("ISO-8859-1"), "UTF-8");
	       String role=request.getParameter("teacher_role");
		   t_teacher t=new  t_teacher();
		   t.setName(name);
		   t.setIdcard(idcard);
		   t.setDtin(dtin);
		   t.setSex(sex);
		   t.setRolename(Integer.parseInt(role));
		   
		   TeacherService ss=new  TeacherService();
		   Boolean bol=false;
	       if(id==null || id==""){
	    	   //添加
	    	  
	    	  bol=  ss.addTeacher(t);
	    	   
	       }else{
	    	   //修改
	    	   t.setId(Integer.parseInt(id));
	    	   bol= ss.updateTeacher(t);
	       }
	       
	       //name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
	      // System.out.println(name);
			if(bol!=false){
				 response.sendRedirect("/Lego2.0/teacherInformation.jsp");
	       }else{
	    	   response.sendRedirect("/Lego2.0/errorAdd.html");
	       }
	}

}
