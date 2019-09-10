package linkedlistsbootcamp;

import MyLinkedList.Node;

public class Problem3TestForCyclicity {

	public static void main(String[] args) {
		Node<Integer> cycleHead = new Node<Integer>(5);
		Node<Integer> node = new Node<Integer>(1,new Node<Integer>(2,new Node<Integer>(3,new Node<Integer>(4,cycleHead))));
		cycleHead.nextNode = new Node<Integer>(6,new Node<Integer>(7,new Node<Integer>(8,new Node<Integer>(9,cycleHead))));
		Node<Integer> hasCycle = hasCycle(node);
		Node<Integer> temp = hasCycle;
		do {
			System.out.println(hasCycle.value);
			hasCycle = hasCycle.nextNode;
		}while(temp!=hasCycle);
		
		Node<Integer> hasCycle2 = hasCycle2(node);
		Node<Integer> temp2 = hasCycle2;
		do {
			System.out.println(hasCycle2.value);
			hasCycle2 = hasCycle2.nextNode;
		}while(temp2!=hasCycle2);
	}
	
	public static Node<Integer> hasCycle(Node<Integer> head){
		
		Node<Integer> slow  = head, fast = head;
		while(fast!=null && fast.nextNode!=null) {
			slow = slow.nextNode;
			fast = fast.nextNode.nextNode;
			if(fast==slow) {
				//calculate length;
				int cycleLen = 0;
				do {
					++cycleLen;
					fast=fast.nextNode;
				}while(slow!=fast);
				// iterate two loops to get the head of the cycle by cycle length to another
				Node<Integer> cycleIter = head;
				while(cycleLen-- >0) {
					cycleIter = cycleIter.nextNode;
				}
				
				Node<Integer> cycleHead = head;
				// tandem loop
				while(cycleHead!=cycleIter) {
					cycleHead = cycleHead.nextNode;
					cycleIter= cycleIter.nextNode;
				}
				return cycleIter;
			}
		}
		return null;
	}
	
    public static Node<Integer> hasCycle2(Node<Integer> head){
		
		Node<Integer> slow = head, fast = head;
		while(fast != null && fast.nextNode != null && fast.nextNode.nextNode!=null) {
			slow=slow.nextNode;
			fast = fast.nextNode.nextNode;
			if(fast== slow) {
				slow = head;
				while(slow!=fast) {
					slow= slow.nextNode;
					fast = fast.nextNode;
				}
				return slow;
			}
		}
		return null;
	}
	
	

}
