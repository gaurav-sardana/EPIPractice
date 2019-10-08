package binarytreesbootcamp;

public class Problem4ComputeTheLCAWhenNodesHaveParentPointers {

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

		BinaryTreeNode<Integer> lca = LCA(I, O);
		System.out.println(lca == null ? "No Ancestor Match!" : lca.toString());
	}

	// time complexity is O(h) and space complexity is O(1)
	public static BinaryTreeNode<Integer> LCA(BinaryTreeNode<Integer> node0, BinaryTreeNode<Integer> node1) {
		if (node0 == null || node1 == null) {
			return null;
		}
		int depth0 = getDepth(node0), depth1 = getDepth(node1);
		if (depth1 > depth0) {
			BinaryTreeNode<Integer> temp = node0;
			node0 = node1;
			node1 = temp;
		}

		// take node0 to the same level to node1
		int diff = Math.abs(depth0 - depth1);
		while (diff-- > 0) {
			node0 = node0.parent;
		}

		// compare there parent in tandem
		while (node0 != node1) {
			node0 = node0.parent;
			node1 = node1.parent;
		}

		return node0;
	}

	public static int getDepth(BinaryTreeNode<Integer> node) {
		int depth = 0;
		while (node.parent != null) {
			depth++;
			node = node.parent;
		}
		return depth;
	}

}
