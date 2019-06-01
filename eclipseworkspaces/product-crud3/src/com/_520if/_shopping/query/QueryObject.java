package com._520if._shopping.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class QueryObject {
	private List<String> conditions = new ArrayList<>();
	private List<Object> parameters = new ArrayList<>();
	private boolean isBuild = false;
	private void init() {
		if(!isBuild) {//如果没有构建过
			this.customizedQuery();
			isBuild = true;
		}
	}
	public String getQuery() {
		StringBuilder sql = new StringBuilder(80);
		this.init();
		if(conditions.size()==0) {
			return "";
		}
		String queryString = StringUtils.join(conditions," AND ");
		return sql.append(" WHERE ").append(queryString).toString();
	}
	public List<Object> getParameters(){
		return parameters;
	}
	//暴露给子类：让子类覆盖并且编写自己的查询方式
	protected void customizedQuery() {
	}
	//暴露给子类，让子类在customized中调用，添加自己的查询条件和参数
	protected void addQuery(String condition,Object...param) {
		this.conditions.add(condition);
		this.parameters.addAll(Arrays.asList(param));
	}
}
