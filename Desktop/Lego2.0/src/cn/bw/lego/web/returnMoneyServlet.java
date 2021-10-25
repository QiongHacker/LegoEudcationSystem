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
import cn.bw.lego.domain.returnMoney;
import cn.bw.lego.domain.t_student;
import cn.bw.lego.service.StudentService;
import cn.bw.lego.service.getMoneyService;
import cn.bw.lego.service.returnMoneyService;

public class returnMoneyServlet extends HttpServlet {

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
			
			//��ȡҳ���˷ѽ��
			String returnMoney=request.getParameter("money");
			//��ȡ�շ�id
			String sf_id = request.getParameter("sf_id");
			
			getMoneyService ss = new getMoneyService();
			returnMoneyService mm = new returnMoneyService();
			
			//���շѼ�¼id��ȡ�շѼ�¼
			//��ȡ�շѼ�¼Ϊ��Ч��
			getMoney t=ss.getMoneyById(Integer.parseInt(sf_id));
			
			int student_id = t.getStudent_id();
			
			int class_id = t.getClass_id();
			
			int final_price = t.getFinalprice();
			
			returnMoneyService gg = new returnMoneyService();
			//���ѧ��ID
			returnMoney tt = gg.getBySfId(Integer.parseInt(sf_id));
			//���ѧ������
			String studentName = tt.getName();
			//���ѧ���绰
			String studentTele = tt.getTele();
			//���ѧ��ѧУ
			String school = tt.getSchool();
		
			
			//�˷�ʱ��
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dt = df.format(date);
			//����˿���С����ȡ��� ����Ϣ��ӵ�refund���� ���Ұ�ifactive��Ϊ0
			if (Integer.parseInt(returnMoney) < final_price || Integer.parseInt(returnMoney) == final_price) {
				
				returnMoney rr = new returnMoney();
				rr.setName(studentName);
				rr.setTele(studentTele);
				rr.setSchool(school);
				rr.setClass_id(class_id);
				rr.setFee(Integer.parseInt(returnMoney));
				rr.setDt(dt);
				rr.setStudent_id(student_id);
				rr.setSf_id(Integer.parseInt(sf_id));
				mm.insertPay(rr);
				
		    	 mm.updatePay(student_id);
		    	 response.setContentType("text/html;charset=utf-8");
		 	     response.sendRedirect("/Lego2.0/returnMoney.jsp");
		 	       
			}else {
				
				response.sendRedirect("/Lego2.0/errorReturnMoney.html");
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
