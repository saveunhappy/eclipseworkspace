package 序列化流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Demo1 {
	public static void main(String[] args) {
		//writeObject();
		readObject();
		/**
		 * 在序列化的过程中要手动指定要序列化的serialVersionUID,这样可以在类改变后依然可以反序列化，否则会报错
		 */
	}
	public static void writeObject() {
		/**
		 * 如果想要序列化某个对象，那这个对象必须实现一个接口Serializable
		 */
		ObjectOutputStream oos = null;
		try {
			//创建序列化的流对象
			 oos = new ObjectOutputStream(new FileOutputStream("person.txt"));
			 Person p = new Person();
			 p.setName("阿彪");
			 p.setAge(20);
			 //调用序列化流的写入方法
			 
			 oos.writeObject(p);
			 //这里不需要做刷新
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(oos!=null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	public static void readObject() {
		/**
		 * 如果想要序列化某个对象，那这个对象必须实现一个接口Serializable
		 */
		ObjectInputStream oos = null;
		try {
			//创建序列化的流对象
			 oos = new ObjectInputStream(new FileInputStream("person.txt"));
			 
			 //从反序列化的流中来读取数据
			 Object obj = oos.readObject();
			 Person p = (Person)obj;
			 System.out.println(p);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		finally {
			if(oos!=null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
