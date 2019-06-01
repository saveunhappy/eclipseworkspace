package com.mypack.dao;

import java.util.List;

import com.mypack.domain.User;

public interface IUserDAO {

	void save(User u);

	void update(User u);

	void delete(User u);

	User get(Long id);

	List<User> listAll();

}
