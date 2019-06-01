package com.api;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.util.HibernateUtil;

public class SessionFactoryTest {
	@Test
	public void testName() throws Exception {
		Session session = HibernateUtil.getSession();
		String hql = "SELECT u FROM User u";
		session.beginTransaction();
		List list = session.createQuery(hql).list();
		
		session.getTransaction().commit();
		System.out.println(list);
	}
}
