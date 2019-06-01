package com._520if._shopping.query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;

//封装了商品对象的查询条件
@Data
public class ProductQueryObject {
	private String name;
	private BigDecimal minSalePrice;
	private BigDecimal maxSalePrice;
	private Long dirId = -1L;
	
	private List<String> conditions = new ArrayList<>();
	private List<Object> parameters = new ArrayList<>();
	public String getQuery() {
		StringBuilder sql = new StringBuilder(80);
		//商品名称
		if(StringUtils.isNotBlank(name)) {
			conditions.add("productName LIKE ?");
			parameters.add("%"+name+"%");
		}
		if(minSalePrice != null) {
			conditions.add("salePrice >= ?");
			parameters.add(minSalePrice);
		}
		if(maxSalePrice!=null) {
			conditions.add("costPrice <= ?");
			parameters.add(maxSalePrice);
		}
		if(dirId != -1) {
			conditions.add("dir_id = ?");
			parameters.add(dirId);
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
