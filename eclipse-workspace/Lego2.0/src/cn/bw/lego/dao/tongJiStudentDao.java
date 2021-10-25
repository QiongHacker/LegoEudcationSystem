package cn.bw.lego.dao;

import java.util.List;

import cn.bw.lego.domain.tongJiStudent;

public interface tongJiStudentDao {
				
	//按月份查询学生信息			
	public List<tongJiStudent> getStudentsForPageBean(String month,int page,int pageSize);
	//按条件获取有多少学生信息
	public int getStudentsCount(String month);
	//根据时间段查询缴费信息
	public List<tongJiStudent> getShouFeiForPageBean(String startTime,String endTime,int page,int pageSize);
	//根据时间段获取有多少缴费信息
	public int getShouFeiCount(String startTime,String endTime);
	//合计金额
	public List<tongJiStudent> getTotalPrice(String startTime,String endTime);
	//根据时间段查询退费信息
		public List<tongJiStudent> getTuiFeiForPageBean(String startTime,String endTime,int page,int pageSize);
	//根据时间段获取有多少退费信息
		public int getTuiFeiCount(String startTime,String endTime);
		//合计退费金额
		public List<tongJiStudent> getTuiTotalPrice(String startTime,String endTime);
	//按教师统计时间段内打卡人次
		public List<tongJiStudent> getSwipeTeacher(String startTime,String endTime,String name);
		//按学生统计时间段内打卡次数
		
		public List<tongJiStudent> getSwipeStudent(String startTime,String endTime,String name);
		//按年月统计课时
		public List<tongJiStudent> getKeShi(String startYear,String startMonth,String endYear,String endMonth);
		//获取所有打卡信息中的教师
		
		public List<tongJiStudent> getTeachers();
		
}
