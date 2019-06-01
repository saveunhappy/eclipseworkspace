package com.one2many;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
	private Long id;
	private String name;
	//员工所属的部门
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
}
