package linkedlistsbootcamp;

import MyLinkedList.Node;

public class Problem6DeleteANodeFromSingleLinkedList {

	public static void main(String[] args) {
			Node<Integer> nodeToDelete = new Node<Integer>(40);
			nodeToDelete.nextNode = new Node<Integer>(50);
			Node<Integer> node = new Node<Integer>(10,new Node<Integer>(20,new Node<Integer>(30,nodeToDelete)));
			deleteFromList(nodeToDelete);
			while(node!=null) {
				System.out.println(node.value);
				node=node.nextNode;
			}
			
	}
	
	public static void deleteFromList(Node<Integer> node) {
		node.value = node.nextNode.value;
		node.nextNode = node.nextNode.nextNode;
	}

}
