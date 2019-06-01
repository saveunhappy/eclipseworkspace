package com._zz._it._test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com._zz._it._dao.IProductDAO;
import com._zz._it._dao._Impl.ProductImpl;
import com._zz._it._domain.Product;
import com._zz._it.query.ProductQueryObject;

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
