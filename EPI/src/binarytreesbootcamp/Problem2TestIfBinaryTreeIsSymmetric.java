package binarytreesbootcamp;

public class Problem2TestIfBinaryTreeIsSymmetric {

	public static void main(String[] args) {

		BinaryTreeNode<Integer> A = new BinaryTreeNode<>();
		A.ele = 40;
		BinaryTreeNode<Integer> B = new BinaryTreeNode<>();
		B.ele = 3;
		B.right = A;
		BinaryTreeNode<Integer> C = new BinaryTreeNode<>();
		C.ele = 2;
		C.right = B;

		BinaryTreeNode<Integer> A1 = new BinaryTreeNode<>();
		A1.ele = 40;
		BinaryTreeNode<Integer> B1 = new BinaryTreeNode<>();
		B1.ele = 3;
		B1.left = A1;
		BinaryTreeNode<Integer> C1 = new BinaryTreeNode<>();
		C1.ele = 2;
		C1.left = B1;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<>();
		root.ele = 1;
		root.left = C;
		root.right = C1;

		boolean symmteric = isSymmteric(root);
		System.out.println("Is Symmetric : " + symmteric);

	}

	//Time complexity O(n), n is the number of nodes
	//Space Complexity O(h) , height of the binary tree;
	public static boolean isSymmteric(BinaryTreeNode<Integer> root) {
		return root == null || checkSymmetry(root.left, root.right);
	}

	public static boolean checkSymmetry(BinaryTreeNode<Integer> subTree1, BinaryTreeNode<Integer> subTree2) {

		if (subTree1 == null && subTree2 == null) {
			return true;
		} else if (subTree1 != null && subTree2 != null) {
			return subTree1.ele == subTree2.ele && checkSymmetry(subTree1.left, subTree2.right)
					&& checkSymmetry(subTree1.right, subTree2.left);
		}
		// when both one is empty and other is not
		return false;
	}

}
