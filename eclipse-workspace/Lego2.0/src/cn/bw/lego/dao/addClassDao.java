package cn.bw.lego.dao;

import java.util.List;

import cn.bw.lego.domain.addClass;
import cn.bw.lego.domain.t_payitem;
import cn.bw.lego.domain.t_student;




public interface addClassDao {
		
	
	//添加班级
	public boolean insert (addClass student);
	//修改
	public boolean update(addClass student);
	//按条件查询
	public List<addClass> getClassesForPageBean(String classname,String state,String teacher,int page,int pageSize);
	//按条件获得总共有多少班级
	public int getClassesCount(String classname,String state,String teacher);
	//通过ID查询
	public addClass getClassById(int id);
	//获取所有班级
	public List<addClass> getClasses();
	public boolean checkUser(String classname);

}
