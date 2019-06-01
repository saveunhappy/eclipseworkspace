package LinkedLIstDemo;

public class Demo2 {
	public static void main(String[] args) {
		Demo1 list = new Demo1();
		
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");
		
		list.addFirst("A");
		System.out.println(list);
		list.delete("e");
		
		System.out.println(list);
		Object a = list.search("e");
		System.out.println(a);
	}
}
