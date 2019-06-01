package countThread;

public class Demo3 {
	public static void main(String[] args) {
		/**
		 * 线程的生命周期
		 * 1.新建：线程被new 出来
		 * 2.准备就绪：线程具有执行的资格，即线程调用了start(),没有执行的权利
		 * 3.运行：具备执行的资格和具备执行的权利
		 * 4.阻塞：准备就绪以后抢到CPU就开始运行   ，运行，运行的时候可以等待，调用sleep方法或者wait方法，，
		 * 	没有执行权利和执行资格，sleep执行时间到了只有就会回到准备就绪的阶段  也可以 notify()其他线程把它诶唤醒
		 * 5.销毁运行之后调用run方法或者stop方法之后就会销毁，线程的对象编程垃圾，释放资源
		 */
		CountThread2 ct = new CountThread2();
		Thread t1 = new Thread(ct,"123");
		CountThread2 ct1 = new CountThread2();
		Thread t2 = new Thread(ct1,"456");
		t1.start();
		t2.start();
		
	}
}
