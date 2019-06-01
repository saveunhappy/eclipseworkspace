package 数据结构;

import java.util.Arrays;

public class Demo1 {
	//存储场上球员的秋衣号码
	private static Integer[] players;
	//场上球员的个数
	private static int size = 0;
	//1.初始容量为5的线性列表，准备存储场上的5个秋衣号码
	private static void init(int a) {
		if(a<0) {
			throw new IllegalArgumentException("亲，容量不能为负数");
		}
		players = new Integer[a];
		
	}
	//向里面添加元素
	private static void add(Integer playerNum) {
		//数组[下标]  = 元素值
		if(size == players.length) {
			//如果满了就需要扩容，这里是把元素组给扩大两倍，再返回一个新的数组，在把原来数组的引用变成新的数组就行了，原来的会被JVM给回收掉的
		Integer[] temp = Arrays.copyOf(players, players.length * 2);
			players = temp;
		}
		
		players[size]  = playerNum;
		size++;
		
	}
	//查找指定索引处的元素
	private static Integer get(Integer index) {
		if(index<0||index>=size) {
			throw new IllegalArgumentException("索引越界");
		}
		// TODO Auto-generated method stub
		return players[index];
	}
	//根据球衣编号查找索引
	private static int getIndexByPlayerNum(Integer num) {
		// TODO Auto-generated method stub
		for(int i=0;i<size;i++) {
			
		if(players[i].equals(num)) {
			return i;
		}
		
		}
		return -1;
		
	}
	//将指定索引的地方的元素替换为新的元素
	private static void set(int index,Integer playerNumber) {
		if(index<0||index>=size) {
			throw new IllegalArgumentException("索引越界");
		}
		players[index] = playerNumber;
		
	}
	//根据元素的值来换取新的值
	private static void update(Integer old,Integer New) {
		//根据传递值来获取到索引
		int index = getIndexByPlayerNum(old);
		if(index>=0) {
			//根据或得到的索引来替换成新的元素
			set(index,New);
		}
		//总体来说就是通过两个方法的组合来实现的：一个是获得索引，在通过索引来改变元素
		
	}
	//是否为空
	 public boolean isEmpty() {
		 return size==0;
	 }
	 //清空
	private static void delete(int index) {
		if(index<0||index>=size) {
			throw new IllegalArgumentException("索引越界");
		}
		for(int i=index;i<size-1;i++) {
			//index +1 移动到index位置
			players[index] = players[index+1];
		}
		//将最后一个位置的元素给制空
		players[size-1] = null;
		//将长度减去一
		size--;
	}
	
	//最简单的，打印
	private static void print() {
		if(players == null) {
			System.out.println("null");
			return;
		}
		if(size==0) {
			System.out.println("[]");
			return;
		}
		
		//[11,22,33,44,55]
											//原本是5个数字，四个逗号再加上两个方括号
		StringBuilder sb = new StringBuilder(size*3+1);
		sb.append("[");
		for(int index = 0;index <size;index++) {
			sb.append(players[index]);
			if(index != size-1) {
				sb.append(",");
			}
			else {
				sb.append("]");
			}
		}
		System.out.println(sb);
		
		
	}
	
	
	public static void main(String[] args) {
		//初始化容量为5的线性列表
		init(5);
		add(11);
		print();
		
		add(22);
		print();
		add(33);
		add(44);
		add(55);
		print();
		//Integer num = get(2);
		//System.out.println(num);
		
		//Integer index = getIndexByPlayerNum(33);
	//	System.out.println(index);
		
		int index = getIndexByPlayerNum(44);
		System.out.println(index);
	}
	

	
}
