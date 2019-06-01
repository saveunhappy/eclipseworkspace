package two_day;

import java.util.Scanner;

public class Demo2 {
	public static void main(String[] args) {
		//int arr[] = {1,3,7,24,36,48};
		int arr[] = new int[7];
		arr[0] = 1;
		arr[1] = 3;
		arr[2] = 7;
		arr[3] = 24;
		arr[4] = 36;
		arr[5] = 48;
//		print(arr);
//		sortUp(arr);
//		print(arr);
//		sortDown(arr);
//		print(arr);
//		Scanner sc = new Scanner(System.in);
//		int a = sc.nextInt();
		finalSort(arr);
		
		
	}
	public static void finalSort(int[] arr) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		arr[arr.length-1] = num;
		int i = 0;
		
		if(arr[i]<arr[arr.length-1]) {
			
			sortUp(arr);
			print(arr);
		}
		else {
			
			sortDown(arr);
			print(arr);
		}
		
			
		
	}
	public static void sortUp(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>=arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	public static void sortDown(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]<=arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	public static void print(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
	}
}
