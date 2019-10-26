package binarytreesbootcamp;

public class Problem9ComputeTheKthNodeInAnInorderTraversal {

	public static void main(String[] args) {
		BinaryTreeNode<Integer> M = new BinaryTreeNode<>();
		M.ele = 641;
		M.size = 1;
		BinaryTreeNode<Integer> L = new BinaryTreeNode<>();
		L.ele = 401;
		L.size = 2;
		L.right = M;
		BinaryTreeNode<Integer> N = new BinaryTreeNode<>();
		N.ele = 257;
		N.size = 1;
		BinaryTreeNode<Integer> K = new BinaryTreeNode<>();
		K.ele = 1;
		K.size = 4;
		K.left = L;
		K.right = N;
		BinaryTreeNode<Integer> J = new BinaryTreeNode<>();
		J.ele = 2;
		J.size = 5;
		J.right = K;
		BinaryTreeNode<Integer> P = new BinaryTreeNode<>();
		P.ele = 28;
		P.size = 1;
		BinaryTreeNode<Integer> O = new BinaryTreeNode<>();
		O.ele = 271;
		O.size = 2;
		O.right = P;
		BinaryTreeNode<Integer> I = new BinaryTreeNode<>();
		I.ele = 6;
		I.size = 8;
		I.left = J;
		I.right = O;

		BinaryTreeNode<Integer> H = new BinaryTreeNode<>();
		H.ele = 17;
		H.size = 1;
		BinaryTreeNode<Integer> G = new BinaryTreeNode<>();
		G.ele = 3;
		G.size = 2;
		G.left = H;
		BinaryTreeNode<Integer> D = new BinaryTreeNode<>();
		D.ele = 28;
		D.size = 1;
		BinaryTreeNode<Integer> E = new BinaryTreeNode<>();
		E.ele = 0;
		E.size = 1;

		BinaryTreeNode<Integer> F = new BinaryTreeNode<>();
		F.ele = 561;
		F.size = 3;
		F.right = G;
		BinaryTreeNode<Integer> C = new BinaryTreeNode<>();
		C.ele = 271;
		C.size = 2;
		C.left = D;
		C.right = E;

		BinaryTreeNode<Integer> B = new BinaryTreeNode<>();
		B.ele = 6;
		B.size = 7;
		B.left = C;
		B.right = F;

		BinaryTreeNode<Integer> A = new BinaryTreeNode<>();
		A.ele = 314;
		A.size = 16;
		A.left = B;
		A.right = I;
		BinaryTreeNode<Integer> findkthNodeBT = findkthNodeBT(A, 16);
		System.out.println(findkthNodeBT != null ? findkthNodeBT.ele : "kth is out of range of tree size");
	}

	private static BinaryTreeNode<Integer> findkthNodeBT(BinaryTreeNode<Integer> root, int k) {

		if (k < 1 || k > root.size) {
			return null;
		}
		BinaryTreeNode<Integer> iter = root;
		while (iter != null) {
			int leftSize = iter.left != null ? iter.left.size : 0;
			if (k > leftSize + 1) {// it means we dont have to commute the left part hit the right part
				k -= (leftSize + 1);// remove the current + left nodes from k we have to go for new kth from right
									// node
				iter = iter.right;
			} else if (k - 1 == leftSize) {
				return iter;// this is the kth Node
			} else {
				iter = iter.left;
			}

		}
		return null;// if the k is between 1 and tree size, the line is unreachable.
	}

}
