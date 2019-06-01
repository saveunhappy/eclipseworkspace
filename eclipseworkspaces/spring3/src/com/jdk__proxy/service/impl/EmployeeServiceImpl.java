package com.jdk__proxy.service.impl;

import com.jdk__proxy.dao.IEmployeeDAO;
import com.jdk__proxy.domain.Employee;
import com.jdk__proxy.service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService{

	private IEmployeeDAO dao;
	public void setDao(IEmployeeDAO dao) {
		this.dao = dao;
	}
	public void save(Employee emp) {
		dao.save(emp);
		System.out.println("保存成功");
	}

	public void update(Employee emp) {
		System.out.println("修改成功");
		throw new RuntimeException("故意出错");
	}

}
