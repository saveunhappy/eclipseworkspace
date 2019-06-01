package com._02.springtest;
//演示Spring的测试

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//告诉JVM，在JVM	上运行Spring容器
@RunWith(SpringJUnit4ClassRunner.class)
//从哪里找配置文件
@ContextConfiguration("classpath:com/_02/springtest/springTest.xml")
public class SpringtestTest {
	@Autowired
	private SomeBean bean;
	@Test
	public void testName() throws Exception {
		bean.sayHello();
	}
}
