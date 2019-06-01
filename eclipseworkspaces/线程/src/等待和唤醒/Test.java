package 等待和唤醒;

public class Test {
	public static void main(String[] args) {
		Fruit fruit = new Fruit();
		//先设置为false
		fruit.setExsit(false);
		fruit.setName("苹果");
		ProductFruit pf  = new ProductFruit(fruit);
		Thread t1 = new Thread(pf);
		BuyFruit bf = new BuyFruit(fruit);
		Thread t2 = new Thread(bf);
		t1.start();
		t2.start();
		
		
		
	}
}
