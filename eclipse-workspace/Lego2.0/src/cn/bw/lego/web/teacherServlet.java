package cn.bw.lego.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.bw.lego.dao.TeacherDaoImpl;

import cn.bw.lego.domain.pageBean;
import cn.bw.lego.domain.t_teacher;

import cn.bw.lego.service.TeacherService;

public class teacherServlet extends HttpServlet {

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
		TeacherService ss=new TeacherService();
		//做查询
		if(request.getParameter("method").equals("query")){	
		String name = request.getParameter("name");
		String page = request.getParameter("page");
		
		int curPage=1;
		if (page!=null&&page!="") {
			
			curPage=Integer.parseInt(page);
			
		}
		
		int pageSize=5;
		
		pageBean pagebean  = ss.getTeachersForPageBean(name, curPage, pageSize);
		if (name!=null) {
			request.setAttribute("teachername", name);
		}
		
		
		if (pagebean!=null) {
			request.setAttribute("teacherList", pagebean.getData());
			request.setAttribute("pageBean", pagebean);
		}
			request.getRequestDispatcher("/teacherInformation.jsp").forward(request, response);
		
		
}else if(request.getParameter("method").equals("update")){

 // 获取你要修改的教师id
  String id=request.getParameter("ID");
  //调用业务类 查询这个学生的信息，
  t_teacher t = ss.getTeacherById(Integer.parseInt(id));
  request.setAttribute("teacher", t);
  //将学生信息传递到修改页面  request.setAttribute
  //转发到学生修改页面
  request.getRequestDispatcher("/teacherAdd.jsp").forward(request,response); 
}
else if(request.getParameter("method").equals("del")){
  // 获取你要修改的教师id
  String id=request.getParameter("ID");
  //调用业务类 删除这个教师的信息，
  TeacherDaoImpl delete = new TeacherDaoImpl();
  delete.delete(id);
  response.sendRedirect("teacherInformation.jsp");
}else if (request.getParameter("method").equals("add")) {
	
request.getRequestDispatcher("/teacherAdd.jsp").forward(request,response); 


	
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