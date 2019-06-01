package com.ssh.dao;

import java.util.List;

public interface IGenericDAO<T> {
	void save(T obj);

	void update(T obj);

	void delete(Long id);

	T get(Long id);

	List<T> listAll();
}
