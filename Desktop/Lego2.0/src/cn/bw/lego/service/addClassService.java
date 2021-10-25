package cn.bw.lego.service;

import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.bw.lego.dao.addClassDao;
import cn.bw.lego.dao.addClassDaoImpl;
import cn.bw.lego.dao.payitemDao;
import cn.bw.lego.dao.payitemDaoImpl;
import cn.bw.lego.domain.addClass;
import cn.bw.lego.domain.listening;
import cn.bw.lego.domain.pageBean;
import cn.bw.lego.domain.t_payitem;


public class addClassService {
			private addClassDao addClassDao = new addClassDaoImpl();
			private payitemDao payitemDao = new payitemDaoImpl();
			public boolean addClasses(addClass t){
				
				
				String classname = t.getClassName();
				boolean bol = addClassDao.checkUser(classname);
				if (bol==false) {     
					return addClassDao.insert(t);
				}
				
				return false;
				
				
				
				
				
			}
			
			public boolean updateClasses(addClass t){
				
				
				return addClassDao.update(t);
				
			}
			public pageBean getClassesForPageBean(String classname,String state,String teacher,int page,int pageSize){
				pageBean pagebean = new pageBean();
				
				pagebean.setCurPage(page);
				
				pagebean.setPageSize(pageSize);
				
				int totalCount = addClassDao.getClassesCount(classname, state, teacher);
				
				pagebean.setTotalCount(totalCount);
				
				int totalPage = totalCount/pageSize;
				if (totalCount%pageSize>0) {
					totalPage++;
				}
				pagebean.setTotalPage(totalPage);
				List<addClass> list = addClassDao.getClassesForPageBean(classname, state, teacher, page, pageSize);
				pagebean.setData(list);	
				return pagebean;
				
				
			}
			public addClass getClassesById(int id){
				
				return addClassDao.getClassById(id);
				
			}
			public List<t_payitem> getItemById(){
				
				return payitemDao.getPayItems();
							}
			public List<addClass> getClasses(){
				
				return addClassDao.getClasses();
			}
			
}
