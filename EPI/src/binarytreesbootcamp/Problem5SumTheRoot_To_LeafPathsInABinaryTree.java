package binarytreesbootcamp;

public class Problem5SumTheRoot_To_LeafPathsInABinaryTree {

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
		System.out.println("Total Sum is  : "+sumRootToLeaf(A));
	}

	public static int sumRootToLeaf(BinaryTreeNode<Integer> tree) {
		return sumRootToLeafHelper(tree, 0);
	}

	private static int sumRootToLeafHelper(BinaryTreeNode<Integer> tree, int partialSum) {
		// formula to calculate the decimal from binary from upwards is 2(ParentSum) +
		// current bit
		if (tree == null)
			return 0;

		partialSum = partialSum * 2 + tree.ele;
		if (tree.left == null && tree.right == null) {// Leaf Captured
			return partialSum;
		}

		// It is a not leaf
		return sumRootToLeafHelper(tree.left, partialSum) + sumRootToLeafHelper(tree.right, partialSum);

	}

}
