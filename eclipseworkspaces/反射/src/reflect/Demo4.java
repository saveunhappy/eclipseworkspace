package reflect;

import java.lang.reflect.Method;

class Stu{
	public void doWork() {
		System.out.println("Stu.doWork()");
	}
	public static void  doWork(String name) {
		System.out.println("Stu.doWork()"+name);
	}
	private String doWork(String name,int age) {
		System.out.println("Stu.doWork()"+name+age);
		return name+" "+age;
	}
}


public class Demo4 {
	public static void main(String[] args) throws Exception {
		//getAll();
		getone();
	}

	private static void getone() throws Exception {
		Class<Stu> clz = Stu.class;
		Method m  = clz.getDeclaredMethod("doWork",String.class);
		m.invoke(null,"hh");
		/*
		m = clz.getDeclaredMethod("doWork",String.class,int.class);
		m.setAccessible(true);
		m.invoke(clz.newInstance(),"阿彪",19);
		*/
	}

	private static void getAll() {
		
		Class clz = Stu.class;
		//获取自身和继承过来的所有public的方法
		Method[] method = clz.getMethods();
		System.out.println(method.length);
		for (Method method2 : method) {
			System.out.println(method2);
		}
		//加上declared就可以获取自身类中的方法了，不包括继承和访问权限无关
		 method = clz.getDeclaredMethods();
		System.out.println(method.length);
		for (Method method2 : method) {
			System.out.println(method2);
		}
		
		
	}
}
