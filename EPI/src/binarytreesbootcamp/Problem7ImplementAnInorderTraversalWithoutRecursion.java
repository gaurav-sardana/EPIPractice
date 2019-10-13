package binarytreesbootcamp;

import java.util.Deque;
import java.util.LinkedList;

public class Problem7ImplementAnInorderTraversalWithoutRecursion {

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
		LinkedList<Integer> inOrderTraversal = inOrderTraversal(A);
		while (inOrderTraversal.size() != 0) {
			System.out.println(inOrderTraversal.pop());
		}
	}

	// space complexity O(h) and time complexity O(n)
	public static LinkedList<Integer> inOrderTraversal(BinaryTreeNode<Integer> root) {

		BinaryTreeNode<Integer> current = root;
		Deque<BinaryTreeNode<Integer>> stack = new LinkedList<BinaryTreeNode<Integer>>();
		LinkedList<Integer> result = new LinkedList<Integer>();

		while (!stack.isEmpty() || current != null)
			if (current != null) {
				stack.addFirst(current);
				current = current.left;
			} else {
				current = stack.removeFirst();
				result.add(current.ele);
				current = current.right;
			}
		return result;
	}

}
