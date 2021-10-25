package cn.bw.lego.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bw.lego.domain.followState;
import cn.bw.lego.domain.listening;
import cn.bw.lego.service.followStateService;

public class followStateServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		followStateService follow = new followStateService();
		
		
		if (request.getParameter("method").equals("select")) {
			 // 获取你要修改的学生id
			  String id=request.getParameter("ID");
			  
			  List<followState> list = follow.getfollowStatesById(Integer.parseInt(id));
			  
			  request.setAttribute("followstate", list);
			  
			  request.getRequestDispatcher("/followStateInformation.jsp").forward(request,response);
			  
			  
		}else if(request.getParameter("method").equals("update")){
			
		 // 获取你要修改的学生id
		  String id=request.getParameter("ID");
		  //调用业务类 查询这个学生的试听信息，
		  followState t = follow.getFollows(Integer.parseInt(id));
 		  request.setAttribute("follow", t);
		  //将学生信息传递到修改页面  request.setAttribute
		  //转发到试听修改页面
		  request.getRequestDispatcher("/followStateAdd.jsp").forward(request,response); 
	}else if (request.getParameter("method").equals("add")) {
		
	request.getRequestDispatcher("/followStateAdd.jsp").forward(request,response); 
	}
	
		
		
		
		
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

		
	}

}
