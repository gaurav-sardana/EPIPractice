package binarytreesbootcamp;

public class Problem16ComputeTheRightSiblingTree {

	public static void main(String[] args) {
		BinaryTreeNode<Integer> binaryTreeNode = new BinaryTreeNode<>(10,
				new BinaryTreeNode<>(20, new BinaryTreeNode<>(30, null, null), new BinaryTreeNode<>(40, null, null)),
				new BinaryTreeNode<>(50, new BinaryTreeNode<>(60, null, null), new BinaryTreeNode<>(70, null, null)));
		contructRightSibling(binaryTreeNode);
		printTree(binaryTreeNode);

	}

	private static void printTree(BinaryTreeNode<Integer> root) {
		if (root != null) {
			System.out.println("Node element : " + root.ele);
			if (root.next != null) {
				System.out.println("Node next element : " + root.next.ele);
			}
			printTree(root.left);
			printTree(root.right);
		}
	}

	// time complexity O(n) and space complexity O(1);
	private static void contructRightSibling(BinaryTreeNode<Integer> tree) {
		BinaryTreeNode<Integer> leftTree = tree;
		while (leftTree != null && leftTree.left != null) {
			populateLowerLevelNextField(leftTree);
			leftTree = leftTree.left;
		}
	}

	private static void populateLowerLevelNextField(BinaryTreeNode<Integer> startNode) {

		BinaryTreeNode<Integer> iter = startNode;
		while (iter != null) {
			// setting left child's next field
			iter.left.next = iter.right;
			// setting right child's next field if iter is not the last node of this level
			// (vertically)
			if (iter.next != null) {
				iter.right.next = iter.next.left;
			}
			iter = iter.next;
		}
	}

}
