package com.mypack.service;

import java.util.List;

import com.mypack.domain.User;

public interface IUserService {
	void save(User u);

	void delete(Long id);

	void update(User u);

	User get(Long id);

	List<User> listAll();
}
