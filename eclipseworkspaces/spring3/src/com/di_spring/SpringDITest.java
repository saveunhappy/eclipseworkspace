package com.di_spring;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SpringDITest {
	
	@Autowired
	@Qualifier("someBean")
	private SomeBean bean;
	@Test
	public void testName() throws Exception {
		System.out.println(bean);
	}
}
