package cn.bw.lego.dao;

import java.util.List;

import cn.bw.lego.domain.getMoney;
import cn.bw.lego.domain.t_student;

public interface getMoneyDao  {
		
	
	
	
		//����շ�
	
		public boolean insert(getMoney money);
		//��ѯ�շ�
		public List<getMoney> getMoneysForPageBean(String studentId,String name,String classId,int page,int pageSize); 

		public int getMoneysCount(String studentId,String classId,String name);
		
		//�����շ�id��ѯ�շ���Ϣ
		
		public getMoney getMoneyById(int id);
		//����ѧ��ID��ȡѧ����Ϣ
		public List<getMoney> getStudentsById(String id);
		
		public boolean checkUser(int id);
}
