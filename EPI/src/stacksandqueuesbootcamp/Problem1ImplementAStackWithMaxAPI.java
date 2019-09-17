package stacksandqueuesbootcamp;

import java.util.Deque;
import java.util.LinkedList;

import MyLinkedList.Node;

public class Problem1ImplementAStackWithMaxAPI {

	public static void main(String[] args) {
		//Node< Integer> node = new Node<Integer>(10,new Node<Integer>(20,new Node<Integer>(30,new Node<Integer>(40,new Node<Integer>(50,null)))));
		//printReverseLinkedList(node);
		MyStack myStack = new MyStack();
		myStack.push(10);
		myStack.push(30);
		myStack.push(15);
		myStack.push(70);
		myStack.push(100);
		myStack.push(20);
		myStack.push(30);
		
		while(!myStack.empty()) {
			System.out.println("Maximum  : "+myStack.max());
			System.out.println("last popped out " + myStack.pop());
		}
		
		
	}

	public static void printReverseLinkedList(Node<Integer> node) {
		Deque<Integer> deque = new LinkedList<Integer>();
		while(node!=null) {
			deque.addFirst(node.value);
			node=node.nextNode;
		}
		
		while(!deque.isEmpty()) {
			System.out.println(deque.poll());
		}
		
	}
	
	private static class ElementWithCachedMax{
		private Integer element;
		private Integer max;
		ElementWithCachedMax (Integer element, Integer max){
			this.element = element;
			this.max = max;
		}
		
	}
	
	
	public static class  MyStack {
		
		private Deque<ElementWithCachedMax> deque = new LinkedList<>();
		
		public  Integer max() {
			if(this.deque.isEmpty())
				throw new IllegalStateException("max() :  empty stack");
			return this.deque.peek().max;
		}
		
		public Integer pop() {
			if(empty())
				throw new IllegalStateException("pop() :  empty stack");
			return this.deque.removeFirst().element;

		}
		
		public void push(Integer element) {
			this.deque.addFirst(new ElementWithCachedMax(element, Math.max(element, empty() ? element : max())));
		}
		
		private boolean empty() {
			return this.deque.isEmpty();
		}
	}
	
	
}
