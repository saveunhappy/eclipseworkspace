package buyTiket;

public class SaleTicket2 extends Thread{
	private String name;
	
	
	
	
	public SaleTicket2(String name) {
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
				synchronized (a) {
					if(tickets>0) {
						try {
							Thread.sleep(0);
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
			else {
			synchronized (a) {
				if(tickets>0) {
					try {
						Thread.sleep(0);
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
			i++;
			
		}
	}
}
class B{
	
	
}
