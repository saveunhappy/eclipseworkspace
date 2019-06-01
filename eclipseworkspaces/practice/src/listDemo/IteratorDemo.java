package listDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("b");
		list.add("C");
		list.add("d");
		/*
		for(String ele:list) {
			System.out.println(ele);
			if("d".equals(ele)) {
				list.remove(ele);
			}
		}*/
		Iterator it = list.iterator();
		while(it.hasNext()) {
			String str = (String)it.next();
			if("b".equals(str)){
				it.remove();
			}
		}
		System.out.println(list);
	}
}	
