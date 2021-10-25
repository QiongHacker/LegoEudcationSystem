package cn.bw.lego.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import cn.bw.lego.domain.pageBean;
import cn.bw.lego.domain.returnMoney;
import cn.bw.lego.service.StudentService;
import cn.bw.lego.service.returnMoneyService;

public class returnMoneyStudentInformation extends HttpServlet {

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
		returnMoneyService ss=new returnMoneyService();
		//×ö²éÑ¯
		
		String sf_id = request.getParameter("sf_id");
		
		List<returnMoney> list = ss.getStudentMoneyBySfId(Integer.parseInt(sf_id));
		
		if(sf_id!=null){
            request.setAttribute("sf_id", list);
	      }
		
		if(list!=null){
            request.setAttribute("studentList", list);
	      }
		
		//List<t_student> list = ss.getStudents(name,sex,state);
		
			request.getRequestDispatcher("/returnMoneyInform.jsp").forward(request, response);
		
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
