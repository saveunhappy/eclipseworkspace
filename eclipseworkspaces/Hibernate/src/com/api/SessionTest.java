package com.api;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.mypack.domain.User;
import com.util.HibernateUtil;

public class SessionTest {
	@Test
	public void testFirstCache() throws Exception {
		Session session = HibernateUtil.getSession();
		String hql = "SELECT u FROM User u where u.name like ? and u.id between ? and ?";
		Query query = session.createQuery(hql);
		//设置占位符参数
		query.setString(0, "%test%").setLong(1,1L).setLong(2,10L);
		List<User> list = query.list();
		session.close();
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testCriteria() throws Exception {
		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.like("name", "test",MatchMode.ANYWHERE));
		List<User> user = criteria.list();
		session.close();
		for (User user2 : user) {
			
			System.out.println(user2);
		}
	}
}
