package com.enums;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.util.HibernateUtil;

public class EnumTest {
	@Before
	public void testSave() throws Exception {
		Employee e = new Employee();
		e.setName("e");
		e.setSex(Sex.FEMALE);
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();
		session.close();
	}
	@Test
	public void testGet() throws Exception {
		
		Session session = HibernateUtil.getSession();
		Employee e = (Employee)session.get(Employee.class, 1L);
		System.out.println(e);
		
		session.close();
		
		
	}
}
