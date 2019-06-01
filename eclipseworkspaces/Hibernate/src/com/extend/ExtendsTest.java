package com.extend;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.util.HibernateUtil;

public class ExtendsTest {
	@Before
	public void testSave() throws Exception {
		Product p = new Product();
		p.setName("p");
		
		BookProduct bp = new BookProduct();
		bp.setName("bp");
		bp.setIsbn("isbn");
		bp.setAuthor("author");
		
		ClothProduct cp = new ClothProduct();
		cp.setName("cp");
		cp.setSize("size");
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		
		session.save(p);
		session.save(bp);
		session.save(cp);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testGet() throws Exception {
		Session session = HibernateUtil.getSession();
		
		BookProduct bp = (BookProduct)session.get(BookProduct.class, 2L);
		System.out.println(bp);

		session.close();
	}
	@Test
	public void testGet2() throws Exception {
		Session session = HibernateUtil.getSession();
		Product p = (Product)session.get(Product.class, 3L);
		System.out.println(p);
		
		session.close();
	}
}
