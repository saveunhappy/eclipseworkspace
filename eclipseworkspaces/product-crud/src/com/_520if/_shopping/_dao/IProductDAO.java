package com._520if._shopping._dao;

import java.util.List;

import com._520if._shopping._domain.Product;

public interface IProductDAO {
	void save(Product obj);
	
	void update(Product obj);
	
	void delete(Long id);
	
	Product get(Long id);
	
	List<Product> list();
}
