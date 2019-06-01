package com.jdk_proxy;

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
public class JdkProxyTest {
	@Autowired
	private TransactionManagerHander hander;
	@Test
	public void testName() throws Exception {
		//获取代理对象
		IEmployeeServcie service = hander.getProxyObject();
		//System.out.println(service.getClass());
		service.save(new Employee());
	}
	@Test
	public void test1() throws Exception {
		IEmployeeServcie service = hander.getProxyObject();
		service.update(new Employee());
	}
}
