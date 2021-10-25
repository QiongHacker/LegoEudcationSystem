package cn.bw.lego.domain;

public class getMoney {
		private int id;
		
		private int student_id;
		private int sf_id;
		private int class_id;
		private String classname;
		private String price;
		
		private String rate;
		
		private int finalprice;
		
		private String pricetime;
		
		private int ifactive;
		
		private String name;
		
		private String course;
		//收费状态 1为新生 0不为新生
		private String state1;
		//状态是否为续费 1为续费 0 为不续费
		private String state2;
		
		//业绩归属人id
		private String teacher_id;
		//赠送 1为赠送课时 2为赠送物品
		private String give;
		//赠送课时节数
		private String give_lesson_num;
		//赠品价格
		private String give_money;
		//赠品备注
		private String give_remarks;
		
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

		public int getClass_id() {
			return class_id;
		}

		public void setClass_id(int class_id) {
			this.class_id = class_id;
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

		public int getFinalprice() {
			return finalprice;
		}

		public void setFinalprice(int finalprice) {
			this.finalprice = finalprice;
		}

		public String getPricetime() {
			return pricetime;
		}

		public void setPricetime(String pricetime) {
			this.pricetime = pricetime;
		}

		public int getIfactive() {
			return ifactive;
		}

		public void setIfactive(int ifactive) {
			this.ifactive = ifactive;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCourse() {
			return course;
		}

		public void setCourse(String course) {
			this.course = course;
		}

		public int getSf_id() {
			return sf_id;
		}

		public void setSf_id(int sf_id) {
			this.sf_id = sf_id;
		}

		public String getClassname() {
			return classname;
		}

		public void setClassname(String classname) {
			this.classname = classname;
		}

		
		public String getGive_remarks() {
			return give_remarks;
		}

		public void setGive_remarks(String give_remarks) {
			this.give_remarks = give_remarks;
		}

		public String getState1() {
			return state1;
		}

		public void setState1(String state1) {
			this.state1 = state1;
		}

		public String getState2() {
			return state2;
		}

		public void setState2(String state2) {
			this.state2 = state2;
		}

		public String getTeacher_id() {
			return teacher_id;
		}

		public void setTeacher_id(String teacher_id) {
			this.teacher_id = teacher_id;
		}

		public String getGive() {
			return give;
		}

		public void setGive(String give) {
			this.give = give;
		}

		public String getGive_lesson_num() {
			return give_lesson_num;
		}

		public void setGive_lesson_num(String give_lesson_num) {
			this.give_lesson_num = give_lesson_num;
		}

		public String getGive_money() {
			return give_money;
		}

		public void setGive_money(String give_money) {
			this.give_money = give_money;
		}
		
		
}
