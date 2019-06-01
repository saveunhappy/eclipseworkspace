package com.static_proxy;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.common.domain.Employee;
import com.common.service.IEmployeeServcie;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class StaticProxyTest {
	@Autowired
	@Qualifier("employeeServiceProxy")
	private IEmployeeServcie proxy;
	@Test
	public void testName() throws Exception {
		System.out.println(proxy.getClass());
		proxy.save(new Employee());
	}
	@Test
	public void test1() throws Exception {
		proxy.update(new Employee());
	}
}
