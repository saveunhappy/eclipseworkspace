package listDemo;

import java.util.Arrays;

public class MyArrayList {
	//存储任意数据类型
	private Object[] elements = null;
	//数组中存储多少个元素
	private int size = 0;
	private static final int DEFAULT = 10;
	
	public MyArrayList(int a) {
		if(a<0) {
			throw new IllegalArgumentException("容量不能为负数");
		}
		elements = new Object[DEFAULT];
	}
	public MyArrayList() {
		this(10);
		//默认调用有参数的那个构造器，初始容量为10
	}
	public void add(Object ele) {
		if(size==elements.length) {
			Object[] temp = Arrays.copyOf(elements, elements.length * 2);
		}
		elements[size] = ele;
		size++;
	}
	
	//查找指定索引位置的索引
	
	public Object get(int index) {
		if(index<0||index>=size) {
			throw new IllegalArgumentException("索引越界");
		}
		return elements[index];
	}
	//替换指定索引位置的元素值
	public void set(int index,Object newEle) {
		if(index<0||index>=size) {
			throw new IllegalArgumentException("索引越界");
		}
		elements[index] = newEle;
	}
	//删除指定索引位置的元素
	public void remove(int index) {
		if(index<0||index>=size) {
			throw new IllegalArgumentException("索引越界");
		}
		for(int i=index; i<size-1;i++) {
			elements[i] = elements[i+1];
			
		}
		//最后一个位置的元素置空
		elements[size - 1] = null;
//		删除之后元素的长度肯定要减去1
		size--;
	}
	
	public String toString() {
		if(elements == null) {
			return "null";
		}
		if(size == 0) {
			return "[]";
		}
		StringBuilder sb = new StringBuilder(size * 2 +1);
		sb.append("[");
		for(int i = 0;i<size;i++) {
			sb.append(elements[i]);
			if(i != size-1) {
				sb.append(",");
			}
			else {
				sb.append("]");
			}
		}
		return sb.toString();
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public void clear() {
		//再这个的基础上重新赋值，相当于清空。再把长度变成0
		this.elements = new Object[DEFAULT];
		size=0;
	}
	
}
