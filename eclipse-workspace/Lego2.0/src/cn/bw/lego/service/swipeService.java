package cn.bw.lego.service;

import java.util.List;

import cn.bw.lego.dao.swipeDao;
import cn.bw.lego.dao.swipeDaoImpl;
import cn.bw.lego.domain.pageBean;
import cn.bw.lego.domain.swipe;
import cn.bw.lego.domain.t_student;
import cn.bw.lego.domain.t_teacher;


public class swipeService {
	
	private swipeDao studentDao = new swipeDaoImpl();
	public List<swipe> getCloseClasses()
	{
	return studentDao.getCloseClass();
	}
	public List<swipe> getOpenClass(){
		
	return studentDao.getOpenClass();
		
	}
	//根据班级名称时间段查询打卡记录
	public pageBean getSwipesForPageBean(String classname, String startTime,
			String endTime, int page, int pageSize) 
	{
		
		//在这里组织分页对象
		pageBean pagebean = new pageBean();
		pagebean.setCurPage(page);
		pagebean.setPageSize(pageSize);
		int totalCount = studentDao.getSwipesCount(classname, startTime, endTime);
		pagebean.setTotalCount(totalCount);
		
		int totalPage = totalCount/pageSize;
		if (totalCount%pageSize>0) {
			totalPage++;
		}
		pagebean.setTotalPage(totalPage);
List<swipe> list= studentDao.getSwipesForPages(classname, startTime, endTime, page, pageSize);
	pagebean.setData(list);	
		return pagebean;
	}
	//根据学生id删除打卡信息
	public boolean deleteSwipe(int id){
		return studentDao.delete(id);
	}
	//添加打卡记录
	public boolean insertSwipe(swipe s){
		
		return studentDao.insert(s);
		
	}
}
