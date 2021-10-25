package cn.bw.lego.dao;


import java.util.List;


import cn.bw.lego.domain.t_student;
import cn.bw.lego.domain.t_teacher;

/*
 * 教师数据层
 */
public interface TeacherDao {
	//添加教师
		public boolean insert (t_teacher teacher);
			
		//删除
		public boolean delete(int id);
		//更新
		public boolean update(t_teacher teacher);
		//查询所有教师
		public List<t_teacher> getAllTeachers();
		//按查询条件检索教师 ：一般对应你查询页面里的所有查询条件 假如有三个条件，我们就对应上三个参数
		public List<t_teacher> getTeachers(String name);
		//根据教师身份证号等查询教师是否存在
		public boolean checkUser(String shenFenId);
		//根据编号查询教师
		public t_teacher getTeacherById(int id);
		//分页
		public List<t_teacher> getTeachersForPageBean(String name,int page,int pageSize);
		//按条件获得总共有多少老师
		public int getTeachersCount(String name);
		
		
}
