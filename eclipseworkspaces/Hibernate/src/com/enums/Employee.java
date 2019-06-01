package com.enums;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Employee {
	private Long id;
	private String name;
	private Sex sex;
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", sex=" + sex + "]";
	}
	
}
