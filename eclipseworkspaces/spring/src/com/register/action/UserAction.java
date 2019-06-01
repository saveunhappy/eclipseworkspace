package com.register.action;

import com.register.domain.User;
import com.register.service.IUserService;

import lombok.Setter;

public class UserAction {
	
	@Setter
	private IUserService userService;
	public void register() {
		System.out.println("UserAction.register()");
		userService.save(new User());
	}
}
