package cn.bw.lego.service;


import java.util.List;

import cn.bw.lego.dao.StudentReviewDao;
import cn.bw.lego.dao.StudentReviewDaoImpl;
import cn.bw.lego.domain.pageBean;
import cn.bw.lego.domain.t_student;
import cn.bw.lego.domain.t_student_review;

public class StudentReviewService {
			private StudentReviewDao reviewDao = new StudentReviewDaoImpl();
			
			public boolean addReview(t_student_review t){
				return reviewDao.insert(t);
				
				
				
			}
			public List<t_student_review> getAllReviews (){
				
				return reviewDao.getAllStudent_reviews();
				
				
			}
			public List<t_student_review> getReviewByStudent_id (int id){
				return reviewDao.getReviews(id);
				
				
				
			} 	
			public pageBean getReviewsForPageBean(int studentId,int page,int pageSize) 
			{
				
				//在这里组织分页对象
				pageBean pagebean = new pageBean();
				pagebean.setCurPage(page);
				pagebean.setPageSize(pageSize);
				int totalCount = reviewDao.getReviewsCount(studentId);
				pagebean.setTotalCount(totalCount);
				
				int totalPage = totalCount/pageSize;
				if (totalCount%pageSize>0) {
					totalPage++;
				}
				pagebean.setTotalPage(totalPage);
		List<t_student_review> list= reviewDao.getReviewsForPageBean(studentId, page, pageSize);
			pagebean.setData(list);	
				return pagebean;
			}	
			
			
			
			
			
}
