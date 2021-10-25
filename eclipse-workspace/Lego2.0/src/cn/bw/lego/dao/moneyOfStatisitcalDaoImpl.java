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
		//����һ�����ݿ����Ӷ���
				Connection connection = null;
				//��������
				PreparedStatement preparedStatement = null;
				//�����
				ResultSet rs=null;
				//�����ѯ������ʼλ��
				
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
					
					//�����ѯ�ܶ������ݣ�����Ҫ����һ�£�������֤ÿ�β�ѯ������˳��Ҫ����һ��
					
					sql+=" order by ID limit "+startpos+","+pageSize;
					
					
					
					
					preparedStatement = connection.prepareStatement(sql);
					//�����ʺŵ�ֵ
				
					int index=1;
					if(startTime !=""&&startTime !=null){
						preparedStatement.setString(index,startTime);
						index++;
					}
					if(endTime !=""&&endTime !=null){
						preparedStatement.setString(index,endTime);
						index++;
					}
					
					//ִ��sql
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
		            // �ͷ���Դ
		        	DBUtil.closeAll(rs, preparedStatement, connection);
		        }
			
		return list;

	}

	@Override
	public int getMoneyCount(String startTime, String endTime) {
		// TODO Auto-generated method stub
		Connection connection = null;
		//��������
		PreparedStatement preparedStatement = null;
		//�����
		ResultSet rs=null;
		//�����ѯ������ʼλ��	
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
            // �ͷ���Դ
        	DBUtil.closeAll(rs, preparedStatement, connection);
        }







return 0;
	}
					
}
