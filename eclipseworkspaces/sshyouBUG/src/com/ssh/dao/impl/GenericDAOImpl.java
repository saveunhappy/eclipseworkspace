package com.ssh.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ssh.dao.IGenericDAO;
import com.ssh.domain.Employee;
import com.ssh.query.PageResult;
import com.ssh.query.QueryObject;

public class GenericDAOImpl<T> implements IGenericDAO<T> {
	private Class<T> targetType;
	GenericDAOImpl(){
		ParameterizedType clz = (ParameterizedType) this.getClass().getGenericSuperclass();
		
		targetType = (Class<T>)clz.getActualTypeArguments()[0];
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
		T obj = (T)session.get(targetType, id);
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
	
/*public List<Employee> query1(EmployeeQueryObject qo) {
		
		String hql = "SELECT obj FROM Employee obj"+qo.getQuery();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		for(int index = 0;index < qo.getParameters().size();index++) {
			query.setParameter(index, qo.getParameters().get(index));
		}
		return query.list();
	}*/

		public PageResult query(QueryObject qo) {
		
		int pageSize = qo.getPageSize();
		int currentPage = qo.getCurrentPage();
		Session session = sessionFactory.getCurrentSession();
		//查询结果总数
		String countHql = "select count(obj) from "+targetType.getSimpleName()+" obj" + qo.getQuery();
		Query query = session.createQuery(countHql);
		setParameters(qo, query);
		int totalCount = ((Long)query.uniqueResult()).intValue();
		if(totalCount==0) {
			return PageResult.empty(pageSize);
		}
		
		String resultHql = "select obj from "+targetType.getSimpleName()+" obj"+ qo.getQuery();
		query = session.createQuery(resultHql);
		setParameters(qo, query);
		if(currentPage > 0 && pageSize > 0) {
				query.setFirstResult((currentPage-1)*pageSize);
				query.setMaxResults(pageSize);
		}
		
		List<Employee> result = query.list();
		//-----------------------------
		
		return new PageResult(totalCount, result, currentPage, pageSize);
	}

		private void setParameters(QueryObject qo, Query query) {
			for(int index = 0;index < qo.getParameters().size();index++) {
				query.setParameter(index, qo.getParameters().get(index));
			}



}
		}
