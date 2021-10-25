package cn.bw.lego.filter;
/**
 * 前台权限管理
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import cn.bw.lego.domain.listening;
import cn.bw.lego.domain.user;
import cn.bw.lego.service.userService;

public class receptionUserFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,

	           FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest)request;
		  
	        HttpServletResponse res = (HttpServletResponse) response;
		  HttpSession session = req.getSession();
		 response.setContentType("text/html;charset=utf-8");
		 userService reception = new userService();
	      

	       String username = (String) session.getAttribute("username");
	       
	       
	       	boolean	r = reception.isReception(username);
	       			
	      
	    
	    /*  if(r=true) {

	    	  res.setContentType("text/html;charset=utf-8");
              PrintWriter out = res.getWriter();
              out.println("<script language='javascript' type='text/javascript'>");
              out.println("window.top.location.href='" + req.getContextPath() + "/errorYouDoNotHavePermission.html'");
              out.println("</script>");
	    	  
	           return;

	       }*/
	       chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
