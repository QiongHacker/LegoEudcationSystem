package cn.bw.lego.dao;


import java.util.List;

import cn.bw.lego.domain.getMoney;
import cn.bw.lego.domain.returnMoney;
import cn.bw.lego.domain.t_student;


public interface returnMoneyDao {
			//添加退费
	public boolean insert(returnMoney money);
			//修改pay中的ifactive
	public boolean update(int id);
				//根据收费id获取学生的详细信息
	public List<returnMoney> getStudentMoneyById(int sf_id);
	
	public returnMoney getBySf_Id(int sf_id);
}
