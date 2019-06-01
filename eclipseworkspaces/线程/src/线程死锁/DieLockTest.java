package Ïß³ÌËÀËø;

public class DieLockTest {
	public static void main(String[] args) {
		
		
		Dielock di1 = new Dielock(true);
		Dielock di2 = new Dielock(false);
		
		Thread t1 = new Thread(di1);
		Thread t2 = new Thread(di2);
		t1.start();
		t2.start();
	}
}	
