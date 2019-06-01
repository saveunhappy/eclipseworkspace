package com.mypack.dao.impl;
import com.mypack.dao.IUserDAO;
import com.mypack.domain.User;
import com.mypack.handler.BeanHandler;
import com.mypack.util.JdbcTemplate;

public class UserDAOImpl implements IUserDAO {

	public User getUserByUsername(String username) {
		String sql = "select * from user where username = ?";
		return JdbcTemplate.query(sql, new BeanHandler<>(User.class), username);
	}

}
