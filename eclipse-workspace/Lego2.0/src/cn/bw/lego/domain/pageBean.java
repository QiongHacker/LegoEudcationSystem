package cn.bw.lego.domain;

import java.util.List;

public class pageBean<T> {
	
			//当前显示条数
			private int pageSize;
			//当前是第几页
			private int curPage;
			//总共有多少页
			private int totalPage;
			//总共有多少条记录
			private int totalCount;
			
			//当前页展示的所有数据
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
