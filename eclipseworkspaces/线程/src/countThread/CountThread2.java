package countThread;

public class CountThread2 implements Runnable{
	
	
	

	/**
	 * 线程的执行体
	 * 
	 * 创建新执行线程有两种方法，一种方法是将类声明为Thread的子类，该子类应该重写Thread类中的run方法
	 * 接下来可以分配并且启动该子类的实例
	 */
	@Override
	public void run() {
		for(int i=0;i<50;i++) {
			//输出线程的名字
			System.out.println(Thread.currentThread().getName()+"hello"+i);
		}
	}

}
