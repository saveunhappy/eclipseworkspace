package com.ioc_anno;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class IocByAnnoTest {
	@Autowired
	private SomeBean bean;
	@Test
	public void testName() throws Exception {
		System.out.println(bean);
	}
}
