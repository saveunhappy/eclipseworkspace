package com.zz;

public class Student extends Person{
	private int alimony;//生活费
	private int tuition;//学费
	public Student() {
		
	}
	public Student(int id, String name,int age) {
		setId(id);
		setName(name);
		setAge(age);
	}
	public int getAlimony() {
		return alimony;
	}
	public void setAlimony(int alimony) {
		this.alimony = alimony;
	}
	public int getTuition() {
		return tuition;
	}
	public void setTuition(int tuition) {
		this.tuition = tuition;
	}
	public void print(){
		System.out.println("学生编号为："+getId()+",学生姓名为："+getName()+"，年龄为："+getAge());
	}
}
