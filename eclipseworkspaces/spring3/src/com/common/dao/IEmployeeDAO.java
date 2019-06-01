package com.common.dao;

import com.common.domain.Employee;

public interface IEmployeeDAO {
	void save(Employee e);
	void update(Employee e);
}
