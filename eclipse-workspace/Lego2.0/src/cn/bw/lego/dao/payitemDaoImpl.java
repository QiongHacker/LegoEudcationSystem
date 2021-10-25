package cn.bw.lego.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bw.lego.domain.t_payitem;
import cn.bw.lego.domain.t_student;
import cn.bw.lego.utils.DBUtil;

/*
 * 收费项目数据层的实现
 */
public class payitemDaoImpl implements payitemDao{

	@Override
	public boolean insert(t_payitem pay) {
		// TODO Auto-generated method stub
		
			int line = 0;
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			try{
				connection = DBUtil.getConnection();
				String sql = "insert into t_payitem(course,classtype,price,rate,finalprice,coursenum)values(?,?,?,?,?,?)";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, pay.getCourse());
				preparedStatement.setString(2, pay.getClassType());
				preparedStatement.setString(3, pay.getPrice());
				preparedStatement.setString(4, pay.getRate());
				preparedStatement.setString(5, pay.getFinalprice());
				preparedStatement.setString(6, pay.getCoursenum());
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
		// TODO Auto-generated method stub
				int line = 0;
				
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				try {
					connection = DBUtil.getConnection();
					String sql = "delete from t_payitem where ID=?";
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
	public boolean update(t_payitem pay) {
		int line = 0;
		//声明一个数据库连接对象
		
		Connection connection = null;
		
		//操作对象
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = DBUtil.getConnection();
			
			String sql = "update t_payitem set course=?,classtype=?,price=?,rate=?,finalprice=?,coursenum=? where ID=?";
			
			preparedStatement = connection.prepareStatement(sql);
			//设置问号的值
			
			preparedStatement.setString(1, pay.getCourse());
			preparedStatement.setString(2, pay.getClassType());
			preparedStatement.setString(3, pay.getPrice());
			preparedStatement.setString(4, pay.getRate());
			preparedStatement.setString(5, pay.getFinalprice());
			preparedStatement.setString(6, pay.getCoursenum());
			preparedStatement.setInt(7, pay.getId());
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
	public List<t_payitem> getAllitems() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
		//声明一个数据库连接对象
		Connection connection = null;
		//操作对象
		PreparedStatement preparedStatement = null;
		//结果集
		ResultSet rs=null;
		
		List<t_payitem> list=new ArrayList<t_payitem>();
		
		try {
			connection = DBUtil.getConnection();
			String sql = "select ID,course,classtype,price,rate,finalprice,coursenum from t_payitem";
			preparedStatement = connection.prepareStatement(sql);

			//执行sql
		    rs = preparedStatement.executeQuery();	
		   while(rs.next()){
		    	t_payitem t = new t_payitem();
                t.setId(rs.getInt(1));
                t.setCourse(rs.getString(2));
                t.setClassType(rs.getString(3));
                t.setPrice(rs.getString(4));
                t.setRate(rs.getString(5));
                t.setFinalprice(rs.getString(6));
                t.setCoursenum(rs.getString(7));
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
	public List<t_payitem> getItem(String courseName, String classType) {
		// TODO Auto-generated method stub
		List<t_payitem> list=new ArrayList<t_payitem>();
		//声明一个数据库连接对象
				Connection connection = null;
				//操作对象
				PreparedStatement preparedStatement = null;
				//结果集
				ResultSet rs=null;
				

				try {
					
					connection = DBUtil.getConnection();
					//String sql = "select ID,name,sex,tele,school,state,remark from t_student where name=? and tele=? and state=?";
					
					String sql = "select ID,course,classtype,coursenum,price,rate,finalprice from t_payitem where 1=1";
					
					if(courseName!=""&&courseName!=null){
						sql+=" and course like ?";
					}
					
					if(classType!=""&&classType!=null){
						
						sql+=" and classtype=?";
					}	
					
					
					
					preparedStatement = connection.prepareStatement(sql);
					//设置问号的值
					//preparedStatement.setInt(1, id);
					int index=1;
					if(courseName!=""&&courseName!=null){
						preparedStatement.setString(index, "%"+courseName+"%");
						index++;
					}
					if(classType!=""&&classType!=null){
						preparedStatement.setString(index, classType);
						index++;
					}
					
					//执行sql
				    rs = preparedStatement.executeQuery();	
				    while(rs.next()){
				    	t_payitem t = new t_payitem();
		                t.setId(rs.getInt(1));
		                t.setCourse(rs.getString(2));
		                t.setClassType(rs.getString(3));
		                t.setPrice(rs.getString(5));
		                t.setRate(rs.getString(6));
		                t.setFinalprice(rs.getString(7));
		                t.setCoursenum(rs.getString(4));
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
	public boolean checkUser(String itemName) {
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
			String sql = "select * from t_payitem where course=?";
			preparedStatement = connection.prepareStatement(sql);
			// 设置问号的值
			preparedStatement.setString(1, itemName);
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

	@Override
	public t_payitem getItemById(int id) {
		Connection connection = null;
		//操作对象
		PreparedStatement preparedStatement = null;
		//结果集
		ResultSet rs=null;
		
		t_payitem t=null;
		try {
			
			connection = DBUtil.getConnection();
			String sql = "select ID,course,classtype,price,rate,finalprice,coursenum from t_payitem where ID=?";
			preparedStatement = connection.prepareStatement(sql);
			//设置问号的值
			preparedStatement.setInt(1, id);
			//执行sql
		    rs = preparedStatement.executeQuery();	
		    if(rs.next()){
                t = new t_payitem();
                t.setId(rs.getInt(1));
                t.setCourse(rs.getString(2));
                t.setClassType(rs.getString(3));
                t.setPrice(rs.getString(4));
                t.setRate(rs.getString(5));
                t.setFinalprice(rs.getString(6));
                t.setCoursenum(rs.getString(7));
     
            }
		} catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
        	DBUtil.closeAll(rs, preparedStatement, connection);
        }
	
		return t;
	}

	@Override
	public List<t_payitem> getItemsForPageBean(String courseName,
			String classType, int page, int pageSize) {
		List<t_payitem> list=new ArrayList<t_payitem>();
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
					
					String sql = "select id,course,classtype_name,coursenum,price,rate,finalprice from v_payitem where 1=1";
					
					if(courseName!=""&&courseName!=null){
						sql+=" and course like ?";
					}
					
					if(classType!=""&&classType!=null){
						
						sql+=" and classtype=?";
					}	
					
					
					
					sql+=" order by ID limit "+startpos+","+pageSize;
					
					preparedStatement = connection.prepareStatement(sql);
					//设置问号的值
					//preparedStatement.setInt(1, id);
					int index=1;
					if(courseName!=""&&courseName!=null){
						preparedStatement.setString(index, "%"+courseName+"%");
						index++;
					}
					if(classType!=""&&classType!=null){
						preparedStatement.setString(index, classType);
						index++;
					}
					
					//执行sql
				    rs = preparedStatement.executeQuery();	
				    while(rs.next()){
				    	t_payitem t = new t_payitem();
		                t.setId(rs.getInt(1));
		                t.setCourse(rs.getString(2));
		                t.setClassType(rs.getString(3));
		                t.setPrice(rs.getString(5));
		                t.setRate(rs.getString(6));
		                t.setFinalprice(rs.getString(7));
		                t.setCoursenum(rs.getString(4));
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
	public int getItemsCount(String courseName, String classType) {
		Connection connection = null;
		//操作对象
		PreparedStatement preparedStatement = null;
		//结果集
		ResultSet rs=null;
		//计算查询数据起始位置
		
		
		
		
		try {
			
			connection = DBUtil.getConnection();
			//String sql = "select ID,name,sex,tele,school,state,remark from t_student where name=? and tele=? and state=?";
			
			String sql = "SELECT count(*) FROM t_payitem where 1=1";
			

			if(courseName!=""&&courseName!=null){
				sql+=" and course like ?";
			}
			
			if(classType!=""&&classType!=null){
				
				sql+=" and classtype=?";
			}	
			
			
			
			preparedStatement = connection.prepareStatement(sql);
			//设置问号的值
			//preparedStatement.setInt(1, id);
			int index=1;

			if(courseName!=""&&courseName!=null){
				preparedStatement.setString(index, "%"+courseName+"%");
				index++;
			}
			if(classType!=""&&classType!=null){
				preparedStatement.setString(index, classType);
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
	public List<t_payitem> getPayItems() {
		// TODO Auto-generated method stub
		List<t_payitem> list=new ArrayList<t_payitem>();
		//声明一个数据库连接对象
				Connection connection = null;
				//操作对象
				PreparedStatement preparedStatement = null;
				//结果集
				ResultSet rs=null;
				t_payitem t = null;
				try {
					
					connection = DBUtil.getConnection();
					//String sql = "select ID,name,sex,tele,school,state,remark from t_student where name=? and tele=? and state=?";
					
					String sql = "select ID,course,classtype_name from v_payitem";
					
					
					
					preparedStatement = connection.prepareStatement(sql);
					
					
					//执行sql
				    rs = preparedStatement.executeQuery();	
				    while(rs.next()){
				    	t = new t_payitem();
		                t.setId(rs.getInt(1));
		                t.setCourse(rs.getString(2));
		                t.setClassType(rs.getString(3));
		               
		                
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
	public List<t_payitem> getPayItemsByClassId(String classId) {
		// TODO Auto-generated method stub
Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet rs=null;
		
		List<t_payitem> list=new ArrayList<t_payitem>();
		
		try {
			connection = DBUtil.getConnection();
			String sql = "SELECT * from t_payitem where ID=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, classId);
			//ִ��sql
		    rs = preparedStatement.executeQuery();	
		    while(rs.next()){
		    	t_payitem t = new t_payitem();
                t.setId(rs.getInt(1));
              t.setCourse(rs.getString(2));
              t.setClassType(rs.getString(3));
              t.setPrice(rs.getString(4));
              t.setRate(rs.getString(5));
              t.setFinalprice(rs.getString(6));
               t.setCoursenum(rs.getString(7));
                
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
	
	

}
