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
			 // ��ȡ��Ҫ�޸ĵ�ѧ��id
			  String id=request.getParameter("ID");
			  
			  List<followState> list = follow.getfollowStatesById(Integer.parseInt(id));
			  
			  request.setAttribute("followstate", list);
			  
			  request.getRequestDispatcher("/followStateInformation.jsp").forward(request,response);
			  
			  
		}else if(request.getParameter("method").equals("update")){
			
		 // ��ȡ��Ҫ�޸ĵ�ѧ��id
		  String id=request.getParameter("ID");
		  //����ҵ���� ��ѯ���ѧ����������Ϣ��
		  followState t = follow.getFollows(Integer.parseInt(id));
 		  request.setAttribute("follow", t);
		  //��ѧ����Ϣ���ݵ��޸�ҳ��  request.setAttribute
		  //ת���������޸�ҳ��
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
