package cn.bw.lego.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.bw.lego.domain.addClass;
import cn.bw.lego.domain.t_payitem;
import cn.bw.lego.domain.t_student;

import cn.bw.lego.utils.DBUtil;

public class addClassDaoImpl implements addClassDao {

	@Override
	public boolean insert(addClass student) {
		// TODO Auto-generated method stub
		int line = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try{
			connection = DBUtil.getConnection();
			String sql = "insert into t_addclass(classname,payitem_id,startlesson,endlesson,state,teacher,classnum,capacity)values(?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getClassName());
			preparedStatement.setString(2, student.getPayItem());
			preparedStatement.setString(3, student.getStartLesson());
			preparedStatement.setString(4, student.getEndLesson());
			preparedStatement.setString(5, student.getState());
			preparedStatement.setString(6, student.getTeacher());
			preparedStatement.setInt(7, student.getClassNum());
			preparedStatement.setInt(8, student.getCapacity());
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
	public boolean update(addClass student) {
		// TODO Auto-generated method stub
		
		int line = 0;
		//声明一个数据库连接对象
		
		Connection connection = null;
		
		//操作对象
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = DBUtil.getConnection();
			
			String sql = "update t_addclass set classname=?,payitem_id=?,startlesson=?,endlesson=?,state=?,teacher=?,classnum=?,capacity=? where ID=?";
			
			preparedStatement = connection.prepareStatement(sql);
			//设置问号的值
			
			preparedStatement.setString(1, student.getClassName());
			preparedStatement.setString(2, student.getPayItem());
			preparedStatement.setString(3, student.getStartLesson());
			preparedStatement.setString(4, student.getEndLesson());
			preparedStatement.setString(5, student.getState());
			preparedStatement.setString(6, student.getTeacher());
			preparedStatement.setInt(7, student.getClassNum());
			preparedStatement.setInt(8, student.getId());
			preparedStatement.setInt(9, student.getCapacity());
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
	public List<addClass> getClassesForPageBean(String classname, String state,
			String teacher, int page, int pageSize){
		List<addClass> list=new ArrayList<addClass>();
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
					
					String sql = "select ID,classname,course,startlesson,endlesson,state_name,teacher,classnum,capacity from v_addclass where 1=1";
					
					if(classname!=""&&classname!=null){
						sql+=" and classname like ?";
					}
					
					if(state!=""&&state!=null){
						
						sql+=" and state_name like ?";
					}	
					
					if(teacher!=""&&teacher!=null){
						
						sql+=" and teacher like ?";
					}
					
					sql+=" order by ID limit "+startpos+","+pageSize;
					
					
					
					
					preparedStatement = connection.prepareStatement(sql);
					//设置问号的值
					//preparedStatement.setInt(1, id);
					int index=1;
					if(classname!=""&&classname!=null){
						preparedStatement.setString(index, "%"+classname+"%");
						index++;
					}
					if(state!=""&&state!=null){
						preparedStatement.setString(index, "%"+state+"%");
						index++;
					}
					if(teacher!=""&&teacher!=null){
						preparedStatement.setString(index, "%"+teacher+"%");
						index++;
					}
					//执行sql
				    rs = preparedStatement.executeQuery();	
				    while(rs.next()){
				    	addClass t = new addClass();
		                t.setId(rs.getInt(1));
		                t.setClassName(rs.getString(2));
		                t.setPayItem(rs.getString(3));
		                t.setStartLesson(rs.getString(4));
		                t.setEndLesson(rs.getString(5));
		                t.setState(rs.getString(6));
		                t.setTeacher(rs.getString(7));
		                t.setClassNum(rs.getInt(8));
		                t.setCapacity(rs.getInt(9));
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
	public int getClassesCount(String classname,String state,String teacher) {
		Connection connection = null;
		//操作对象
		PreparedStatement preparedStatement = null;
		//结果集
		ResultSet rs=null;
		//计算查询数据起始位置
		
		
		
		
		try {
			
			connection = DBUtil.getConnection();
			//String sql = "select ID,name,sex,tele,school,state,remark from t_student where name=? and tele=? and state=?";
			
			String sql = "SELECT count(*) FROM t_addclass where 1=1";
			
			if(classname!=""&&classname!=null){
				sql+=" and classname like ?";
			}
			
			if(state!=""&&state!=null){
				
				sql+=" and state=?";
			}	
			
			if(teacher!=""&&teacher!=null){
				
				sql+=" and teacher like ?";
			}
			
			
			preparedStatement = connection.prepareStatement(sql);
			//设置问号的值
			//preparedStatement.setInt(1, id);
			int index=1;
			if(classname!=""&&classname!=null){
				preparedStatement.setString(index, "%"+classname+"%");
				index++;
			}
			if(state!=""&&state!=null){
				preparedStatement.setString(index, state);
				index++;
			}
			if(teacher!=""&&teacher!=null){
				preparedStatement.setString(index, "%"+teacher+"%");
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

	@Override
	public addClass getClassById(int id) {
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet rs=null;
		
		addClass t=null;
		try {
			
			connection = DBUtil.getConnection();
			String sql = "select ID,classname,course,startlesson,endlesson,state_name,teacher,classnum,capacity from v_addclass where ID=?";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, id);
			
		    rs = preparedStatement.executeQuery();	
		    if(rs.next()){
                t = new addClass();
                t.setId(rs.getInt(1));
                t.setClassName(rs.getString(2));
                t.setPayItem(rs.getString(3));
                t.setStartLesson(rs.getString(4));
                t.setEndLesson(rs.getString(5));
                t.setState(rs.getString(6));
                t.setTeacher(rs.getString(7));
                t.setClassNum(rs.getInt(8));
                t.setCapacity(rs.getInt(9));
            }
		} catch (Exception e) {
            e.printStackTrace();
        } finally {
            
        	DBUtil.closeAll(rs, preparedStatement, connection);
        }
	
		return t;
	}

	@Override
	public List<addClass> getClasses() {
		// TODO Auto-generated method stub
		List<addClass> list=new ArrayList<addClass>();
		//声明一个数据库连接对象
				Connection connection = null;
				//操作对象
				PreparedStatement preparedStatement = null;
				addClass t=null;
				//结果集
				ResultSet rs=null;
				
				try {
					
					connection = DBUtil.getConnection();
					//String sql = "select ID,name,sex,tele,school,state,remark from t_student where name=? and tele=? and state=?";
					
					String sql = "select ID,classname,course,startlesson,endlesson,state_name,teacher,classnum,capacity from v_addclass";
					
					
					
					preparedStatement = connection.prepareStatement(sql);
					
					
					//执行sql
				    rs = preparedStatement.executeQuery();	
				    while(rs.next()){
				    	 t = new addClass();
			                t.setId(rs.getInt(1));
			                t.setClassName(rs.getString(2));
			                t.setPayItem(rs.getString(3));
			                t.setStartLesson(rs.getString(4));
			                t.setEndLesson(rs.getString(5));
			                t.setState(rs.getString(6));
			                t.setTeacher(rs.getString(7));
			                t.setClassNum(rs.getInt(8));
			                t.setCapacity(rs.getInt(9));
		               
		                
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
	public boolean checkUser(String classname) {
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
			String sql = "select * from t_addclass where classname=?";
			preparedStatement = connection.prepareStatement(sql);
			// 设置问号的值
			preparedStatement.setString(1, classname);
			
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
