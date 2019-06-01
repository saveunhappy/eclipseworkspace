package com._zz._it._test;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;

import org.junit.Test;

import com._zz._it._dao.IProductDAO;
import com._zz._it._dao._Impl.ProductImpl;
import com._zz._it._domain.Product;
import com._zz._it.handler.BeanListHandler;
import com._zz._it.page.PageResult;
import com._zz._it.query.ProductQueryObject;
import com._zz._it.util.JdbcTemplate;

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
	@Test
	public void test3() throws Exception {
		ProductQueryObject qo = new ProductQueryObject();
		qo.setName("M");
		qo.setMinSalePrice(new BigDecimal("100"));
		//qo.setMaxSalePrice(new BigDecimal("200"));
		//----------------------------------------
		PageResult pageResult = dao.query(qo);
		System.out.println("总条数"+pageResult.getTotalCount());
		System.out.println("上一条"+pageResult.getPrevPage());
		System.out.println("下一条"+pageResult.getNextPage());
		for (Object o : pageResult.getListData()) {
			System.out.println(o);
		}

	}
}
