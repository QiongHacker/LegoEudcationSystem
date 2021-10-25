package cn.bw.lego.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bw.lego.dao.StudentDao;
import cn.bw.lego.dao.StudentDaoImpl;
import cn.bw.lego.domain.pageBean;
import cn.bw.lego.domain.t_student;
import cn.bw.lego.service.StudentService;

public class studentServlet extends HttpServlet {

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
			StudentService ss=new StudentService();
			
			
			
			//����ѯ
			if(request.getParameter("method").equals("query")){	
			String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			String state = request.getParameter("state");
			String page = request.getParameter("page");
			
			
			int curPage=1;
			if (page!=null&&page!="") {
				
				curPage=Integer.parseInt(page);
				
			}
			
			int pageSize=5;
			
			
			//List<t_student> list = ss.getStudents(name,sex,state);
			pageBean pagebean  = ss.getStudentsForPageBean(name, sex, state, curPage, pageSize);
			if (name!=null) {
				request.setAttribute("studentname", name);
			}
			if (sex!=null) {
 				request.setAttribute("sex", sex);
			}
			if (state!=null) {
				request.setAttribute("state", state);
			}
			if (pagebean!=null) {
				request.setAttribute("studentList", pagebean.getData());
				request.setAttribute("pageBean", pagebean);
			}
 			request.getRequestDispatcher("/studentInformation.jsp").forward(request, response);
			
			
}if(request.getParameter("method").equals("query2")){	
	String name = request.getParameter("name");
	String sex = request.getParameter("sex");
	String state = request.getParameter("state");
	String page = request.getParameter("page");
	
	
	int curPage=1;
	if (page!=null&&page!="") {
		
		curPage=Integer.parseInt(page);
		
	}
	
	int pageSize=5;
	
	
	//List<t_student> list = ss.getStudents(name,sex,state);
	pageBean pagebean  = ss.getStudentsForPageBean(name, sex, state, curPage, pageSize);
	if (name!=null) {
		request.setAttribute("studentname", name);
	}
	if (sex!=null) {
			request.setAttribute("sex", sex);
	}
	if (state!=null) {
		request.setAttribute("state", state);
	}
	if (pagebean!=null) {
		request.setAttribute("studentList", pagebean.getData());
		request.setAttribute("pageBean", pagebean);
	}
		request.getRequestDispatcher("/getMoneyInformation.jsp").forward(request, response);
	
	
}
			
			
			
			else if(request.getParameter("method").equals("update")){
	
	 // ��ȡ��Ҫ�޸ĵ�ѧ��id
	  String id=request.getParameter("ID");
	  //����ҵ���� ��ѯ���ѧ������Ϣ��
	  t_student t=ss.getStudentById(Integer.parseInt(id));
	  request.setAttribute("student", t);
	  //��ѧ����Ϣ���ݵ��޸�ҳ��  request.setAttribute
	  //ת����ѧ���޸�ҳ��
	  request.getRequestDispatcher("/studentAdd.jsp").forward(request,response); 
}
else if(request.getParameter("method").equals("del")){
	  // ��ȡ��Ҫ�޸ĵ�ѧ��id
	  String id=request.getParameter("ID");
	  //����ҵ���� ɾ�����ѧ������Ϣ��
	  StudentDaoImpl delete = new StudentDaoImpl();
	  delete.delete(id);
	  response.sendRedirect("studentInformation.jsp");
}else if (request.getParameter("method").equals("add")) {
		
	request.getRequestDispatcher("/studentAdd.jsp").forward(request,response); 
	
	
		
}else if (request.getParameter("method").equals("review")) {
	
	// ��ȡ��Ҫ�޸ĵ�ѧ��id
		  String id=request.getParameter("ID");
		  //����ҵ���� ��ѯ���ѧ������Ϣ��
		  t_student t=ss.getStudentById(Integer.parseInt(id));
		  request.setAttribute("student", t);
		  //��ѧ����Ϣ���ݵ��޸�ҳ��  request.setAttribute  
		  //ת����ѧ���޸�ҳ��
		  request.getRequestDispatcher("/studentAddReview.jsp").forward(request,response); 

 
	
}
    //��ҳ����ת��Studen.jsp
                   }

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
