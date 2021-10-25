package cn.bw.lego.domain;
/*
 * 学生实体类 
 * 
 * @author Li dong cheng
 *
 */
public class t_student {
	// 属性 : 学生信息表中ID属性
		private int id;
		// 属性: 学生信息表中name属性
		private String name;
		// 属性: 学生信息表中sex属性
		private String sex;
		// 属性：学生信息表中tele属性
		private String tele;
		// 属性：学生信息表中school属性
		private String school;
		// 属性：学生信息表中state属性
		private String state;
		// 属性：学生信息表中remark属性
		private String remark;
		//from属性
		private String from;
		//生日
		private String birth;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getTele() {
			return tele;
		}
		public void setTele(String tele) {
			this.tele = tele;
		}
		public String getSchool() {
			return school;
		}
		public void setSchool(String school) {
			this.school = school;
		}
		public String getState() {
			return state;
		}
		public void setState(String string) {
			this.state = string;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		public String getBirth() {
			return birth;
		}
		public void setBirth(String birth) {
			this.birth = birth;
		}
		public String getFrom() {
			return from;
		}
		public void setFrom(String from) {
			this.from = from;
		}
		
		
		
}
