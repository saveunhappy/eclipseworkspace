package com._zz._it.test;

import java.util.List;

import org.junit.Test;

import com._zz._it._dao.IProductDirDAO;
import com._zz._it._dao._Impl.ProductDirImpl;
import com._zz._it._domain.ProductDir;

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
