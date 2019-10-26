package binarytreesbootcamp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem11ImplementAnInorderTraversalWithO_1Space {

	// a traverse can be done using O(1) space complexity if the node has additional
	// information (parent node)
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

		List<Integer> inorderTraversal = inorderTraversal(A);
		System.out.println(inorderTraversal.toString());
	}

	// additional space complexity is O(1) and time complexity is o(h)
	//
	private static List<Integer> inorderTraversal(BinaryTreeNode<Integer> root) {

		BinaryTreeNode<Integer> prev = null, curr = root;
		List<Integer> result = new ArrayList<Integer>();

		while (curr != null) {
			BinaryTreeNode<Integer> next;
			if (curr.parent == prev) {
				// we came down to curr from prev
				if (curr.left != null) {
					next = curr.left;
				} else {
					result.add(curr.ele);
					// done with the left now go for the right if right isn't empty else go up
					next = curr.right != null ? curr.right : curr.parent;
				}
			} else if (curr.left == prev) {
				result.add(curr.ele);
				// done with the left now go for the right if right isn't empty else go up
				next = curr.right != null ? curr.right : curr.parent;
			} else {
				next = curr.parent;
			}
			prev = curr;
			curr = next;
		}

		return result;
	}

}
