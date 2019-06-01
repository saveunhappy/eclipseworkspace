package com._zz._it._test;


import org.junit.Test;

import com._zz._it._dao.IUserDAO;
import com._zz._it._dao._Impl.UserDAOImpl;
import com._zz._it._domain.User;

public class UserDAOImplTest {
	IUserDAO user = new UserDAOImpl();
	@Test
	public void testGetUserByUsername() {
		String username = "admin";
		User s = user.getUserByUsername(username);
		System.out.println(s);
	}

}
