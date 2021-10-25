package cn.bw.lego.service;

import java.util.List;

import cn.bw.lego.dao.StudentDao;
import cn.bw.lego.dao.StudentDaoImpl;
import cn.bw.lego.domain.pageBean;
import cn.bw.lego.domain.t_student;

/*
 * 业务层
 */
public class StudentService {
			private StudentDao studentDao = new StudentDaoImpl();
			
			public boolean addStudent(t_student student){
				//如果学生已经存在，那么就不再添加了
				String tele = student.getTele();
				String name = student.getName();
				boolean bol = studentDao.checkUser(tele,name);
				if (bol==false) {     
					return studentDao.insert(student);
				}
				
				return false;
				
				
			}
			public boolean updateStudent(t_student t){
				return studentDao.update(t);
				
			}
			public boolean deleteStduent(int id){
				
				return studentDao.delete(id);
			}
			public List<t_student> getAllStudent(){
				
				return studentDao.getAllStudents();
								
			}
			//按条件查询
			public List<t_student> getStudents(String name,String sex,String state){
				
				return studentDao.getStudents(name, sex, state);
							}
			//分页
			public pageBean getStudentsForPageBean(String name, String sex, String state,int page,int pageSize) 
			{
				
				//在这里组织分页对象
				pageBean pagebean = new pageBean();
				pagebean.setCurPage(page);
				pagebean.setPageSize(pageSize);
				int totalCount = studentDao.getStudentsCount(name, sex, state);
				pagebean.setTotalCount(totalCount);
				
				int totalPage = totalCount/pageSize;
				if (totalCount%pageSize>0) {
					totalPage++;
				}
				pagebean.setTotalPage(totalPage);
		List<t_student> list= studentDao.getStudentsForPageBean(name, sex, state, page, pageSize);
			pagebean.setData(list);	
				return pagebean;
			}
			public List<t_student> getStudents(t_student t){
				return studentDao.getStudents(t.getName(),t.getTele(), ""+t.getState()); 
							
			}
			public t_student getStudentById(int id)
			{
				return studentDao.getStudentById(id);
			}
			//根据教学班ID获取学生信息
			public List<t_student> getStudentByClassId(String class_id){
				return studentDao.getAllStudentsByClassId(class_id);
			}
			public List<t_student> getStudents(){
				return studentDao.getAllStudents();
							
			}
}
