package reflect;

public class Demo2 {
	public static void main(String[] args) {
		Class i = int.class;
		
		Class<Boolean> b = boolean.class;
		//int和Integer是不同的数据类型
		System.out.println(Integer.class == int.class);
//		doWork(10);
		System.out.println(Integer.TYPE == int.class);
		
		
		int[] arr1 = {1,2,3};
		Class cl = arr1.getClass();
		Class cl1  = int[].class;
		//所有的具有相同的维数和相同的元素类型的数组共享同一份字节码对象，和元素没有关系
		System.out.println(cl.getClass() == cl1.getClass());
	}
	 public static void doWork(int a) {
		 System.out.println("hh");
	 }
	 public static void doWork(Integer a) {
		 System.out.println("hhhhhh");
	 }
}
