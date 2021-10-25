package cn.bw.lego.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.bw.lego.domain.t_teacher;
import cn.bw.lego.domain.user;
import cn.bw.lego.utils.DBUtil;

public class userDaoImpl {

	
	public boolean getUsers(String username) {
		// TODO Auto-generated method stub
		List<user> list = new ArrayList<user>();
Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet rs=null;
		
		user   t = new user();
		try {
			
			connection = DBUtil.getConnection();
			String sql = "select 1 from t_user where username=? and rolename=1";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, username);
			
		    rs = preparedStatement.executeQuery();	
		    if(rs.next()){
             return true;
             
            }
		} catch (Exception e) {
            e.printStackTrace();
        } finally {
            // �ͷ���Դ
        	DBUtil.closeAll(rs, preparedStatement, connection);
        }
	
		return false;
	}



}
