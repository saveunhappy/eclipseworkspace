package com.mypack.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data
public class Department {
	private Long id;
	private String name;
	private List<Employee> emps = new ArrayList<Employee>();
	

	

}
 