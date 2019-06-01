package com.many2one;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
	private Long id;
	private String name;
	//员工所属的部门
	private Department dept;
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
}
