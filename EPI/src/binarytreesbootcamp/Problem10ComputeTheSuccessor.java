package binarytreesbootcamp;

public class Problem10ComputeTheSuccessor {

	public static void main(String[] args) {
		BinaryTreeNode<Integer> M = new BinaryTreeNode<>();
		M.ele = 641;
		BinaryTreeNode<Integer> L = new BinaryTreeNode<>();
		L.ele = 401;
		L.right = M;
		M.parent = L;
		BinaryTreeNode<Integer> N = new BinaryTreeNode<>();
		N.ele = 257;
		BinaryTreeNode<Integer> K = new BinaryTreeNode<>();
		K.ele = 1;
		K.left = L;
		K.right = N;
		L.parent = K;
		N.parent = K;
		BinaryTreeNode<Integer> J = new BinaryTreeNode<>();
		J.ele = 2;
		J.right = K;
		K.parent = J;
		BinaryTreeNode<Integer> P = new BinaryTreeNode<>();
		P.ele = 28;
		BinaryTreeNode<Integer> O = new BinaryTreeNode<>();
		O.ele = 271;
		O.right = P;
		P.parent = O;
		BinaryTreeNode<Integer> I = new BinaryTreeNode<>();
		I.ele = 6;
		I.left = J;
		I.right = O;
		J.parent = I;
		O.parent = I;

		BinaryTreeNode<Integer> H = new BinaryTreeNode<>();
		H.ele = 17;
		BinaryTreeNode<Integer> G = new BinaryTreeNode<>();
		G.ele = 3;
		G.left = H;
		H.parent = G;
		BinaryTreeNode<Integer> D = new BinaryTreeNode<>();
		D.ele = 28;
		BinaryTreeNode<Integer> E = new BinaryTreeNode<>();
		E.ele = 0;

		BinaryTreeNode<Integer> F = new BinaryTreeNode<>();
		F.ele = 561;
		F.right = G;
		G.parent = F;
		BinaryTreeNode<Integer> C = new BinaryTreeNode<>();
		C.ele = 271;
		C.left = D;
		C.right = E;
		D.parent = C;
		E.parent = C;
		BinaryTreeNode<Integer> B = new BinaryTreeNode<>();
		B.ele = 6;
		B.left = C;
		B.right = F;
		C.parent = B;
		F.parent = B;

		BinaryTreeNode<Integer> A = new BinaryTreeNode<>();
		A.ele = 314;
		A.left = B;
		A.right = I;
		B.parent = A;
		I.parent = A;

		BinaryTreeNode<Integer> successor = findSuccessor(A);
		System.out.println(
				successor != null ? successor.toString() : "It is the right most node of the BT, Hence no successor!");
	}

	// time complexity O(h)
	public static BinaryTreeNode<Integer> findSuccessor(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> iter = root;
		// if the right node is present.
		if (iter.right != null) {
			iter = iter.right;
			while (iter.left != null) {
				iter = iter.left;
			}
			return iter;
		}
		// if right is null and we have to find the Grand++ Parent or if it is the last
		// there is no successor.
		while (iter.parent != null && iter.parent.right == iter) {
			iter = iter.parent;
		}
		// returning null if there is no successor of the given node i.e. it is the
		// right most node of the BT.
		return iter.parent;

	}

}
