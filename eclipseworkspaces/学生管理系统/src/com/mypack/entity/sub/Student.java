package com.mypack.entity.sub;

import com.mypack.entity.Person;

public class Student extends Person{
	public Student(String name, int id,String homeWork,int height) {
		super(name, id);
		this.homeWork=homeWork;
		this.height=height;
		// TODO Auto-generated constructor stub
	}
	private String homeWork;
	private int height;
	public String getHomeWork() {
		return homeWork;
	}
	public void setHomeWork(String homeWork) {
		this.homeWork = homeWork;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String toString() {
		return "Student [homeWork=" + homeWork + ", height=" + height + "]";
	}

	
}
