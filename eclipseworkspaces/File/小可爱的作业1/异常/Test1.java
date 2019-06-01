package 异常;

public class Test1 {

	public static void main(String[] args) {
		
		//Exception: 异常会造成后续代码的中断执行
		
		int m=10,n=0;
		//java.lang.ArithmeticException 算术异常
		//System.out.println(m/n);
		System.out.println(1);
		
		String s=null;
		//java.lang.NullPointerException  空指针异常
		//int len=s.length();
		System.out.println(2);
		
		int[] arr={12,13,24};
		//java.lang.ArrayIndexOutOfBoundsException  数组下标越界异常
		//int ele=arr[3];
		System.out.println(3);
		
		String str="aaaa";
		// java.lang.StringIndexOutOfBoundsException 字符串下标越界异常
		char ch=str.charAt(4);
		System.out.println(4);

	}

}
