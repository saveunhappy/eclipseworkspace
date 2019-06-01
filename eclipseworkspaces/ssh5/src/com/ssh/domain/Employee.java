package com.ssh.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Employee extends BaseDomain{
	private String name;
	private Integer age;
	private String password;
	private String email;
	private Department dept;
	private boolean admin = false;
	@Override
	public String toString() {
		return "Employee [name=" + name + ", password=" + password + ", email="+ "]";
	}
	List<Role> roles = new ArrayList<>();
	
}
