package com.ssh.dao;

import java.util.List;

import com.ssh.query.EmployeeQueryObject;
import com.ssh.query.PageResult;
import com.ssh.query.QueryObject;

public interface IGenericDAO<T> {
	void save(T obj);

	void update(T obj);

	void delete(Long id);

	T get(Long id);

	List<T> listAll();
	
	PageResult query(QueryObject qo);
}
