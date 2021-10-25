package cn.bw.lego.domain;
/*
 * 收费项目设置实体类
 */
public class t_payitem {
	
			private int id;
			//课程名称
			private String course;
			//课程类型
			private String classType;
			//最终价格
			private String finalprice;
			//课程数目
			private String coursenum;
			//原价
			private String price;
			//优惠
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
