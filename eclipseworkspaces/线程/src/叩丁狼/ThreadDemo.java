package 叩丁狼;
class MusicThread extends java.lang.Thread{
	
	@Override
	public void run() {
		for(int i=0;i<50;i++) {
			System.out.println("正在播放音乐"+i);
		}
	}
	
}
//方式一：继承Thread类
public class ThreadDemo {
	public static void main(String[] args) {
		
		for(int i=0;i<50;i++) {
			System.out.println("正在打游戏"+i);
			if(i==10) {
				
				MusicThread t = new MusicThread();
				t.start();
			}
		}
	}
}
