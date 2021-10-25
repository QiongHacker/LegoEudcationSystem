package cn.bw.lego.service;

import cn.bw.lego.dao.LoginImpl;
import cn.bw.lego.dao.registerDao;
import cn.bw.lego.dao.registerDaoImpl;
import cn.bw.lego.dao.registerImpl;
import cn.bw.lego.domain.r_register;


public class registerService {
	
	
		private registerDao registerDao = new registerDaoImpl();
		
		public boolean insert(r_register register){
			return registerDao.register(register);
			
			
		}
public boolean isRegister(String uname) {
			
			registerImpl reImpl = new registerImpl();
			
			
			
			return reImpl.isRegister(uname);
		}
}
