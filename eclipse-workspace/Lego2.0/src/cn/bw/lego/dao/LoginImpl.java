package cn.bw.lego.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.bw.lego.domain.t_student;
import cn.bw.lego.utils.DBUtil;

public class LoginImpl {
		
	
	public boolean isLogin(String uname,String pwd){
		
		
		//声明一个数据库连接对象
				Connection connection = null;
				//操作对象
				PreparedStatement preparedStatement = null;
				//结果集
				ResultSet rs=null;
				
				t_student t=null;
				try {
					
					connection = DBUtil.getConnection();
					String sql = "select 1 from t_user where username=? and password=?";
					preparedStatement = connection.prepareStatement(sql);
					//设置问号的值
					preparedStatement.setString(1, uname);
					preparedStatement.setString(2, pwd);
					//执行sql
				    rs = preparedStatement.executeQuery();	
				    if(rs.next()){
		                	
				    		return true;
		            }
				} catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            // 释放资源
		        	DBUtil.closeAll(rs, preparedStatement, connection);
		        }
		
		
		
		
		
		return false;
		
		
		
		
		
		
	}
}
