package com._520if._shopping._dao;

import java.util.List;

import com._520if._shopping._domain.Product;
import com._520if._shopping.page.PageResult;
import com._520if._shopping.query.ProductQueryObject;

public interface IProductDAO {

	
	List<Product> list();

	List<Product> query1(ProductQueryObject qo);
	
	PageResult query(Integer currentPage,Integer PageSize);
	
	//高级查询加分页查询
	PageResult query(ProductQueryObject qo);
}
