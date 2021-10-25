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
import cn.bw.lego.domain.t_payitem;
import cn.bw.lego.domain.t_student;
import cn.bw.lego.service.PayItemService;
import cn.bw.lego.service.StudentService;

public class swipeTongJi extends HttpServlet {

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

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		//����ҵ���� ���ݽ�ѧ��id��ѯѧ����Ϣ
		//ѧ����Ϣ��json��ʽ����
		String class_id=request.getParameter("c_id");
		List<t_payitem> list = new PayItemService().getPayItemsByClassId(class_id);
		
		//����JsonArray����JSONArray����[]����������һ������(Array)���˴����÷��������󼯺�װ��
		JSONArray json = JSONArray.fromObject(list);
		//JSONObject��һ��{}����������һ������(Object)���˴�ϣ���Զ���Ϊ��λ���в��������Դ���JSONObject����
		JSONObject jb = new JSONObject();
		//��jsonArray����װ��
		jb.put("person", json);
		//���Json���ݣ�������һ�������ʽ���ַ���
		response.getWriter().println(jb.toString());
	}

}
