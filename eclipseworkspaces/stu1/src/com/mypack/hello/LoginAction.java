package com.mypack.hello;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	
	private static final long serialVersionUID = 1L;
	public String execute() throws Exception {
		System.out.println("LoginAction.execute()");
		return NONE;
	}
}