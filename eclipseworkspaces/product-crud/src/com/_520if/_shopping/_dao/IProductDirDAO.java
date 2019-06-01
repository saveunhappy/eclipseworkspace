package com._520if._shopping._dao;

import java.util.List;

import com._520if._shopping._domain.ProductDir;

public interface IProductDirDAO {
	void save(ProductDir obj);
	
	void update(ProductDir obj);
	
	void delete(Long id);
	
	ProductDir get(Long id);
	
	List<ProductDir> list();
}
