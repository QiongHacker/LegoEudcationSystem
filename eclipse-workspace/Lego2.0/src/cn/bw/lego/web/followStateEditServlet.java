package cn.bw.lego.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bw.lego.domain.followState;
import cn.bw.lego.domain.listening;
import cn.bw.lego.service.ListeningService;
import cn.bw.lego.service.followStateService;

public class followStateEditServlet extends HttpServlet {

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
			String id = request.getParameter("ID");
			
	       String sid=request.getParameter("student_id");
	       
	       String date= request.getParameter("follow_date");
	       date=new String(date.getBytes("ISO-8859-1"), "UTF-8");
	       
	       
	       String follow=request.getParameter("follower");
	       follow=new String(follow.getBytes("ISO-8859-1"), "UTF-8");
	       
	       
	       String content=request.getParameter("follow_content");
	       
	       content=new String(content.getBytes("ISO-8859-1"), "UTF-8");
	       
	       
		   followState t=new  followState();
		   t.setDate(date);
		   t.setFollow(follow);
		   t.setContent(content);
		   t.setStudent_id(Integer.parseInt(sid));
		  
		   followStateService ss=new  followStateService();
		   Boolean bol=false;
	       if(id==null || id==""){
	    	   //添加
	    	  
	    	  bol=  ss.addFollowState(t);
	    	   
	       }else{
	    	   //修改
	    	   t.setId(Integer.parseInt(id));
	    	   bol= ss.updateFollowState(t);
	       }
	       
	       //name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
	      // System.out.println(name);
			if(bol){
	          response.sendRedirect("/Lego2.0/listening.jsp");
	       }else{
	    	   
	       }
	}

}
