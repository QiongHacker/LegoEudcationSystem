package cn.bw.lego.dao;

import java.util.List;

import cn.bw.lego.domain.t_student;
import cn.bw.lego.domain.t_student_review;

/*
 * 学生回访
 */
public interface StudentReviewDao {
		//添加回访
	public boolean insert (t_student_review student);
	
		//查询所有回访
	public List<t_student_review> getAllStudent_reviews();
		//按条件查询回访
	public List<t_student_review> getReviews(int studentId);
	//分页
	public List<t_student_review> getReviewsForPageBean(int studentId,int page,int pageSize);
	//按条件获得总共有多少回访
		public int getReviewsCount(int studentId);
}
