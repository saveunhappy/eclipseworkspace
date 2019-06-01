package sss;

public class Student {

	int id;
	String name;
	public Student() {
		
	}
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	public String toString() {
		return "id=" + id + ", name=" + name;
	}
	public void show(){
		System.out.println("±àºÅ£º "+id+"ÐÕÃû£º "+name);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
