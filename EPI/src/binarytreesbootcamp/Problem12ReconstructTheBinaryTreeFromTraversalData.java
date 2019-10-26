package binarytreesbootcamp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem12ReconstructTheBinaryTreeFromTraversalData {

	public static void main(String[] args) {

	}

	private static BinaryTreeNode<Integer> binaryTreeFromPreorderInorder(List<Integer> preorder,
			List<Integer> inorder) {

		Map<Integer, Integer> nodeToInorderIdx = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.size(); i++) {
			nodeToInorderIdx.put(inorder.get(i), i);
		}
		BinaryTreeNode<Integer> binaryTreeFromPreorderInorderHelper = binaryTreeFromPreorderInorderHelper(preorder, 0,
				preorder.size(), 0, inorder.size(), nodeToInorderIdx);

		return binaryTreeFromPreorderInorderHelper;
	}

	private static BinaryTreeNode<Integer> binaryTreeFromPreorderInorderHelper(List<Integer> preorder,
			int preorderStart, int preorderEnd, int inorderStart, int inorderEnd,
			Map<Integer, Integer> nodeToInorderIdx) {

		if (preorderEnd <= preorderStart || inorderEnd <= inorderStart) {
			return null;
		}
		int rootInorderIdx = nodeToInorderIdx.get(preorder.get(preorderStart));
		int leftSubtreeSize = rootInorderIdx - inorderStart;
		return new BinaryTreeNode<Integer>(preorder.get(preorderStart),
				binaryTreeFromPreorderInorderHelper(preorder, preorderStart + 1, preorderStart + 1 + leftSubtreeSize,
						inorderStart, rootInorderIdx, nodeToInorderIdx),
				binaryTreeFromPreorderInorderHelper(preorder, preorderStart + 1 + leftSubtreeSize, preorderEnd,
						rootInorderIdx + 1, inorderEnd, nodeToInorderIdx));
	}
}
