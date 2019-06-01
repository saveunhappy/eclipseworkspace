package com._520if._shopping._dao._Impl;

import org.junit.Test;

import com._520if._shopping._dao.IUserDAO;
import com._520if._shopping._domain.User;

public class UserDAOImplTest {
	IUserDAO user = new UserDAOImpl();
	@Test
	public void testGetUserByUsername() {
		String username = "admin1";
		User s = user.getUserByUsername(username);
		System.out.println(s);
	}

}
