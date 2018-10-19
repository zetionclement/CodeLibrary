package entity;

import java.util.List;

/**
 * 分页数据实体类
 */
public class PageData<T> {
	    //页数
		private int page;
		//每页显示数据条数
		private int pageSize;
		//数据总条数
		private Long totalRecords;
		//结果
		private List<Object[]> resultList;
		
		public PageData(int page, int pageSize, Long totalRecords, List<Object[]> resultList) {
			super();
			this.page = page;
			this.pageSize = pageSize;
			this.totalRecords = totalRecords;
			this.resultList = resultList;
		}

		//求取总页数
		public int totalPages(){
			int totalPages = (int)(totalRecords/pageSize);
			if(totalRecords%pageSize != 0){
				totalPages +=1;
			}
			return totalPages;
		}

		public int getPage() {
			return page;
		}

		public void setPage(int page) {
			this.page = page;
		}

		public int getPageSize() {
			return pageSize;
		}

		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}

		public Long getTotalRecords() {
			return totalRecords;
		}

		public void setTotalRecords(Long totalRecords) {
			this.totalRecords = totalRecords;
		}

		public List<Object[]> getResultList() {
			return resultList;
		}

		public void setResultList(List<Object[]> resultList) {
			this.resultList = resultList;
		}
		

}
