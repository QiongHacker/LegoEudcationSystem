package cn.bw.lego.dao;


import java.util.List;

import cn.bw.lego.domain.getMoney;
import cn.bw.lego.domain.returnMoney;
import cn.bw.lego.domain.t_student;


public interface returnMoneyDao {
			//����˷�
	public boolean insert(returnMoney money);
			//�޸�pay�е�ifactive
	public boolean update(int id);
				//�����շ�id��ȡѧ������ϸ��Ϣ
	public List<returnMoney> getStudentMoneyById(int sf_id);
	
	public returnMoney getBySf_Id(int sf_id);
}
