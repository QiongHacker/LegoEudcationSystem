package cn.bw.lego.service;

import java.util.List;

import cn.bw.lego.dao.getMoneyDao;
import cn.bw.lego.dao.getMoneyImpl;
import cn.bw.lego.domain.getMoney;
import cn.bw.lego.domain.listening;
import cn.bw.lego.domain.pageBean;
import cn.bw.lego.domain.t_student;

public class getMoneyService {
				private getMoneyDao moneyDao =new getMoneyImpl();
				
				public boolean insertMoney (getMoney money){
					int id = money.getStudent_id();
				
					boolean bol = moneyDao.checkUser(id);
					if (bol==false) {     
						return moneyDao.insert(money);
					}
					return false;
					
					
				}
				public getMoney getMoneyById(int id)
				{
					return moneyDao.getMoneyById(id);
				}
				public List<getMoney> getStudentById(String id){
					return moneyDao.getStudentsById(id);
				}
				
				
				
				public pageBean getMoneyForPageBean (String studentId,String classId,String name,int page,int pageSize){
					pageBean pagebean = new pageBean();
					pagebean.setCurPage(page);
					pagebean.setPageSize(pageSize);
					int totalCount = moneyDao.getMoneysCount(studentId, classId,name);
					pagebean.setTotalCount(totalCount);
					
					int totalPage = totalCount/pageSize;
					if (totalCount%pageSize>0) {
						totalPage++;
							
					}
					pagebean.setTotalPage(totalPage);
					List<getMoney> list= moneyDao.getMoneysForPageBean(studentId, classId, name , page, pageSize);
					pagebean.setData(list);	
						
						return pagebean;
						
				}
	
}
