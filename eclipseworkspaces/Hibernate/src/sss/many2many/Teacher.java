package sss.many2many;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
@Getter@Setter
public class Teacher {
	private Long id;
	private String name;
	private Set<Student> stus = new HashSet<>();
	public Teacher(String name) {
		super();
		this.name = name;
	}

	public Teacher() {
		super();
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + "]";
	}
	
}
