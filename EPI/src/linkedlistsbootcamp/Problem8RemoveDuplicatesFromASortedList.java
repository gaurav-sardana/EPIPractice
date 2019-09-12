package linkedlistsbootcamp;

import MyLinkedList.Node;

public class Problem8RemoveDuplicatesFromASortedList {

	public static void main(String[] args) {
		Node<Integer> node =  new Node<Integer>(10,new Node<Integer>(20,new Node<Integer>(30,new Node<Integer>(40,new Node<Integer>(40,new Node<Integer>(50))))));
		Node<Integer> removeDuplicates = removeDuplicates(node);
		while(removeDuplicates!=null) {
			System.out.println(removeDuplicates.value);
			removeDuplicates=removeDuplicates.nextNode;
		}
	}
	
	public static Node<Integer> removeDuplicates(Node<Integer> node){
		Node<Integer> iter = node;
		
		while(iter!=null) {
			
			Node<Integer> nextDistinct = iter.nextNode;
			while(nextDistinct!=null && nextDistinct.value ==  iter.value) {
				nextDistinct =nextDistinct.nextNode;
			}
			
			iter.nextNode = nextDistinct;
			iter = nextDistinct;
			
		}
		return node;
	}

}
