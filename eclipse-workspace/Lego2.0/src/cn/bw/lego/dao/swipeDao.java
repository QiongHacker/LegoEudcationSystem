package cn.bw.lego.dao;

import java.util.List;

import cn.bw.lego.domain.swipe;
import cn.bw.lego.domain.t_student;

public interface swipeDao {
		
	
	
			//��ȡ��ǰ��ѧ����Ϣ
		public List<swipe> getCloseClass();
		
		public List<swipe> getOpenClass();
		//��Ӵ���Ϣ
		public boolean insert (swipe s);
		//����
		public boolean delete(int id);
		//��ѯ����Ϣ
		public List<swipe> getSwipesForPages(String classname,String startTime,String endTime,int page,int pageSize);
		
		public int getSwipesCount(String classname,String startTime,String endTime);
}
