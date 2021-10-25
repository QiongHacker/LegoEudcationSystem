package cn.bw.lego.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bw.lego.domain.r_register;
import cn.bw.lego.service.LoginService;
import cn.bw.lego.service.registerService;

public class registerServlet extends HttpServlet {

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

		response.setContentType("text/html");
		if (request.getParameter("method").equals("register")) {
			
			request.getRequestDispatcher("/register.jsp").forward(request,response); 
			
			
				
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

		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
		
		//调用业务层 验证用户
		registerService ls = new registerService();
		Boolean isRegister = ls.isRegister(username);
		if(isRegister==false){
			
			//通过验证跳转主页面
			r_register register = new r_register();
			//response.sendRedirect("index.html");
			
			register.setPasswords(password);
			register.setUsersname(username);
			ls.insert(register);
			response.getWriter().print("ok");
			
		}else {
			//response.sendRedirect("error.html");	
			//验证不通过，去登录页面提示用户名或者密码错误
			
			response.getWriter().print("no");
		}
	}

}
