package cn.bw.lego.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bw.lego.domain.listening;
import cn.bw.lego.domain.pageBean;
import cn.bw.lego.service.ListeningService;

public class listeningServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ListeningService ss = new ListeningService();
		
		
		if(request.getParameter("method").equals("query")){
		String name = request.getParameter("name");
		String classType = request.getParameter("classtype");
		String teacher = request.getParameter("teacher");
		String state = request.getParameter("state");
		String page = request.getParameter("page");
		int curPage=1;
		if (page!=null&&page!="") {
			
			curPage=Integer.parseInt(page);
			
		}
		
		int pageSize=5;
		
		pageBean pagebean  = ss.getClassesForPageBean(name, classType, teacher, curPage, pageSize);
		if (name!=null) {
			request.setAttribute("studentname", name);
		}
		if (classType!=null) {
				request.setAttribute("classtype", classType);
		}
		if (teacher!=null) {
			request.setAttribute("teacher", teacher);
		}
		if (pagebean!=null) {
			request.setAttribute("listenList", pagebean.getData());
			request.setAttribute("pageBean", pagebean);
		}
			request.getRequestDispatcher("/listening.jsp").forward(request, response);
			
	 }else if(request.getParameter("method").equals("update")){
			
		 // 获取你要修改的学生id
		  String id=request.getParameter("ID");
		  //调用业务类 查询这个学生的试听信息，
		  listening t=ss.getListeningsById(Integer.parseInt(id));
		  request.setAttribute("listen", t);
		  //将学生信息传递到修改页面  request.setAttribute
		  //转发到试听修改页面
		  request.getRequestDispatcher("/listeningAdd.jsp").forward(request,response); 
	}else if (request.getParameter("method").equals("add")) {
		
	request.getRequestDispatcher("/listeningAdd.jsp").forward(request,response); 
	
	
		
		}else if (request.getParameter("method").equals("followstate")) {
			
			request.getRequestDispatcher("/followState.jsp").forward(request,response); 
			
			
				
				}
	}
}
