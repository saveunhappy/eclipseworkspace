package com.ssh.service;

import java.util.List;

import com.ssh.domain.Employee;
import com.ssh.query.EmployeeQueryObject;
import com.ssh.query.PageResult;

public interface IEmployeeService {
	void save(Employee e);
	
	void update(Employee e);
	
	void delete(Long id);
	
	Employee get(Long id);
	
	List<Employee> listAll();
	
	List<Employee> query(EmployeeQueryObject qo);
	PageResult query(int currentPage,int pageSize);
}
