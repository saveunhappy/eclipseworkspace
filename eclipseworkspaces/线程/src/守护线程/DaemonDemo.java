package 守护线程;

public class DaemonDemo {
	public static void main(String[] args) {
		
		DaemonThread pt = new DaemonThread();
		DaemonThread pt1 = new DaemonThread();
//		守护线程 
//		主线程解除了，守护线程也结束到相应的地方，就是不一定全部执行完
		pt.setDaemon(true);
		pt1.setDaemon(true);
		
		pt.start();
		pt1.start();
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+"正在执行"+i);
			
		}
	
	}
}
