package file;

public class FileDemo5 {
	public static void main(String[] args) {
		
		
		int a = fn(5);
		System.out.println(a);
		
	}
	public static int fn(int n) {
		if(n>=2) {
			return n*fn(n-1);
		}
		else {
			return 1;
		}
	}
}
