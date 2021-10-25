package cn.bw.lego.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
            FilterChain arg2) throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest req = (HttpServletRequest)arg0;
        HttpServletResponse resp =(HttpServletResponse) arg1;
        HttpSession session = req.getSession();
           // ����û������URI
        String path = req.getRequestURI();
        // ��sessionȡ���Ѿ���¼��֤��ƾ֤ �������demo�õ���password����Ϊ��¼ƾ֤
        String username = (String) session.getAttribute("username");
        // login.jspҳ���������(�����Լ���Ŀ��Ҫ����)
        //	System.out.println(username);
//Ҳ����path.contains("login.jsp")  ������ô��ȷ��ô���Ͳ���˵��
        if(path.indexOf("/login.html") > -1) {//ע�⣺��¼ҳ��ǧ���ܹ���  ��Ȼ�������͡������������е��Բ�Ҫ͵���������������
            arg2.doFilter(req, resp);
            return;
        } else {//�������login.jsp���й���
            if (username == null || "".equals(username)) {
                // ��ת����½ҳ��
                resp.sendRedirect("login.html");
            } else {
                // �Ѿ���½,�����˴�����
                arg2.doFilter(req, resp);
            }
        }
    }
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
    }
}
