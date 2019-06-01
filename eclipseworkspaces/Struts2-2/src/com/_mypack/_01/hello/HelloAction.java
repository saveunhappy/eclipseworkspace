package com._mypack._01.hello;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;

	public String sayHello() {
		System.out.println("hello struts2");
		return "will";
	}
}
