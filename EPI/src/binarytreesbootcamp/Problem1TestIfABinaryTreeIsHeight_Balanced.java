package binarytreesbootcamp;
// Problem Write a program that takes as input the root of a binary tree and checks whether the tree is height-balanced.

// Variant 1. Write a program that returns the size of the largest subtree that is complete. 
// Variant 2. :Define a node in a binary tree to be k-balanced if the difference in the number of nodes in its left and right
//             subtrees is no more than k. Design an algorithm that takes as input a binary tree and positive integer k,and returns
//			   a node in the binary tree such that the node is not k-balanced, but all of its descendants are k-balanced.
//			   For example, when applied to the binary tree in Figure10.1 on Page 150, if k = 3,your algorithm should
//             return Node/.

public class Problem1TestIfABinaryTreeIsHeight_Balanced {

	public static void main(String[] args) {
		BinaryTreeNode<Integer> M = new BinaryTreeNode<>();
		M.ele = 641;
		BinaryTreeNode<Integer> L = new BinaryTreeNode<>();
		L.ele = 401;
		L.right = M;
		BinaryTreeNode<Integer> N = new BinaryTreeNode<>();
		N.ele = 257;
		BinaryTreeNode<Integer> K = new BinaryTreeNode<>();
		K.ele = 1;
		K.left = L;
		K.right = N;
		BinaryTreeNode<Integer> J = new BinaryTreeNode<>();
		J.ele = 2;
		J.right = K;
		BinaryTreeNode<Integer> P = new BinaryTreeNode<>();
		P.ele = 28;
		BinaryTreeNode<Integer> O = new BinaryTreeNode<>();
		O.ele = 271;
		O.right = P;
		BinaryTreeNode<Integer> I = new BinaryTreeNode<>();
		I.ele = 6;
		I.left = J;
		I.right = O;

		BinaryTreeNode<Integer> H = new BinaryTreeNode<>();
		H.ele = 17;
		BinaryTreeNode<Integer> G = new BinaryTreeNode<>();
		G.ele = 3;
		G.left = H;
		BinaryTreeNode<Integer> D = new BinaryTreeNode<>();
		D.ele = 28;
		BinaryTreeNode<Integer> E = new BinaryTreeNode<>();
		E.ele = 0;

		BinaryTreeNode<Integer> F = new BinaryTreeNode<>();
		F.ele = 561;
		F.right = G;
		BinaryTreeNode<Integer> C = new BinaryTreeNode<>();
		C.ele = 271;
		C.left = D;
		C.right = E;

		BinaryTreeNode<Integer> B = new BinaryTreeNode<>();
		B.ele = 6;
		B.left = C;
		B.right = F;

		BinaryTreeNode<Integer> A = new BinaryTreeNode<>();
		A.ele = 314;
		A.left = B;
		A.right = I;

		BalanceStatusWithHeight checkBalanced = checkBalanced(A);
		System.out.println("Balanced  : " + checkBalanced.isBalanced + ", height : " + checkBalanced.height);
		BinaryTreeNode<Integer> left = new BinaryTreeNode<>();
		left.ele = 76;
		BinaryTreeNode<Integer> right = new BinaryTreeNode<>();
		right.ele = 76;
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>();
		root.ele = 76;
		root.left = left;
		root.right = right;
		BalanceStatusWithHeight checkBalanced2 = checkBalanced(root);
		System.out.println("Balanced  : " + checkBalanced2.isBalanced + ", height : " + checkBalanced2.height);

	}

	// Time Complexity O(n), n is number of nodes and Space , Space Complexity
	// O(h),h is the height of the tree (Stacks created)
	// good point early termination willnot go for the right subtree analysis.
	public static BalanceStatusWithHeight checkBalanced(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return new BalanceStatusWithHeight(true, -1);
		}

		// process the left subtree and get the status with height
		BalanceStatusWithHeight leftTreeResult = checkBalanced(root.left);
		if (!leftTreeResult.isBalanced) {
			return leftTreeResult; // tree is not balanced return it;
		}

		// process the right subtree and get the status with height
		BalanceStatusWithHeight rightTreeResult = checkBalanced(root.right);
		if (!rightTreeResult.isBalanced)
			return rightTreeResult;

		// using post order traverse return the balanced status with height.
		boolean isBalanced = Math.abs(leftTreeResult.height - rightTreeResult.height) <= 1;
		int height = Math.max(rightTreeResult.height, leftTreeResult.height) + 1;
		return new BalanceStatusWithHeight(isBalanced, height);
	}

}

class BalanceStatusWithHeight {
	boolean isBalanced;
	int height;

	public BalanceStatusWithHeight(boolean isBalanced, int height) {
		this.isBalanced = isBalanced;
		this.height = height;
	}
}
