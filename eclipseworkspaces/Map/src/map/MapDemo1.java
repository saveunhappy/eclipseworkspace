package map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo1 {
	public static void main(String[] args) {
		
		/**
		 * Map的特点：
		 * 数据成对出现
		 * 数据的键是唯一的
		 * 一个键只能对应一个值
		 * 值可以重复
		 * 键允许一个为空，值可以多个是空
		 * 方法：
		 * put()
		 * putAll()
		 * remove()
		 * clear()
		 * 
		 * get()
		 *  Set<k>   keySet
		 *  
		 *  判断功能：
		 *  containsKey()
		 *  containsValue()
		 *  isEmpty()
		 *  
		 *  
		 *  遍历方式：
		 *  Set<Entry<String,Person>> entry = map.entrySet();
		 *  for(Entry<String,Person> sp:entry){
		 *  	String key = sp.getKey();
		 *  	Person value = sp.getValue();
		 *  System.out.println("键："+key+"   值:"+value);
		 *  
		 *  }
		 *  HashMap:
		 *  
		 *  HashMap是map的实现类
		 *   允许多个null值和null键
		 *   Hashmap中的元素没有顺序
		 *   hashmap不是线程安全的
		 *   Map<String,String> map = new HashMap<String,String>();
		 *   map = Collections.synchronizedMap(map);
		 *   这样就变成了线程安全的
		 *   
		 *   Treemap：
		 *   可以进行自然排序
		 *   可以创建comparetor进行排序，可以重写compareto进行排序
		 *   
		 *   key不能为null，不能重复
		 *   
		 *   
		 *   HashTable：
		 *   不允许有任何null值和null键
		 *   
		 *   HashTable中的元素没有顺序
		 *   是线程安全的
		 *   
		 *   LinkedHashMap:
		 *   
		 *   有顺序，
		 *   允许多个null值和null键
		 *   不是线程安全的
		 *   
		 *  
		 *  
		 */
		Map<String,String> map = new HashMap<String,String>();
		map.put("鼓上蚤","时迁");
		map.put("行者","武松");
		//键是唯一的，如果有俩会存在覆盖的情况
		map.put("行者","武大郎");
		
		
	}
}
