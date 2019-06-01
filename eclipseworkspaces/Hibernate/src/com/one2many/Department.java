package com.one2many;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Department {
	private Long id;
	private String name;
	private Set<Employee> emps = new HashSet<>();
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
	
}
