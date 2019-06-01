package com._520it._01_sims.domain;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Student {
	private Long id;
	private String name;
	private Integer age;
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}
