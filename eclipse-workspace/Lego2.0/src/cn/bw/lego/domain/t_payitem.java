package cn.bw.lego.domain;
/*
 * �շ���Ŀ����ʵ����
 */
public class t_payitem {
	
			private int id;
			//�γ�����
			private String course;
			//�γ�����
			private String classType;
			//���ռ۸�
			private String finalprice;
			//�γ���Ŀ
			private String coursenum;
			//ԭ��
			private String price;
			//�Ż�
			private String rate;
			private String state_nameString;
			public String getState_nameString() {
				return state_nameString;
			}
			public void setState_nameString(String state_nameString) {
				this.state_nameString = state_nameString;
			}
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getCourse() {
				return course;
			}
			public void setCourse(String course) {
				this.course = course;
			}
			public String getClassType() {
				return classType;
			}
			public void setClassType(String string) {
				this.classType = string;
			}
			public String getFinalprice() {
				return finalprice;
			}
			public void setFinalprice(String finalprice) {
				this.finalprice = finalprice;
			}
			public String getCoursenum() {
				return coursenum;
			}
			public void setCoursenum(String coursenum) {
				this.coursenum = coursenum;
			}
			public String getPrice() {
				return price;
			}
			public void setPrice(String price) {
				this.price = price;
			}
			public String getRate() {
				return rate;
			}
			public void setRate(String rate) {
				this.rate = rate;
			}
			
			
			
}
