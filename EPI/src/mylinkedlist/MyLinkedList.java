package mylinkedlist;

public class MyLinkedList  {

	private Node first;
	private Node last;
	private int size;

	public  void add(Object obj) {
		if (null == first) {
			first = new Node(obj);
			last= first;
			size++;
			return;
		}
		last.nextNode = new Node(obj);
		last= last.nextNode;
		size++;
	}
	
	public void add(int index,Object obj) {
		if(index>=size()) throw new IndexOutOfBoundsException();
		if(index==0) {
			first = new Node(obj,first);
			size++;
			return;
		}
		Node n = first;
		for(int i=1;i<=index;i++) {
			n = n.nextNode;
		}
		n.nextNode= new Node(obj,n.nextNode);
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public Object get(int index) {
		if(index>= size) throw new IndexOutOfBoundsException();
		Node n=first;
		for(int i=1;i<=index;i++) {
			n = n.nextNode;
		}
		return n.value;
	}

	public void remove(int index) {
		if(index>= size) throw new IndexOutOfBoundsException();
		if(index ==0) {
			first = first.nextNode;
			size--;
			return;
		}
		
		Node n = first;
		for(int i=1;i<=index;i++) {
			n= n.nextNode;
		}
		n.nextNode = n.nextNode.nextNode;
		size--;

	}
}
