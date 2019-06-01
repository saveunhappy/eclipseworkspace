package buyTiket;

public class SaleTicket4 implements Runnable{

//	private Object obj = new Object();
	private int tickets = 100;
	@Override
	public void run() {
	
		
		while(true) {
			
			int i=0;
			if(i%2==0) {
				//同步代码块
				/**
				 * 非静态的锁就是当前的对象，它的锁是this
				 */
				synchronized (this) {
					if(tickets>0) {
						try {
							Thread.sleep(0);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						System.out.println(Thread.currentThread().getName()+"正在卖"+tickets--+"张票");
					}else {
						System.out.println("票已经售完");
						break;
					}
				}
			}
			else {
				saleTicked();
			}
			i++;
			
		}
	}
	/**
	 * 非静态方法的synchronized锁是当前类的类对象
	 */
	public synchronized void saleTicked() {
		
			if(tickets>0) {
				try {
					Thread.sleep(0);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				System.out.println(Thread.currentThread().getName()+"正在卖"+tickets--+"张票");
			}else {
				System.out.println("票已经售完");
				
			}
		
		
		
		
	}
	
}

