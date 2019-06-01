package com._520if._shopping._dao._Impl;

import java.util.List;
import java.util.concurrent.SynchronousQueue;

import org.junit.Test;

import com._520if._shopping._dao.IUserDAO;
import com._520if._shopping._domain.Product;
import com._520if._shopping._domain.User;
import com._520if._shopping.handler.BeanListHandler;
import com._520if._shopping.util.JdbcTemplate;
import com._520if._shopping.util.MD5;

public class UserDAOImplTest {
	IUserDAO user = new UserDAOImpl();
	@Test
	public void testGetUserByUsername() {
		String username = "1";
		JdbcTemplate.update("update t_user set username = ? where id = ?",MD5.encode(username),1);
		List<User> query = JdbcTemplate.query("select * from t_user where id = ?",new BeanListHandler<>(User.class),1);
		System.out.println("---------");
		for (User user : query) {
			System.out.println(user);
		}
		
		
	}

}
