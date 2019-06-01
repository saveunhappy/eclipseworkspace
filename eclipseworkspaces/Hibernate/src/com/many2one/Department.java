package com.many2one;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Department {
	private Long id;
	private String name;
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
	
}
