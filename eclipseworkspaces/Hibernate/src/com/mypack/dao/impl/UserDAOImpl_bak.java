package com.mypack.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mypack.dao.IUserDAO;
import com.mypack.domain.User;

@SuppressWarnings("all")
public class UserDAOImpl_bak implements IUserDAO {

	public void save(User u) {
		// 1.创建配置文件
		Configuration config = new Configuration();
		// 2.读取配置文件
		config.configure("/hibernate.cfg.xml");
		// 3.创建sessionFactory先看做是DataSource
		SessionFactory factory = config.buildSessionFactory();
		// 4.创建session县看做是connection
		Session session = factory.openSession();
		// 5.打开事务
		Transaction tx = session.getTransaction();
		tx.begin();
		// 6.具体的DML操作
		session.save(u);
		// 7.提交/回滚事务
		tx.commit();
		// 8.关闭session
		session.close();
		// 9.关闭sessionFactory
		factory.close();

	}

	public void update(User u) {
		// 1.创建配置文件
		Configuration config = new Configuration();
		// 2.读取配置文件
		config.configure("/hibernate.cfg.xml");
		// 3.创建sessionFactory先看做是DataSource
		SessionFactory factory = config.buildSessionFactory();
		// 4.创建session县看做是connection
		Session session = factory.openSession();
		// 5.打开事务
		Transaction tx = session.getTransaction();
		tx.begin();
		// 6.具体的DML操作、
		session.update(u);
		// 7.提交/回滚事务
		tx.commit();
		// 8.关闭session
		session.close();
		// 9.关闭sessionFactory
		factory.close();

	}

	public void delete(User u) {
		// 1.创建配置文件
		Configuration config = new Configuration();
		// 2.读取配置文件
		config.configure("/hibernate.cfg.xml");
		// 3.创建sessionFactory先看做是DataSource
		SessionFactory factory = config.buildSessionFactory();
		// 4.创建session县看做是connection
		Session session = factory.openSession();
		// 5.打开事务
		Transaction tx = session.getTransaction();
		tx.begin();
		// 6.具体的DML操作
		session.delete(u);
		// 7.提交/回滚事务
		tx.commit();
		// 8.关闭session
		session.close();
		// 9.关闭sessionFactory
		factory.close();

	}

	// select * from t_user where uid = ?
	// select * from是固定的写法 t_user是通过User.class的这份字节码对象再去读取配置文件，找到t_uesr,uid
	// 也是通过配置文件来
	public User get(Long id) {
		// 1.创建配置文件
		Configuration config = new Configuration();
		// 2.读取配置文件
		config.configure("/hibernate.cfg.xml");
		// 3.创建sessionFactory先看做是DataSource

		SessionFactory factory = config.buildSessionFactory();
		// 4.创建session县看做是connection
		Session session = factory.openSession();
		// 5.具体查询操作
		User u = (User) session.get(User.class, id);
		// 6.关闭session
		session.close();
		// 7.关闭sessionFactory
		factory.close();
		return u;
	}

	public List<User> listAll() {
		// 1.创建配置文件
		Configuration config = new Configuration();
		// 2.读取配置文件
		config.configure("/hibernate.cfg.xml");
		// 3.创建sessionFactory先看做是DataSource

		SessionFactory factory = config.buildSessionFactory();
		// 4.创建session县看做是connection
		Session session = factory.openSession();
		// 5.具体查询操作
		String hql = "SELECT u FROM User u";
		List list = session.createQuery(hql).list();
		// 6.关闭session
		session.close();
		// 7.关闭sessionFactory
		factory.close();
		return list;
	}

}
