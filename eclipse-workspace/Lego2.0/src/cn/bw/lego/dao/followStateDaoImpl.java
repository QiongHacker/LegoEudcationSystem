package cn.bw.lego.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.bw.lego.domain.followState;
import cn.bw.lego.domain.listening;
import cn.bw.lego.utils.DBUtil;

public class followStateDaoImpl implements followStateDao {

	@Override
	public  List<followState> getFollowStatesById(int id) {
		Connection connection = null;
		List<followState> list = new ArrayList<followState>();
		PreparedStatement preparedStatement = null;
		
		ResultSet rs=null;
		
		followState t=null;
		
		try {
			
			connection = DBUtil.getConnection();
			String sql = "select student_id,date,follow,content,name from v_followstate where student_id=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();	
			while (rs.next()) {
				
				t = new followState();
				
				
				t.setStudent_id(rs.getInt(1));
				t.setDate(rs.getString(2));
				
				t.setFollow(rs.getString(3));
				
				t.setContent(rs.getString(4));
				t.setName(rs.getString(5));
				list.add(t);
						
			}
					
		} catch (Exception e) {
			// TODO: handle exception			
			e.printStackTrace();
					
		}finally{
			
			DBUtil.closeAll(rs, preparedStatement, connection);			
		}
		return list;
	}

	@Override
	public boolean update(followState follow) {
		// TODO Auto-generated method stub
		int line = 0;
		//声明一个数据库连接对象
		
		Connection connection = null;
		
		//操作对象
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DBUtil.getConnection();
			
			String sql = "update t_followstate set date=?,follow=?,content=? where student_id=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, follow.getDate());
			preparedStatement.setString(2, follow.getFollow());
			preparedStatement.setString(3, follow.getContent());
			preparedStatement.setInt(4, follow.getStudent_id());
			
			
			
			line = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			
			
			
		}finally{
			
			DBUtil.closeAll(null,preparedStatement, connection);
			
			
		}
		
		
		
		return line>0?true:false;
	}

	@Override
	public boolean insert(followState follow) {
		// TODO Auto-generated method stub
		int line = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			connection = DBUtil.getConnection();
			String sql = "insert into t_followstate(student_id,date,follow,content)values(?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, follow.getStudent_id());
			preparedStatement.setString(2, follow.getDate());
			preparedStatement.setString(3, follow.getFollow());
			preparedStatement.setString(4, follow.getContent());
			line = preparedStatement.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll(null,preparedStatement, connection);
			
			
		}
		
		return line>0?true:false;
	}

	@Override
	public followState getFollows(int id) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet rs=null;
		followState t =null;
		try {
			
			connection = DBUtil.getConnection();
			String sql = "select student_id,date,follow,content from t_followstate where student_id=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();	
			if (rs.next()) {
				t=new followState();
				
				t.setStudent_id(rs.getInt(1));
				
				t.setDate(rs.getString(2));
				t.setFollow(rs.getString(3));
				t.setContent(rs.getString(4));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll(rs, preparedStatement, connection);	
			
			
		}
		
		return t;
	}

}
