package cn.bw.lego.domain;

import java.util.List;

public class pageBean<T> {
	
			//��ǰ��ʾ����
			private int pageSize;
			//��ǰ�ǵڼ�ҳ
			private int curPage;
			//�ܹ��ж���ҳ
			private int totalPage;
			//�ܹ��ж�������¼
			private int totalCount;
			
			//��ǰҳչʾ����������
			private List<T> Data;

			public int getPageSize() {
				return pageSize;
			}

			public void setPageSize(int pageSize) {
				this.pageSize = pageSize;
			}

			public int getCurPage() {
				return curPage;
			}

			public void setCurPage(int curPage) {
				this.curPage = curPage;
			}

			public int getTotalPage() {
				return totalPage;
			}

			public void setTotalPage(int totalPage) {
				this.totalPage = totalPage;
			}

			public int getTotalCount() {
				return totalCount;
			}

			public void setTotalCount(int totalCount) {
				this.totalCount = totalCount;
			}

			public List<T> getData() {
				return Data;
			}

			public void setData(List<T> data) {
				Data = data;
			}
			
}
