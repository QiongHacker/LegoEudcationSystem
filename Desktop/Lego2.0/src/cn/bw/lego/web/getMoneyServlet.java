 package cn.bw.lego.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.IntRange;

import cn.bw.lego.domain.getMoney;
import cn.bw.lego.domain.pageBean;
import cn.bw.lego.domain.returnMoney;
import cn.bw.lego.service.getMoneyService;

public class getMoneyServlet extends HttpServlet {

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
		
		getMoneyService ss = new getMoneyService();
		if(request.getParameter("method").equals("query")){	
			String student_id = request.getParameter("student_id");
			String class_id = request.getParameter("class_id");
			String name = request.getParameter("name");
			String page = request.getParameter("page");
			
			
			int curPage=1;
			if (page!=null&&page!="") {
				
				curPage=Integer.parseInt(page);
				
			}
			
			int pageSize=5;
			pageBean pagebean  = ss.getMoneyForPageBean(student_id, class_id,name,curPage, pageSize);
			
			
			if (student_id!=null) {
				request.setAttribute("student_id", student_id);
			}
			if (class_id!=null) {
 				request.setAttribute("class_id", class_id);
			}
			if (name!=null) {
 				request.setAttribute("name", name);
			}
			if (pagebean!=null) {
				request.setAttribute("returnMoney", pagebean.getData());
				request.setAttribute("pageBean", pagebean);
			}
 			request.getRequestDispatcher("/returnMoney.jsp").forward(request, response);
		}
		
		else if (request.getParameter("method").equals("add")) {
			  request.getRequestDispatcher("/getMoneyInformation.jsp").forward(request,response);
		}
		//根据学生ID获取信息
		
		
		else if (request.getParameter("method").equals("query2")) {
			String id = request.getParameter("ID");
			
			List<getMoney> list = ss.getStudentById(id);
			
			if(id!=null){
	            request.setAttribute("id", list);
		      }
			
			if(list!=null){
	            request.setAttribute("studentList", list);
		      }
			
			//List<t_student> list = ss.getStudents(name,sex,state);
			
				request.getRequestDispatcher("/getMoney.jsp").forward(request, response);
			
			
			
			
			
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
