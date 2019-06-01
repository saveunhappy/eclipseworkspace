package 序列化流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Demo2 {
	public static void main(String[] args) {
	//	writeObject1();
		readObject1();
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
			 oos = new ObjectOutputStream(new FileOutputStream("person1.txt"));
			 Person p = new Person();
			 p.setName("阿彪");
			 p.setAge(20);
			 //调用序列化流的写入方法
			 Person p1 = new Person();
			 p1.setName("张三");
			 p1.setAge(18);
		
			 Person p2 = new Person();
			 p2.setName("李四");
			 p2.setAge(25);
			 oos.writeObject(p);
			 oos.writeObject(p1);
			 oos.writeObject(p2);
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
	public static void writeObject1() {
		/**
		 * 如果想要序列化某个对象，那这个对象必须实现一个接口Serializable
		 */
		ObjectOutputStream oos = null;
		try {
			//创建序列化的流对象
			 oos = new ObjectOutputStream(new FileOutputStream("person1.txt"));
			 ArrayList<Person> al = new ArrayList<Person>();
			 Person p = new Person();
			 p.setName("阿彪");
			 p.setAge(20);
			 //调用序列化流的写入方法
			 Person p1 = new Person();
			 p1.setName("张三");
			 p1.setAge(18);
		
			 Person p2 = new Person();
			 p2.setName("李四");
			 p2.setAge(25);
			 al.add(p);
			 al.add(p1);
			 al.add(p2);
			 //这里不需要做刷新
			 /**
			  * 这里写入的就是集合
			  */
			 oos.writeObject(al);
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
			 oos = new ObjectInputStream(new FileInputStream("person1.txt"));
			 
			 //从反序列化的流中来读取数据
			 Object obj = oos.readObject();
			 Object obj1 = oos.readObject();
			 Object obj2 = oos.readObject();
			 Person p = (Person)obj;
			 System.out.println(p);
			 System.out.println(obj1);
			 System.out.println(obj2);
			 
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
	public static void readObject1() {
		/**
		 * 如果想要序列化某个对象，那这个对象必须实现一个接口Serializable
		 */
		ObjectInputStream oos = null;
		try {
			//创建序列化的流对象
			 oos = new ObjectInputStream(new FileInputStream("person1.txt"));
			 Object obj = oos.readObject();
			 ArrayList<Person> al = (ArrayList<Person>)obj;
			 for(Person p : al) {
				 System.out.println(p);
			 }
			 /**
			 * 
			 不能这么干！！！得放到一个集合里面去
			 Object obj = null;
			 while((obj = oos.readObject()) != null)
			 {
				 System.out.println(obj);
			 }
			 */
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
