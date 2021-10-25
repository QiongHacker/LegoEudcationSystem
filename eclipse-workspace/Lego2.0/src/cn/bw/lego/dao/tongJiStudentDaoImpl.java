package cn.bw.lego.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.bw.lego.domain.swipe;
import cn.bw.lego.domain.t_student;
import cn.bw.lego.domain.tongJiStudent;
import cn.bw.lego.utils.DBUtil;

public class tongJiStudentDaoImpl implements tongJiStudentDao {

	
	
	//缴费信息统计
	@Override
	public List<tongJiStudent> getStudentsForPageBean(String month, int page,
			int pageSize) {
		// TODO Auto-generated method stub
		List<tongJiStudent> list=new ArrayList<tongJiStudent>();
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
					
					String sql = "select * from v_student_tongji a where 1=1";
					
					if(month!=""&&month!=null){
						sql+=" and month(cast(birth as datetime))=?";
					}
					
					
					sql+=" order by ID limit "+startpos+","+pageSize;
					
					preparedStatement = connection.prepareStatement(sql);
					//设置问号的值
				
					int index=1;
					if(month !=""&&month !=null){
						preparedStatement.setString(index,month);
						index++;
					}
					
					
					//执行sql
				    rs = preparedStatement.executeQuery();	
				    while(rs.next()){
				    	tongJiStudent t = new tongJiStudent();
				    	t.setId(rs.getInt(1));
				    	t.setName(rs.getString(2));
				    	t.setSex(rs.getString(3));
				    	t.setTele(rs.getString(4));
				    	t.setSchool(rs.getString(5));
				    	t.setState(rs.getString(6));
				    	
				    	t.setBirth(rs.getString(7));
				    	
				    	
				    	
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
	public int getStudentsCount(String month) {
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
			
			String sql = "SELECT count(*) FROM v_student_tongji where 1=1";
			
			if(month!=""&&month!=null){
				sql+=" month(cast(birth as datetime))=?";
				
			}
			
			preparedStatement = connection.prepareStatement(sql);
			//设置问号的值
			//preparedStatement.setInt(1, id);
			int index=1;
			if(month!=""&&month!=null){
				preparedStatement.setString(index, month);
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
	
	
	
//按时间段查询 缴费信息
	@Override
	public List<tongJiStudent> getShouFeiForPageBean(String startTime,
			String endTime, int page, int pageSize) {
		// TODO Auto-generated method stub
		List<tongJiStudent> list=new ArrayList<tongJiStudent>();
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
					
					String sql = "select * from v_shoufei_tongji where 1=1";
					
					
					if(startTime !=""&&startTime !=null){
						sql+=" and pricetime>= ?";
					}
					if(endTime !=""&&endTime !=null){
						sql+=" and pricetime<DATE_ADD(? ,INTERVAL 1 day)";
					}
					sql+=" order by pricetime desc limit "+startpos+","+pageSize;
					preparedStatement = connection.prepareStatement(sql);
					//设置问号的值
				
					int index=1;
					
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
				    	tongJiStudent t = new tongJiStudent();
		                t.setStudentid(rs.getInt(1));
		                t.setName(rs.getString(2));
		                t.setSex(rs.getString(3));
		                t.setBirth(rs.getString(4));
		                t.setTele(rs.getString(5));
		                t.setSchool(rs.getString(6));
		                t.setState(rs.getString(7));
		                t.setPrice(rs.getInt(8));
		                t.setPricetime(rs.getString(9));
		                
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
	public int getShouFeiCount(String startTime, String endTime) {
		Connection connection = null;
		//操作对象
		PreparedStatement preparedStatement = null;
		//结果集
		ResultSet rs=null;
		//计算查询数据起始位置
	
		try {
			
			connection = DBUtil.getConnection();
			//String sql = "select ID,name,sex,tele,school,state,remark from t_student where name=? and tele=? and state=?";
			
			String sql = "SELECT count(*) FROM v_shoufei_tongji where 1=1";
			
			if(startTime !=""&&startTime !=null){
				sql+=" and pricetime>= ?";
			}
			if(endTime !=""&&endTime !=null){
				sql+=" and pricetime<= ?";
			}
			
			preparedStatement = connection.prepareStatement(sql);
			//设置问号的值
			//preparedStatement.setInt(1, id);
			int index=1;
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

	@Override
	public List<tongJiStudent> getTotalPrice(String startTime, String endTime) {
		// TODO Auto-generated method stub
		Connection connection = null;
		//操作对象
		PreparedStatement preparedStatement = null;
		//结果集
		ResultSet rs=null;
		//计算查询数据起始位置
		List<tongJiStudent> list=new ArrayList<tongJiStudent>();
		try {
			
			connection = DBUtil.getConnection();
			//String sql = "select ID,name,sex,tele,school,state,remark from t_student where name=? and tele=? and state=?";
			
			String sql = "select SUM(finalprice) as sum from v_shoufei_tongji where 1=1";
			
			if(startTime !=""&&startTime !=null){
				sql+=" and pricetime>= ?";
			}
			if(endTime !=""&&endTime !=null){
				sql+=" and pricetime<= ?";
			}
			
			preparedStatement = connection.prepareStatement(sql);
			//设置问号的值
			//preparedStatement.setInt(1, id);
			int index=1;
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
		    	tongJiStudent t = new tongJiStudent();
		    	t.setSumprice(rs.getInt(1));
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
	
//退费信息统计
	//查询退费信息
	@Override
	public List<tongJiStudent> getTuiFeiForPageBean(String startTime,
			String endTime, int page, int pageSize) {
		// TODO Auto-generated method stub
		List<tongJiStudent> list=new ArrayList<tongJiStudent>();
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
					
					String sql = "select * from v_tuifei_tongji where 1=1";
					
					
					if(startTime !=""&&startTime !=null){
						sql+=" and refunddate>= ?";
					}
					if(endTime !=""&&endTime !=null){
						sql+=" and refunddate<DATE_ADD(? ,INTERVAL 1 day)";
					}
					sql+=" order by refunddate desc limit "+startpos+","+pageSize;
					preparedStatement = connection.prepareStatement(sql);
					//设置问号的值
				
					int index=1;
					
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
				    	tongJiStudent t = new tongJiStudent();
		                t.setStudentid(rs.getInt(1));
		                t.setName(rs.getString(2));
		                t.setSex(rs.getString(3));
		                t.setBirth(rs.getString(4));
		                t.setTele(rs.getString(5));
		                t.setSchool(rs.getString(6));
		                t.setState(rs.getString(7));
		                t.setReturnprice(rs.getInt(8));
		                t.setReturnpricetime(rs.getString(9));
		                
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
	//有多少退费信息
	@Override
	public int getTuiFeiCount(String startTime, String endTime) {
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
			
			String sql = "SELECT count(*) FROM v_tuifei_tongji where 1=1";
			
			if(startTime !=""&&startTime !=null){
				sql+=" and refunddate>= ?";
			}
			if(endTime !=""&&endTime !=null){
				sql+=" and refunddate<= ?";
			}
			
			preparedStatement = connection.prepareStatement(sql);
			//设置问号的值
			//preparedStatement.setInt(1, id);
			int index=1;
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
	//合计退费
	@Override
	public List<tongJiStudent> getTuiTotalPrice(String startTime, String endTime) {
		// TODO Auto-generated method stub
		Connection connection = null;
		//操作对象
		PreparedStatement preparedStatement = null;
		//结果集
		ResultSet rs=null;
		//计算查询数据起始位置
		List<tongJiStudent> list=new ArrayList<tongJiStudent>();
		try {
			
			connection = DBUtil.getConnection();
			//String sql = "select ID,name,sex,tele,school,state,remark from t_student where name=? and tele=? and state=?";
			
			String sql = "select SUM(refundprice) as sum from v_tuifei_tongji where 1=1";
			
			if(startTime !=""&&startTime !=null){
				sql+=" and refunddate>= ?";
			}
			if(endTime !=""&&endTime !=null){
				sql+=" and refunddate<= ?";
			}
			
			preparedStatement = connection.prepareStatement(sql);
			//设置问号的值
			//preparedStatement.setInt(1, id);
			int index=1;
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
		    	tongJiStudent t = new tongJiStudent();
		    	t.setSumreturnprice(rs.getInt(1));
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
	public List<tongJiStudent> getSwipeTeacher(String startTime,
			String endTime,String name) {
		// TODO Auto-generated method stub
		Connection connection = null;
		//操作对象
		PreparedStatement preparedStatement = null;
		//结果集
		ResultSet rs=null;
		
		//计算查询数据起始位置
		List<tongJiStudent> list=new ArrayList<tongJiStudent>();
		try {
			
			connection = DBUtil.getConnection();
			//String sql = "select ID,name,sex,tele,school,state,remark from t_student where name=? and tele=? and state=?";
			String sql = "SELECT a.teacher,a.classname,COUNT(swipedt) num FROM v_swipe_tongji a where 1=1";
			
			if (startTime!=""&&startTime!=null) {
				 sql+=" and swipedt>=?";
			}
			if (endTime!=""&&endTime!=null) {
				 sql+=" and swipedt<DATE_ADD(?,INTERVAL 1 day)";
			}
			if (name!=""&&name!=null) {
				sql+=" and teacher like ?";
			}
			sql+=" GROUP BY teacher";
			
			
			preparedStatement = connection.prepareStatement(sql);
			
			
			
			//设置问号的值
			//preparedStatement.setInt(1, id);
			int index=1;
			if(startTime !=""&&startTime !=null){
				preparedStatement.setString(index,startTime);
				index++;
			}
			if(endTime !=""&&endTime !=null){
				preparedStatement.setString(index,endTime);
				index++;
			}
			if(name !=""&&name !=null){
				preparedStatement.setString(index,"%"+name+"%");
				index++;
			}
			//执行sql
		    rs = preparedStatement.executeQuery();	
		    while(rs.next()){
		    	tongJiStudent t = new tongJiStudent();
		    	t.setSwipeteacher(rs.getString(1));
		    	t.setClassname(rs.getString(2));
		    	t.setSwipenum(rs.getInt(3));
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
	public List<tongJiStudent> getSwipeStudent(String startTime, String endTime,String name) {
		// TODO Auto-generated method stub
		Connection connection = null;
		//操作对象
		PreparedStatement preparedStatement = null;
		//结果集
		ResultSet rs=null;
		//计算查询数据起始位置
		List<tongJiStudent> list=new ArrayList<tongJiStudent>();
		try {
			
			connection = DBUtil.getConnection();
			//String sql = "select ID,name,sex,tele,school,state,remark from t_student where name=? and tele=? and state=?";
			
			String sql = "SELECT a.name,a.sex,a.school,a.tele,a.state_name,a.birth,COUNT(swipedt) num FROM v_swipe_tongji a WHERE 1=1";
			if (startTime!=""&&startTime!=null) {
				 sql+=" and swipedt>=?";
			}
			if (endTime!=""&&endTime!=null) {
				 sql+=" and swipedt<DATE_ADD(?,INTERVAL 1 day)";
			}
			if (name!=""&&name!=null) {
				sql+=" and name like ?";
			}
			
			sql+=" GROUP BY name";
			preparedStatement = connection.prepareStatement(sql);
			//设置问号的值
			//preparedStatement.setInt(1, id);
			int index=1;
			if(startTime !=""&&startTime !=null){
				preparedStatement.setString(index,startTime);
				index++;
			}
			if(endTime !=""&&endTime !=null){
				preparedStatement.setString(index,endTime);
				index++;
			}
			if(name !=""&&name !=null){
				preparedStatement.setString(index,"%"+name+"%");
				index++;
			}
			
			//执行sql
		    rs = preparedStatement.executeQuery();	
		    while(rs.next()){
		    	tongJiStudent t = new tongJiStudent();
		    	t.setName(rs.getString(1));
		    	t.setSex(rs.getString(2));
		    	t.setSchool(rs.getString(3));
		    	t.setTele(rs.getString(4));
		    	t.setState(rs.getString(5));
		    	t.setBirth(rs.getString(6));
		    	t.setSwipenum(rs.getInt(7));
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
	public List<tongJiStudent> getKeShi(String startYear, String startMonth,
			String endYear, String endMonth) {
		// TODO Auto-generated method stub
		Connection connection = null;
		//操作对象
		PreparedStatement preparedStatement = null;
		//结果集
		ResultSet rs=null;
		//计算查询数据起始位置
		List<tongJiStudent> list=new ArrayList<tongJiStudent>();
		try {
			
			connection = DBUtil.getConnection();
			//String sql = "select ID,name,sex,tele,school,state,remark from t_student where name=? and tele=? and state=?";
			
			String sql = "select c.ye,c.mon,c.amount,ifnull(a.num,0) xz_num,ifnull(b.num,0) xc_num,c.amount+ ifnull(a.num,0)-ifnull(b.num,0) byxz_num from t_month_jieyu c "
					+"left join ( select sum(b.classnum) as num,YEAR(a.pricetime) as ye ,MONTH(a.pricetime) as mon from t_pay a inner join t_addclass b where a.ifactive=1 group by YEAR(a.pricetime) ,MONTH(a.pricetime)) a on c.ye=a.ye and c.mon+1 =a.mon "
					+"left join(select count(swipedt) num ,YEAR(swipedt) as ye,month(swipedt) as mon from t_swipe a group by YEAR(swipedt),month(swipedt))b on c.ye=b.ye and c.mon+1=b.mon "
					+"where (c.ye>? or (c.ye=? and c.mon>=?))  and (c.ye<? or (c.ye=? and c.mon<=?))";
					
			
			
			
			preparedStatement = connection.prepareStatement(sql);
			//设置问号的值
			//preparedStatement.setInt(1, id);
			int index=1;
			if(startYear !=""&&startYear !=null){
				preparedStatement.setString(index,startYear);
				index++;
			}
			if(startYear !=""&&startYear !=null){
				preparedStatement.setString(index,startYear);
				index++;
			}
			if(startMonth !=""&&startMonth !=null){
				preparedStatement.setString(index,startMonth);
				index++;
			}
			if(endYear !=""&&endYear !=null){
				preparedStatement.setString(index,endYear);
				index++;
			}if(endYear !=""&&endYear !=null){
				preparedStatement.setString(index,endYear);
				index++;
			}
			if(endMonth !=""&&endMonth !=null){
				preparedStatement.setString(index,endMonth);
				index++;
			}
			//执行sql
		    rs = preparedStatement.executeQuery();	
		    while(rs.next()){
		    	tongJiStudent t = new tongJiStudent();
		    	t.setYear(rs.getInt(1));
		    	t.setMon(rs.getInt(2));
		    	t.setAmount(rs.getInt(3));
		    	t.setXznum(rs.getInt(4));
		    	t.setXcnum(rs.getInt(5));
		    	t.setByxznum(rs.getInt(6));
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
	public List<tongJiStudent> getTeachers() {
		// TODO Auto-generated method stub
Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet rs=null;
		
		List<tongJiStudent> list=new ArrayList<tongJiStudent>();
		
		try {
			connection = DBUtil.getConnection();
			String sql = "select distinct teacher from v_swipe_tongji";
			preparedStatement = connection.prepareStatement(sql);

			//ִ��sql
		    rs = preparedStatement.executeQuery();	
		    while(rs.next()){
		    	tongJiStudent t = new tongJiStudent();
                t.setName(rs.getString(1));
                
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
