package binarytreesbootcamp;

import java.util.Arrays;
import java.util.List;

public class Problem13ReconstructTheBinaryTreeFromAPreorderTraversalWithMarkers {

	private static Integer subtreeIdx;

	public static void main(String[] args) {
		List<Integer> preorder = Arrays.asList(1, 2, 3, null, null, 4, 5, null, null, null, 6, null, 7, null, 8, 9,
				null, null, null);
		BinaryTreeNode<Integer> reconstructPreorder = reconstructPreorder(preorder);
		treeTraversal(reconstructPreorder);
	}

	//
	private static void treeTraversal(BinaryTreeNode<Integer> node) {
		if (node != null) {
			System.out.println("Pre-Order : " + node.ele);
			treeTraversal(node.left);
			treeTraversal(node.right);
		}
	}

	public static BinaryTreeNode<Integer> reconstructPreorder(List<Integer> preorder) {
		subtreeIdx = 0;
		return reconstructPreorderSubtree(preorder);
	}

	// time complexity is O(n)
	public static BinaryTreeNode<Integer> reconstructPreorderSubtree(List<Integer> preorder) {

		Integer value = preorder.get(subtreeIdx);
		subtreeIdx++;
		if (value == null) {
			return null;
		}
		return new BinaryTreeNode<Integer>(value, reconstructPreorderSubtree(preorder),
				reconstructPreorderSubtree(preorder));

	}

}
