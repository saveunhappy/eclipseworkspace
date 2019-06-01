package com.register.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.register.dao.IUserDAO;
import com.register.domain.User;
import com.register.service.IUserService;
@Service("userServcie")
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserDAO userDAO;
	public void save(User u) {
		System.out.println("UserServiceImpl.save()");	
		userDAO.save(u);
	}

}
