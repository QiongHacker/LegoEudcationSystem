package cn.bw.lego.service;

import java.util.List;

import cn.bw.lego.dao.tongJiStudentDao;
import cn.bw.lego.dao.tongJiStudentDaoImpl;
import cn.bw.lego.domain.pageBean;
import cn.bw.lego.domain.t_student;
import cn.bw.lego.domain.t_teacher;
import cn.bw.lego.domain.tongJiStudent;


public class tongJiStudentService {
			
			private	tongJiStudentDao studentDao = new tongJiStudentDaoImpl();
			
			public pageBean getStudentsForPageBean(String month,int page,int pageSize) 
			{
				
				//在这里组织分页对象
				pageBean pagebean = new pageBean();
				pagebean.setCurPage(page);
				pagebean.setPageSize(pageSize);
				int totalCount = studentDao.getStudentsCount(month);
				pagebean.setTotalCount(totalCount);
				
				int totalPage = totalCount/pageSize;
				if (totalCount%pageSize>0) {
					totalPage++;
				}
				pagebean.setTotalPage(totalPage);
		List<tongJiStudent> list= studentDao.getStudentsForPageBean(month, page, pageSize);
			pagebean.setData(list);	
				return pagebean;
			}
	
			
			public pageBean getShouFeiForPageBean(String startTime,
					String endTime, int page, int pageSize) 
			{
				
				//在这里组织分页对象
				pageBean pagebean = new pageBean();
				pagebean.setCurPage(page);
				pagebean.setPageSize(pageSize);
				int totalCount = studentDao.getShouFeiCount(startTime, endTime);
				pagebean.setTotalCount(totalCount);
				
				int totalPage = totalCount/pageSize;
				if (totalCount%pageSize>0) {
					totalPage++;
				}
				pagebean.setTotalPage(totalPage);
		List<tongJiStudent> list= studentDao.getShouFeiForPageBean(startTime, endTime, page, pageSize);
			pagebean.setData(list);	
				return pagebean;
			}
			public List<tongJiStudent> getTotalPrice(String startTime,
					String endTime) {
						return studentDao.getTotalPrice(startTime, endTime);
				
			}
			
			
			public pageBean getTuiFeiForPageBean(String startTime,
					String endTime, int page, int pageSize) 
			{
				
				//在这里组织分页对象
				pageBean pagebean = new pageBean();
				pagebean.setCurPage(page);
				pagebean.setPageSize(pageSize);
				int totalCount = studentDao.getTuiFeiCount(startTime, endTime);
				pagebean.setTotalCount(totalCount);
				
				int totalPage = totalCount/pageSize;
				if (totalCount%pageSize>0) {
					totalPage++;
				}
				pagebean.setTotalPage(totalPage);
		List<tongJiStudent> list= studentDao.getTuiFeiForPageBean(startTime, endTime, page, pageSize);
			pagebean.setData(list);	
				return pagebean;
			}
			public List<tongJiStudent> getTotalTuiPrice(String startTime,
					String endTime) {
						return studentDao.getTuiTotalPrice(startTime, endTime);
				
			}
			
			public List<tongJiStudent> getStudentSwipe(String startTime,
					String endTime,String name) {
						return studentDao.getSwipeStudent(startTime, endTime,name);
				
			}
			public List<tongJiStudent> getTeacherSwipe(String startTime,
					String endTime,String name) {
						return studentDao.getSwipeTeacher(startTime, endTime,name);
				
			}
			public List<tongJiStudent> getKeShi(String startYear, String startMonth,
					String endYear, String endMonth) {
						return studentDao.getKeShi(startYear, startMonth, endYear, endMonth);
				
			}
			public List<tongJiStudent> getTeachers() {
						return studentDao.getTeachers();
				
			}
			
}
