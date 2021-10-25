package cn.bw.lego.dao;
/*
 * 学生数据层的功能实现
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Line;

import cn.bw.lego.domain.t_student;
import cn.bw.lego.domain.t_student_user;
import cn.bw.lego.utils.DBUtil;

public class StudentDaoImpl implements StudentDao{
			
	
	public boolean insert(t_student student) {
		int line = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try{
			connection = DBUtil.getConnection();
			String sql = "insert into t_student(name,sex,tele,school,state,birth,remark,sfrom)values(?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getSex());
			preparedStatement.setString(3, student.getTele());
			preparedStatement.setString(4, student.getSchool());
			preparedStatement.setString(5, student.getState());
			preparedStatement.setString(6, student.getBirth());
			preparedStatement.setString(7, student.getRemark());
			preparedStatement.setString(8, student.getFrom());
			line = preparedStatement.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(null,preparedStatement, connection);
			
			
		}
		return line>0?true:false;
		
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		
		int line = 0;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "update t_student set ifactive=0 where ID=?";
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
	public boolean update(t_student student) {
		// TODO Auto-generated method stub
		
		
		int line = 0;
		//声明一个数据库连接对象
		
		Connection connection = null;
		
		//操作对象
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = DBUtil.getConnection();
			
			String sql = "update t_student set name=?,sex=?,tele=?,school=?,state=?,birth=?,remark=?,sfrom=? where ID=?";
			
			preparedStatement = connection.prepareStatement(sql);
			//设置问号的值
			
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getSex());
			preparedStatement.setString(3, student.getTele());
			preparedStatement.setString(4, student.getSchool());
			preparedStatement.setString(5, student.getState());
			preparedStatement.setString(6, student.getBirth());
			preparedStatement.setString(7, student.getRemark());
			preparedStatement.setInt(8, student.getId());
			preparedStatement.setString(9, student.getFrom());
			//执行sql
			
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
	public List<t_student> getAllStudents() {
		// TODO Auto-generated method stub
		
				//声明一个数据库连接对象
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet rs=null;
		
		List<t_student> list=new ArrayList<t_student>();
		
		try {
			connection = DBUtil.getConnection();
			String sql = "select ID,name,sex,tele,school,birth,studentfrom from v_student";
			preparedStatement = connection.prepareStatement(sql);

			//ִ��sql
		    rs = preparedStatement.executeQuery();	
		    while(rs.next()){
		    	t_student t = new t_student();
                t.setId(rs.getInt(1));
                t.setName(rs.getString(2));
                t.setSex(rs.getString(3));
                t.setTele(rs.getString(4));
                t.setSchool(rs.getString(5));
              t.setBirth(rs.getString(6));
                t.setFrom(rs.getString(7));
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
	public List<t_student> getStudents(String name, String sex, String state) {
		// TODO Auto-generated method stub
		
		    List<t_student> list=new ArrayList<t_student>();
		//声明一个数据库连接对象
				Connection connection = null;
				//操作对象
				PreparedStatement preparedStatement = null;
				//结果集
				ResultSet rs=null;

				try {
					
					connection = DBUtil.getConnection();
					//String sql = "select ID,name,sex,tele,school,state,remark from t_student where name=? and tele=? and state=?";
					
					String sql = "select ID,name,sex,tele,school,state,remark,sfrom from t_student where 1=1";
					
					if(name!=""&&name!=null){
						sql+=" and name like ?";
					}
					
					if(sex!=""&&sex!=null){
						
						sql+=" and sex =?";
					}	
					
					if(state!=""&&state!=null){
						
						sql+=" and state =?";
					}	
					
					preparedStatement = connection.prepareStatement(sql);
					//设置问号的值
					//preparedStatement.setInt(1, id);
					int index=1;
					if(name!=""&&name!=null){
						preparedStatement.setString(index, "%"+name+"%");
						index++;
					}
					if(sex!=""&&sex!=null){
						preparedStatement.setString(index, sex);
						index++;
					}
					if(state!=""&&state!=null){
						preparedStatement.setString(index, state);
						index++;
					}
					//执行sql
				    rs = preparedStatement.executeQuery();	
				    while(rs.next()){
				    	t_student t = new t_student();
		                t.setId(rs.getInt(1));
		                t.setName(rs.getString(2));
		                t.setSex(rs.getString(3));
		                t.setTele(rs.getString(4));
		                t.setSchool(rs.getString(5));
		                t.setState(rs.getString(6));
		                t.setRemark(rs.getString(7));
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
		//分页
	//page第几页
	//pageSize每一页有几条数据
	@Override
	public List<t_student> getStudentsForPageBean(String name, String sex, String state,int page,int pageSize) {
		// TODO Auto-generated method stub
		
	    List<t_student> list=new ArrayList<t_student>();
	//声明一个数据库连接对象
			Connection connection = null;
			//操作对象
			PreparedStatement preparedStatement = null;
			//结果集
			ResultSet rs=null;
			//计算查询数据起始位置
			
			int startpos=(page-1)*pageSize;
			
			
			try {
				
				connection = DBUtil.getConnection();
				//String sql = "select ID,name,sex,tele,school,state,remark from t_student where name=? and tele=? and state=?";
				
				String sql = "select ID,name,sex,tele,school,state_name,birth,studentfrom from v_student where 1=1";
				
				if(name!=""&&name!=null){
					sql+=" and name like ?";
				}
				
				if(sex!=""&&sex!=null){
					
					sql+=" and sex=?";
				}	
				
				if(state!=""&&state!=null){
					
					sql+=" and state_name=?";
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
				if(sex!=""&&sex!=null){
					preparedStatement.setString(index, sex);
					index++;
				}
				if(state!=""&&state!=null){
					preparedStatement.setString(index, state);
					index++;
				}
				//执行sql
			    rs = preparedStatement.executeQuery();	
			    while(rs.next()){
			    	t_student t = new t_student();
	                t.setId(rs.getInt(1));
	                t.setName(rs.getString(2));
	                t.setSex(rs.getString(3));
	                t.setTele(rs.getString(4));
	                t.setSchool(rs.getString(5));
	                t.setState(rs.getString(6));
	               t.setBirth(rs.getString(7));
	               t.setFrom(rs.getString(8));
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
	public boolean checkUser(String tele,String name) {
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
			String sql = "select * from t_student where tele=? and name=?";
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
		
	public t_student getStudentById(int id) {
		// TODO Auto-generated method stub
				
				Connection connection = null;
				
				PreparedStatement preparedStatement = null;
				
				ResultSet rs=null;
				
				t_student t=null;
				try {
					
					connection = DBUtil.getConnection();
					String sql = "select ID,name,sex,tele,school,state,remark,birth,sfrom from t_student where ID=?";
					preparedStatement = connection.prepareStatement(sql);
					
					preparedStatement.setInt(1, id);
					
				    rs = preparedStatement.executeQuery();	
				    if(rs.next()){
		                t = new t_student();
		                t.setId(id);
		                t.setName(rs.getString(2));
		                t.setSex(rs.getString(3));
		                t.setTele(rs.getString(4));
		                t.setSchool(rs.getString(5));
		                t.setState(rs.getString(6));
		                t.setRemark(rs.getString(7));
		                t.setBirth(rs.getString(8));
		                t.setFrom(rs.getString(9));
		            }
				} catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            // �ͷ���Դ
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
	public int getStudentsCount(String name, String sex, String state) {
		
				Connection connection = null;
				//操作对象
				PreparedStatement preparedStatement = null;
				//结果集
				ResultSet rs=null;
				//计算查询数据起始位置
			
				try {
					
					connection = DBUtil.getConnection();
					//String sql = "select ID,name,sex,tele,school,state,remark from t_student where name=? and tele=? and state=?";
					
					String sql = "SELECT count(*) FROM v_student where 1=1";
					
					if(name!=""&&name!=null){
						sql+=" and name like ?";
					}
					
					if(sex!=""&&sex!=null){
						
						sql+=" and sex=?";
					}	
					
					if(state!=""&&state!=null){
						
						sql+=" and state_name=?";
					}
					
					
					preparedStatement = connection.prepareStatement(sql);
					//设置问号的值
					//preparedStatement.setInt(1, id);
					int index=1;
					if(name!=""&&name!=null){
						preparedStatement.setString(index, "%"+name+"%");
						index++;
					}
					if(sex!=""&&sex!=null){
						preparedStatement.setString(index, sex);
						index++;
					}
					if(state!=""&&state!=null){
						preparedStatement.setString(index, state);
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
	
	
	//根据班级ID查询学生信息
	public List<t_student> getAllStudentsByClassId(String class_id) {
		
		
			
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet rs=null;
		
		List<t_student> list=new ArrayList<t_student>();
		
		try {
			connection = DBUtil.getConnection();
			String sql = "SELECT ID,name,sex,tele,school,state,remark,sfrom from t_student WHERE ID in (SELECT student_id FROM t_pay WHERE class_id=? AND ifactive=1)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, class_id);
			//ִ��sql
		    rs = preparedStatement.executeQuery();	
		    while(rs.next()){
		    	t_student t = new t_student();
                t.setId(rs.getInt(1));
                t.setName(rs.getString(2));
                t.setSex(rs.getString(3));
                t.setTele(rs.getString(4));
                t.setSchool(rs.getString(5));
                
                
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
	public List<t_student> getAllStudentsForPage() {
		// TODO Auto-generated method stub
Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet rs=null;
		
		List<t_student> list=new ArrayList<t_student>();
		
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from v_student limit 10";
			preparedStatement = connection.prepareStatement(sql);

			//ִ��sql
		    rs = preparedStatement.executeQuery();	
		    while(rs.next()){
		    	t_student t = new t_student();
                t.setId(rs.getInt(1));
                t.setName(rs.getString(2));
                t.setSex(rs.getString(3));
                t.setTele(rs.getString(4));
                t.setSchool(rs.getString(5));
              t.setBirth(rs.getString(6));
                t.setState(rs.getString(7));
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
	public int getStudentsCount() {
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
			
			String sql = "SELECT count(*) FROM t_student";
			
			
			
			
			preparedStatement = connection.prepareStatement(sql);
			//设置问号的值
			//preparedStatement.setInt(1, id);
			
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

