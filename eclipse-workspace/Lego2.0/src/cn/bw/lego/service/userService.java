package cn.bw.lego.service;

import java.util.List;

import cn.bw.lego.dao.userDaoImpl;
import cn.bw.lego.domain.user;

public class userService {
			
	public boolean isReception(String username) {
		
		userDaoImpl reception = new userDaoImpl();
		return reception.getUsers(username);
		
	}
	
	

}
