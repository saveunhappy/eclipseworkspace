package com._520if._shopping._test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com._520if._shopping._dao.IProductDAO;
import com._520if._shopping._dao._Impl.ProductImpl;
import com._520if._shopping._domain.Product;
import com._520if._shopping.query.ProductQueryObject;

public class ProductImplTest {
	private IProductDAO dao = new ProductImpl();

	@Test
	public void testList() {
		List<Product> list = dao.list();
		for (Product product : list) {
			System.out.println(product);
		}
	}
	@Test
	public void query() {
		ProductQueryObject qo = new ProductQueryObject();
		qo.setName("M");
		qo.setMinSalePrice(new BigDecimal("100"));
		List<Product> list = dao.query1(qo);
		System.out.println(list.size());
		for (Product product : list) {
			System.out.println(product);
		}
	}

}
