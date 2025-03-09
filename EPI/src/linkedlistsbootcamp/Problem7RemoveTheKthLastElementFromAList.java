package linkedlistsbootcamp;

import MyLinkedList.Node;

public class Problem7RemoveTheKthLastElementFromAList {

	public static void main(String[] args) {
		Node<Integer> node = new Node<Integer>(10,new Node<Integer>(20,new Node<Integer>(30,new Node<Integer>(40,new Node<Integer>(50,new Node<Integer>(60))))));
		Node<Integer> removeKthLastNode = removeKthLastNode(node,2);
		while(removeKthLastNode!=null) {
			System.out.println(removeKthLastNode.value);
			removeKthLastNode=removeKthLastNode.nextNode;
		}
	}

	public static Node<Integer> removeKthLastNode(Node<Integer> node, int k){
		if(k==0) {
			return node;
		}
		Node<Integer> dummyHead = new Node<Integer>(0,node);
		Node<Integer> first = dummyHead.nextNode;
		
		//first loop advanced by k
		while(k-- >0) {
			first =  first.nextNode;
		}
		
		Node<Integer> second =  dummyHead;
		//second loop in tandem with advance value and dumyHead
		while(first!=null) {
			first=first.nextNode;
			second = second.nextNode;
		}
		//as soon as the first loop reaches the tail, second pounts to the kth+1 node, it means delete it's successor.
		second.nextNode = second.nextNode.nextNode;
		return dummyHead.nextNode;
	}
}
