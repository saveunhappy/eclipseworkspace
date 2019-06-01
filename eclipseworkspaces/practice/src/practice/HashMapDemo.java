package practice;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
		
	
	public static void main(String[] args) {
		/**
		 * map的实现类HashMap
		 * 1.允许多个null值和一个null键
		 * 2.HashMap中的元素没有顺序（跟添加的顺序无关）
		 * 3.HashMap不是线程安全的
		 */
		Map<String,String> map = new HashMap<String,String>();
		map.put("鼓上蚤", "时迁");
		map.put("呼保义", "宋江");
		map.put("及时雨", "宋江");
		map.put("行者", "武松");
		System.out.println(map);
		
	}
}
