package cn.bw.lego.dao;

import java.util.List;

import cn.bw.lego.domain.swipe;
import cn.bw.lego.domain.t_student;

public interface swipeDao {
		
	
	
			//获取当前教学班信息
		public List<swipe> getCloseClass();
		
		public List<swipe> getOpenClass();
		//添加打卡信息
		public boolean insert (swipe s);
		//修正
		public boolean delete(int id);
		//查询打卡信息
		public List<swipe> getSwipesForPages(String classname,String startTime,String endTime,int page,int pageSize);
		
		public int getSwipesCount(String classname,String startTime,String endTime);
}
