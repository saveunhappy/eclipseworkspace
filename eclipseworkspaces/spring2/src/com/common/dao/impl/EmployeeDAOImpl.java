package com.common.dao.impl;

import org.springframework.stereotype.Repository;

import com.common.dao.IEmployeeDAO;
import com.common.domain.Employee;
public class EmployeeDAOImpl implements IEmployeeDAO{
	
	public void save(Employee e) {
		System.out.println("保存员工");
	}

	@Override
	public void update(Employee e) {
		System.out.println("更新员工");
	}

}
