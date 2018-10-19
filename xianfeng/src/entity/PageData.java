package entity;

import java.util.List;

/**
 * ��ҳ����ʵ����
 */
public class PageData<T> {
	    //ҳ��
		private int page;
		//ÿҳ��ʾ��������
		private int pageSize;
		//����������
		private Long totalRecords;
		//���
		private List<Object[]> resultList;
		
		public PageData(int page, int pageSize, Long totalRecords, List<Object[]> resultList) {
			super();
			this.page = page;
			this.pageSize = pageSize;
			this.totalRecords = totalRecords;
			this.resultList = resultList;
		}

		//��ȡ��ҳ��
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
