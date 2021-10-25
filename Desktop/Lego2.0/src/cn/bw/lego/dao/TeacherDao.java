package cn.bw.lego.dao;


import java.util.List;


import cn.bw.lego.domain.t_student;
import cn.bw.lego.domain.t_teacher;

/*
 * ��ʦ���ݲ�
 */
public interface TeacherDao {
	//��ӽ�ʦ
		public boolean insert (t_teacher teacher);
			
		//ɾ��
		public boolean delete(int id);
		//����
		public boolean update(t_teacher teacher);
		//��ѯ���н�ʦ
		public List<t_teacher> getAllTeachers();
		//����ѯ����������ʦ ��һ���Ӧ���ѯҳ��������в�ѯ���� �������������������ǾͶ�Ӧ����������
		public List<t_teacher> getTeachers(String name);
		//���ݽ�ʦ���֤�ŵȲ�ѯ��ʦ�Ƿ����
		public boolean checkUser(String shenFenId);
		//���ݱ�Ų�ѯ��ʦ
		public t_teacher getTeacherById(int id);
		//��ҳ
		public List<t_teacher> getTeachersForPageBean(String name,int page,int pageSize);
		//����������ܹ��ж�����ʦ
		public int getTeachersCount(String name);
		
		
}
