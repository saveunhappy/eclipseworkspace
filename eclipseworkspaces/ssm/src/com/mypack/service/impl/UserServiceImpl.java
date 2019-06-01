package com.mypack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypack.domain.User;
import com.mypack.mapper.UserMapper;
import com.mypack.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserMapper userMapper;
	public void save(User u) {
		userMapper.save(u);
	}

	@Override
	public void delete(Long id) {
		userMapper.delete(id);
	}

	@Override
	public void update(User u) {
		userMapper.update(u);
	}

	@Override
	public User get(Long id) {
		return userMapper.get(id);
	}

	@Override
	public List<User> listAll() {
		return userMapper.listAll();
	}

}
