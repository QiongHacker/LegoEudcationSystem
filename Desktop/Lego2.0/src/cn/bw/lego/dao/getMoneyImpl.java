package cn.bw.lego.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.bw.lego.domain.getMoney;
import cn.bw.lego.domain.t_student;
import cn.bw.lego.utils.DBUtil;

public class getMoneyImpl implements getMoneyDao {

	@Override
	public boolean insert(getMoney money) {
		// TODO Auto-generated method stub
		int line = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try{
			connection = DBUtil.getConnection();
			String sql = "insert into t_pay(student_id,class_id,price,rate,finalprice,pricetime,state,teacher_id,give,give_lesson_num,give_money,give_remarks)values(?,?,?,?,?,?,?,?,?,?,?,?)";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, money.getStudent_id());
			preparedStatement.setInt(2, money.getClass_id());
			preparedStatement.setString(3, money.getPrice());
			preparedStatement.setString(4, money.getRate());
			preparedStatement.setInt(5, money.getFinalprice());
			preparedStatement.setString(6, money.getPricetime());
			preparedStatement.setString(7, money.getState1());
			
			preparedStatement.setString(8, money.getTeacher_id());
			preparedStatement.setString(9, money.getGive());
			preparedStatement.setString(10, money.getGive_lesson_num());
			preparedStatement.setString(11, money.getGive_money());
			preparedStatement.setString(12, money.getGive_remarks());			
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
	public List<getMoney> getMoneysForPageBean(String studentId,
			String classId,String name, int page, int pageSize) {
		List<getMoney> list=new ArrayList<getMoney>();
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
					
					String sql = "select ID,name,sf_id,student_id,class_id,course,price,rate,finalprice,pricetime,ifactive from v_pay2 where 1=1";
					
					if(studentId!=""&&studentId!=null){
						sql+=" and student_id=?";
					}
					
					if(classId!=""&&classId!=null){
						
						sql+=" and class_id=?";
					}	
					if(name!=""&&name!=null){
						
						sql+=" and name like ?";
					}	
					
					
					
					
					sql+=" order by ID limit "+startpos+","+pageSize;
					
					
					
					
					preparedStatement = connection.prepareStatement(sql);
					//设置问号的值
					//preparedStatement.setInt(1, id);
					int index=1;
					if(studentId!=""&&studentId!=null){
						preparedStatement.setString(index, studentId);
						index++;
					}
					if(classId!=""&&classId!=null){
						preparedStatement.setString(index, classId);
						index++;
					}
					if(name!=""&&name!=null){
						preparedStatement.setString(index, "%"+name+"%");
						index++;
					}
					
					//执行sql
				    rs = preparedStatement.executeQuery();	
				    while(rs.next()){
				    	getMoney t = new getMoney();
				    	 t.setId(rs.getInt(1));
					    	t.setName(rs.getString(2));
					    	t.setSf_id(rs.getInt(3));
					    	t.setStudent_id(rs.getInt(4));
					    	t.setClass_id(rs.getInt(5));
					    	t.setCourse(rs.getString(6));
					    	t.setPrice(rs.getString(7));
					    	t.setRate(rs.getString(8));
					    	t.setFinalprice(rs.getInt(9));
					    	t.setPricetime(rs.getString(10));
					    	t.setIfactive(rs.getInt(11));
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
	public int getMoneysCount(String studentId, String classId,String name) {
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
			
			String sql = "SELECT count(*) FROM v_pay2 where 1=1";
			if(studentId!=""&&studentId!=null){
				sql+=" and student_id=?";
			}
			
			if(classId!=""&&classId!=null){
				
				sql+=" and class_id=?";
			}	
			if(name!=""&&name!=null){
				
				sql+=" and name like ?";
			}
			preparedStatement = connection.prepareStatement(sql);
			//设置问号的值
			//preparedStatement.setInt(1, id);
			int index=1;
			
			if(studentId!=""&&studentId!=null){
				preparedStatement.setString(index, studentId);
				index++;
			}
			if(classId!=""&&classId!=null){
				preparedStatement.setString(index, classId);
				index++;
			}
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
			//根据收费ID查询，是否退费成功
	@Override
	public getMoney getMoneyById(int id) {
		// TODO Auto-generated method stub
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet rs=null;
		
		getMoney t=null;
		try {
			
			connection = DBUtil.getConnection();
			String sql = "select ID,name,sf_id,student_id,class_id,course,price,rate,finalprice,pricetime,ifactive from v_pay2 where ifactive=1 and sf_id=?";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, id);
			
		    rs = preparedStatement.executeQuery();	
		    if(rs.next()){
                t = new getMoney();
                t.setId(rs.getInt(1));
		    	t.setName(rs.getString(2));
		    	t.setSf_id(rs.getInt(3));
		    	t.setStudent_id(rs.getInt(4));
		    	t.setClass_id(rs.getInt(5));
		    	t.setCourse(rs.getString(6));
		    	t.setPrice(rs.getString(7));
		    	t.setRate(rs.getString(8));
		    	t.setFinalprice(rs.getInt(9));
		    	t.setPricetime(rs.getString(10));
		    	t.setIfactive(rs.getInt(11));
     
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
	public List<getMoney> getStudentsById(String id) {
		// TODO Auto-generated method stub
		List<getMoney> list=new ArrayList<getMoney>();
		//声明一个数据库连接对象
				Connection connection = null;
				//操作对象
				PreparedStatement preparedStatement = null;
				//结果集
				ResultSet rs=null;
				//计算查询数据起始位置
				
				
				
				try {
					
					connection = DBUtil.getConnection();
					//String sql = "select ID,name,sex,tele,school,state,remark from t_student where name=? and tele=? and state=?";
					
					String sql = "select * from t_student where ID=?";
					
					
					preparedStatement = connection.prepareStatement(sql);
					//设置问号的值
					//preparedStatement.setInt(1, id);
					int index=1;
					if(id!=""&&id!=null){
						preparedStatement.setString(index, id);
						index++;
					}
					
					
					//执行sql
				    rs = preparedStatement.executeQuery();	
				    while(rs.next()){
				    	getMoney t = new getMoney();
				    	 t.setId(rs.getInt(1));
					    	t.setName(rs.getString(2));
					    	
					    	
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
	public boolean checkUser(int id) {
		// TODO Auto-generated method stub
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
					String sql = "select * from v_pay2 where student_id=?";
					preparedStatement = connection.prepareStatement(sql);
					// 设置问号的值
					preparedStatement.setInt(1, id);
					
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
