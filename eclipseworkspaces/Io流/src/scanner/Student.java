package scanner;

public class Student implements Comparable<Student>{
	private Integer Id;
	
	private String name;
	
	private Integer age;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public int compareTo(Student o) {
		int val  = this.Id-o.getId();
		if(val==0)
		{
			val = this.age - o.getAge();
			if(val==0) {
			val = this.name.compareTo(o.getName());
			}
		}
		return val;
	}
	
}
