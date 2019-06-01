package com._init_destory;

public class SomeBean {
	public SomeBean(){
		System.out.println("构造器");
	}
	public void open() {
		System.out.println("初始化");
	}
	public void desory() {
		System.out.println("销毁");
	}
	public void sayHello() {
		System.out.println("hello");
	}
}
