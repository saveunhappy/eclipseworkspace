package com._zz._it._dao;

import java.util.List;

import com._zz._it._domain.ProductDir;
import com._zz._it.page.PageResult;
import com._zz._it.query.ProductQueryObject;

public interface IProductDirDAO {
	void save(ProductDir obj);
	
	void update(ProductDir obj);
	
	void delete(Long id);
	
	ProductDir get(Long id);
	
	List<ProductDir> list();
	//分页查询
	PageResult query(ProductQueryObject qo);
}
