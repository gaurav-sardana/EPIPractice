package binarytreesbootcamp;

public class Problem6FindARootToLeafPathWithSpecifiedSum {

	public static void main(String[] args) {
		BinaryTreeNode<Integer> M = new BinaryTreeNode<>();
		M.ele = 1;
		BinaryTreeNode<Integer> L = new BinaryTreeNode<>();
		L.ele = 1;
		L.right = M;
		BinaryTreeNode<Integer> N = new BinaryTreeNode<>();
		N.ele = 0;
		BinaryTreeNode<Integer> K = new BinaryTreeNode<>();
		K.ele = 0;
		K.left = L;
		K.right = N;
		BinaryTreeNode<Integer> J = new BinaryTreeNode<>();
		J.ele = 0;
		J.right = K;
		BinaryTreeNode<Integer> P = new BinaryTreeNode<>();
		P.ele = 0;
		BinaryTreeNode<Integer> O = new BinaryTreeNode<>();
		O.ele = 0;
		O.right = P;
		BinaryTreeNode<Integer> I = new BinaryTreeNode<>();
		I.ele = 1;
		I.left = J;
		I.right = O;

		BinaryTreeNode<Integer> H = new BinaryTreeNode<>();
		H.ele = 0;
		BinaryTreeNode<Integer> G = new BinaryTreeNode<>();
		G.ele = 1;
		G.left = H;
		BinaryTreeNode<Integer> D = new BinaryTreeNode<>();
		D.ele = 0;
		BinaryTreeNode<Integer> E = new BinaryTreeNode<>();
		E.ele = 1;

		BinaryTreeNode<Integer> F = new BinaryTreeNode<>();
		F.ele = 1;
		F.right = G;
		BinaryTreeNode<Integer> C = new BinaryTreeNode<>();
		C.ele = 0;
		C.left = D;
		C.right = E;

		BinaryTreeNode<Integer> B = new BinaryTreeNode<>();
		B.ele = 0;
		B.left = C;
		B.right = F;

		BinaryTreeNode<Integer> A = new BinaryTreeNode<>();
		A.ele = 1;
		A.left = B;
		A.right = I;
		System.out.println("has Sum Path ?  : "+hasPathSum(A,12));
	}

	//time complexity : O(n) and space complexity(h) , h and n are height and number of nodes of the tress 
	public static boolean hasPathSum(BinaryTreeNode<Integer> tree, int targetSum) {
		return hasPathSumHelper(tree, 0, targetSum);
	}

	private static boolean hasPathSumHelper(BinaryTreeNode<Integer> tree, int partialSum, int targerSum) {

		if (tree == null) {
			return false;
		}
		partialSum = partialSum * 2 + tree.ele;
		if (tree.left == null && tree.right == null) {
			return partialSum == targerSum;
		}

		return hasPathSumHelper(tree.left, partialSum, targerSum)
				|| hasPathSumHelper(tree.right, partialSum, targerSum);

	}

}
