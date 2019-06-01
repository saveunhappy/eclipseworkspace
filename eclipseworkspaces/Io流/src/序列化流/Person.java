package 序列化流;

import java.io.Serializable;

public class Person implements Serializable{
	/**
	 * 给	类一个指定的序列化版本的ID如果这个类发生了变化，不会影响到反序列化
	 */
	private static final long serialVersionUID = 9054167076142082527L;

	private String name;
	
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
