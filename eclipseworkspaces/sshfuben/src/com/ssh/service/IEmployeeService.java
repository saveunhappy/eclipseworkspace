package com.ssh.service;

import java.util.List;

import com.ssh.domain.Employee;

public interface IEmployeeService {
	void save(Employee e);
	
	void update(Employee e);
	
	void delete(Employee id);
	
	Employee get(Long id);
	
	List<Employee> listAll();
	
	
}
