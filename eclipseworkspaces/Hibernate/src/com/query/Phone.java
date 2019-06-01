package com.query;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Phone {
	private Long id;
 	private PhoneType types;
	private String number;
	private Employee employee;//EMPLOYEE_ID
	@Override
	public String toString() {
		return "Phone [id=" + id + ", types=" + types + ", number=" + number + "]";
	}
	
	
}
