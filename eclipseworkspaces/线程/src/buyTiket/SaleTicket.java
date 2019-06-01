package buyTiket;

public class SaleTicket extends Thread{
	private String name;
	
	
	
	
	public SaleTicket(String name) {
		super(name);
	
	}

	private static int tickets = 100;
	private static Object obj = new Object();
	private static B a = new B();
	@Override
	public void run() {
	
		
		while(true) {
			/**
			 * synchronized同步代码块的锁对象可以是任意类对象(线程的实现方式是继承于Thread)
			 * 这个类对象必须是线程共享的
			 */
			
			
			synchronized (a) {
				if(tickets>0) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					System.out.println(this.getName()+"正在卖"+tickets--+"张票");
				}else {
					System.out.println("票已经售完");
					break;
				}
			}
			
			
			
		}
	}
}
class A{
	
	
}
