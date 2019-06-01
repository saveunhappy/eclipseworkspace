package com._zz._it._dao._Impl;

import com._zz._it._dao.IUserDAO;
import com._zz._it._domain.User;
import com._zz._it.handler.BeanHandler;
import com._zz._it.util.JdbcTemplate;

public class UserDAOImpl implements IUserDAO{

	public User getUserByUsername(String name) {
		String sql = "select * from t_user where username = ?";
		return JdbcTemplate.query(sql, new BeanHandler<>(User.class), name);
	}
	
}
