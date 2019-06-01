package com._520if._shopping._dao._Impl;

import java.util.List;

import com._520if._shopping._dao.IProductDirDAO;
import com._520if._shopping._domain.ProductDir;
import com._520if._shopping.handler.BeanHandler;
import com._520if._shopping.handler.BeanListHandler;
import com._520if._shopping.util.JdbcTemplate;

public class ProductDirImpl implements IProductDirDAO {

	public List<ProductDir> list() {
		String sql = "select * from productdir";
		return JdbcTemplate.query(sql, new BeanListHandler<>(ProductDir.class));
	}

	
	
}
