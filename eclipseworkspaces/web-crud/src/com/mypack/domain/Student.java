package com.mypack.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Student {
	private Long id;
	private String name;
	private Integer age;
	
	
	
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	public Student(Long id, String name, Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public Student(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	public Student() {}

	
}
