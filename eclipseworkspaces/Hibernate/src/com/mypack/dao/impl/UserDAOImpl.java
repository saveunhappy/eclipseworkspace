package com.mypack.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mypack.dao.IUserDAO;
import com.mypack.domain.User;
import com.util.HibernateUtil;

@SuppressWarnings("all")
public class UserDAOImpl implements IUserDAO {

	public void save(User u) {
		Session session = HibernateUtil.getSession();
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

	}

	public void update(User u) {
		Session session = HibernateUtil.getSession();
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

	}

	public void delete(User u) {
		Session session = HibernateUtil.getSession();
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

	}

	// select * from t_user where uid = ?
	// select * from是固定的写法 t_user是通过User.class的这份字节码对象再去读取配置文件，找到t_uesr,uid
	// 也是通过配置文件来
	public User get(Long id) {
		Session session = HibernateUtil.getSession();
		// 5.具体查询操作
		User u = (User) session.get(User.class, id);
		// 6.关闭session
		session.close();
		// 7.关闭sessionFactory
		return u;
	}

	public List<User> listAll() {

		Session session = HibernateUtil.getSession();
		// 5.具体查询操作
		String hql = "SELECT u FROM User u";
		List list = session.createQuery(hql).list();
		// 6.关闭session
		session.close();
		// 7.关闭sessionFactory
		return list;
	}

}
