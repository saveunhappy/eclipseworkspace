package sleepDemo;

public class Demo1 {
	public static void main(String[] args) {
		SleepDemo sd = new SleepDemo();
		Thread th = new Thread(sd);
		th.start();
		/**
		 * 线程的休眠是很必要的，在做服务端的时候为了减少服务器的压力我们需要休眠
		 * 如果休眠是在同步代码块中执行，休眠不会让出锁对象
		 */
	}
}
