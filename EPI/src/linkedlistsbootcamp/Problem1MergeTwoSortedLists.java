package linkedlistsbootcamp;

import MyLinkedList.Node;

public class Problem1MergeTwoSortedLists {

	public static void main(String[] args) {
		Node<Integer> n1 = new Node<Integer>(2,new Node<Integer>(5,new Node<Integer>(7,null)));
		Node<Integer> n2 = new Node<Integer>(3,new Node<Integer>(11,null));
		Node<Integer> resulted = mergeSortedLinkedList(n1,n2);
		while(resulted!=null) {
			System.out.println(resulted.value);
			resulted = resulted.nextNode;
		}
		
}
	
	private static Node<Integer> mergeSortedLinkedList(Node<Integer> node1, Node<Integer> node2) {
		Node<Integer> dummyHead = new Node<Integer>(0,null);
		Node<Integer> current = dummyHead;
		Node<Integer> p1=node1 ,p2=node2;
		while(p1!=null&& p2!=null) {
			if(p1.value <= p2.value) {
				current.nextNode = p1;
				p1=p1.nextNode;
			}else {
				current.nextNode = p2;
				p2=p2.nextNode;
			}
			current = current.nextNode;
		}
		current.nextNode = p1!=null ? p1 :p2;
		return dummyHead.nextNode;
	}
	
	
	

}
