package com._zz._it.query;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.Setter;

//封装了商品对象的查询条件
@Getter@Setter
public class ProductQueryObject extends QueryObject{
	private String name;
	private BigDecimal minSalePrice;
	private BigDecimal maxSalePrice;
	private Long dirId = -1L;
	private String keyword;	
	
	
	
		public void customizedQuery() {
		//商品名称
		if(StringUtils.isNotBlank(name)) {
			super.addQuery("productName LIKE ?", "%"+name+"%");
		}
		if(minSalePrice != null) {
			super.addQuery("salePrice >= ?", minSalePrice);
		}
		if(maxSalePrice!=null) {
			super.addQuery("costPrice <= ?", maxSalePrice);
		}
		if(dirId != -1) {
			super.addQuery("dir_id = ?", dirId);
		}
		if(StringUtils.isNotBlank(keyword)) {
			super.addQuery("(productName LIKE ? OR brand LIKE ?)", "%"+keyword+"%", "%"+keyword+"%");
		}
	}

}
