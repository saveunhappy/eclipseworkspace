package Ïß³Ì1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ShareResource {
	private String name;
	private String gender;
	private boolean isEmpty = true;
	private final Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	 public void push(String name, String gender) {
		 lock.lock();
			try {
				while(!isEmpty) {
				
				condition.await();
				}
				this.name = name;
				Thread.sleep(10);
				this.gender = gender;
				isEmpty = false;
				condition.signalAll();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
		
	}
	
	 public void popup() {
		 lock.lock();
		try {
			while(isEmpty) {
			
			condition.await();
			}
			Thread.sleep(10);
			System.out.println(this.name+" "+this.gender);
			isEmpty = true;
			condition.signalAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		
		
	}
	
}
