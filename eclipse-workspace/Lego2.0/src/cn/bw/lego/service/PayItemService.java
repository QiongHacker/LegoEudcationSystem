package cn.bw.lego.service;

import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.bw.lego.dao.addClassDao;
import cn.bw.lego.dao.addClassDaoImpl;
import cn.bw.lego.dao.payitemDao;
import cn.bw.lego.dao.payitemDaoImpl;
import cn.bw.lego.domain.pageBean;
import cn.bw.lego.domain.t_payitem;
import cn.bw.lego.domain.t_student;

/**
 * 
 * @author Li dong cheng
 *
 */
public class PayItemService {
			private payitemDao payitemDao = new payitemDaoImpl();
			private addClassDao addClassDao = new addClassDaoImpl(); 
			public boolean addPayitem(t_payitem t){
				//如果学生已经存在，那么就不再添加了
				
				String itemName = t.getCourse();
						
				
				if (!payitemDao.checkUser(itemName)) {
					return payitemDao.insert(t);
				}
				return false;
				
				
			}
			public boolean updatePayitem(t_payitem t){
				return payitemDao.update(t);
				
			}
			public boolean deletePayitem(int id){
				
				return payitemDao.delete(id);
			}
			public List<t_payitem> getAllPayitems(){
				
				return payitemDao.getAllitems();
								
			}
			//按条件查询
			public List<t_payitem> getPayitems(String courseName,String classType){
				
				return payitemDao.getItem(courseName, classType);
							}
			
public List<t_payitem> getPayItemsByClassId(String classId){
				
				return payitemDao.getPayItemsByClassId(classId);
							}
			
			
			
			public t_payitem getPayitemByid(int id)
			{
				return payitemDao.getItemById(id);
			}
			
			public pageBean getItemsForPageBean(String courseName,
					String classType, int page, int pageSize) 
			{
				
				//在这里组织分页对象
				pageBean pagebean = new pageBean();
				pagebean.setCurPage(page);
				pagebean.setPageSize(pageSize);
				int totalCount =payitemDao.getItemsCount(courseName,classType);
				pagebean.setTotalCount(totalCount);
				
				int totalPage = totalCount/pageSize;
				if (totalCount%pageSize>0) {
					totalPage++;
				}
				pagebean.setTotalPage(totalPage);
		List<t_payitem> list= payitemDao.getItemsForPageBean(courseName,classType, page, pageSize);
			pagebean.setData(list);	
				return pagebean;
			
			}
			
			};

