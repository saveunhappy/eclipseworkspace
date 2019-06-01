package com._04.factorybean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class BeanCreateTest {
	@Autowired
	private ApplicationContext ctx;
	
	@Test
	public void testName() throws Exception {
		SomeBean4 bean4 = ctx.getBean("someBean4",SomeBean4.class);
		System.out.println(bean4);
	
	}
}
