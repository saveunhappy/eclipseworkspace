package 守护线程;

public class DaemonThread extends Thread{
		@Override
		public void run() {
			for(int i=0;i<150;i++) {
				System.out.println(this.getName()+"    "+i);
				//当前的线程回到就绪的状态，让出CPU
				
				Thread.yield();
			}
		}
}
