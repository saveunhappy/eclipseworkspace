package 异常;

public class Test2 {

	public static void main(String[] args) {
		
		/*
		 * 异常： Exception   代码原因引起的
		 * 错误： Error		死机  断电  内存问题  jvm故障 驱动问题
		 */
		//Exception: 异常会造成后续代码的中断执行
		//传统的方式处理异常
		
		int m=10,n=0;
		//java.lang.ArithmeticException 算术异常
		if(n!=0){
			System.out.println(m/n);
		}else{
			System.out.println("除数不能为0");
		}
		
		System.out.println(1);
		
		String s=null;
		//java.lang.NullPointerException  空指针异常
		if(s!=null){
			int len=s.length();
		}else{
			System.out.println("出现空指针异常啦");
		}
		
		System.out.println(2);
		
		int[] arr={12,13,24};
		//java.lang.ArrayIndexOutOfBoundsException  数组下标越界异常
		int i=3;
		if(i<arr.length){
			int ele=arr[i];
		}else{
			System.out.println("下标超出最大取值范围了");
		}
		
		System.out.println(3);
		
		String str="aaaa";
		// java.lang.StringIndexOutOfBoundsException 字符串下标越界异常
		int j=4;
		if(j<str.length()){
			char ch=str.charAt(j);
		}else{
			System.out.println("字符串下标越界了。。。。");
		}
		
		System.out.println(4);

	}

}
