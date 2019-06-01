package com.ioc_anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class SomeBean {
	
	@Autowired
	private OtherBean bean;

	@Override
	public String toString() {
		return "SomeBean [bean=" + bean + "]";
	}


	
}	
