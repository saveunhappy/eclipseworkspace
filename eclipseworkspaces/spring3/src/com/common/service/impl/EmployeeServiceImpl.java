package com.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.dao.IEmployeeDAO;
import com.common.domain.Employee;
import com.common.service.IEmployeeServcie;

import lombok.Setter;
public class EmployeeServiceImpl implements IEmployeeServcie{
	@Autowired
	private IEmployeeDAO dao;
	public void save(Employee e) {
			dao.save(e);
	}
		

	public void update(Employee e) {
			dao.update(e);
		
	}

}
