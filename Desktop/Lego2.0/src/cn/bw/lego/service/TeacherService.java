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
			//�����ʦ���ھͲ������
			String shenFenId = t.getIdcard();
			if (!teacherDao.checkUser(shenFenId)) {     
				return teacherDao.insert(t);
			}
			
			
			return false;
			
			
		}
		
		public boolean delete(int id) {
			return teacherDao.delete(id);
		}
		//����
		public boolean updateTeacher(t_teacher teacher) {
			return teacherDao.update(teacher);
		}
		//��ѯ���н�ʦ
		public List<t_teacher> getAllTeachers() {
			return teacherDao.getAllTeachers();
		}
		//����ѯ����������ʦ ��һ���Ӧ���ѯҳ��������в�ѯ���� �������������������ǾͶ�Ӧ����������
		public List<t_teacher> getTeachers(String name) {
			return teacherDao.getTeachers(name);
		}
		//���ݽ�ʦ���֤�Ȳ�ѯ��ʦ�Ƿ��Ѵ���
		public boolean checkUser(String shenFenId){
			return teacherDao.checkUser(shenFenId);
			
		}
	
		public t_teacher getTeacherById(int id) {
			return teacherDao.getTeacherById(id);
		}
		//��ҳ
		public pageBean getTeachersForPageBean(String name,int page,int pageSize) 
		{
			
			//��������֯��ҳ����
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
