package linkedlistsbootcamp;

import MyLinkedList.Node;

public class Problem5TestForOverlappingList_Cyclic {

	public static void main(String[] args) {

	}

	public static Node<Integer> overLappingList(Node<Integer> L1, Node<Integer> L2) {

		// Store the start of the cycle
		Node<Integer> root1 = Problem3TestForCyclicity.hasCycle(L1);
		Node<Integer> root2 = Problem3TestForCyclicity.hasCycle(L2);

		if (root1 == null && root2 == null) {
			// Both list doesn't have cycles
			return Problem4TestForOverlappingList_CycleFree.overlappingNoCylclicList(root1, root2);
		} else if (root1 != null && root2 == null || root1 == null && root2 != null) {
			// One list has cycle and one list doesn't have cycle!
			return null;
		}

		// Both List have cycle.
		Node<Integer> temp = root2;
		do {
			temp = temp.nextNode;
		} while (temp != root1 && temp != root2);

		// if root1 didn't show up first it means they both don't share the same cycle
		if (temp != root1) {
			return null;
		}

		int stem1Len = distance(L1, root1), stem2Len = distance(L2, root2);

		if (stem1Len > stem2Len) {
			L1 = Problem4TestForOverlappingList_CycleFree.advanceNode(L1, stem1Len - stem2Len);
		} else {
			L2 = Problem4TestForOverlappingList_CycleFree.advanceNode(L2, stem2Len - stem1Len);
		}

		while (L1 != L2 && L1 != null && L2 != null) {
			L1 = L1.nextNode;
			L2 = L2.nextNode;
		}
		// if L1=L2 before reaching root1, it means the overlap first occurs before the cycle starts; otherwise,
		// the first overlapping node is not unique, so we can return any node on the cycle
		return L1 == L2 ? L1 : root1;

	}

	public static int distance(Node<Integer> a, Node<Integer> b) {
		int len = 0;
		while (a != b) {
			a = a.nextNode;
			++len;
		}
		return len;
	}
}
