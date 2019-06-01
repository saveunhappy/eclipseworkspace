package com.spring_aop_xml.copy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.common.domain.Employee;
import com.common.service.IEmployeeServcie;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AopByXmlTest {
	@Autowired
	private IEmployeeServcie service;
	@Test
	public void testName() throws Exception {
		service.save(new Employee());
	}
	@Test
	public void test1() throws Exception {
		service.update(new Employee());
	}
}
