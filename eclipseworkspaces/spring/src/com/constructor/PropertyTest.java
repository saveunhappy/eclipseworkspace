package com.constructor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class PropertyTest {
	@Autowired
//	private ApplicationContext ctx;
	private Employee emp;
	
	//@Autowired
	//private EmployeeService service;
	
	//@Autowired
	//private CollectionBean bean;
	@Test
	public void testName() throws Exception {
		//Employee bean4 = ctx.getBean("emp",Employee.class);
		//System.out.println(bean4);
	System.out.println(emp);
//		System.out.println(service);
		//System.out.println(bean);
	}
}
