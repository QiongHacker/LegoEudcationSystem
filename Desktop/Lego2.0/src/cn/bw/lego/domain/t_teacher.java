package cn.bw.lego.domain;
/*
 * ��ʦʵ����
 * @author Li dong cheng
 *
 */
public class t_teacher {
	// ���� : ��ʦ��Ϣ����ID����
			private int id;
			// ����: ��ʦ��Ϣ����name����
			private String name;
			// ����: ��ʦ��Ϣ����sex����
			private String sex;
			
			// ���ԣ���ʦ��Ϣ����dtin����
			private String dtin;
			//���� :��ʦ��Ϣ����idcard����
			private String idcard;
			//��ʦ����id
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
