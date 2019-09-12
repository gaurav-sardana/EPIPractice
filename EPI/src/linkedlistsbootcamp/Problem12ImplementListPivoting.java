package linkedlistsbootcamp;

import MyLinkedList.Node;

public class Problem12ImplementListPivoting {

	public static void main(String[] args) {
		Node<Integer> node = new Node<Integer>(3, new Node<Integer>(2, new Node<Integer>(2, new Node<Integer>(11,
						new Node<Integer>(7, new Node<Integer>(5, new Node<Integer>(11)))))));
		Node<Integer> listPivoting = listPivoting(node, 7);
		while(listPivoting!=null) {
			System.out.println(listPivoting.value);
			listPivoting =listPivoting.nextNode;
		}
	}
	
	//time complexity O(n) and space complexity O(1)
	public static Node<Integer> listPivoting(Node<Integer> node , int k){
		
		Node<Integer> lessHead = new Node<Integer>(0,null);
		Node<Integer> equalHead = new Node<Integer>(0,null);
		Node<Integer> higherHead = new Node<Integer>(0,null);
		Node<Integer> lessIter = lessHead;
		Node<Integer> equalIter = equalHead;
		Node<Integer> higerIter = higherHead;
		Node<Integer> L=node;
		
		while(L!=null) {
			if(L.value>k) {
				higerIter.nextNode = L;
				higerIter=L;
			}else if(L.value==k) {
				equalIter.nextNode=L;
				equalIter = L;
			}else {
				lessIter.nextNode=L;
				lessIter= L;
			}
			L=L.nextNode;
		}
		
		//O(1) time
		higerIter.nextNode=null;
		equalIter.nextNode = higherHead.nextNode;
		lessIter.nextNode=equalHead.nextNode;
		
		return lessHead.nextNode;
	}

}
