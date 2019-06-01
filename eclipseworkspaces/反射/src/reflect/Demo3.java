package reflect;
class Person{
	public Person() {
		System.out.println("无参数构造器");
	}
	public Person(String name) {
		
		System.out.println("一个参数构造器");
	}
	private Person(String name,int age) {
		
		System.out.println("两个参数构造器");
	}
}
public class Demo3 {
	public static void main(String[] args) throws Exception {
//		传统方式
//		new Person();
		Class<Person> clz = Person.class;
		//有一个公共的无参数构造器就可以直接使用它的newinstance方法
		clz.newInstance();
		java.lang.reflect.Constructor<Person> con = clz.getConstructor();
		Person p =  con.newInstance();
		System.out.println(p);
		con = clz.getConstructor(String.class);
		con.newInstance("hhh");
		con = clz.getDeclaredConstructor(String.class,int.class);
		con.setAccessible(true);
		con.newInstance("aa",17);
		
		
	}
}	
