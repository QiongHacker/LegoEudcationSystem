package cn.bw.lego.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bw.lego.domain.addClass;
import cn.bw.lego.service.addClassService;

public class addClassEditServlet extends HttpServlet {

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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id=request.getParameter("student_id");
	       
	       String className = request.getParameter("class_name");
	       className=new String(className.getBytes("ISO-8859-1"), "UTF-8");
	       
	       String payItem = request.getParameter("class_payItem");
	       payItem=new String(payItem.getBytes("ISO-8859-1"), "UTF-8");
	       
	       String startLesson = request.getParameter("class_startLesson");
	       startLesson = new String(startLesson.getBytes("ISO-8859-1"), "UTF-8");
	       
	       String endLesson = request.getParameter("class_endLesson");
	       endLesson = new String(endLesson.getBytes("ISO-8859-1"), "UTF-8");
	       
	       String state = request.getParameter("class_state");
	       String teacher = request.getParameter("class_teacher");
	       teacher = new String(teacher.getBytes("ISO-8859-1"), "UTF-8");
	       String classNum = request.getParameter("class_num");
	       String capacity = request.getParameter("class_capacity");
	       addClass t = new addClass();
	       t.setClassName(className);
	       t.setPayItem(payItem);
	       t.setStartLesson(startLesson);
	       t.setEndLesson(endLesson);
	       t.setState(state);
	       t.setTeacher(teacher);
	       t.setCapacity(Integer.parseInt(capacity));
	       t.setClassNum(Integer.parseInt(classNum));
	       addClassService ss = new addClassService();
	       
	       Boolean bol=false;
	       if(id==null || id==""){
	    	   //添加
	    	  
	    	  bol=  ss.addClasses(t);
	    	  
	    	   
	       }else{
	    	   //修改
	    	   t.setId(Integer.parseInt(id));
	    	   bol= ss.updateClasses(t);
	    	   
	    	   
	    	   
	       }
	       if(bol!=false){
	    	   response.sendRedirect("/Lego2.0/addClass.jsp");
	        }else{
	        	response.sendRedirect("/Lego2.0/errorAdd.html");
	        }
	       
	}

}
