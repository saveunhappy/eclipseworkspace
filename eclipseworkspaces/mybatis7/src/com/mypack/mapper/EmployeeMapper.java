package com.mypack.mapper;

import java.util.List;

import com.mypack.domain.Employee;
import com.mypack.query.EmployeeQueryObject;

public interface EmployeeMapper {
	List<Employee> queryForList(EmployeeQueryObject qo);
	
	int queryForCount(EmployeeQueryObject qo);

}
