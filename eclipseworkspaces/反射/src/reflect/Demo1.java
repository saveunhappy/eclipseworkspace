package reflect;

import java.util.Date;

public class Demo1 {
	public static void main(String[] args) throws Exception {
		//需求1：获取java.util.Date类的字节码对象
		//方式一：使用class属性
		Class<java.util.Date> clz = java.util.Date.class;
		//方式2：通过对象的getClass方法，这个方法是object中的，所有的对象都可以用
		Date date = new Date();
		Class<?> clz1 = date.getClass();
		//方式3：通过class类中的静态方法forName(String className)
		Class<?>clz3 = Class.forName("java.util.Date");
		System.out.println(clz);
		System.out.println(clz1);
		System.out.println(clz3);
		
		
		
	}
}
