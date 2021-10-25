package cn.bw.lego.dao;

import java.util.List;

import cn.bw.lego.domain.t_student;
/*
 * ѧ�����ݲ�
 */
public interface StudentDao {
		
	
	//���ѧ��
	public boolean insert (t_student student);
		
	//ɾ��
	public boolean delete(int id);
	//����
	public boolean update(t_student student);
	//��ѯ����ѧ��
	public List<t_student> getAllStudents();
	//��ҳ��ѯ����ѧ��
	public List<t_student> getAllStudentsForPage();
	//����ѯ��������ѧ�� ��һ���Ӧ���ѯҳ��������в�ѯ���� �������������������ǾͶ�Ӧ����������
	public List<t_student> getStudents(String name,String tele,String state);
	//��ҳ
	public List<t_student> getStudentsForPageBean(String name, String sex, String state,int page,int pageSize);
	//����ѧ�������Ȳ�ѯѧ���Ƿ����
	public boolean checkUser(String tele,String name);
	//����������ܹ��ж���ѧ��
	public int getStudentsCount(String name, String sex, String state);
	//���ݱ�Ų�ѯѧ��
	public t_student getStudentById(int id);
	//���ݽ�ѧ��ID��ѧ����Ϣ
	public List<t_student> getAllStudentsByClassId(String class_id);
	public int getStudentsCount();
	//���ݰ༶ID��ȡ��ѧ����Ϣ
	
	
}
