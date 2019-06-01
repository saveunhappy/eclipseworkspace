package com.di_spring;

import org.springframework.beans.factory.annotation.Autowired;

public class SomeBean {
	
	
	private OtherBean1 bean1;
	private OtherBean2 bean2;
	@Autowired
	public void setBean1(OtherBean1 bean1) {
		this.bean1 = bean1;
	}

	@Autowired
	public void setBean2(OtherBean2 bean2) {
		this.bean2 = bean2;
	}

	public String toString() {
		return "SomeBean [bean1=" + bean1 + ", bean2=" + bean2 + "]";
	}
	
	
}	
