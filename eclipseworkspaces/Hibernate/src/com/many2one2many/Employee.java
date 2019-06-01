package com.many2one2many;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
	private Long id;
	private String name;
	private Department dept;
	//员工所属的部门
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
}
