package countThread;

public class Demo2 {
	public static void main(String[] args) {
		CountThread ct = new CountThread("我是1");
		CountThread ct1 = new CountThread("我是2");
		/*
		ct.setName("线程1");
		ct1.setName("线程2");
		*/
		//启动线程
		/**
		 *  ct.run()!!!不是这么调用的，这样只是调用了run方法
		 */
		ct.start();
		ct1.start();
	}
}
