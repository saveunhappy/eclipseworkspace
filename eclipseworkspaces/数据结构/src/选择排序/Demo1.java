package Ñ¡ÔñÅÅĞò;

public class Demo1 {
	public static void main(String[] args) {
		int [] arr = {4,5,6,1,2,3,7,8,9};
		print(arr);
		System.out.println();
		sorted1(arr);
		print(arr);
		
	}
	public static void print(int [] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
		}
	}
	public static void sort(int [] arr) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length -i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int t = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = t;
				}
			}
		}
	}
	
	public static void sorted(int [] arr) {
		for(int times=1;times<=arr.length-1;times++) {
			for(int j=times;j<=arr.length-1;j++) {
				if(arr[times-1]>arr[j]) {
					int t = arr[times-1];
					arr[times-1] = arr[j];
					arr[j] = t;
				}
			}
		}
	}
	public static void sorted1(int [] arr) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i;j<=arr.length-1;j++) {
				if(arr[i-1]>arr[j]) {
					int t = arr[i-1];
					arr[i-1] = arr[j];
					arr[j] = t;
				}
			}
		}
	}
	
	
	
}
