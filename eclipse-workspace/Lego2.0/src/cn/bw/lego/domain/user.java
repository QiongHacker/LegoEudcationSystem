package cn.bw.lego.domain;
/**
 * 登录者的个人信息
 * @author Li dong cheng
 *
 */
public class user {

			//登录者的用户名	
			private String username;
			//登录者的密码
			private String passwords;
			//登录人的权限
			private int role_name;
			//是否为教师
			private int teacher_id;
			public String getUsername() {
				return username;
			}
			public void setUsername(String username) {
				this.username = username;
			}
			public String getPasswords() {
				return passwords;
			}
			public void setPasswords(String passwords) {
				this.passwords = passwords;
			}
			public int getRole_name() {
				return role_name;
			}
			public void setRole_name(int role_name) {
				this.role_name = role_name;
			}
			public int getTeacher_id() {
				return teacher_id;
			}
			public void setTeacher_id(int teacher_id) {
				this.teacher_id = teacher_id;
			}
			
			
			
}
