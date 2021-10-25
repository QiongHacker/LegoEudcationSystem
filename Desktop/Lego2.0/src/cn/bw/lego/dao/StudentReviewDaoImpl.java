package cn.bw.lego.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.bw.lego.domain.t_student;
import cn.bw.lego.domain.t_student_review;
import cn.bw.lego.utils.DBUtil;

public class StudentReviewDaoImpl implements StudentReviewDao {

	@Override
	public boolean insert(t_student_review student) {
		// TODO Auto-generated method stub
		int line = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "insert into t_student_review(Student_id,Dt,Content)values(?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getDt());
			preparedStatement.setString(3, student.getContent());
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
	public List<t_student_review> getAllStudent_reviews() {
		// TODO Auto-generated method stub
		//����һ�����ݿ����Ӷ���
		Connection connection = null;
		//��������
		PreparedStatement preparedStatement = null;
		//�����
		ResultSet rs=null;
		
		List<t_student_review> list= new ArrayList<t_student_review>();
		try {
			connection = DBUtil.getConnection();
			String sql = "select ID,Student_id,Dt,content from t_student_review";
			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while(rs.next()){
		    	t_student_review t = new t_student_review();
                t.setId(rs.getInt(0));
                t.setStudent_id(rs.getInt(1));
                t.setDt(rs.getString(2));
                t.setContent(rs.getString(3));
               
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

	public List<t_student_review> getReviews(int studentId) {
		// TODO Auto-generated method stub
		
		List<t_student_review> list = new ArrayList<t_student_review>();
		Connection connection = null;
		//��������
		PreparedStatement preparedStatement = null;
		//�����
		ResultSet rs=null;
		try {
			connection = DBUtil.getConnection();
			//String sql = "select ID,name,sex,tele,school,state,remark from t_student where name=? and tele=? and state=?";
			
			String sql = "select ID,Student_id,Dt,content from t_student_review where 1=1";
			
			String val=studentId +"";
			if(val!=""&&val!=null){
				sql+=" and Student_id=?";
			}
			
			
			preparedStatement = connection.prepareStatement(sql);
			//�����ʺŵ�ֵ
			//preparedStatement.setInt(1, id);
			int index=1;
			if(val!=""&&val!=null){
				preparedStatement.setString(index, val);
				index++;
			}
			
			 rs = preparedStatement.executeQuery();	
			    while(rs.next()){
			    	t_student_review t = new t_student_review();
	                t.setId(rs.getInt(0));
	                t.setStudent_id(rs.getInt(1));
	                t.setDt(rs.getString(2));
	               
	               
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
	public List<t_student_review> getReviewsForPageBean(int studentId,
			int page, int pageSize) {
		List<t_student_review> list = new ArrayList<t_student_review>();
		Connection connection = null;
		//��������
		PreparedStatement preparedStatement = null;
		//�����
		ResultSet rs=null;
		
		int startpos=(page-1)*pageSize;
		try {
			connection = DBUtil.getConnection();
			//String sql = "select ID,name,sex,tele,school,state,remark from t_student where name=? and tele=? and state=?";
			
			String sql = "select ID,Student_id,Dt,Content,name from v_student_review where 1=1";
			
			String val=studentId +"";
			if(val!=""&&val!=null){
				sql+=" and Student_id=?";
			}
			//�����ѯ�ܶ������ݣ�����Ҫ����һ�£�������֤ÿ�β�ѯ������˳��Ҫ����һ��
			
			sql+=" order by ID limit "+startpos+","+pageSize;
			
			preparedStatement = connection.prepareStatement(sql);
			//�����ʺŵ�ֵ
			//preparedStatement.setInt(1, id);
			int index=1;
			if(val!=""){
				preparedStatement.setString(index, val);
				index++;
			}
			
			 rs = preparedStatement.executeQuery();	
			    while(rs.next()){
			    	t_student_review t = new t_student_review();
	                t.setId(rs.getInt(1));
	                t.setStudent_id(rs.getInt(2));
	                t.setDt(rs.getString(3));
	                t.setContent(rs.getString(4));
	                t.setName(rs.getString(5));
	               
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
	public int getReviewsCount(int studentId) {
		Connection connection = null;
		//��������
		PreparedStatement preparedStatement = null;
		//�����
		ResultSet rs=null;
		//�����ѯ������ʼλ��
		
		
		
		
		try {
			
			connection = DBUtil.getConnection();
			//String sql = "select ID,name,sex,tele,school,state,remark from t_student where name=? and tele=? and state=?";
			
			String sql = "SELECT count(*) FROM t_student_review where 1=1";
			
			 
			String t = studentId+"";
			if(t!=""&&t!=null){
				sql+=" and Student_id=?";
			}
			
			
			
			
			preparedStatement = connection.prepareStatement(sql);
			//�����ʺŵ�ֵ
			//preparedStatement.setInt(1, id);
			int index=1;
			if(t!=""&&t!=null){
				preparedStatement.setString(index, t);
				index++;
			}
			
			//ִ��sql
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
