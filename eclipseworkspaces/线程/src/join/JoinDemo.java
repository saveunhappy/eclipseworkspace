package join;

public class JoinDemo {
	public static void main(String[] args) {
		
		JoinThread pt = new JoinThread();
		JoinThread pt1 = new JoinThread();
		JoinThread pt2 = new JoinThread();
//		线程优先级setPriority()  默认是5 最大是10 最小是1  相对来说得到的机会多，也不是特别准确
		/*
		System.out.println(pt.getPriority());
		System.out.println(pt1.getPriority());
		System.out.println(pt2.getPriority());
		*/
		/*
		pt.setPriority(1);
		pt1.setPriority(5);
		pt2.setPriority(10);
		*/
		pt2.start();
			try {
				//join线程会抢先拿到CPU来执行线程，然后其他的线程再来执行
				pt2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pt.start();
		pt1.start();
		
	
	}
}
