package cn.bw.lego.dao;

import java.util.List;

import cn.bw.lego.domain.getMoney;
import cn.bw.lego.domain.t_student;

public interface getMoneyDao  {
		
	
	
	
		//添加收费
	
		public boolean insert(getMoney money);
		//查询收费
		public List<getMoney> getMoneysForPageBean(String studentId,String name,String classId,int page,int pageSize); 

		public int getMoneysCount(String studentId,String classId,String name);
		
		//根据收费id查询收费信息
		
		public getMoney getMoneyById(int id);
		//根据学生ID获取学生信息
		public List<getMoney> getStudentsById(String id);
		
		public boolean checkUser(int id);
}
