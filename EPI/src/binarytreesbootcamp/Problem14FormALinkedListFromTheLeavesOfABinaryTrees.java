package binarytreesbootcamp;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Problem14FormALinkedListFromTheLeavesOfABinaryTrees {

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

		List<BinaryTreeNode<Integer>> leavesOfTree = getLeavesOfTree(A);
		Iterator<BinaryTreeNode<Integer>> iterator = leavesOfTree.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().ele);
		}
	}

	// time complexity O(n)
	private static List<BinaryTreeNode<Integer>> getLeavesOfTree(BinaryTreeNode<Integer> root) {
		List<BinaryTreeNode<Integer>> leavesBinaryTreeNodes = new LinkedList<BinaryTreeNode<Integer>>();
		addLeavesLeftToRight(root, leavesBinaryTreeNodes);
		return leavesBinaryTreeNodes;
	}

	private static void addLeavesLeftToRight(BinaryTreeNode<Integer> root, List<BinaryTreeNode<Integer>> leaves) {

		if (root != null) {
			if (root.left == null && root.right == null) {
				leaves.add(root);
			} else {
				addLeavesLeftToRight(root.left, leaves);
				addLeavesLeftToRight(root.right, leaves);
			}
		}
	}

}
