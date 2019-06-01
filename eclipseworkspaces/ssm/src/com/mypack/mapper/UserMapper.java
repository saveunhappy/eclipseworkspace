package com.mypack.mapper;

import java.util.List;

import com.mypack.domain.User;

public interface UserMapper {
	void save(User u);
	
	void delete(Long id);
	
	void update(User u);
	
	User get(Long id);
	
	List<User> listAll();
}
