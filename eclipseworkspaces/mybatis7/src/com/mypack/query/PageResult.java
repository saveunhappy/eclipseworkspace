package com.mypack.query;

import java.util.List;

import lombok.Getter;
@Getter
public class PageResult {
	private List<?> result;// 每一页的结果集
	private int totalCount;// 结果总数
	private int currentPage = 1;
	private int pageSize = 3;// 每页多少条数据

	private int prevPage;
	private int nextPage;
	private int totalPage;

	public PageResult(List<?> result, int totalCount, int currentPage, int pageSize) {
		this.result = result;
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalPage = totalPage % pageSize == 0 ? totalPage / pageSize : totalPage / pageSize + 1;
		this.prevPage = currentPage - 1 >= 1 ? currentPage - 1 : 1;
		this.nextPage = currentPage + 1 <= totalPage ? currentPage + 1 : totalPage;
		
		currentPage = currentPage>totalPage?totalPage:currentPage;
	}

}
