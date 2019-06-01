package 集合框架;

import java.util.ArrayList;
import java.util.List;

public class Demo2 {
	public static void main(String[] args) {
		//带有integer类型的泛型
		List<Integer> list1 = new ArrayList<>();
		
		list1.add(123);
		
		List list2 = null;
		list2 = list1;//此时泛型被擦除
		list2.add("ABC");
		List<String> list3 = null;
		list3 = list2;
		//等价于 String num = 123;
		String num = list3.get(0);
		System.out.println(num);
		
		
		
	}
}
