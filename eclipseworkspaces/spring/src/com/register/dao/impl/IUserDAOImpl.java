package com.register.dao.impl;

import com.register.dao.IUserDAO;
import com.register.domain.User;

public class IUserDAOImpl implements IUserDAO{
	
	public void save(User u) {
		System.out.println("IUserDAOImpl.save()");
	}

}
