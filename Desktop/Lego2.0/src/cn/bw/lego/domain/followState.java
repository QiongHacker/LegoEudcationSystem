package cn.bw.lego.domain;
/**
 * 跟进状态 实体类
 * @author Li dong cheng
 *
 */
public class followState {
			private int id;
			private int student_id;
			
			private String follow;
			
			private String date;
			
			private String content;
			private String name;
			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getFollow() {
				return follow;
			}

			public void setFollow(String follow) {
				this.follow = follow;
			}

			public String getDate() {
				return date;
			}

			public void setDate(String date) {
				this.date = date;
			}

			public String getContent() {
				return content;
			}

			public void setContent(String content) {
				this.content = content;
			}

			public int getStudent_id() {
				return student_id;
			}

			public void setStudent_id(int student_id) {
				this.student_id = student_id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}
			
}
