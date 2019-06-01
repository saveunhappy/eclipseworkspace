package com._520if._shopping.util;

public class Test {
	public static void main(String[] args) {
		Person p1 = new Person("张三",18);
		Person p2 = new Person("李四",20);
		Person p3 = new Person("王五",22);
		Person[] person = {p1,p2,p3};
//		Double d = getTotal(person);
//		Double d = getTotal(p1,p2,p3);
//		System.out.println(d);
	}
//	public static Double getTotal(Person ... items) {
//		Double ret = 0.0;
//		for (int i = 0; i < items.length; i++) {
//			Person p = items[i];
//			ret += p.getAge();
//		}
//		
//		return ret;
//	}
	public static Double getTotal(Person[] items) {
		Double ret = 0.0;
		for (int i = 0; i < items.length; i++) {
			Person p = items[i];
			ret += p.getAge();
		}
		
		return ret;
	}


}
