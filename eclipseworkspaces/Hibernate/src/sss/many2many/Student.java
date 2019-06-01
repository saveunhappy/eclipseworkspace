package sss.many2many;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
@Getter@Setter
public class Student {
	private Long id;
	private String name;
	private Set<Teacher> teas = new HashSet<>();
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	public Student() {
		super();
	}
	
}
