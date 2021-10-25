package cn.bw.lego.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bw.lego.domain.pageBean;
import cn.bw.lego.service.StudentService;
import cn.bw.lego.service.moneyOfStatisticalService;

public class moneyOfStatisticalServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		moneyOfStatisticalService ss = new moneyOfStatisticalService(); 
		//×ö²éÑ¯
		if(request.getParameter("method").equals("query")){	
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		
		String page = request.getParameter("page");
		
		
		int curPage=1;
		if (page!=null&&page!="") {
			
			curPage=Integer.parseInt(page);
			
		}
		
		int pageSize=5;
		
		
		//List<t_student> list = ss.getStudents(name,sex,state);
		pageBean pagebean  = ss.getMoneyForPageBean(startTime, endTime, curPage, pageSize);
		if (endTime!=null) {
			request.setAttribute("endTime", endTime);
		}
		if (startTime!=null) {
				request.setAttribute("startTime", startTime);
		}
		
		if (pagebean!=null) {
			request.setAttribute("studentList", pagebean.getData());
			request.setAttribute("pageBean", pagebean);
		}
			request.getRequestDispatcher("/moneyOfStatistical.jsp").forward(request, response);
		
		
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
