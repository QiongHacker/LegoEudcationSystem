package cn.bw.lego.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import cn.bw.lego.service.LoginService;

public class LoginServlet extends HttpServlet {

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
		
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		//����ҵ��� ��֤�û�
		LoginService ls = new LoginService();
		Boolean isLogin = ls.isLogin(username,pwd);
		if(isLogin){
			
			//ͨ����֤��ת��ҳ��
			
			//response.sendRedirect("index.html");
			response.getWriter().print("ok");
			 HttpSession session = request.getSession();
			          //�����ݴ洢��session��
			         session.setAttribute("username", username);
				
			
		}else {
			//response.sendRedirect("error.html");	
			//��֤��ͨ����ȥ��¼ҳ����ʾ�û��������������
			
			response.getWriter().print("no");
		}
		
		
		
	}

}
