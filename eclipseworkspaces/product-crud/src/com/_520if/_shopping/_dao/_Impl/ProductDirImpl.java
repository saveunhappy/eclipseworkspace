package com._520if._shopping._dao._Impl;

import java.util.List;

import com._520if._shopping._dao.IProductDirDAO;
import com._520if._shopping._domain.ProductDir;
import com._520if._shopping.handler.BeanHandler;
import com._520if._shopping.handler.BeanListHandler;
import com._520if._shopping.util.JdbcTemplate;

public class ProductDirImpl implements IProductDirDAO {

	public void save(ProductDir obj) {
		String sql = "insert into productdir (dirName,parent_id) values(?,?)";
		JdbcTemplate.update(sql, obj.getDirName(),obj.getParent_id());
	}

	public void update(ProductDir obj) {
		String sql = "update productdir set dir_name=?,parent_id=? where id=?";
		
		JdbcTemplate.update(sql, obj.getDirName(),obj.getParent_id(),obj.getId());
		
	}

	public void delete(Long id) {
		String sql = "delete from productname where id = ?";
		JdbcTemplate.update(sql,id);
		
	}
	public ProductDir get(Long id) {
		String sql = "select * from productdir where id=?";
		return JdbcTemplate.query(sql, new BeanHandler<>(ProductDir.class), id);
		
	}

	public List<ProductDir> list() {
		String sql = "select * from productdir";
		return JdbcTemplate.query(sql, new BeanListHandler<>(ProductDir.class));
	}

	
	
}
