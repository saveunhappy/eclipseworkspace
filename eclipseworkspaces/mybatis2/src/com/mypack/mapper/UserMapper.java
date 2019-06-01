package com.mypack.mapper;

import java.util.List;

import com.mypack.domain.User;

public interface UserMapper {
	void save(User u);
	
	void update(User u);
	
	void delete(Long id);
	
	User get(Long id);
	
	List<User> listAll();
}
