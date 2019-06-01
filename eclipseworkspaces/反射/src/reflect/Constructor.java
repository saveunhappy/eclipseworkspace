package reflect;

class User{
	public User() {
		
	}
	public User(String name) {
		
	}
	private User(String name,int age) {
		
	}
}

public class Constructor {
	
	
	public static void main(String[] args) throws Exception {
		//getAll();
		getone();
	}

	private static void getone() throws Exception {

		Class clz = Person.class;
		java.lang.reflect.Constructor con = clz.getConstructor();
		System.out.println(con);
		con = clz.getConstructor(String.class);
		System.out.println(con);
		con = clz.getDeclaredConstructor(String.class,int.class);
		System.out.println(con);
			
	}

	private static void getAll() {
		Class<Person> clz = Person.class;
		java.lang.reflect.Constructor<?>[] cs = clz.getConstructors();
		for (java.lang.reflect.Constructor<?> constructor : cs) {
				System.out.println(constructor);
		}
		cs = clz.getDeclaredConstructors();
		for (java.lang.reflect.Constructor<?> constructor : cs) {
				System.out.println(constructor);
		}
	}
}
