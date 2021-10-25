package cn.bw.lego.domain;
/**
 * 学生回访实体类
 * @author Li dong cheng
 *
 */
public class t_student_review {
		//学生回访表中的ID属性
		private int id;
		//学生回访表中的student_id属性
		private int student_id;
		//学生回访表中的dt属性
		private String dt;
	    //学生回访表中的content属性
		private String content;
		//name
		private String name;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getStudent_id() {
			return student_id;
		}
		public void setStudent_id(int student_id) {
			this.student_id = student_id;
		}
		public String getDt() {
			return dt;
		}
		public void setDt(String dt) {
			this.dt = dt;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		
}
