package stacksandqueuesbootcamp;

import java.util.Deque;
import java.util.LinkedList;

import mylinkedlist.Node;

public class Problem1ImplementAStackWithMaxAPI {

	public static void main(String[] args) {
//		Node< Integer> node = new Node<Integer>(10,new Node<Integer>(20,new Node<Integer>(30,new Node<Integer>(40,new Node<Integer>(50,null)))));
//		printReverseLinkedList(node);
		MyStack2 myStack = new MyStack2();
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
			System.out.println(deque.pop());
			//poll or pollFirst or pop or remove or removeFirst
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
	
	
	//time complexity O(1) space O(n) 
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
	
	public static class MaxWithCount{
		public Integer max;
		public Integer count;
		
		public MaxWithCount(Integer max , Integer count) {
			this.max = max;
			this.count = count;
		}
	}
	
	
	
	//worst space complexity is O(n) but id the stack is prepared with smaller quantity, the addition space complexity is O(1), the best.
	public static class MyStack2{
		private Deque<Integer> elemDeque = new LinkedList<Integer>();
		private Deque<MaxWithCount> cachedMaxWithCount = new LinkedList<MaxWithCount>();
		
		public boolean empty() {
			return elemDeque.isEmpty();
		}
		public Integer peek() {
			if(empty()) throw new IllegalStateException("peek() is empty");
			return elemDeque.peekFirst();
			
		}
		
		public Integer max() {
			if(empty()) throw new IllegalStateException("max() is empty");
			return cachedMaxWithCount.peekFirst().max;
		}
		public Integer pop() {
			if(empty()) throw new IllegalStateException("pop() is empty");
			Integer poppedValue = elemDeque.removeFirst();
			if(cachedMaxWithCount.peek().max.equals(poppedValue)) {
				cachedMaxWithCount.peek().count-=1;
				if(cachedMaxWithCount.peek().count.equals(0)) {
					cachedMaxWithCount.removeFirst();
				}
			}
			return poppedValue;
		}
		public void push(Integer ele) {
			if(empty()) {
				cachedMaxWithCount.addFirst(new  MaxWithCount(ele,1));
			}else {
				if(Integer.compare(ele, cachedMaxWithCount.getFirst().max)==0) {
					cachedMaxWithCount.peekFirst().count+=1;
				}else if(Integer.compare(ele, cachedMaxWithCount.getFirst().max)>0){
					cachedMaxWithCount.addFirst(new  MaxWithCount(ele,1));
				}
			}
			elemDeque.addFirst(ele);
			
		}
	}
	
	
}
