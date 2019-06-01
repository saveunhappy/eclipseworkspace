package com.mypack.domain;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.mypack.mapper.EmployeeMapper;
import com.mypack.util.MybatisUtil;

public class App {
	//需求1：查询工资大于等于1000的
	@Test
	public void test1() throws Exception {
		EmployeeMapper employeeMapper = MybatisUtil.getMapper(EmployeeMapper.class);
		BigDecimal minSalary = new BigDecimal("1000");
		BigDecimal maxSalary = new BigDecimal("2000");
		List<Employee> query = employeeMapper.query(null,null,30L);
		for (Employee employee : query) {
			System.out.println(employee);
			
		}
		
	}
	@Test
	public void test2() throws Exception {
	//	EmployeeMapper employeeMapper = MybatisUtil.getMapper(EmployeeMapper.class);
		
		SqlSession session = MybatisUtil.getSession();
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		employeeMapper.batchDelect(new Long[] {40L,20L});
		session.commit();
		session.close();
		
	}
	
	
	
}
