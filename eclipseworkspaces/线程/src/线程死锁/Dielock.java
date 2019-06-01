package 线程死锁;

public class Dielock implements Runnable{

	private boolean flag;
	
	@Override
	public void run() {
		if(flag) {
			synchronized(Lock.lock1) {
				System.out.println("线程1拿到第一把锁");
				synchronized (Lock.lock2) {
					System.out.println("线程1要拿第二把锁");
					
					
				}
			}
			
			
		}else {
			
			synchronized (Lock.lock2) {
				System.out.println("线程2拿到第2把锁");
				synchronized (Lock.lock1) {
					System.out.println("线程2要拿第1把锁");
					
				}
			}
			
		}
	}
	/**
	 * 线程开发的时候避免出现死锁
	 * @param flag
	 */

	public Dielock(boolean flag) {
		super();
		this.flag = flag;
	}
	
}
