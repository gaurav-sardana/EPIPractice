package binarytreesbootcamp;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Problem15ComputeAExteriorOfABinaryTree {

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

		List<BinaryTreeNode<Integer>> leavesOfTree = exteriorBinaryTree(A);
		Iterator<BinaryTreeNode<Integer>> iterator = leavesOfTree.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().ele);
		}
	}

	public static List<BinaryTreeNode<Integer>> exteriorBinaryTree(BinaryTreeNode<Integer> tree) {
		List<BinaryTreeNode<Integer>> exterior = new LinkedList<BinaryTreeNode<Integer>>();
		if (tree != null) {
			exterior.add(tree);
			exterior.addAll(leftBoundaryAndLeaf(tree.left, true));
			exterior.addAll(rightBoundaryAndLeaf(tree.right, true));
		}
		return exterior;
	}

	private static List<BinaryTreeNode<Integer>> leftBoundaryAndLeaf(BinaryTreeNode<Integer> subTreeRoot,
			boolean isBoundary) {
		List<BinaryTreeNode<Integer>> result = new LinkedList<>();
		if (subTreeRoot != null) {
			if (isBoundary || isLeaf(subTreeRoot)) {
				result.add(subTreeRoot);
			}
			result.addAll(leftBoundaryAndLeaf(subTreeRoot.left, isBoundary));
			result.addAll(leftBoundaryAndLeaf(subTreeRoot.right, isBoundary && subTreeRoot.left == null));
		}

		return result;
	}

	private static List<BinaryTreeNode<Integer>> rightBoundaryAndLeaf(BinaryTreeNode<Integer> subTreeRoot,
			boolean isBoundary) {
		List<BinaryTreeNode<Integer>> result = new LinkedList<>();
		if (subTreeRoot != null) {
			result.addAll(rightBoundaryAndLeaf(subTreeRoot.left, isBoundary && subTreeRoot.right == null));
			result.addAll(rightBoundaryAndLeaf(subTreeRoot.right, isBoundary));
			if (isBoundary || isLeaf(subTreeRoot)) {
				result.add(subTreeRoot);
			}
		}
		return result;
	}

	private static boolean isLeaf(BinaryTreeNode<Integer> node) {
		return node.left == null && node.right == null;
	}
}
