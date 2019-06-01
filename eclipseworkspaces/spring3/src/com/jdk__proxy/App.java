package com.jdk__proxy;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jdk__proxy.domain.Employee;
import com.jdk__proxy.service.IEmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class App {
	@Autowired
	private IEmployeeService service;
	
	@Test
	public void test1() throws Exception {
			service.save(new Employee());
	}
	@Test
	public void test2() throws Exception {
		service.update(new Employee());
	}
}
