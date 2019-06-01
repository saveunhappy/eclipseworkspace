package com._520if._shopping._dao;

import java.util.List;

import com._520if._shopping._domain.Employee;
import com._520if._shopping.page.PageResult;
import com._520if._shopping.query.QueryObject;

public interface IEmployeeDAO {
	void save(Employee p);
	
	void update(Employee p);
	
	void delete(Long id);
	
	Employee get(Long id);
	
	List<Employee> list();
	//高级查询加分页
	//
	PageResult query(QueryObject qo);
}
