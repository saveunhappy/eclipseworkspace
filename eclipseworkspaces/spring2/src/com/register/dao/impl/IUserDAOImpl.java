package com.register.dao.impl;

import org.springframework.stereotype.Repository;

import com.register.dao.IUserDAO;
import com.register.domain.User;
@Repository("userDAO")
public class IUserDAOImpl implements IUserDAO{
	
	public void save(User u) {
		System.out.println("IUserDAOImpl.save()");
	}

}
