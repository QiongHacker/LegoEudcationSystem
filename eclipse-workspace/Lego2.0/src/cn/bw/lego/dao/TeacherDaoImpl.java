package cn.bw.lego.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.bw.lego.domain.t_student;
import cn.bw.lego.domain.t_teacher;
import cn.bw.lego.utils.DBUtil;

/*
 * 教师数据层的实现
 */
public class TeacherDaoImpl implements TeacherDao {

	@Override
	public boolean insert(t_teacher teacher) {
		int line = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "insert into t_teacher(name,sex,idcard,dtin,rolename)values(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, teacher.getName());
			preparedStatement.setString(2, teacher.getSex());
			preparedStatement.setString(3, teacher.getIdcard());
			preparedStatement.setString(4, teacher.getDtin());
			preparedStatement.setInt(5, teacher.getRolename());
			line = preparedStatement.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(null,preparedStatement, connection);
			
			
			
		}
		// TODO Auto-generated method stub
		
		
		
		return line>0?true:false;
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		int line = 0;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "delete from t_teacher where ID=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
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
	public boolean update(t_teacher teacher) {
		// TODO Auto-generated method stub
		
		
		int line = 0;
		//声明一个数据库连接对象
		
		Connection connection = null;
		
		//操作对象
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = DBUtil.getConnection();
			
			String sql = "update t_teacher set name=?,sex=?,idcard=?,dtin=?,rolename=? where ID=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, teacher.getName());
			preparedStatement.setString(2, teacher.getSex());
			preparedStatement.setString(3, teacher.getIdcard());
			preparedStatement.setString(4, teacher.getDtin());
			preparedStatement.setInt(5, teacher.getRolename());
			preparedStatement.setInt(6, teacher.getId());
			
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
	public List<t_teacher> getAllTeachers() {
		// TODO Auto-generated method stub
		//声明一个数据库连接对象
		Connection connection = null;
		//操作对象
		PreparedStatement preparedStatement = null;
		//结果集
		ResultSet rs=null;
		List<t_teacher> list = new ArrayList<t_teacher>();
		try {
			connection = DBUtil.getConnection();
			String sql = "select ID,name,sex,idcard,dtin from t_teacher";
			preparedStatement = connection.prepareStatement(sql);

			//执行sql
		    rs = preparedStatement.executeQuery();	
		   while(rs.next()){
		    	t_teacher t = new t_teacher();
                t.setId(rs.getInt(1));
                t.setName(rs.getString(2));
                t.setSex(rs.getString(3));
                t.setIdcard(rs.getString(4));
                t.setDtin(rs.getString(5));
               
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
	public List<t_teacher> getTeachers(String name
			) {
		// TODO Auto-generated method stub
		
		List<t_teacher> list = new ArrayList<t_teacher>();
		
		//声明一个数据库连接对象
		Connection connection = null;
		//操作对象
		PreparedStatement preparedStatement = null;
		//结果集
		ResultSet rs=null;
		try {
			connection = DBUtil.getConnection();
			//String sql = "select ID,name,sex,tele,school,state,remark from t_student where name=? and tele=? and state=?";
			
			String sql = "select ID,name,sex,idcard,dtin from t_teacher where 1=1";
			
			if(name!=""&&name!=null){
				sql+=" and name like ?";
			}
			
			
			
			
			
			preparedStatement = connection.prepareStatement(sql);
			//设置问号的值
			//preparedStatement.setInt(1, id);
			int index=1;
			if(name!=""&&name!=null){
				preparedStatement.setString(index, "%"+name+"%");
				index++;
			}
			
			//执行sql
		    rs = preparedStatement.executeQuery();	
		    while(rs.next()){
		    	t_teacher t = new t_teacher();
                t.setId(rs.getInt(1));
                t.setName(rs.getString(2));
                t.setSex(rs.getString(3));
                t.setIdcard(rs.getString(4));
                t.setDtin(rs.getString(5));
              list.add(t);
            }
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}finally{
			
			 // 释放资源
        	DBUtil.closeAll(rs, preparedStatement, connection);
			
			
			
		}
		return list;
	}

	@Override
	public boolean checkUser(String shenFenId) {
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
			String sql = "select * from t_teacher where idcard=?";
			preparedStatement = connection.prepareStatement(sql);
			// 设置问号的值
			preparedStatement.setString(1, shenFenId);
			// 执行sql
			rs = preparedStatement.executeQuery();

			if (rs.next()) {
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
	
	public t_teacher getTeacherById(int id) {
		// TODO Auto-generated method stub
		//声明一个数据库连接对象
				Connection connection = null;
				//操作对象
				PreparedStatement preparedStatement = null;
				//结果集
				ResultSet rs=null;
				t_teacher t=null;
				try {
					
					connection = DBUtil.getConnection();
					String sql = "select ID,name,sex,idcard,dtin,rolename from t_teacher where ID=?";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setInt(1, id);
					//执行sql
				    rs = preparedStatement.executeQuery();	
				    if(rs.next()){
		                t = new t_teacher();
		                t.setId(id);
		                t.setName(rs.getString(2));
		                t.setSex(rs.getString(3));
		                t.setIdcard(rs.getString(4));
		                t.setDtin(rs.getString(5));
		                t.setRolename(rs.getInt(6));
		                
					
				}
				    }
				    catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally{
					
					DBUtil.closeAll(rs, preparedStatement, connection);
					
					
					
				}
				
				
				
		return t;
	}

	

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<t_teacher> getTeachersForPageBean(String name, int page,
			int pageSize) {
List<t_teacher> list = new ArrayList<t_teacher>();
		
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
			
			String sql = "select ID,name,sex,idcard,dtin from t_teacher where 1=1";
			
			if(name!=""&&name!=null){
				sql+=" and name like ?";
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
			
			//执行sql
		    rs = preparedStatement.executeQuery();	
		    while(rs.next()){
		    	t_teacher t = new t_teacher();
                t.setId(rs.getInt(1));
                t.setName(rs.getString(2));
                t.setSex(rs.getString(3));
                t.setIdcard(rs.getString(4));
                t.setDtin(rs.getString(5));
              list.add(t);
            }
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}finally{
			
			 // 释放资源
        	DBUtil.closeAll(rs, preparedStatement, connection);
			
			
			
		}
		return list;
	}

	@Override
	public int getTeachersCount(String name) {
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
			
			String sql = "SELECT count(*) FROM t_teacher where 1=1";
			
			if(name!=""&&name!=null){
				sql+=" and name like ?";
			}
				
			preparedStatement = connection.prepareStatement(sql);
			//设置问号的值
			//preparedStatement.setInt(1, id);
			int index=1;
			if(name!=""&&name!=null){
				preparedStatement.setString(index, "%"+name+"%");
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
