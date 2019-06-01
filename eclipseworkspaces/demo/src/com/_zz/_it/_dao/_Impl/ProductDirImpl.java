package com._zz._it._dao._Impl;

import java.util.List;

import com._zz._it._dao.IProductDirDAO;
import com._zz._it._domain.ProductDir;
import com._zz._it.handler.BeanHandler;
import com._zz._it.handler.BeanListHandler;
import com._zz._it.page.PageResult;
import com._zz._it.query.ProductQueryObject;
import com._zz._it.util.JdbcTemplate;

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

	@Override
	public PageResult query(ProductQueryObject qo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
