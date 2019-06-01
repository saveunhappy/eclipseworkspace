package com.query;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
@Getter@Setter
public class Department {
	private Long id;
	private String name;
	private String provice;
	private String city;
	private String street;
	private String sn;
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", provice=" + provice + ", city=" + city + ", street="
				+ street + ", sn=" + sn + "]";
	}
	private Employee manager;//MANAGER_ID
	private Set<Employee> emps = new HashSet<>();
}
