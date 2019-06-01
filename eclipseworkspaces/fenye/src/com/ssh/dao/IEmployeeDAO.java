package com.ssh.dao;

import java.util.List;

import com.ssh.domain.Employee;
import com.ssh.query.EmployeeQueryObject;
import com.ssh.query.PageResult;

public interface IEmployeeDAO extends IGenericDAO<Employee>{
	//高级查询
	List<Employee> query(EmployeeQueryObject qo);
	
	//分页查询
	PageResult query(int currentpage,int pageSize);
}
