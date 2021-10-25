package cn.bw.lego.service;

import java.util.List;

import cn.bw.lego.dao.returnMoneyDao;
import cn.bw.lego.dao.returnMoneyImpl;
import cn.bw.lego.domain.getMoney;
import cn.bw.lego.domain.returnMoney;
import cn.bw.lego.domain.t_student;

public class returnMoneyService {
				
			private returnMoneyDao returnMoneyDao = new returnMoneyImpl();
	
	
			public boolean updatePay(int t){
				
				
				return returnMoneyDao.update(t);	
			}
			public boolean insertPay(returnMoney t){
					
				return returnMoneyDao.insert(t);
				
			}
			public List<returnMoney> getStudentMoneyBySfId(int sf_id)
			{
				return returnMoneyDao.getStudentMoneyById(sf_id);
			}
			public returnMoney getBySfId(int sf_id)
			{
				return returnMoneyDao.getBySf_Id(sf_id);
			}
}
