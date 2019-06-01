package com.ssh.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.Setter;

//高级查询对象的基类
public class QueryObject {
	@Setter@Getter
	private int currentPage = 1;
	@Setter@Getter
	private int pageSize = 5;
	
	private boolean build = false;
	private List<String> conditions = new ArrayList<>();//查询条件
	
	private List<Object> params = new ArrayList<>();//占位符参数
	
	private void init() {
		if(!build) {
			this.customizedQuery();
			build = false;
		}
	}
	public String getQuery() {
		init();
		if(conditions.size()==0) {
			return "";
		}
		return " where " + StringUtils.join(conditions," AND ");
		
	}
	protected void customizedQuery() {
		
		
	}
	
	protected void addQuery(String condition,Object... args) {
		this.conditions.add(condition);
		this.params.addAll(Arrays.asList(args));
	}
	
	public List<Object> getParameters() {
		init();
		return this.params;
	}
	
	protected boolean hasLength(String str) {
		return str!=null&&!"".equals(str.trim());
	}
}
