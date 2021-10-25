package cn.bw.lego.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.bw.lego.domain.listening;

import cn.bw.lego.utils.DBUtil;

public class ListeningDaoImpl implements ListeningDao {

	@Override
	public boolean insert(listening listen) {
		// TODO Auto-generated method stub
		int line = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "insert into t_listening(name,classtype,teacher,tele,visitor,dtin,studentfrom,state)values(?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, listen.getName());
			preparedStatement.setInt(2, listen.getClassType());
			preparedStatement.setString(3, listen.getTeacher());
			preparedStatement.setString(4, listen.getTele());
			preparedStatement.setString(5, listen.getVisitor());
			preparedStatement.setString(6, listen.getDtin());
			preparedStatement.setInt(7, listen.getStudentFrom());
			preparedStatement.setInt(8, listen.getState());
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
	public boolean update(listening listen) {
		// TODO Auto-generated method stub
		
		int line = 0;
		//声明一个数据库连接对象
		
		Connection connection = null;
		
		//操作对象
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DBUtil.getConnection();
			
			String sql = "update t_listening set name=?,classtype=?,teacher=?,tele=?,visitor=?,dtin=?,studentfrom=?,state=? where ID=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, listen.getName());
			preparedStatement.setInt(2, listen.getClassType());
			preparedStatement.setString(3, listen.getTeacher());
			preparedStatement.setString(4, listen.getTele());
			preparedStatement.setString(5, listen.getVisitor());
			preparedStatement.setString(6, listen.getDtin());
			preparedStatement.setInt(7, listen.getStudentFrom());
			preparedStatement.setInt(8, listen.getState());
			preparedStatement.setInt(9, listen.getId());
			
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
	public List<listening> getListenings(String name, String classType,
			String teacher,int page,int pageSize) {
		// TODO Auto-generated method stub
		
		
		List<listening> list = new ArrayList<listening>();
		Connection connection = null;
		//操作对象
		PreparedStatement preparedStatement = null;
		//结果集
		ResultSet rs=null;
		int startpos=(page-1)*pageSize;
		try {
			
			connection = DBUtil.getConnection();
			//String sql = "select ID,name,sex,tele,school,state,remark from t_student where name=? and tele=? and state=?";
			
			String sql = "select ID,name,classtype_name,teacher,tele,visitor,dtin,studentfrom,state from v_listening where 1=1";
			
			if(name!=""&&name!=null){
				sql+=" and name like ?";
			}
			if(teacher!=""&&teacher!=null){
				
				sql+=" and teacher like ?";
			}	
			if (classType!=""&&classType!=null) {
				sql+=" and classtype =?";
			}
			//如果查询很多条数据，尽量要排序一下，这样保证每次查询出来的顺序要保持一致
			
			sql+=" order by ID limit "+startpos+","+pageSize;
			
			
			
			preparedStatement = connection.prepareStatement(sql);
			//设置问号的值
			//preparedStatement.setInt(1, id);
			int index=1;
			
			if(name!=""&&name!=null){
				preparedStatement.setString(index, "%"+name+"%");
				index++;
			}
			if(teacher!=""&&teacher!=null){
				preparedStatement.setString(index, "%"+teacher+"%");
				index++;
			}
			if(classType!=""&&classType!=null){
				preparedStatement.setString(index, classType);
				index++;
			}
			rs = preparedStatement.executeQuery();	
			while(rs.next()){
				listening t = new listening();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setClasstypename(rs.getString(3));
				t.setTeacher(rs.getString(4));
				t.setTele(rs.getString(5));
				t.setVisitor(rs.getString(6));
				t.setDtin(rs.getString(7));
				t.setStudentfromname(rs.getString(8));
				t.setStatename(rs.getString(9));
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
	public listening getListeningsById(int id) {
		// TODO Auto-generated method stub
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet rs=null;
		
		listening t=null;
		
		try {
			
			connection = DBUtil.getConnection();
			String sql = "select ID,name,classtype,teacher,tele,visitor,dtin,studentfrom,state from t_listening where ID=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();	
			if (rs.next()) {
				
				t = new listening();
				
				t.setId(id);
				
				t.setName(rs.getString(2));
				
				t.setClassType(rs.getInt(3));
				
				t.setTeacher(rs.getString(4));
				
				t.setTele(rs.getString(5));
				
				t.setVisitor(rs.getString(6));
				
				t.setDtin(rs.getString(7));
				
				t.setStudentFrom(rs.getInt(8));
				
				t.setState(rs.getInt(9));
						
			}
					
		} catch (Exception e) {
			// TODO: handle exception			
			e.printStackTrace();
					
		}finally{
			
			DBUtil.closeAll(rs, preparedStatement, connection);			
		}
		return t;
				
	}

	@Override
	public int getListeningCount(String name, String classType,
			String teacher) {
		// TODO Auto-generated method stub
		Connection connection = null;
		//操作对象
		PreparedStatement preparedStatement = null;
		//结果集
		ResultSet rs=null;
		//计算查询数据起始位置
		try {
			
			connection = DBUtil.getConnection();
			//String sql = "select ID,name,sex,tele,school,state,remark from t_student where name=? and tele=? and state=?";
			
			String sql = "SELECT count(*) FROM t_listening where 1=1";
			if(name!=""&&name!=null){
				sql+=" and name like ?";
			}
			if(teacher!=""&&teacher!=null){
				
				sql+=" and teacher like ?";
			}	
			if (classType!=""&&classType!=null) {
				sql+=" and classtype =?";
			}
			preparedStatement = connection.prepareStatement(sql);
				int index=1;
			
			if(name!=""&&name!=null){
				preparedStatement.setString(index, "%"+name+"%");
				index++;
			}
			if(teacher!=""&&teacher!=null){
				preparedStatement.setString(index, "%"+teacher+"%");
				index++;
			}
			if(classType!=""&&classType!=null){
				preparedStatement.setString(index, classType);
				index++;
			}
			rs = preparedStatement.executeQuery();	
		    if(rs.next()){
		    	return rs.getInt(1);
            }
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(rs, preparedStatement, connection);
			
			
			
		}
		
		return 0;
	}

	@Override
	public boolean checkUser(String tele, String name) {
		// TODO Auto-generated method stub
		Connection connection = null;
		// 操作对象
		PreparedStatement preparedStatement = null;
		// 结果集
		ResultSet rs = null;
		boolean chek = false;
		try {

			connection = DBUtil.getConnection();
			// 这是根据ID判断 后续需要改成Name 或者tele
			String sql = "select * from t_listening where tele=? and name=?";
			preparedStatement = connection.prepareStatement(sql);
			// 设置问号的值
			preparedStatement.setString(1, tele);
			preparedStatement.setString(2, name);
			// 执行sql
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				chek = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			DBUtil.closeAll(rs, preparedStatement, connection);
		}

		return chek;
		
	}

}
