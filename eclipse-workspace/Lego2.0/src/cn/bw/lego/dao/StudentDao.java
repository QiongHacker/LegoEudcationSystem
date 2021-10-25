package cn.bw.lego.dao;

import java.util.List;

import cn.bw.lego.domain.t_student;
/*
 * 学生数据层
 */
public interface StudentDao {
		
	
	//添加学生
	public boolean insert (t_student student);
		
	//删除
	public boolean delete(int id);
	//更新
	public boolean update(t_student student);
	//查询所有学生
	public List<t_student> getAllStudents();
	//分页查询所有学生
	public List<t_student> getAllStudentsForPage();
	//按查询条件检索学生 ：一般对应你查询页面里的所有查询条件 假如有三个条件，我们就对应上三个参数
	public List<t_student> getStudents(String name,String tele,String state);
	//分页
	public List<t_student> getStudentsForPageBean(String name, String sex, String state,int page,int pageSize);
	//根据学生姓名等查询学生是否存在
	public boolean checkUser(String tele,String name);
	//按条件获得总共有多少学生
	public int getStudentsCount(String name, String sex, String state);
	//根据编号查询学生
	public t_student getStudentById(int id);
	//根据教学班ID获学生信息
	public List<t_student> getAllStudentsByClassId(String class_id);
	public int getStudentsCount();
	//根据班级ID获取教学班信息
	
	
}
