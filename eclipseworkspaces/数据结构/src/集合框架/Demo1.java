package 集合框架;

import java.util.ArrayDeque;
import java.util.Deque;

public class Demo1 {
	
	protected Object[] elementDate;
	
	protected int elementCount;
	
	static final int a = 10;
	/*
	public Vector(int a) {
		this.elementDate = new Object(a);
	}
	public Vector() {
		this(10); //Vactor的默认容量为10
	}
	集合中存储的对象都是对象的引用，而不是对象本身
	
	栈(Stack):数据结构中的一种，存储特点：后进先出
	
	官方建议：使用栈尽量使用ArrayDeque
	
	*/
	public static void main(String[] args) {
		
		/**
		 * 常用的集合类：
		 * set(集):集合中的对象不按特定的方式排序，不允许元素重复
		 * list(列表):集合中的对象按照索引位置排序，允许元素重复
		 * Map(映射):集合中每一个元素都包含一对key和value对象，不允许key对象重复，值对象可以重复
		 * 
		 * 
		 */
		/**
		 * 
		 * 
		 */
		Deque<Integer> stack = new ArrayDeque<Integer>();
		stack.add(1);
		stack.add(1);
		stack.add(1);
		System.out.println(stack);
	}
	/**
	 * 
	 * 
	 * ArrayList类是java集合框架出现之后用来取代vector类的
	 * 二者底层原理都是基于数组的算法，一模一样
	 * vector所有方法都使用了synchronized修饰符
	 * ArrayList所有方法都没有使用synchronized修饰符
	 * 即使以后在多线程环境下，我们也不使用vector类
	 * ArrayList list = Collections.synchronizedList(new ArrayList(...))
	 * ArrayLIst返回值：如果是一个都没有查询到，我们不会返回null，而是会返回一个空的集合
	 * 
	 * 
	 */
	/**
	 * 
	 * foreach可以操作数组  底层依然使用for循环+索引来获取数组元素
	 * foreach可以操作Iterable的实例，底层使用的Iterator(迭代器)
	 * 编译前：
	 * List list = new ArrayList();
	 * list.add("a");
	 * list.add("b");
	 * list.add("c");
	 * list.add("d");
	 * for(Object ele:list){
	 * 	System.out.println(ele);
	 * }
	 * 编译后:
	 * List list = new ArrayList();
	 * list.add("a");
	 * list.add("b");
	 * list.add("c");
	 * list.add("d");
	 * Object ele;
	 * for(Iterator iterator = list.iterator();iterator.hasNext();;)
	 * ele = iterator.next();
	 * System.out.println(ele);
	 */
	/**
	 * 当需要边迭代集合边删除指定的元素时，只能使用迭代器。
	 * 而且只能使用迭代器的remove方法
	 * 当迭代的时候线程A会单独创建一个线程B  吧里面的元素给拷贝过去，A迭代，B删除，B每次都会去检查元素是否个数相同
	 * 不是的话就会报错
	 * list中的remove只能从集合中删除，不能删除迭代器中的元素，
	 * 王道：使用Iterator中的remove
	 * 该方法会从两个线程中	同时移除被删除的元素，保证两个线程的同步
	 * 
	 * Iterator it = list.iterator();
	 * while(it.hasNext){
	 * Object ele = it.next();
	 * if("B".equals(ele)){
	 * 	//list.remove(ele)错误，不能使用集合对象的remove方法		
	 * it.remove()
	 * }
	 * } 
	 * 
	 */
}
