package Ïß³Ì;

public class Test {
	public static void main(String[] args) {
		
		
		ShareResource resource = new ShareResource();
		new Thread(new Productor(resource)).start();
		new Thread(new Consumer(resource)).start();
	}
}
