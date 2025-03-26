package linkedlistsbootcamp;

import java.util.Arrays;
import java.util.List;

import mylinkedlist.Node;

public class Problem10ImplementEvenOddMerge {

	public static void main(String[] args) {
		Node<Integer> node = new Node<Integer>(0,
				new Node<Integer>(1, new Node<Integer>(2, new Node<Integer>(3, new Node<Integer>(4,
						new Node<Integer>(5, new Node<Integer>(6, new Node<Integer>(7, new Node<Integer>(8)))))))));
		 Node<Integer> evenOddMerge = evenOddMerge(node);
		 while(evenOddMerge!=null) {
			 System.out.println(evenOddMerge.value);
			 evenOddMerge=evenOddMerge.nextNode;
		 }
		 

	}

	//time complexity is O(n) and space complexity O(1)
	public static Node<Integer> evenOddMerge(Node<Integer> node) {
		Node<Integer> dummyHeadEven = new Node<Integer>(0, null), dummyHeadOdd = new Node<Integer>(0, null);
		List<Node<Integer>> asList = Arrays.asList(dummyHeadEven,dummyHeadOdd);
		int temp =0;
		for(Node<Integer> iter = node ; iter!=null;iter=iter.nextNode) {
			asList.get(temp).nextNode = iter;
			asList.set(temp, asList.get(0).nextNode);
			temp^=1;
		}
		asList.get(1).nextNode=null;
		asList.get(0).nextNode= dummyHeadOdd.nextNode;

		return dummyHeadEven.nextNode;
	}

}
