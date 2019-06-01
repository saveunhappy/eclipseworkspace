package com.mypack.service;

import com.mypack.query.EmployeeQueryObject;
import com.mypack.query.PageResult;

public interface IEmployeeService {
	PageResult query(EmployeeQueryObject qo);
	
}
