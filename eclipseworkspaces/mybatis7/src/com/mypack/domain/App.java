package com.mypack.domain;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.mypack.mapper.EmployeeMapper;
import com.mypack.query.EmployeeQueryObject;
import com.mypack.query.PageResult;
import com.mypack.service.IEmployeeService;
import com.mypack.service.impl.EmployeeServiceImpl;
import com.mypack.util.MybatisUtil;

public class App {
	@Test
	public void test1() throws Exception {
		EmployeeQueryObject qo = new EmployeeQueryObject();
		//qo.setKeyword(" ");
		qo.setMinSalary(new BigDecimal("1000"));
		qo.setMaxSalary(new BigDecimal("2500"));
		EmployeeMapper mapper = MybatisUtil.getMapper(EmployeeMapper.class);
		List<Employee> list = mapper.queryForList(qo);
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
	@Test
	public void test2() throws Exception {
		EmployeeQueryObject qo = new EmployeeQueryObject();
		qo.setMinSalary(new BigDecimal("1000"));
		qo.setMaxSalary(new BigDecimal("2500"));
		EmployeeMapper mapper = MybatisUtil.getMapper(EmployeeMapper.class);
		int queryForCount = mapper.queryForCount(qo);
		System.out.println(queryForCount);
		
		}
	
	@Test
	public void test3() throws Exception {
		EmployeeQueryObject qo = new EmployeeQueryObject();
		IEmployeeService servcie = new EmployeeServiceImpl();
		qo.setMinSalary(new BigDecimal("1000"));
		qo.setMaxSalary(new BigDecimal("2500"));
		qo.setDeptId(10L);
		PageResult pageResult = servcie.query(qo);
		System.out.println(pageResult.getTotalCount());
		for(Object o : pageResult.getResult()) {
			System.out.println(o);
		}
		
	}
	
	
	
}
