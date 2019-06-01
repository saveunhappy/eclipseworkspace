package sleepDemo;

import java.util.Date;

public class SleepDemo implements Runnable{

	@Override
	public void run() {

		
			while(true) {
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(new Date());
				
				
			}
	}

}
