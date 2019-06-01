package com.query;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Project {
	private Long id;
	private String name;
	private Employee manager;//MANAGER_ID
	private Set<Employee> emps = new HashSet<>();
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", manager=" + manager + "]";
	}
	
}
