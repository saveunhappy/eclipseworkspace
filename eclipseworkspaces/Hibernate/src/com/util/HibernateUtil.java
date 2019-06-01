package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("all")
public class HibernateUtil {
	private HibernateUtil() {}
	private static SessionFactory sessionFactory;
	static {
			Configuration config = new Configuration().configure("/hibernate.cfg.xml");
			sessionFactory =  config.buildSessionFactory();
			
	}
	public static Session getSession() {
		//sessionFactory.openSession()
		//sessionFactory.getCurrentSession()
		return sessionFactory.openSession();
//		return sessionFactory.getCurrentSession();
	}
	
}
