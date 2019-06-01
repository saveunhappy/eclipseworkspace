package LinkedLIstDemo;

public class Demo1 {
	private Node first;//链表的第一个节点
	
	private Node last;//链表的最后一个节点
	
	private int size;//节点的数量
	
	public boolean search(Object ele) {
		Node current = this.first;
		for(int i=0;i<size;i++) {
			if(!current.ele.equals(ele)) {
				if(current.next==null) {
					return false;
					}
			current = current.next;
			}
		}
		return true;
		
	}
	public void delete(Object ele) {
		Node current = this.first;
		for(int i=0;i<size;i++) {
			if(!current.ele.equals(ele)) {
				if(current.next==null) {
					return;
					}
			current = current.next;
			}
		}
		
		//删除节点
		//System.out.println("current = "+current.ele);
		if(current == first) {
			this.first = current.next;
			this.first.prev = null;
		}else if(current == last) {
			this.last=current.prev;
			this.last.next = null;
		}
		else {
			current.prev.next = current.next;
			current.next.prev =	current.prev;
		}
		size--;
	
	}
	
	
	public void addFirst(Object ele) {
		
		Node node = new Node(ele);
		if(size==0) {
			this.first = node;
			this.last = node;  
		}
		else {
			//把之前第一个节点作为新增节点的下一个节点;
			node.next = this.first;
			
			this.first.prev = node;
			
			this.first = node;
		}
		
		
		size++;
	}
	
	
	public void addLast(Object ele) {
		//需要保存的节点对象
		Node node = new Node(ele);
		
		if(size==0) {
		//如果节点的数量为0，那么他既是第一个节点也是最后一个节点
			this.first = node;
			this.last = node;
		}
		else {
			//新增加的这个节点是最后一个，原来的最后一个的元素的下一个节点就应该是这个节点对象了
			this.last.next = node;
			//这时候添加的新节点的前一个节点就是原来的最后一个节点
			node.prev=this.last;
			//这个时候的新增节点就是最后一个节点
			this.last=node;
		}
		size++;
	}
	
	public String toString() {
		if(size==0) {
			return "[]";
		}
		StringBuilder sb = new StringBuilder(size * 2 +1);
		Node current = this.first;
		sb.append("[");
		for(int i=0;i<size;i++) {
			sb.append(current.ele);
			if( i != size-1) {
				sb.append(",");
			}
			else {
				sb.append("]");
			}
			current = current.next; 
			
		}
		return sb.toString();
		
	}
	
	
	
	//链表中的每一个节点
	class Node{
		Node prev;//上一个节点对象
		Node next;
		Object ele;
		public Node(Object ele) {
			this.ele = ele;
		}
		
		
	}



	
}
