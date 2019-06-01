package ss;

public class Live {
	private static boolean alive = true;
	public static void main(String[] args) {
		while(alive) {
			eat();
			sleep();
			code();
			repeat();
		}
		
	}
	public static void eat() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("³Ô·¹·¹");
	}
	public static void sleep() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Ë¯¾õ¾õ");
	}
	public static void code() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ÇÃ´úÂë");
	}
	public static void repeat() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eat();
		sleep();
		code();
		repeat();
	}

}
