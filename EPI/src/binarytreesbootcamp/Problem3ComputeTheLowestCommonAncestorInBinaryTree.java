package binarytreesbootcamp;

public class Problem3ComputeTheLowestCommonAncestorInBinaryTree {

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

		BinaryTreeNode<Integer> lca = LCA(A, M, N);
		System.out.println(lca == null ? "No Ancestor Match!" : lca.toString());
	}

	public static BinaryTreeNode<Integer> LCA(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node0,
			BinaryTreeNode<Integer> node1) {

		return LCAHelper(root, node0, node1).ancestor;
	}

	// time complexity O(n) and space complexity O(h), n and h are the number of
	// nodes and h is the height of the tree.
	private static Status LCAHelper(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node0,
			BinaryTreeNode<Integer> node1) {
		if (root == null) {
			return new Status(0, null);
		}
		// traverse the left and get the status
		Status leftResult = LCAHelper(root.left, node0, node1);
		if (leftResult.numTargetNodes == 2) {
			return leftResult;
		}

		// traverse the right and get the status
		Status rightResult = LCAHelper(root.right, node0, node1);
		if (rightResult.numTargetNodes == 2) {
			return rightResult;
		}

		int numNodesTargeted = leftResult.numTargetNodes + rightResult.numTargetNodes + (root == node0 ? 1 : 0)
				+ (root == node1 ? 1 : 0);

		return new Status(numNodesTargeted, numNodesTargeted == 2 ? root : null);
	}

}

class Status {
	public int numTargetNodes;
	public BinaryTreeNode<Integer> ancestor;

	public Status(int numTargetNodes, BinaryTreeNode<Integer> ancestor) {
		this.numTargetNodes = numTargetNodes;
		this.ancestor = ancestor;
	}
}
