package cn.bw.lego.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.bw.lego.dao.StudentDaoImpl;
import cn.bw.lego.dao.swipeDaoImpl;
import cn.bw.lego.domain.pageBean;
import cn.bw.lego.domain.swipe;
import cn.bw.lego.service.swipeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class swipeDo extends HttpServlet {

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

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		swipeService service = new swipeService();
		
		
		if (request.getParameter("method").equals("getS")) {
			String class_id=request.getParameter("cid");
			String student_ids =request.getParameter("sid");

Date datetime = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String applyTime =sdf.format(datetime);

			
			//获取到所有勾选了学生的id
			if (class_id=="") {
				
				request.getRequestDispatcher("/swipe.jsp").forward(request, response);
			}else {
				if (student_ids!=null&&student_ids!="") {
					
					String srt[] = student_ids.split(",");
					int array[] = new int [srt.length];
					swipe s = new swipe();
					for (int i = 0; i < srt.length; i++) {
						array[i] = Integer.parseInt(srt[i]);
							s.setStudent_id(array[i]);
							
							s.setClass_id(Integer.parseInt(class_id));
							
							s.setSwipedt(applyTime);
							
							service.insertSwipe(s);
							
				}
					
					
				}else {
					
					response.sendRedirect("swipe.jsp");
				}
				response.sendRedirect("swipe.jsp");
			}
		}
		
		if(request.getParameter("method").equals("query")){	
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			String className = request.getParameter("classname");
			String page = request.getParameter("page");
			int curPage=1;
			if (page!=null&&page!="") {
				
				curPage=Integer.parseInt(page);
				
			}
			int pageSize=5;
			pageBean pagebean  = service.getSwipesForPageBean(className, startTime, endTime, curPage, pageSize);
			
			//List<t_student> list = ss.getStudents(name,sex,state);
			if (className!=null) {
				request.setAttribute("className", className);
			}
			if (endTime!=null) {
				request.setAttribute("endTime", endTime);
			}
			if (startTime!=null) {
					request.setAttribute("startTime", startTime);
			}
			if (pagebean!=null) {
				request.setAttribute("teacherList", pagebean.getData());
				request.setAttribute("pageBean", pagebean);
			}
			
				request.getRequestDispatcher("/swipeModify.jsp").forward(request, response);
	}else if(request.getParameter("method").equals("del")){
		  // 获取你要修改的学生id
		  String id=request.getParameter("sid");
		  
		 
		  if (id=="") {
				
				request.getRequestDispatcher("/swipeModify.jsp").forward(request, response);
			}else {
				if (id!=null&&id!="") {
					
					String srt[] = id.split(",");
					int array[] = new int [srt.length];
					swipe s = new swipe();
					for (int i = 0; i < srt.length; i++) {
						array[i] = Integer.parseInt(srt[i]);
						swipeDaoImpl delete = new swipeDaoImpl();
						  delete.delete(array[i]);
				}
					response.sendRedirect("swipeModify.jsp");
					
				}else {
					
					response.sendRedirect("swipeModify.jsp");
				}
			}}
		
		
	
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
