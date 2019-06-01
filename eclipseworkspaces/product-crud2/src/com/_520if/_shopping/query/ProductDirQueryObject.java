package com._520if._shopping.query;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;

//封装了商品对象的查询条件
@Data
public class ProductDirQueryObject {
	private String name;
	private Long parentId = -1L;
	
	
	private List<String> conditions = new ArrayList<>();
	private List<Object> parameters = new ArrayList<>();
	public String getQuery() {
		StringBuilder sql = new StringBuilder(80);
		//商品名称
		if(StringUtils.isNotBlank(name)) {
			conditions.add("dirName LIKE ?");
			parameters.add("%"+name+"%");
		}
		if(parentId != null) {
			conditions.add("parent_id >= ?");
			parameters.add(parentId);
		}
	
		if(conditions.size()==0) {
			return "";
		}
		String queryString  = StringUtils.join(conditions, " AND ");
		return sql.append(" WHERE ").append(queryString).toString();
	}
	public List<Object> getParameters() {
		
		return parameters;
	}
}
