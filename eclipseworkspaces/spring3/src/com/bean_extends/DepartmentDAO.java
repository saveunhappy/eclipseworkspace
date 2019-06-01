package com.bean_extends;

import lombok.Setter;

public class DepartmentDAO {
	@Setter
	private String connection;
	public void save() {
		System.out.println(connection);
		System.out.println("保存部门");
	}
}
