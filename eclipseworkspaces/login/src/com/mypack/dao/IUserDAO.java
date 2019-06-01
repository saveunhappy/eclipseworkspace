package com.mypack.dao;

import com.mypack.domain.User;

public interface IUserDAO {
	User getUserByUsername(String username);
}
