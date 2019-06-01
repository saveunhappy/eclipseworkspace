package com.mypack.service.impl;

import java.util.Collections;
import java.util.List;

import com.mypack.domain.Employee;
import com.mypack.mapper.EmployeeMapper;
import com.mypack.query.EmployeeQueryObject;
import com.mypack.query.PageResult;
import com.mypack.service.IEmployeeService;
import com.mypack.util.MybatisUtil;

public class EmployeeServiceImpl implements IEmployeeService{
	private EmployeeMapper mapper = MybatisUtil.getMapper(EmployeeMapper.class);
	public PageResult query(EmployeeQueryObject qo) {
		int rows = mapper.queryForCount(qo);
		if(rows==0) {
			return new PageResult(Collections.EMPTY_LIST, 0, 1, qo.getPageSize());
		}
		List<Employee> result = mapper.queryForList(qo);
		
		return new PageResult(result, rows, qo.getCurrentPage(), qo.getPageSize());
	}
	
}
