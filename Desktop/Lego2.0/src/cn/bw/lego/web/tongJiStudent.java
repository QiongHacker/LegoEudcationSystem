package cn.bw.lego.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bw.lego.dao.StudentDaoImpl;
import cn.bw.lego.dao.tongJiStudentDaoImpl;
import cn.bw.lego.domain.pageBean;
import cn.bw.lego.domain.swipe;
import cn.bw.lego.service.tongJiStudentService;

public class tongJiStudent extends HttpServlet {

	private String endMonth;

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
		tongJiStudentService ss = new tongJiStudentService();
		
		
		if(request.getParameter("method").equals("query")){	
			String month = request.getParameter("month");
			String page = request.getParameter("page");
			
			int curPage=1;
			if (page!=null&&page!="") {
				
				curPage=Integer.parseInt(page);
				
			}
			
			int pageSize=5;
			
			pageBean pagebean  = ss.getStudentsForPageBean(month, curPage, pageSize);
			if (month!=null) {
				request.setAttribute("month", month);
			}
			
			
			if (pagebean!=null) {
				request.setAttribute("studentList", pagebean.getData());
				request.setAttribute("pageBean", pagebean);
			}
				request.getRequestDispatcher("/statisticalStudent.jsp").forward(request, response);
			
			
	}else if(request.getParameter("method").equals("shoufeiquery")){

		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String page = request.getParameter("page");
		
		int curPage=1;
		if (page!=null&&page!="") {
			
			curPage=Integer.parseInt(page);
			
		}
		
		int pageSize=5;
		
		pageBean pagebean  = ss.getShouFeiForPageBean(startTime, endTime, curPage, pageSize);
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
		  // 获取你要合计的时间段
		
		  //调用业务类 合计金额
		 List<cn.bw.lego.domain.tongJiStudent> list = ss.getTotalPrice(startTime, endTime);
		 if (endTime!=null) {
				request.setAttribute("endTime", endTime);
			}
			if (startTime!=null) {
					request.setAttribute("startTime", startTime);
			}
			if (list!=null) {
				request.setAttribute("studentList", list);
			}
			request.getRequestDispatcher("/shouFeiTongJi.jsp").forward(request, response);
		}
		
	else if(request.getParameter("method").equals("tuifeiquery")){

		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String page = request.getParameter("page");
		
		int curPage=1;
		if (page!=null&&page!="") {
			
			curPage=Integer.parseInt(page);
			
		}
		
		int pageSize=5;
		
		pageBean pagebean  = ss.getTuiFeiForPageBean(startTime, endTime, curPage, pageSize);
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
		  // 获取你要合计的时间段
		
		  //调用业务类 合计金额
		 List<cn.bw.lego.domain.tongJiStudent> list = ss.getTotalTuiPrice(startTime, endTime);
		 if (endTime!=null) {
				request.setAttribute("endTime", endTime);
			}
			if (startTime!=null) {
					request.setAttribute("startTime", startTime);
			}
			if (list!=null) {
				request.setAttribute("studentList", list);
			}
			request.getRequestDispatcher("/tuiFeiTongJi.jsp").forward(request, response);
		}
		
		
	else if(request.getParameter("method").equals("swipeteacherquery")){	
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			String name = request.getParameter("name");
			
			List<cn.bw.lego.domain.tongJiStudent> list = ss.getTeacherSwipe(startTime, endTime,name);
			
			//List<t_student> list = ss.getStudents(name,sex,state);
		
			if (endTime!=null) {
				request.setAttribute("endTime", endTime);
			}
			if (startTime!=null) {
					request.setAttribute("startTime", startTime);
			}
			if (name!=null) {
				request.setAttribute("name", name);
		}
			if (list!=null) {
				request.setAttribute("studentList", list);
			}
			
				request.getRequestDispatcher("/swipeTongJi.jsp").forward(request, response);
	}else if(request.getParameter("method").equals("swipestudentquery")){	
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String name = request.getParameter("name");

		List<cn.bw.lego.domain.tongJiStudent> list = ss.getStudentSwipe(startTime, endTime,name);
		
		//List<t_student> list = ss.getStudents(name,sex,state);
	
		if (endTime!=null) {
			request.setAttribute("endTime", endTime);
		}
		if (startTime!=null) {
				request.setAttribute("startTime", startTime);
		}
		if (name!=null) {
			request.setAttribute("name", name);
	}
		if (list!=null) {
			request.setAttribute("studentList", list);
		}
		
			request.getRequestDispatcher("/swipeStudentTongJi.jsp").forward(request, response);
			
}else if(request.getParameter("method").equals("keshiquery")){	
	String startYear = request.getParameter("startYear");
	String startMonth = request.getParameter("startMonth");
	String endYear = request.getParameter("endYear");
	String endMonth = request.getParameter("endMonth");
	
	

	List<cn.bw.lego.domain.tongJiStudent> list = ss.getKeShi(startYear, startMonth, endYear, endMonth);
	
	//List<t_student> list = ss.getStudents(name,sex,state);

	if (startYear!=null) {
		request.setAttribute("startYear", startYear);
	}
	if (startMonth!=null) {
			request.setAttribute("startMonth", startMonth);
	}
	if (endYear!=null) {
		request.setAttribute("endYear", endYear);
	}
	if (endMonth!=null) {
			request.setAttribute("endMonth", endMonth);
	}
	
	
	if (list!=null) {
		request.setAttribute("studentList", list);
	}
	
		request.getRequestDispatcher("/keShiTongJi.jsp").forward(request, response);
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
	}

}
