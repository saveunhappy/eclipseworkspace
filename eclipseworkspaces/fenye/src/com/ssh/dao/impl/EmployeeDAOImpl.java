package com.ssh.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ssh.dao.IEmployeeDAO;
import com.ssh.domain.Employee;
import com.ssh.query.EmployeeQueryObject;
import com.ssh.query.PageResult;

public class EmployeeDAOImpl extends  GenericDAOImpl<Employee> implements IEmployeeDAO{

	public List<Employee> query(EmployeeQueryObject qo) {
		String hql = "SELECT obj FROM Employee obj"+qo.getQuery();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		for(int index = 0;index < qo.getParameters().size();index++) {
			query.setParameter(index, qo.getParameters().get(index));
		}
		return query.list();
	}

	public PageResult query(int currentPage, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		//查询结果总数
		String countHql = "select count(obj) from Employee obj";
		Query query = session.createQuery(countHql);
		int totalCount = ((Long)query.uniqueResult()).intValue();
		if(totalCount==0) {
			return PageResult.empty(pageSize);
		}
		
		String resultHql = "select obj from Employee obj";
		query = session.createQuery(resultHql);
		if(currentPage > 0 && pageSize > 0) {
				query.setFirstResult((currentPage-1)*pageSize);
				query.setMaxResults(pageSize);
		}
		
		List<Employee> result = query.list();
		//-----------------------------
		
		return new PageResult(totalCount, result, currentPage, pageSize);
	}



}
