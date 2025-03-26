package linkedlistsbootcamp;

import mylinkedlist.Node;

public class Problem11TestPalindromicityOfSingleLinkedList {

	public static void main(String[] args) {
		Node<Integer> node = 
				new Node<Integer>(1, new Node<Integer>(2, new Node<Integer>(3, new Node<Integer>(4,
						 new Node<Integer>(3, new Node<Integer>(2, new Node<Integer>(1)))))));
	System.out.println(testPalindromicity(node));
	}

	//time complexity is O(n) and space complexity is O(1)
	public static boolean testPalindromicity(Node<Integer> node) {
		if(node== null){
			return true;
		}
		Node<Integer> fast = node,slow = node;
		while(fast.nextNode!=null && fast.nextNode.nextNode!=null) {
			fast=fast.nextNode.nextNode;
			slow=slow.nextNode;
		}
		Node<Integer> firstHalf = node;
		Node<Integer> reverseLinkedList = reverseLinkedList(slow);
		
		while(firstHalf!=null && reverseLinkedList!=null) {
			if(firstHalf.value!=reverseLinkedList.value) {
				return false;
			}
			firstHalf=firstHalf.nextNode;
			reverseLinkedList=reverseLinkedList.nextNode;
		}
		return true;
	}

	public static Node<Integer> reverseLinkedList(Node<Integer> node) {
		Node<Integer> dummyHead = new Node<Integer>(0,node);
		Node<Integer> sublistHead = dummyHead;
		Node<Integer> temp = node;
		int len = 0;
		while (temp != null) {
			len++;
			temp = temp.nextNode;
		}
		Node<Integer> listIter = sublistHead.nextNode;
		int k=1;
		while(k++<len) {
			Node<Integer> tempo = listIter.nextNode;
			listIter.nextNode = tempo.nextNode;
			tempo.nextNode = sublistHead.nextNode;
			sublistHead.nextNode = tempo;
		}
		
		return dummyHead.nextNode;
	}

}
