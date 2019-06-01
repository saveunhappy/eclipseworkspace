package com.mypack.entity;

public class Person {
	private String name;
	private int id;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return "Person [name=" + name + ", id=" + id + "]";
	}

	public Person(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	
	
}
