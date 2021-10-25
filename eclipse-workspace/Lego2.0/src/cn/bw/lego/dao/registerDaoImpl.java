package cn.bw.lego.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.bw.lego.domain.r_register;
import cn.bw.lego.utils.DBUtil;

public class registerDaoImpl implements registerDao {

	@Override
	public boolean register(r_register register) {
		// TODO Auto-generated method stub
		int line = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try{
			connection = cn.bw.lego.utils.DBUtil.getConnection();
			String sql = "insert into t_user(username,password)values(?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, register.getUsersname());
			preparedStatement.setString(2, register.getPasswords());
		
			
		
			line = preparedStatement.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(null,preparedStatement, connection);
			
			
		}
		return line>0?true:false;
	}

	
}
