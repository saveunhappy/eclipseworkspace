package com._520if._shopping._dao._Impl;

import java.util.List;

import com._520if._shopping._dao.IProductDAO;
import com._520if._shopping._domain.Product;
import com._520if._shopping.handler.BeanHandler;
import com._520if._shopping.handler.BeanListHandler;
import com._520if._shopping.util.JdbcTemplate;

public class ProductImpl implements IProductDAO {

	public void save(Product obj) {
		String sql = "INSERT INTO product (productName,brand,supplier,salePrice,costPrice,cutoff,dir_id) values(?,?,?,?,?,?,?)";
		Object[] params = { obj.getProductName(), obj.getBrand(), obj.getSupplier(), obj.getSalePrice(),
			obj.getSalePrice(), obj.getCostPrice(), obj.getDir_id() };
		JdbcTemplate.update(sql, params);

	}

	public void update(Product obj) {
		String sql = "update product set productName=?,brand=?,supplier=?,salePrice=?,costPrice=?,cutoff=?,dir_id=? where id = ?";
		Object[] params = { obj.getProductName(), obj.getBrand(), obj.getSupplier(), obj.getSalePrice(),
				obj.getSalePrice(), obj.getCostPrice(), obj.getDir_id(), obj.getId() };
		JdbcTemplate.update(sql, params);
	}

	public void delete(Long id) {
		String sql = "delete from product where id=?";
		JdbcTemplate.update(sql, id);
	}

	public Product get(Long id) {
		String sql = "select * from product where id=?";
		return JdbcTemplate.query(sql,new BeanHandler<>(Product.class),id);
	}

	public List<Product> list() {
		String sql = "select * from product";
		return JdbcTemplate.query(sql,new BeanListHandler<>(Product.class));

	}
	
}
