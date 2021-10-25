package cn.bw.lego.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.bw.lego.domain.moneyOfStatistical;
import cn.bw.lego.utils.DBUtil;

public class moneyOfStatisitcalDaoImpl implements moneyOfStatisticalDao {

	@Override
	public List<moneyOfStatistical> getmoneyOfStatistical(String startTime,
			String endTime, int page, int pageSize) {
		// TODO Auto-generated method stub
		List<moneyOfStatistical> list=new ArrayList<moneyOfStatistical>();
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
					
					String sql = "select ID,name,school,tele,classname,finalprice,pricetime from v_moneyplan where 1=1";
					
					 //pricetime>= ? and pricetime<= ?
					if(startTime !=""&&startTime !=null){
						sql+=" and pricetime>= ?";
					}
					if(endTime !=""&&endTime !=null){
						sql+=" and pricetime<DATE_ADD(? ,INTERVAL 1 day)";
					}
					
					//如果查询很多条数据，尽量要排序一下，这样保证每次查询出来的顺序要保持一致
					
					sql+=" order by ID limit "+startpos+","+pageSize;
					
					
					
					
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
				    	moneyOfStatistical t = new moneyOfStatistical();
		                t.setId(rs.getInt(1));
		                t.setName(rs.getString(2));
		                t.setSchool(rs.getString(3));
		                t.setTele(rs.getString(4));
		               t.setClassname(rs.getString(5));
		                t.setPrice(rs.getInt(6));
		               t.setDt(rs.getString(7));
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
	public int getMoneyCount(String startTime, String endTime) {
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
			
			String sql = "SELECT count(*) FROM v_moneyplan where 1=1";
			if(startTime !=""&&startTime !=null){
				sql+=" and pricetime>= ?";
			}
			if(endTime !=""&&endTime !=null){
				sql+=" and pricetime<= ?";
			}
			preparedStatement = connection.prepareStatement(sql);
			
			
			int index=1;
			if(startTime!=""&&startTime!=null){
				preparedStatement.setString(index,startTime);
				index++;
			}
			if(endTime!=""&&endTime!=null){
				preparedStatement.setString(index, endTime);
				index++;
			}
			
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
