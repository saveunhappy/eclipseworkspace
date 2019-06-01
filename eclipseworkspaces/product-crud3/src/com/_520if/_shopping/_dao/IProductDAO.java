package com._520if._shopping._dao;

import java.util.List;

import com._520if._shopping._domain.Product;
import com._520if._shopping.page.PageResult;
import com._520if._shopping.query.ProductQueryObject;

public interface IProductDAO {

	
	List<Product> list();

	List<Product> query(ProductQueryObject qo);
	
	PageResult query(Integer currentPage,Integer PageSize);
}
