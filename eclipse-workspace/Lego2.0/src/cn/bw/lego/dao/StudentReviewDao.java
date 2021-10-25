package cn.bw.lego.dao;

import java.util.List;

import cn.bw.lego.domain.t_student;
import cn.bw.lego.domain.t_student_review;

/*
 * ѧ���ط�
 */
public interface StudentReviewDao {
		//��ӻط�
	public boolean insert (t_student_review student);
	
		//��ѯ���лط�
	public List<t_student_review> getAllStudent_reviews();
		//��������ѯ�ط�
	public List<t_student_review> getReviews(int studentId);
	//��ҳ
	public List<t_student_review> getReviewsForPageBean(int studentId,int page,int pageSize);
	//����������ܹ��ж��ٻط�
		public int getReviewsCount(int studentId);
}
