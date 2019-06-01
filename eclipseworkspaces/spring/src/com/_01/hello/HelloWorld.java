package com._01.hello;

public class HelloWorld {
	private String username;
	public void setUsername(String username) {
		this.username = username;
	}
	public void sayHello() {
		System.out.println("hello Spring"+username);
	}
}
