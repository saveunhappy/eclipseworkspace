package yieldDemo;

public class YieldDemo {
	public static void main(String[] args) {
		
		YieldThread pt = new YieldThread();
		YieldThread pt1 = new YieldThread();
		YieldThread pt2 = new YieldThread();
		/**
		 * 等待线程就是让线程从运行阶段回到就绪阶段，目的是把CPU的资源让给其他线程
		 * 发挥谦让，然而该抢资源还是会抢资源的
		 */
		pt2.start();
		pt.start();
		pt1.start();
		
	
	}
}
