package 线程优先级;

public class PriorityTest {
	public static void main(String[] args) {
		
		Priority pt = new Priority();
		Priority pt1 = new Priority();
		Priority pt2 = new Priority();
//		线程优先级setPriority()  默认是5 最大是10 最小是1  相对来说得到的机会多，也不是特别准确
		/*
		System.out.println(pt.getPriority());
		System.out.println(pt1.getPriority());
		System.out.println(pt2.getPriority());
		*/
		
		pt.setPriority(1);
		pt1.setPriority(5);
		pt2.setPriority(10);
		pt.start();
		pt1.start();
		pt2.start();
	}
}
