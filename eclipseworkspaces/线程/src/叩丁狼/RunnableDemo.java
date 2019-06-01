package ßµ¶¡ÀÇ;

class RunnableDemo1 implements java.lang.Runnable {
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println("ÌýÒôÀÖ"+i);
		}
	}
}

public class RunnableDemo {
	public static void main(String[] args) {
		for(int i=0;i<50;i++) {
			System.out.println("´òÓÎÏ·"+i);
			if(i==10) {
			Runnable target = new RunnableDemo1();
			Thread t = new Thread(target);
			t.start();
		}
		}
	}
}
