package buyTiket;

public class SaleTicket3 extends Thread{
	private String name;
	
	
	
	
	public SaleTicket3(String name) {
		super(name);
	
	}

	private static int tickets = 100;
	private static Object obj = new Object();
	private static A a = new A();
	@Override
	public void run() {
	
		
		while(true) {
			/**
			 * synchronized同步代码块的锁对象可以是任意类对象(线程的实现方式是继承于Thread)
			 * 这个类对象必须是线程共享的
			 */
			int i=0;
			if(i%2==0) {
				//同步代码块
				/**
				 * 这个就是当前类的类的类对象
				 */
				synchronized (SaleTicket3.class) {
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
	 * 静态方法的synchronized锁是当前类的类对象
	 */
	public synchronized static void saleTicked() {
		
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

