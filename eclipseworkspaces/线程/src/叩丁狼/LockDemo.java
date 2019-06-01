package 叩丁狼;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class RunnableDemo2 implements java.lang.Runnable {
	private int num = 50;
	
	private final Lock lock = new ReentrantLock();
	
	public void run() {
		for(int i=0;i<50;i++) {
			eat();
		}
	}
	private void eat() {
		lock.lock();
		try {
			if(num>0) {
				System.out.println(Thread.currentThread().getName()+"吃了编号为"+
			num+"的苹果");
				Thread.sleep(10);
				num--;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}
}




public class LockDemo {
	public static void main(String[] args) {
		RunnableDemo2 r = new RunnableDemo2();
		Thread t1 = new Thread(r,"小A");
		Thread t2 = new Thread(r,"小B");
		Thread t3 = new Thread(r,"小C");
		t1.start();
		t2.start();
		t3.start();
		
	}
}
