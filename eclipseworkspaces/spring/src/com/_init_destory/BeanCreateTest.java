package com._init_destory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class BeanCreateTest {
	@Autowired
	private ApplicationContext ctx;
	
	@Test
	public void testName() throws Exception {
		SomeBean bean4 = ctx.getBean("someBean",SomeBean.class);
		System.out.println(bean4);
	
	}
}
