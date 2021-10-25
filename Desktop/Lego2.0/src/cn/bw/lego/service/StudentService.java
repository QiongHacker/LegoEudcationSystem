package cn.bw.lego.service;

import java.util.List;

import cn.bw.lego.dao.StudentDao;
import cn.bw.lego.dao.StudentDaoImpl;
import cn.bw.lego.domain.pageBean;
import cn.bw.lego.domain.t_student;

/*
 * ҵ���
 */
public class StudentService {
			private StudentDao studentDao = new StudentDaoImpl();
			
			public boolean addStudent(t_student student){
				//���ѧ���Ѿ����ڣ���ô�Ͳ��������
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
			//��������ѯ
			public List<t_student> getStudents(String name,String sex,String state){
				
				return studentDao.getStudents(name, sex, state);
							}
			//��ҳ
			public pageBean getStudentsForPageBean(String name, String sex, String state,int page,int pageSize) 
			{
				
				//��������֯��ҳ����
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
			//���ݽ�ѧ��ID��ȡѧ����Ϣ
			public List<t_student> getStudentByClassId(String class_id){
				return studentDao.getAllStudentsByClassId(class_id);
			}
			public List<t_student> getStudents(){
				return studentDao.getAllStudents();
							
			}
}
