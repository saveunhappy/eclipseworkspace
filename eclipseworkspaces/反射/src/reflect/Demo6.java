package reflect;

import java.lang.reflect.Modifier;

public class Demo6 {
	public static void main(String[] args) {
		
		Class clz = Demo6.class;
		int modify = clz.getModifiers();
		System.out.println(modify);
		String m = Modifier.toString(modify);
		System.out.println(m);
	}
}
