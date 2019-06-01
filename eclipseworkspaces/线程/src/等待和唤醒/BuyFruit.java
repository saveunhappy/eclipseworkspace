package 等待和唤醒;

public class BuyFruit implements Runnable{
	private Fruit fruit;

	public BuyFruit(Fruit fruit) {
		super();
		this.fruit = fruit;
	}

	@Override
	public void run() {

			while(true) {
				
				synchronized(fruit) {
					if(!fruit.isExsit()) {
						try {
							fruit.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(fruit.getName()+"我来买了！");
					fruit.setExsit(false);
					fruit.notify();
					
				}
			}
		
	}
	
	
}
