package cn.bw.lego.dao;

import java.util.List;

import cn.bw.lego.domain.addClass;
import cn.bw.lego.domain.t_payitem;
import cn.bw.lego.domain.t_student;




public interface addClassDao {
		
	
	//��Ӱ༶
	public boolean insert (addClass student);
	//�޸�
	public boolean update(addClass student);
	//��������ѯ
	public List<addClass> getClassesForPageBean(String classname,String state,String teacher,int page,int pageSize);
	//����������ܹ��ж��ٰ༶
	public int getClassesCount(String classname,String state,String teacher);
	//ͨ��ID��ѯ
	public addClass getClassById(int id);
	//��ȡ���а༶
	public List<addClass> getClasses();
	public boolean checkUser(String classname);

}
