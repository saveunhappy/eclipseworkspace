package com.ssh.dao;

import java.util.List;

import com.ssh.domain.Employee;
import com.ssh.query.EmployeeQueryObject;
import com.ssh.query.PageResult;

public interface IEmployeeDAO extends IGenericDAO<Employee>{
	//高级查询加分页
	PageResult query(EmployeeQueryObject qo);
	
	public List<Employee> query1(EmployeeQueryObject qo);
}
