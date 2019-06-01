package properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Demo5 {
	public static void main(String[] args) {
		
		/**
		 * java.lang.Object
  			继承者 java.util.Dictionary<K,V>
      			继承者 java.util.Hashtable<Object,Object>
          			继承者 java.util.Properties
		属性集类
		 * 这个不用指定泛型以为API中就没有指定
		 */
		Properties pro = new Properties();
		FileReader fr = null;
		
	
		try {
			//实际项目中使用properties来存储数据，不用TXT
			fr = new FileReader("src/prop.properties");
			//把字符流数据读到pro对象中
			pro.load(fr);
			String name = pro.getProperty("zhangshan");
			String age = pro.getProperty("lisi");
			String gender = pro.getProperty("wangwu");
			/**
			 * 输出的是键后面的东西，如果键后面有自己写的东西也会被读取出来
			 */
			System.out.println(name);
			System.out.println(age);
			System.out.println(gender);
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(fr!=null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
