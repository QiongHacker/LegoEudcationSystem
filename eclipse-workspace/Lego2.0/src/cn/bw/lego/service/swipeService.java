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
	//���ݰ༶����ʱ��β�ѯ�򿨼�¼
	public pageBean getSwipesForPageBean(String classname, String startTime,
			String endTime, int page, int pageSize) 
	{
		
		//��������֯��ҳ����
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
	//����ѧ��idɾ������Ϣ
	public boolean deleteSwipe(int id){
		return studentDao.delete(id);
	}
	//��Ӵ򿨼�¼
	public boolean insertSwipe(swipe s){
		
		return studentDao.insert(s);
		
	}
}
