package utils;

public class PageUtil {
	private int currentPage = 1;// 当前页码
	private int totalPages;// 总页码
	private int count;// 总记录数
	private int start;// 起始位置
	private int end;// 结束位置
	private int pageSize = 8;// 页面大小

	public PageUtil() {
		// TODO Auto-generated constructor stub
	}

	public PageUtil(int currentPage, int pageSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;

	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPages() {
		return count % pageSize == 0 ? count / pageSize
				: (count / pageSize) + 1;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {

		this.count = count;

	}

	public int getStart() {
		if (currentPage <= 1) {
			return 0;
		} else {
			return (currentPage - 1) * pageSize;
		}

	}

	public int getEnd() {
		return getStart() + pageSize;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
