package com._520if._shopping.page;

import java.util.Collections;
import java.util.List;

import lombok.Getter;

@SuppressWarnings("all")
@Getter
public class PageResult {
	private List listData;//结果集数据，通过SQL查询
	private Integer totalCount;//结果总条数，通过SQL查询
	
	private Integer currentPage = 1;//当前页，用户传入的
	private Integer pageSize = 5;//每页条数,用户传入
	
	private Integer beginPage=1;//首页
	private Integer prevPage;//上一页计算出来
	private Integer nextPage;//下一页计算出来
	private Integer totalPage;//末页，总页数计算出来
	
	
	
	public static PageResult empty(Integer pageSize) {
		return new PageResult(1, pageSize, Collections.EMPTY_LIST, 0);
	}
	public PageResult(Integer currentPage,Integer pageSize,List listData, Integer totalCount ) {
		this.listData = listData;
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalPage = totalCount % pageSize ==0 ? totalCount / pageSize : totalCount / pageSize+1;
		this.prevPage = currentPage -1 >=1?currentPage-1:1;
		this.nextPage = currentPage +1 <= totalPage?currentPage+1:totalPage;
		
	}
	
}
