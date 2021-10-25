package cn.bw.lego.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bw.lego.domain.t_student_review;
import cn.bw.lego.service.StudentReviewService;

public class ReviewEditServlet extends HttpServlet {

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
	      
	       
	       String dtin= request.getParameter("review_dtin");
	       dtin=new String(dtin.getBytes("ISO-8859-1"), "UTF-8");
	       
	     String content = request.getParameter("review_content");
	     content = new String(content.getBytes("ISO-8859-1"),"utf-8");
	      

	       
	       
	       
	       t_student_review review = new t_student_review();
	       review.setDt(dtin);
	       review.setContent(content);
	       review.setId(Integer.parseInt(id));
	       
	       StudentReviewService ss = new StudentReviewService();
	       
	    	  
	    	  ss.addReview(review);
	    	  
	       
	      
	           response.sendRedirect("/Lego2.0/studentInformation.jsp");
	        
	}

}
