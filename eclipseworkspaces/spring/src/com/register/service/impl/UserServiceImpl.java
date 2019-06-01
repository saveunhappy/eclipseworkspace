package com.register.service.impl;

import com.register.dao.IUserDAO;
import com.register.dao.impl.IUserDAOImpl;
import com.register.domain.User;
import com.register.service.IUserService;

import lombok.Setter;

public class UserServiceImpl implements IUserService{
	@Setter
	private IUserDAO userDAO;
	public void save(User u) {
		System.out.println("UserServiceImpl.save()");	
		userDAO.save(u);
	}

}
