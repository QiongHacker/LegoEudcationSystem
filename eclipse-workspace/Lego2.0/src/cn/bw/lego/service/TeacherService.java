package cn.bw.lego.service;

import java.util.List;

import cn.bw.lego.dao.TeacherDao;
import cn.bw.lego.dao.TeacherDaoImpl;
import cn.bw.lego.domain.pageBean;
import cn.bw.lego.domain.t_student;
import cn.bw.lego.domain.t_teacher;

public class TeacherService {
		private TeacherDao teacherDao = new TeacherDaoImpl();
		public boolean addTeacher (t_teacher t){
			//如果老师存在就不添加了
			String shenFenId = t.getIdcard();
			if (!teacherDao.checkUser(shenFenId)) {     
				return teacherDao.insert(t);
			}
			
			
			return false;
			
			
		}
		
		public boolean delete(int id) {
			return teacherDao.delete(id);
		}
		//更新
		public boolean updateTeacher(t_teacher teacher) {
			return teacherDao.update(teacher);
		}
		//查询所有教师
		public List<t_teacher> getAllTeachers() {
			return teacherDao.getAllTeachers();
		}
		//按查询条件检索教师 ：一般对应你查询页面里的所有查询条件 假如有三个条件，我们就对应上三个参数
		public List<t_teacher> getTeachers(String name) {
			return teacherDao.getTeachers(name);
		}
		//根据教师身份证等查询教师是否已存在
		public boolean checkUser(String shenFenId){
			return teacherDao.checkUser(shenFenId);
			
		}
	
		public t_teacher getTeacherById(int id) {
			return teacherDao.getTeacherById(id);
		}
		//分页
		public pageBean getTeachersForPageBean(String name,int page,int pageSize) 
		{
			
			//在这里组织分页对象
			pageBean pagebean = new pageBean();
			pagebean.setCurPage(page);
			pagebean.setPageSize(pageSize);
			int totalCount = teacherDao.getTeachersCount(name);
			pagebean.setTotalCount(totalCount);
			
			int totalPage = totalCount/pageSize;
			if (totalCount%pageSize>0) {
				totalPage++;
			}
			pagebean.setTotalPage(totalPage);
	List<t_teacher> list= teacherDao.getTeachersForPageBean(name,page, pageSize);
		pagebean.setData(list);	
			return pagebean;
		}
		
		
}
