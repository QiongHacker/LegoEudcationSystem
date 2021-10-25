package cn.bw.lego.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bw.lego.domain.addClass;
import cn.bw.lego.domain.followState;
import cn.bw.lego.domain.pageBean;
import cn.bw.lego.domain.t_payitem;
import cn.bw.lego.domain.t_student;
import cn.bw.lego.service.addClassService;

public class addClassServlet extends HttpServlet {

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
		addClassService ss = new addClassService();
		if(request.getParameter("method").equals("query")){	
			String classname = request.getParameter("name");
			String teacher = request.getParameter("teacher");
			String state = request.getParameter("state");
			String page = request.getParameter("page");
			
			
			int curPage=1;
			if (page!=null&&page!="") {
				
				curPage=Integer.parseInt(page);
				
			}
			
			int pageSize=5;
			
			
			//List<t_student> list = ss.getStudents(name,sex,state);
			pageBean pagebean  = ss.getClassesForPageBean(classname, state, teacher, curPage, pageSize);
			
			
			if (classname!=null) {
				request.setAttribute("classname", classname);
			}
			if (teacher!=null) {
 				request.setAttribute("teacher", teacher);
			}
			if (state!=null) {
				request.setAttribute("state", state);
			}
			if (pagebean!=null) {
				request.setAttribute("studentList", pagebean.getData());
				request.setAttribute("pageBean", pagebean);
			}
 			request.getRequestDispatcher("/addClass.jsp").forward(request, response);
 			
 			
 			
		
		}else if(request.getParameter("method").equals("update")){
			
			 // 获取你要修改的学生id
			  String id=request.getParameter("ID");
			  //调用业务类 查询这个学生的信息，
			  addClass t=ss.getClassesById(Integer.parseInt(id));
			  
			
			  
			 
			  request.setAttribute("addclass", t);
			  //将学生信息传递到修改页面  request.setAttribute
			  //转发到学生修改页面
			  request.getRequestDispatcher("/addClassAdd.jsp").forward(request,response); 
		}else if (request.getParameter("method").equals("add")) {
			
			
			  
			  
			  
			  request.getRequestDispatcher("/addClassAdd.jsp").forward(request,response);
			 
			
			
				
		}
	}

}
