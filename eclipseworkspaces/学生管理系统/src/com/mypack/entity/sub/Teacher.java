package com.mypack.entity.sub;

import com.mypack.entity.Person;

public class Teacher extends Person{

	public Teacher(String name, int id,String salary,String course) {
		super(name, id);
		this.salary=salary;
		this.course=course;
	}
	private String salary;
	private String course;
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String toString() {
		return "Teacher [salary=" + salary + ", course=" + course + "]";
	}

	
	
}
