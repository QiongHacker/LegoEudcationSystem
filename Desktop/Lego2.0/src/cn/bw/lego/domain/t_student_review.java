package cn.bw.lego.domain;
/**
 * ѧ���ط�ʵ����
 * @author Li dong cheng
 *
 */
public class t_student_review {
		//ѧ���طñ��е�ID����
		private int id;
		//ѧ���طñ��е�student_id����
		private int student_id;
		//ѧ���طñ��е�dt����
		private String dt;
	    //ѧ���طñ��е�content����
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
