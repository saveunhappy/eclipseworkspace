package com.mypack.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	public String execute() throws Exception{
		System.out.println("hello struts2");
		return "will";
	}
	public String hello() throws Exception{
		System.out.println("hello ");
		return "will";
	}
}
