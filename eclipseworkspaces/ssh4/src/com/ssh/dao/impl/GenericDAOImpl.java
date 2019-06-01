package com.ssh.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ssh.dao.IGenericDAO;
import com.ssh.query.PageResult;
import com.ssh.query.QueryObject;

public class GenericDAOImpl<T> implements IGenericDAO<T> {
	private Class<T> targetType;

	GenericDAOImpl() {
		ParameterizedType clz = (ParameterizedType) this.getClass().getGenericSuperclass();

		targetType = (Class<T>) clz.getActualTypeArguments()[0];
	}

	protected SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(T obj) {
		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
	}

	public void update(T obj) {
		Session session = sessionFactory.getCurrentSession();
		session.update(obj);
	}

	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		T obj = (T) session.get(targetType, id);
		session.delete(obj);
	}

	public T get(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (T) session.get(targetType, id);
	}

	public List<T> listAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(targetType).list();
	}

	public PageResult query(QueryObject qo) {

		int pageSize = qo.getPageSize();
		int currentPage = qo.getCurrentPage();
		Session session = sessionFactory.getCurrentSession();
		// 查询结果总数
		String countHql = "select count(obj) from " + targetType.getSimpleName() + " obj" + qo.getQuery();
		System.out.println("===========================");
		System.out.println("countHql:::" + countHql);
		Query query = session.createQuery(countHql);
		System.out.println("qo::::::"+qo);
		setParameters(qo, query);
		int totalCount = ((Long) query.uniqueResult()).intValue();
		System.out.println("totalCount------" + totalCount);
		if (totalCount == 0) {
			return PageResult.empty(pageSize);
		}
		String resultHql = "select obj from " + targetType.getSimpleName() + " obj" + qo.getQuery();
		System.out.println("resultHql:::" + resultHql);
		System.out.println("resultHqlGetQuery" + qo.getQuery());
		Query query1 = session.createQuery(resultHql);
		setParameters(qo, query1);
		if (currentPage > 0 && pageSize > 0) {
			query1.setFirstResult((currentPage - 1) * pageSize);
			query1.setMaxResults(pageSize);
		}

		List result = query1.list();
		// -----------------------------

		return new PageResult(totalCount, result, currentPage, pageSize);
	}

	private void setParameters(QueryObject qo, Query query) {
		for (int index = 0; index < qo.getParameters().size(); index++) {
			query.setParameter(index, qo.getParameters().get(index));
		}

	}
}
