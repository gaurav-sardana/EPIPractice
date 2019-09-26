package stacksandqueuesbootcamp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem7ComputeBinaryTreeNodesInOrderOfIncreasingDepth {

	public static void main(String[] args) {

//		QueueWithMaxIntro intro = new QueueWithMaxIntro();
//		intro.enque(3);
//		intro.enque(1);
//		intro.enque(2);
//		System.out.println(intro.dequeue());
//		System.out.println(intro.findMax());

	}

	//time complexity is O(n) and space complexity O(m) and m is the maximum number of nodes at any depth
	public static List<List<Integer>> binaryTreeDepthOrder(BinaryTreeNode<Integer> binaryTreeNode) {
		// We need to have two queue's for storing Binary node(s) at depth i and i+1 and
		// so on.
		Queue<BinaryTreeNode<Integer>> currBinaryTreeNodeQueue = new LinkedList<BinaryTreeNode<Integer>>();
		currBinaryTreeNodeQueue.add(binaryTreeNode);
		List<List<Integer>> resultedArray = new ArrayList<>();

		while (!currBinaryTreeNodeQueue.isEmpty()) {
			Queue<BinaryTreeNode<Integer>> nextBinaryNodesQueue = new LinkedList<>();
			List<Integer> currentValues = new ArrayList<>();
			while (!currBinaryTreeNodeQueue.isEmpty()) {
				BinaryTreeNode<Integer> curr = currBinaryTreeNodeQueue.poll();
				if (null != curr) {
					currentValues.add(curr.value);
				}
				nextBinaryNodesQueue.add(curr.left);
				nextBinaryNodesQueue.add(curr.right);
			}
			currBinaryTreeNodeQueue = nextBinaryNodesQueue;
			if (!currentValues.isEmpty()) {
				resultedArray.add(currentValues);
			}

		}
		return resultedArray;
	}

}

class BinaryTreeNode<E> {
	public E value;
	public BinaryTreeNode<E> left, right;
}

class QueueWithMaxIntro {
	private Deque<Integer> deque = new LinkedList<Integer>();

	public void enque(Integer x) {
		deque.add(x);
	}

	public Integer dequeue() {
		return deque.removeFirst();
	}

	public Integer findMax() {
		if (!deque.isEmpty()) {
			return Collections.max(deque);
		}
		throw new IllegalStateException("Max cannot be find because the queue is empty");
	}
}
