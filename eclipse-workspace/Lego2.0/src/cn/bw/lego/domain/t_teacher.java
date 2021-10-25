package cn.bw.lego.domain;
/*
 * 教师实体类
 * @author Li dong cheng
 *
 */
public class t_teacher {
	// 属性 : 教师信息表中ID属性
			private int id;
			// 属性: 教师信息表中name属性
			private String name;
			// 属性: 教师信息表中sex属性
			private String sex;
			
			// 属性：教师信息表中dtin属性
			private String dtin;
			//属性 :教师信息表中idcard属性
			private String idcard;
			//教师管理id
			private String roleid;
			
			private int rolename;
			
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
			public String getIdcard() {
				return idcard;
			}
			public void setIdcard(String idcard) {
				this.idcard = idcard;
			}
			public String getDtin() {
				return dtin;
			}
			public void setDtin(String dtin) {
				this.dtin = dtin;
			}
			public String getRoleid() {
				return roleid;
			}
			public void setRoleid(String roleid) {
				this.roleid = roleid;
			}
			public int getRolename() {
				return rolename;
			}
			public void setRolename(int rolename) {
				this.rolename = rolename;
			}
			
}
