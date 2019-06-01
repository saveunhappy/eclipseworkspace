package join;

public class JoinThread extends Thread{
		@Override
		public void run() {
			for(int i=0;i<150;i++) {
				System.out.println(this.getName()+"    "+i);
			}
		}
}
