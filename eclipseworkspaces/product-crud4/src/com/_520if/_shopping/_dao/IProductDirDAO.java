package com._520if._shopping._dao;

import java.util.List;

import com._520if._shopping._domain.ProductDir;
import com._520if._shopping.page.PageResult;
import com._520if._shopping.query.ProductQueryObject;

public interface IProductDirDAO {
	
	List<ProductDir> list();
	
	PageResult query(ProductQueryObject qo);
}
