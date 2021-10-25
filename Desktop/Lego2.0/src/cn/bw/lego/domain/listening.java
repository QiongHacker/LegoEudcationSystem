package cn.bw.lego.domain;
/**
 * 试听管理实体类
 * @author Li dong cheng
 *
 */
public class listening {
	//学生ID	
	private int id;
	//学生姓名
	private String name;
	//班型
	private int classType;
	//班型名称
	private String classtypename;
	//指导老师
	private String teacher;
	//家长联系方式
	private String tele;
	//课程顾问
	private String visitor;
	//试听日期
	private String dtin;
	//学生来源
	private int studentfrom;
	//学生来源名称
	private String studentfromname;
	//学生状态
	private int state;
	
	private String statename;
	
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
	public int getClassType() {
		return classType;
	}
	public void setClassType(int classType) {
		this.classType = classType;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public String getVisitor() {
		return visitor;
	}
	public void setVisitor(String visitor) {
		this.visitor = visitor;
	}
	public String getDtin() {
		return dtin;
	}
	public void setDtin(String dtin) {
		this.dtin = dtin;
	}
	public int getStudentFrom() {
		return studentfrom;
	}
	public void setStudentFrom(int from) {
		this.studentfrom = from;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getClasstypename() {
		return classtypename;
	}
	public void setClasstypename(String classtypename) {
		this.classtypename = classtypename;
	}
	public String getStudentfromname() {
		return studentfromname;
	}
	public void setStudentfromname(String studentfromname) {
		this.studentfromname = studentfromname;
	}
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	
	
	
}
