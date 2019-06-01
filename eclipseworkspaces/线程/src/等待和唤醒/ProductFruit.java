package 等待和唤醒;

public class ProductFruit implements Runnable{
	/**
	*生产者生成水果，如果水果没有被买走那么就不生产处于等待状态，如果水果被消费者买走的时候，消费者会通知生产者
	*告诉生产者，我已经买了，快生产，消费者同理，如果水果已经生产出来就买走，买走之后再通知生产者记得生产
	*买的水果是一个对象，是公共的，在synchronize代码块中，
	*。
	 */
	private Fruit fruit;

	public ProductFruit(Fruit fruit) {
		super();
		this.fruit = fruit;
	}

	@Override
	public void run() {

		
			while(true) {
				
				synchronized(fruit) {
					if(fruit.isExsit()) {
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
					System.out.println(fruit.getName()+"有水果了");
					fruit.setExsit(true);
					fruit.notify();
					
				}
			}
	}
}
