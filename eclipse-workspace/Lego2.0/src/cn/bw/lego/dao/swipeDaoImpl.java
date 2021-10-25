package cn.bw.lego.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.bw.lego.domain.listening;
import cn.bw.lego.domain.moneyOfStatistical;
import cn.bw.lego.domain.swipe;
import cn.bw.lego.domain.t_student;
import cn.bw.lego.utils.DBUtil;

public class swipeDaoImpl implements swipeDao {

	@Override
	public List <swipe> getCloseClass() {
		// TODO Auto-generated method stub
		List<swipe> list = new ArrayList<swipe>();
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet rs=null;
		
		swipe t=null;
		try {
			
			connection = DBUtil.getConnection();
			String sql = "select ID,classname from t_addclass where cast(endlesson as datetime)>now() and state=1";
			
			sql+=" order by ID";
			
			preparedStatement = connection.prepareStatement(sql);
			
		    rs = preparedStatement.executeQuery();	
		    while(rs.next()){
               t = new swipe();
               t.setId(rs.getInt("id"));
               t.setClassname(rs.getString("classname"));
               list.add(t);
            }
		} catch (Exception e) {
            e.printStackTrace();
        } finally {
            // �ͷ���Դ
        	DBUtil.closeAll(rs, preparedStatement, connection);
        }
	
		return list;
	}

	@Override
	public List <swipe> getOpenClass() {
		// TODO Auto-generated method stub
		List<swipe> list = new ArrayList<swipe>();
Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet rs=null;
		
		swipe t=null;
		try {
			
			connection = DBUtil.getConnection();
			String sql = "select ID,classname from t_addclass where cast(startlesson as datetime)<now() and state=1";
			
			sql+=" order by ID";
			
			preparedStatement = connection.prepareStatement(sql);
			
		    rs = preparedStatement.executeQuery();	
		    while(rs.next()){
               t = new swipe();
               t.setId(rs.getInt("id"));
               t.setClassname(rs.getString("classname"));
               list.add(t);
            }
		} catch (Exception e) {
            e.printStackTrace();
        } finally {
            // �ͷ���Դ
        	DBUtil.closeAll(rs, preparedStatement, connection);
        }
	
		return list;
	}

	@Override
	public boolean insert(swipe s) {
		// TODO Auto-generated method stub
		int line = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try{
			connection = DBUtil.getConnection();
			String sql = "insert into t_swipe(student_id,class_id)values(?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, s.getStudent_id());
			preparedStatement.setInt(2, s.getClass_id());
			
			line = preparedStatement.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(null,preparedStatement, connection);
			
			
		}
		return line>0?true:false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		int line = 0;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "delete from t_swipe where student_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
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
	public List<swipe> getSwipesForPages(String classname, String startTime,
			String endTime, int page, int pageSize) {
		// TODO Auto-generated method stub
		List<swipe> list=new ArrayList<swipe>();
		//声明一个数据库连接对象
				Connection connection = null;
				//操作对象
				PreparedStatement preparedStatement = null;
				//结果集
				ResultSet rs=null;
				int startpos=(page-1)*pageSize;
				try {
					
					connection = DBUtil.getConnection();
					//String sql = "select ID,name,sex,tele,school,state,remark from t_student where name=? and tele=? and state=?";
					
					String sql = "select * from v_swipe where 1=1";
					
					if(classname !=""&&classname !=null){
						sql+=" and classname like ?";
					}
					if(startTime !=""&&startTime !=null){
						sql+=" and swipedt>= ?";
					}
					if(endTime !=""&&endTime !=null){
						sql+=" and swipedt<= ?";
					}
					sql+=" order by swipe_id limit "+startpos+","+pageSize;
					preparedStatement = connection.prepareStatement(sql);
					//设置问号的值
				
					int index=1;
					if(classname !=""&&classname !=null){
						preparedStatement.setString(index,'%'+classname+'%');
						index++;
					}
					if(startTime !=""&&startTime !=null){
						preparedStatement.setString(index,startTime);
						index++;
					}
					if(endTime !=""&&endTime !=null){
						preparedStatement.setString(index,endTime);
						index++;
					}
					
					//执行sql
				    rs = preparedStatement.executeQuery();	
				    while(rs.next()){
				    	swipe t = new swipe();
		                t.setStudentname(rs.getString(1));
		                t.setSex(rs.getString(2));
		                t.setSchool(rs.getString(3));
		                t.setStatename(rs.getString(4));
		                t.setTele(rs.getString(5));
		                t.setBirth(rs.getString(6));
		                t.setId(rs.getInt(7));
		                t.setStudent_id(rs.getInt(8));
		                t.setClass_id(rs.getInt(9));
		                t.setSwipedt(rs.getString(10));
		                t.setClassname(rs.getString(11));
		                list.add(t);
		            }
				} catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            // 释放资源
		        	DBUtil.closeAll(rs, preparedStatement, connection);
		        }
			
				return list;

	}

	

	@Override
	public int getSwipesCount(String classname, String startTime, String endTime) {
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
			
			String sql = "SELECT count(*) FROM v_swipe where 1=1";
			
			if(classname !=""&&classname !=null){
				sql+=" and classname like ?";
			}
			if(startTime !=""&&startTime !=null){
				sql+=" and swipedt>= ?";
			}
			if(endTime !=""&&endTime !=null){
				sql+=" and swipedt<= ?";
			}
				
			preparedStatement = connection.prepareStatement(sql);
			//设置问号的值
			//preparedStatement.setInt(1, id);
			int index=1;
			if(classname !=""&&classname !=null){
				preparedStatement.setString(index,'%'+classname+'%');
				index++;
			}
			if(startTime !=""&&startTime !=null){
				preparedStatement.setString(index,startTime);
				index++;
			}
			if(endTime !=""&&endTime !=null){
				preparedStatement.setString(index,endTime);
				index++;
			}
			
			//执行sql
		    rs = preparedStatement.executeQuery();	
		    if(rs.next()){
		    	return rs.getInt(1);
            }
		} catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
        	DBUtil.closeAll(rs, preparedStatement, connection);
        }
	
		return 0;
	}

	
			
	
			
	
	
}
