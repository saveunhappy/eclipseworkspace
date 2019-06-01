package com.jdk__proxy.dao.impl;

import com.jdk__proxy.dao.IEmployeeDAO;
import com.jdk__proxy.domain.Employee;

public class EmployeeDAOImpl implements IEmployeeDAO{

	public void save(Employee emp) {
		System.out.println("保存员工");
	}

	public void update(Employee emp) {
		System.out.println("更新员工");
	}

}
