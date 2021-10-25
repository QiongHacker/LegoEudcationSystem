package cn.bw.lego.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bw.lego.domain.t_payitem;

import cn.bw.lego.service.PayItemService;
import cn.bw.lego.service.StudentService;

public class PayitemEditServlet extends HttpServlet {

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
		response.setContentType("text/html;charset=utf-8");
		
	       String id=request.getParameter("payitem_id");
	       
	       String name= request.getParameter("payitem_course");
	       name=new String(name.getBytes("ISO-8859-1"), "UTF-8");
	       
	       String classtype=request.getParameter("payitem_classtype");
	       classtype=new String(classtype.getBytes("ISO-8859-1"), "UTF-8");
	       String payitem_coursenum=request.getParameter("payitem_coursenum");
	       payitem_coursenum=new String(payitem_coursenum.getBytes("ISO-8859-1"), "UTF-8");
	       
	       String payitem_price=request.getParameter("payitem_price");
	       String payitem_rate=request.getParameter("payitem_rate");
	      
	       String payitem_finalprice=request.getParameter("payitem_finalprice");
	       
		   t_payitem t=new  t_payitem();
		   t.setCourse(name);
		   t.setCoursenum(payitem_coursenum);
		   t.setPrice(payitem_price);
		   t.setRate(payitem_rate);
		   t.setFinalprice(payitem_finalprice);
		   t.setClassType(classtype);
		   PayItemService ss=new  PayItemService();
		   Boolean bol=false;
	       if(id==null || id==""){
	    	   //添加
	    	  
	    	  bol=  ss.addPayitem(t);
	    	   
	       }else{
	    	   //修改
	    	   t.setId(Integer.parseInt(id));
	    	   bol= ss.updatePayitem(t);
	       }
	       
	       //name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
	      // System.out.println(name);
			if(bol!=false){
				 response.sendRedirect("/Lego2.0/payItem.jsp");
	       }else{
	    	   response.sendRedirect("/Lego2.0/errorAdd.html");
	       }
		
	}

}
