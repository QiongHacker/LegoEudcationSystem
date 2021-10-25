package cn.bw.lego.dao;

import java.util.List;

import cn.bw.lego.domain.t_payitem;
import cn.bw.lego.domain.t_student;


/*
 * �շ���Ŀ�������ݲ�
 */
public interface payitemDao {
		
	//�����Ŀ
		public boolean insert (t_payitem pay);
			
		//ɾ��
		public boolean delete(int id);
		//����
		public boolean update(t_payitem pay);
		//��ѯ������Ŀ
		public List<t_payitem> getAllitems();
		//����ѯ���������շ���ĿҪ ��һ���Ӧ���ѯҳ��������в�ѯ���� �������������������ǾͶ�Ӧ����������
		public List<t_payitem> getItem(String courseName,String classType);
		//���ݿγ̵Ȳ�ѯ�շ���Ŀ�Ƿ����
		public boolean checkUser(String itemName);
		//���ݱ�Ų�ѯ�շ���Ŀ
		public t_payitem getItemById(int id);
		//��ҳ
		public List<t_payitem> getItemsForPageBean(String courseName,String classType,int page,int pageSize);
		//����������ܹ��ж����շ���
		public int getItemsCount(String courseName,String classType);
		
		public List<t_payitem> getPayItems();
		
		public List<t_payitem> getPayItemsByClassId(String classId);
		
}
