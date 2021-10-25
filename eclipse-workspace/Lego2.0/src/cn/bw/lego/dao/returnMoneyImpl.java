package cn.bw.lego.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.bw.lego.domain.getMoney;
import cn.bw.lego.domain.returnMoney;
import cn.bw.lego.domain.t_student;
import cn.bw.lego.utils.DBUtil;

public class returnMoneyImpl implements returnMoneyDao{

	@Override
	public boolean insert(returnMoney money) {
		// TODO Auto-generated method stub
		int line = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try{
			connection = DBUtil.getConnection();
			String sql = "insert into t_refund(name,school,tele,class_id,fee,dt,sf_id,student_id)values(?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, money.getName());
			preparedStatement.setString(2, money.getSchool());
			preparedStatement.setString(3, money.getTele());
			preparedStatement.setInt(4, money.getClass_id());
			preparedStatement.setInt(5, money.getFee());
			preparedStatement.setString(6, money.getDt());
			preparedStatement.setInt(7, money.getSf_id());
			preparedStatement.setInt(8, money.getStudent_id());
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
	public boolean update(int id) {
		int line = 0;
		//声明一个数据库连接对象
		
		Connection connection = null;
		
		//操作对象
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = DBUtil.getConnection();
			
			String sql = "update t_pay set ifactive=0 where student_id=?";
			
			preparedStatement = connection.prepareStatement(sql);
			//设置问号的值
			
			
			
			preparedStatement.setInt(1, id);
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
	public List<returnMoney> getStudentMoneyById(int sf_id) {
		// TODO Auto-generated method stub
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		List<returnMoney> list=new ArrayList<returnMoney>();
		ResultSet rs=null;
		
		
		try {
			
			connection = DBUtil.getConnection();
			String sql = "select student_name,sex,tele,school,birth,classname,course,coursenum,price,rate,finalprice,pricetime,state_name,give,give_lesson_num,give_money,give_remarks from v_pay where ifactive=1 and sf_id=?";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, sf_id);
			
		    rs = preparedStatement.executeQuery();	
		   while(rs.next()){
            returnMoney t = new returnMoney();
                t.setName(rs.getString(1));
                t.setSex(rs.getString(2));
                t.setTele(rs.getString(3));
                t.setSchool(rs.getString(4));
                t.setBirth(rs.getString(5));
                t.setClassname(rs.getString(6));
                t.setCoursename(rs.getString(7));
                t.setCoursenum(rs.getInt(8));
                t.setPrice(rs.getString(9));
                t.setRate(rs.getString(10));
                t.setFinalprice(rs.getInt(11));
                t.setPricetime(rs.getString(12));
                t.setGive(rs.getString(14));
                
                t.setGive_lesson_num(rs.getString(15));
                t.setGive_money(rs.getString(16));
                t.setGive_remarks(rs.getString(17));
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
	public returnMoney getBySf_Id(int sf_id) {
		// TODO Auto-generated method stub
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet rs=null;
		
		returnMoney t=null;
		try {
			
			connection = DBUtil.getConnection();
			String sql = "select student_name,sex,tele,school,birth,classname,course,coursenum,price,rate,finalprice,pricetime from v_pay where ifactive=1 and sf_id=?";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, sf_id);
			
		    rs = preparedStatement.executeQuery();	
		    if(rs.next()){
                t = new returnMoney();
                t.setName(rs.getString(1));
                t.setSex(rs.getString(2));
                t.setTele(rs.getString(3));
                t.setSchool(rs.getString(4));
                t.setBirth(rs.getString(5));
                t.setClassname(rs.getString(6));
                t.setCoursename(rs.getString(7));
                t.setCoursenum(rs.getInt(8));
                t.setPrice(rs.getString(9));
                t.setRate(rs.getString(10));
                t.setFinalprice(rs.getInt(11));
                t.setPricetime(rs.getString(12));
     
            }
		} catch (Exception e) {
            e.printStackTrace();
        } finally {
            // �ͷ���Դ
        	DBUtil.closeAll(rs, preparedStatement, connection);
        }
	
		return t;
	}

}
