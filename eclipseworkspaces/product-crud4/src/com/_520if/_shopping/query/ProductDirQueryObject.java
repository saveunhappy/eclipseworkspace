package com._520if._shopping.query;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.Setter;

//封装了商品对象的查询条件
@Getter@Setter
public class ProductDirQueryObject extends QueryObject{
	private String name;
	private Long parentId = -1L;
	public void customizedQuery() {
		//商品名称
		if(StringUtils.isNotBlank(name)) {
			super.addQuery("dirName LIKE ?", "%"+name+"%");
		}
		if(parentId != null) {
			super.addQuery("parent_id >= ?", parentId);
		}

	}

}
