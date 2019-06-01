package com.query;

import org.hibernate.Session;
import org.junit.Test;

import com.util.HibernateUtil;

public class QueryTest {
	@Test
	public void testName() throws Exception {
		HibernateUtil.getSession();
	}
	@Test
	public void test1() throws Exception {
		int pageSize = 3;
		int currentPage = 1;
		Session session= HibernateUtil.getSession();
		String hql = "select e from Employee e where e.name like?"; 
	}
}
