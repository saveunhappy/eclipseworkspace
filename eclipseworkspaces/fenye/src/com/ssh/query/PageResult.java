package com.ssh.query;

import java.util.Collections;
import java.util.List;

import lombok.Getter;
@Getter
public class PageResult {
	private int totalCount;//结果总数：SQL查询
	private List<?> result;//结果集：SQL查询
	
	private int currentPage = 1;//当前页，用户传入
	private int pageSize = 3;//每页最多显示多少条数据，用户传入
	
	private int totalPage;//总页数：计算
	private int prevPage;//上一页：计算
	private int nextPage;//下一页：计算

	public static PageResult empty(int pageSize) {
		return new PageResult(0,Collections.emptyList(),1,pageSize);
	}
	
	
	public PageResult(int totalCount, List result, int currentPage, int pageSize) {
		this.totalCount = totalCount;
		this.result = result;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		
		totalPage = totalCount % pageSize == 0? totalCount/pageSize :  totalCount/pageSize + 1;
		prevPage = currentPage - 1>=currentPage?currentPage - 1: 1;
		//nextPage = currentPage + 1>=totalPage?totalPage:currentPage+1;
		nextPage = currentPage + 1<=totalPage?currentPage+1:totalPage;
		
	}
	
	
}
