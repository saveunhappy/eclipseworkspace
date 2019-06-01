package com.jdk__proxy.dao;

import com.jdk__proxy.domain.Employee;

public interface IEmployeeDAO {
	void save(Employee emp);
	void update(Employee emp);
}
