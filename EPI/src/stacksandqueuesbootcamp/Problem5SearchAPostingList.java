package stacksandqueuesbootcamp;

import java.util.Deque;
import java.util.LinkedList;

public class Problem5SearchAPostingList {

	public static void main(String[] args) {
		PostingListNode<Integer> postingListNode1 = new PostingListNode<Integer>(-1);
		PostingListNode<Integer> postingListNode2 = new PostingListNode<Integer>(-1);
		PostingListNode<Integer> postingListNode3 = new PostingListNode<Integer>(-1);
		PostingListNode<Integer> postingListNode4 = new PostingListNode<Integer>(-1);
		postingListNode1.nextNode = postingListNode2;
		postingListNode1.jumpNode = postingListNode3;
		postingListNode2.nextNode = postingListNode3;
		postingListNode2.jumpNode = postingListNode4;
		postingListNode3.nextNode = postingListNode4;
		postingListNode3.jumpNode = postingListNode2;
		postingListNode4.jumpNode = postingListNode4;
		postingListNode4.nextNode = null;

		setJumpOrderIteratively(postingListNode1);
		while (postingListNode1 != null) {
			System.out.println(postingListNode1.element);
			postingListNode1 = postingListNode1.nextNode;
		}

	}
	
	//time complexity is O(n) and space complexity O(n)
	public static void setJumpOrderRecursively(PostingListNode<Integer> postingListNode) {
		setJumpOrderHelper(postingListNode, 0);
	}

	private static int setJumpOrderHelper(PostingListNode<Integer> postingListNode, int order) {
		if (postingListNode != null && postingListNode.element == -1) {
			postingListNode.element = order++;
			order = setJumpOrderHelper(postingListNode.jumpNode, order);
			order = setJumpOrderHelper(postingListNode.nextNode, order);
		}
		return order;
	}

	public static void setJumpOrderIteratively(PostingListNode<Integer> postingListNode) {

		Deque<PostingListNode<Integer>> deque = new LinkedList<PostingListNode<Integer>>();
		int order = 0;
		deque.addFirst(postingListNode);
		while (!deque.isEmpty()) {
			PostingListNode<Integer> removeFirst = deque.removeFirst();
			if (removeFirst != null && removeFirst.element == -1  ) {
				removeFirst.element = order++;
				deque.addFirst(removeFirst.nextNode);
				deque.addFirst(removeFirst.jumpNode);
			}
		}

	}

}

class PostingListNode<E> {
	E element;
	PostingListNode<E> nextNode;
	PostingListNode<E> jumpNode;

	public PostingListNode(E element) {
		this.element = element;
	}

}
