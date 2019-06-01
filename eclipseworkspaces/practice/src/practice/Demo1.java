package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Demo1 {
	public static void main(String[] args) {
		/**
		 * map的特点： 1.数据成对出现 2.数据的键是唯一的，如果有相同的会被覆盖的 3.一个键只能有一个值 4.值可以重复
		 * 5.键允许有一个为空，值可以多个是空，有一个null可以对应，有两个null就无法正确对应了
		 */
		Map<String, String> map = new HashMap<String, String>();
		map.put("鼓上蚤", "时迁");
		map.put("行者", "武松");
		map.put("及时雨", "宋江");
		map.put("呼保义", "宋江");
		map.put(null, "无用");
		map.put("晓晓", null);
		map.put("螃蟹", null);
		// 只能有一个null键，否则，会被覆盖
//		map.put(null, "无1用");
		System.out.println(map);

		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("花和尚", "鲁智深");
		map1.put("青面兽", "杨志");
		// 一个map添加到另一个map中
		map.putAll(map1);
		System.out.println(map);
//		清空map
		map1.clear();
		System.out.println(map1);
		// 删除一个键值对
		map.remove("青面兽");
		// 通过对应的键来获取值
		System.out.println(map);
		// 通过get来获取键值对  如果没有相应的键就返回null
		String a = map.get("花和尚");
		System.out.println(a);
			
		Set<String> set = map.keySet();
		//这里输出的是所有的键
		System.out.println(set);
		for(String key:set) {
			//根据当前的key来获得value
			String value  = map.get(key);
			System.out.println(value);
		}
		
		Map<String,Person> map2 = new HashMap<String,Person>();
		
		map2.put("3", new Person(1,"阿彪",1));
		map2.put("2", new Person(1,"拖拉机",2));
		System.out.println(map2);
		//是否包含某个值
		boolean iscon = map.containsKey("花和尚");
		System.out.println(iscon);
		boolean isval = map.containsValue("鲁智深");
		System.out.println(isval);
		
		boolean isval1 = map2.containsValue(new Person(1,"阿彪",1));
		System.out.println(isval1);
		
		Set<Entry<String, String>> entry  = map.entrySet();
		for(Entry<String, String> et : entry)
		{		//for循环中自己定义的那个就是元素
			String key1 = et.getKey();
			String value1 = et.getValue();
			System.out.println("键：  "+key1+"     值:"+value1);
		}
		
	}
}
