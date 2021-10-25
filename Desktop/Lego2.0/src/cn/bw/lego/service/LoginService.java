package cn.bw.lego.service;

import cn.bw.lego.dao.LoginImpl;

/**
 * 登陆验证业务
 * @author Li dong cheng
 *
 */
public class LoginService {
		public boolean isLogin(String uname,String pwd) {
			
			LoginImpl impl = new LoginImpl();
			
			
			
			return impl.isLogin(uname, pwd);
		}
}
