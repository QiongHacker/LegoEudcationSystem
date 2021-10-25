package cn.bw.lego.dao;

import java.util.List;

import cn.bw.lego.domain.t_payitem;
import cn.bw.lego.domain.t_student;


/*
 * 收费项目设置数据层
 */
public interface payitemDao {
		
	//添加项目
		public boolean insert (t_payitem pay);
			
		//删除
		public boolean delete(int id);
		//更新
		public boolean update(t_payitem pay);
		//查询所有项目
		public List<t_payitem> getAllitems();
		//按查询条件检索收费项目要 ：一般对应你查询页面里的所有查询条件 假如有三个条件，我们就对应上三个参数
		public List<t_payitem> getItem(String courseName,String classType);
		//根据课程等查询收费项目是否存在
		public boolean checkUser(String itemName);
		//根据编号查询收费项目
		public t_payitem getItemById(int id);
		//分页
		public List<t_payitem> getItemsForPageBean(String courseName,String classType,int page,int pageSize);
		//按条件获得总共有多少收费项
		public int getItemsCount(String courseName,String classType);
		
		public List<t_payitem> getPayItems();
		
		public List<t_payitem> getPayItemsByClassId(String classId);
		
}
