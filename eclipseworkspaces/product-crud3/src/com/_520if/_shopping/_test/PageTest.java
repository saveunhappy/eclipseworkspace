package com._520if._shopping._test;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.util.List;

import org.junit.Test;

import com._520if._shopping._dao.IProductDAO;
import com._520if._shopping._dao._Impl.ProductImpl;
import com._520if._shopping._domain.Product;
import com._520if._shopping.handler.BeanListHandler;
import com._520if._shopping.handler.IResultSetHandler;
import com._520if._shopping.page.PageResult;
import com._520if._shopping.util.JdbcTemplate;

public class PageTest {
	//控制台版本的分页
	private IProductDAO dao = new ProductImpl();
	@Test
	public void test1() throws Exception {
		//用户传入
		Integer currentPage = 2;
		Integer pageSize = 5;
		//查询结果总数
		String countsql = "SELECT COUNT(*) FROM product";
		Integer totalCount = JdbcTemplate.query(countsql,
			
			(ResultSet rs) -> {
				if(rs.next()) {
					return rs.getLong(1);
				}
				return 0L;
			}
		).intValue();
		//===============================
		//查询结果集
		String resultSql = "SELECT * FROM product LIMIT ?,?";
		Object[] params = {(currentPage -1 )*pageSize,pageSize};
		List<Product> listData = JdbcTemplate.query(resultSql,new BeanListHandler<>(Product.class), params);
		for (Product p: listData) {
			System.out.println(p);
		}
		System.out.println(totalCount);
	}
	
	
	@Test
	public void test2() throws Exception {
		Integer currentPage = 1;
		Integer PageSize = 5;
		PageResult pageResult = dao.query(currentPage, PageSize);
		System.out.println("总条数"+pageResult.getTotalCount());
		System.out.println("上一条"+pageResult.getPrevPage());
		System.out.println("下一条"+pageResult.getNextPage());
		for (Object o : pageResult.getListData()) {
			System.out.println(o);
		}
	}
}
