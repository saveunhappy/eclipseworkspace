package data;

public class Demo1 {
	//存储场上球员的秋衣号码
	private static Integer[] players;
	//场上球员的个数
	private static int size = 0;
	//1.初始容量为5的线性列表，准备存储场上的5个秋衣号码
	private static void init(int a) {
		players = new Integer[5];
		
	}
	//向里面添加元素
	private static void add(Integer playerNum) {
		//数组[下标]  = 元素值
		players[size]  = playerNum;
		size++;
		
	}
	//查找指定索引处的元素
	private static Integer get(Integer index) {
		// TODO Auto-generated method stub
		return players[index];
	}
	//根据元素查找指定的索引
	private static Integer getIndexByPlayerNum(Integer num) {
		// TODO Auto-generated method stub
		for(int i=0;i<size;i++) {
			
		if(players[i].equals(num)) {
			return i;
		}
		
		}
		return -1;
		
	}
	private static void set(int i, Integer j) {
		for(int index = 0;index<size;index++) {
					if(i == index) {
						players[index]=j; 
					}
			
		}
		
	}
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
		StringBuilder sb = new StringBuilder(size*2+1);
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
		
		//Integer index = getIndexByPlayerNum(33);
		//System.out.println(index);
		
		
		set(2,333);
		print();
	}
	private static void divede(int num,int num1) {
		System.out.println("begin");
		if(num1==0) {
			throw new ArithmeticException("被除数不能为0");
		}
	}
	
	

	
}
