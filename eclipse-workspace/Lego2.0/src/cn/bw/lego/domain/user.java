package cn.bw.lego.domain;
/**
 * ��¼�ߵĸ�����Ϣ
 * @author Li dong cheng
 *
 */
public class user {

			//��¼�ߵ��û���	
			private String username;
			//��¼�ߵ�����
			private String passwords;
			//��¼�˵�Ȩ��
			private int role_name;
			//�Ƿ�Ϊ��ʦ
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
