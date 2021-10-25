package cn.bw.lego.dao;

import java.util.List;

import cn.bw.lego.domain.tongJiStudent;

public interface tongJiStudentDao {
				
	//���·ݲ�ѯѧ����Ϣ			
	public List<tongJiStudent> getStudentsForPageBean(String month,int page,int pageSize);
	//��������ȡ�ж���ѧ����Ϣ
	public int getStudentsCount(String month);
	//����ʱ��β�ѯ�ɷ���Ϣ
	public List<tongJiStudent> getShouFeiForPageBean(String startTime,String endTime,int page,int pageSize);
	//����ʱ��λ�ȡ�ж��ٽɷ���Ϣ
	public int getShouFeiCount(String startTime,String endTime);
	//�ϼƽ��
	public List<tongJiStudent> getTotalPrice(String startTime,String endTime);
	//����ʱ��β�ѯ�˷���Ϣ
		public List<tongJiStudent> getTuiFeiForPageBean(String startTime,String endTime,int page,int pageSize);
	//����ʱ��λ�ȡ�ж����˷���Ϣ
		public int getTuiFeiCount(String startTime,String endTime);
		//�ϼ��˷ѽ��
		public List<tongJiStudent> getTuiTotalPrice(String startTime,String endTime);
	//����ʦͳ��ʱ����ڴ��˴�
		public List<tongJiStudent> getSwipeTeacher(String startTime,String endTime,String name);
		//��ѧ��ͳ��ʱ����ڴ򿨴���
		
		public List<tongJiStudent> getSwipeStudent(String startTime,String endTime,String name);
		//������ͳ�ƿ�ʱ
		public List<tongJiStudent> getKeShi(String startYear,String startMonth,String endYear,String endMonth);
		//��ȡ���д���Ϣ�еĽ�ʦ
		
		public List<tongJiStudent> getTeachers();
		
}
