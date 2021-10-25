package cn.bw.lego.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bw.lego.domain.getMoney;
import cn.bw.lego.service.getMoneyService;

public class getMoneyEditServlet extends HttpServlet {

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
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String student_id=request.getParameter("student_id");
		String class_id=request.getParameter("class_id");
		String price = request.getParameter("price");
		String rate = request.getParameter("rate");
		String final_price = request.getParameter("final_price");
		String state1 = request.getParameter("state1");
	
		String teacher_id = request.getParameter("teacher_id");
		String give = request.getParameter("give");
		String give_lesson_num = request.getParameter("give_lesson_num");
		String give_remarks = request.getParameter("give_remarks");
		String give_money = request.getParameter("give_money");
		
		Date datetime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String applyTime =sdf.format(datetime);
		getMoney money = new getMoney();
		
		money.setStudent_id(Integer.parseInt(student_id));
		money.setClass_id(Integer.parseInt(class_id));
		money.setPrice(price);
		money.setRate(rate);
		money.setFinalprice(Integer.parseInt(final_price));
		money.setPricetime(applyTime);
		money.setState1(state1);
	
		money.setTeacher_id(teacher_id);
		money.setGive(give);
		money.setGive_lesson_num(give_lesson_num);
		money.setGive_money(give_money);
		money.setGive_remarks(give_remarks);
		
		
		
		getMoneyService moneyService = new getMoneyService();
		
		Boolean bol=false;
		bol= moneyService.insertMoney(money);
		 if(bol!=false){
	           response.sendRedirect("/Lego2.0/getMoneyInformation.jsp");
	        }else {
	        	 response.sendRedirect("/Lego2.0/errorGetMoney.html");
			}
		
	}

}
