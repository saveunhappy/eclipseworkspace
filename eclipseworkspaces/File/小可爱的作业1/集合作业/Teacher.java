package com.zz;

public class Teacher extends Person{
	private int salary;//工资
	private String major;//专业
	public Teacher() {
		
	}
	public Teacher(int id, String name,int age) {
		setId(id);
		setName(name);
		setAge(age);
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public void print(){
		System.out.println("老师编号为："+getId()+"老师姓名为："+getName()+"，年龄为："+getAge());
	}
}
