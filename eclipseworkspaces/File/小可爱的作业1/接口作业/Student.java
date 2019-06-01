package 接口作业;

public class Student extends Person implements Player,Singer,Dancer{
	public void activity(){
		System.out.println("开始活动");
	}

	
	public void exercise() {
		System.out.println("开始运动");
		
	}

	public void sing() {
		System.out.println("开始唱歌");
		
	}

	public void daner() {
		System.out.println("开始跳舞");
		
	}

}
