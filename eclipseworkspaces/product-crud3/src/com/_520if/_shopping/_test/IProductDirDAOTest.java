package com._520if._shopping._test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com._520if._shopping._dao.IProductDirDAO;
import com._520if._shopping._dao._Impl.ProductDirImpl;
import com._520if._shopping._domain.ProductDir;

public class IProductDirDAOTest {
	private IProductDirDAO dao = new ProductDirImpl();
	@Test
	public void testSave() {
	}

	@Test
	public void testUpdate() {
	}

	@Test
	public void testDelete() {
	}

	@Test
	public void testGet() {
	}

	@Test
	public void testList() {
		List<ProductDir> list = dao.list();
		for (ProductDir p : list) {
			System.out.println(p);
		}
	}

}
