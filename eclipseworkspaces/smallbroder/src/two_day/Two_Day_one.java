package two_day;

public class Two_Day_one {
	 
	 
	 public static void main(String[] args){
		 TestPerson p =new TestPerson ("张三",18,'男');
			System.out.println(p.name);
			System.out.println(p.age);
			System.out.println(p.gender);
		}
		

}		
 class TestPerson{
	 String name;
		
		int age;
		
		char gender;
		/*
		 *构造器：
		 *语法:
		 * public 类名  (数据类型 参数名,....){
		 *
		 *}
		 *目的:创建对象 
		 *其中：public 也可是 private,但是必须有  
		 *特点：
		 *1,方法名和类名一样
		 *2,方法没有返回值,没有void
		 *3，参数可有可无;
		 * */
		public TestPerson (String name,int age , char gender){
			this.name=name;		
			this.age=age;
			this.gender=gender;
			System.out.println("创建构造器");
		}
		
		
		public void introduce(){
			System.out.println("我是"+name+"    年龄："+age+"    性别："+gender);
		
	}
}	

