package com.register.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.register.domain.User;
import com.register.service.IUserService;

import lombok.Setter;
@Controller("userAction")
@Scope("prototype")
public class UserAction {
	@Autowired
	private IUserService userService;
	public void register() {
		System.out.println("UserAction.register()");
		userService.save(new User());
	}
}
