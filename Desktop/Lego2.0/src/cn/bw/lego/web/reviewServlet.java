package cn.bw.lego.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bw.lego.domain.pageBean;
import cn.bw.lego.domain.t_student;
import cn.bw.lego.service.StudentReviewService;
import cn.bw.lego.service.StudentService;

public class reviewServlet extends HttpServlet {

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
		StudentReviewService ss=new StudentReviewService();
		//做查询
		if(request.getParameter("method").equals("query")){	
		String studentId = request.getParameter("ID");
		
		String page = request.getParameter("page");
		
		
		int curPage=1;
		if (page!=null&&page!="") {
			
			curPage=Integer.parseInt(page);
			
		}
		
		int pageSize=5;
		
		
		//List<t_student> list = ss.getStudents(name,sex,state);
		pageBean pagebean  = ss.getReviewsForPageBean(Integer.parseInt(studentId), curPage, pageSize);
		if (studentId!=null) {
			request.setAttribute("studentname", studentId);
		}
		
		if (pagebean!=null) {
			request.setAttribute("studentList", pagebean.getData());
			request.setAttribute("pageBean", pagebean);
		}
			request.getRequestDispatcher("/review.jsp").forward(request, response);
	}
		else if (request.getParameter("method").equals("review")) {
			
			// 获取你要修改的学生id
				  String id=request.getParameter("ID");
				  //调用业务类 查询这个学生的信息，
				  StudentService s=new StudentService();
				 t_student t=s.getStudentById(Integer.parseInt(id));
				  request.setAttribute("student", t);
				  //将学生信息传递到修改页面  request.setAttribute  
				  //转发到学生修改页面
				  request.getRequestDispatcher("/studentAddReview.jsp").forward(request,response); 

		 
			
		}
		
		
	}
}
