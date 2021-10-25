package cn.bw.lego.service;

import java.util.List;

import cn.bw.lego.dao.ListeningDao;
import cn.bw.lego.dao.ListeningDaoImpl;
import cn.bw.lego.domain.listening;
import cn.bw.lego.domain.pageBean;
import cn.bw.lego.domain.t_student;

public class ListeningService {
			
			private ListeningDao listen = new  ListeningDaoImpl();
			
			public boolean addListen(listening t){
				
				//如果学生已经存在，那么就不再添加了
				String tele = t.getTele();
				String name = t.getName();
				boolean bol = listen.checkUser(tele,name);
				if (bol==false) {     
					return listen.insert(t);
				}
				
				return false;	
				
				
				
				
				
				
				
			}	
			public boolean updateListen (listening t){
				return listen.update(t);
				
			}
			public pageBean getClassesForPageBean (String name,String classType,String teacher,int page,int pageSize){
				pageBean pagebean = new pageBean();
				pagebean.setCurPage(page);
				pagebean.setPageSize(pageSize);
				int totalCount = listen.getListeningCount(name, classType, teacher);
				pagebean.setTotalCount(totalCount);
				
				int totalPage = totalCount/pageSize;
				if (totalCount%pageSize>0) {
					totalPage++;
						
				}
				pagebean.setTotalPage(totalPage);
				List<listening> list= listen.getListenings(name, classType, teacher, totalPage, pageSize);
				pagebean.setData(list);	
					
					return pagebean;
					
			}
			public listening getListeningsById(int id){
				return listen.getListeningsById(id);
				
				
			}
	
}
