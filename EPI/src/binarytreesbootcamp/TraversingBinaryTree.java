package binarytreesbootcamp;

public class TraversingBinaryTree {

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
		treeTraversal(A);

	}

	//time complexity is O(n) n is the number of nodes.
	// function call stack reaches the maximum depth of h,height of the tree, Hence space complexity is O(h) and no additional space complexity.
	//The minimum value of h is lg(n) (When tree is complete binary tree) and maximum is value of h is n-1(skewed binary tree)
	private static void treeTraversal(BinaryTreeNode<Integer> root) {
		if (root != null) {
			// Pre order (PLR) Processes the root before the traversals of left and right
			// children.
			System.out.println("Preorder : " + root.ele);
			treeTraversal(root.left);

			// in order (LPR) Process the root after the traversal of left and before the
			// traversal of right.
			System.out.println("Inorder : " + root.ele);
			treeTraversal(root.right);

			// post order (LRP) Process the root after the traversal of left and right
			System.out.println("Post Order : "+root.ele);
		}
	}
}
