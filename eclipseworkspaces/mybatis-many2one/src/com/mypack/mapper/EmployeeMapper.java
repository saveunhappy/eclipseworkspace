package com.mypack.mapper;

import java.util.List;

import com.mypack.domain.Employee;

public interface EmployeeMapper {
	void save(Employee employee);

	Employee get(Long id);

	List<Employee> ListAll();
}
