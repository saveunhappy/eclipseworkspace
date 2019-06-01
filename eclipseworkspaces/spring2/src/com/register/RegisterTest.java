package com.register;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.register.action.UserAction;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class RegisterTest {
	
	
	@Autowired
	private UserAction action;
	@Test
	public void testName() throws Exception {
		action.register();
		
	}
}
