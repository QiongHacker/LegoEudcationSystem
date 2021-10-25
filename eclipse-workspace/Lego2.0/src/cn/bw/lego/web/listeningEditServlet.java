package cn.bw.lego.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bw.lego.domain.listening;
import cn.bw.lego.domain.t_student;
import cn.bw.lego.service.ListeningService;
import cn.bw.lego.service.StudentService;

public class listeningEditServlet extends HttpServlet {

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
	       
	       String classType=request.getParameter("classtype");
	      
	    
	       
	       String tele=request.getParameter("student_tele");
	       String teacher=request.getParameter("listen_teacher");
	       teacher=new String(teacher.getBytes("ISO-8859-1"), "UTF-8");
	       String state=request.getParameter("student_state");
	       
	       String visitor=request.getParameter("listen_visitor");
	       visitor=new String(visitor.getBytes("ISO-8859-1"), "UTF-8");
	       
	       String dtin=request.getParameter("listen_dtin");
	       String from =request.getParameter("listen_from");
		   listening t=new  listening();
		   t.setName(name);
		   t.setClassType(Integer.parseInt(classType));
		   t.setTeacher(teacher);
		   t.setTele(tele);
		   t.setVisitor(visitor);
		   t.setDtin(dtin);
		   t.setStudentFrom(Integer.parseInt(from));
		   t.setState(Integer.parseInt(state));
		   ListeningService ss=new  ListeningService();
		   Boolean bol=false;
	       if(id==null || id==""){
	    	   //添加
	    	  
	    	  bol=  ss.addListen(t);
	    	   
	       }else{
	    	   //修改
	    	   t.setId(Integer.parseInt(id));
	    	   bol= ss.updateListen(t);
	       }
	       
	       //name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
	      // System.out.println(name);
			if(bol!=false){
				 response.sendRedirect("/Lego2.0/listening.jsp");
	       }else{
	    	   response.sendRedirect("/Lego2.0/errorAdd.html");
	       }
	}

}
