package com.common;

import org.junit.Test;

import com.common.domain.Employee;
import com.common.service.IEmployeeServcie;
import com.common.service.impl.EmployeeServiceImpl;

public class App {
	@Test
	public void testName() throws Exception {
		IEmployeeServcie wapper = new EmployeeServiceImplWapper(new EmployeeServiceImpl(), new TransactionManager());
		wapper.save(new Employee());
	}
}
