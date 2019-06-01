package com._520if._shopping._dao._Impl;

import com._520if._shopping._dao.IUserDAO;
import com._520if._shopping._domain.User;
import com._520if._shopping.handler.BeanHandler;
import com._520if._shopping.util.JdbcTemplate;

public class UserDAOImpl implements IUserDAO{

	public User getUserByUsername(String name) {
		String sql = "select * from t_user where username = ?";
		return JdbcTemplate.query(sql, new BeanHandler<>(User.class), name);
	}
	
}
