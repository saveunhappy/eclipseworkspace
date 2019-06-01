package com.ssh.service.impl;

import java.util.List;

import org.hibernate.Session;

import com.ssh.dao.IEmployeeDAO;
import com.ssh.domain.Employee;
import com.ssh.query.EmployeeQueryObject;
import com.ssh.query.PageResult;
import com.ssh.service.IEmployeeService;

import lombok.Setter;

public class EmployeeServiceImpl implements IEmployeeService{
	@Setter
	private IEmployeeDAO employeeDAO;
	public void save(Employee e) {
		employeeDAO.save(e);
	}

	public void update(Employee e) {
		employeeDAO.update(e);
	}

	public void delete(Long e) {
		employeeDAO.delete(e);
	}

	public Employee get(Long id) {
		return employeeDAO.get(id);
	}

	public List<Employee> listAll() {
		return employeeDAO.listAll();
	}


	public PageResult query(EmployeeQueryObject qo) {
		return employeeDAO.query(qo);
	}





}
