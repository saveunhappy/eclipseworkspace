package com._520if._shopping._dao._Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com._520if._shopping._dao.IProductDAO;
import com._520if._shopping._domain.Product;
import com._520if._shopping.handler.BeanListHandler;
import com._520if._shopping.handler.IResultSetHandler;
import com._520if._shopping.page.PageResult;
import com._520if._shopping.query.ProductQueryObject;
import com._520if._shopping.util.JdbcTemplate;

public class ProductImpl implements IProductDAO {

	
	public List<Product> list() {
		String sql = "select * from product";
		return JdbcTemplate.query(sql,new BeanListHandler<>(Product.class));
	}
	public List<Product> query(ProductQueryObject qo) {
		String querySql = qo.getQuery();
		List<Object> parameters = qo.getParameters();
		String sql = "select * from product"+querySql;
		System.out.println("sql=" +sql);
		System.out.println("参数=" + parameters);
		return JdbcTemplate.query(sql,new BeanListHandler<>(Product.class),qo.getParameters().toArray());
	}
	@Override
	public PageResult query(Integer currentPage, Integer pageSize) {
		//-------------------------------------------
		//查询结果总数
		String countSql = "SELECT COUNT(*) FROM product";
		Integer totalCount = JdbcTemplate.query(countSql, new IResultSetHandler<Long>() {
			public Long handle(ResultSet rs) throws Exception {
				if(rs.next()) {
					return rs.getLong(1);
				}
				return 0L;
			}
		}).intValue(); 
		if(totalCount == 0) {
			PageResult.empty(pageSize);
		}
		String resultSql = "SELECT * FROM product LIMIT ?,?";
		Object[] params = {(currentPage - 1)*pageSize,pageSize};
		List listData = JdbcTemplate.query(resultSql, new BeanListHandler<>(Product.class), params);
		//-------------------------------------------
		return new PageResult(currentPage, pageSize, listData, totalCount);
	}
	
}
