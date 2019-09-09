package linkedlistsbootcamp;

import MyLinkedList.Node;

public class Problem2ReverseASingleSublist {

	public static void main(String[] args) {
		Node<Integer> n1 = new Node<Integer>(2,new Node<Integer>(5,new Node<Integer>(7,new Node<Integer>(9,new Node<Integer>(3,new Node<Integer>(8,null))))));
		Node<Integer> resulted = reverseSublist(n1,2,6);
		while(resulted!=null) {
			System.out.println(resulted.value);
			resulted = resulted.nextNode;
		}
	}

	private static Node<Integer> reverseSublist(Node<Integer> node, int start, int end) {

		Node<Integer> dummyHead = new Node<Integer>(0, node);
		Node<Integer> sublistHead = dummyHead;
		int k = 1;
		while (k++ < start) {
			sublistHead = sublistHead.nextNode;
		}

		Node<Integer> sublistItr = sublistHead.nextNode;
		while (start++ < end) {
			Node<Integer> temp = sublistItr.nextNode;
			sublistItr.nextNode = temp.nextNode;
			temp.nextNode = sublistHead.nextNode;
			sublistHead.nextNode = temp;
		}

		return dummyHead.nextNode;
	}

}
