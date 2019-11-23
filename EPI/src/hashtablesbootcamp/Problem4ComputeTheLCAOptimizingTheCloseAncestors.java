package hashtablesbootcamp;

import java.util.HashSet;
import java.util.Set;

import binarytreesbootcamp.BinaryTreeNode;

public class Problem4ComputeTheLCAOptimizingTheCloseAncestors {

	public static void main(String[] args) {

	}

	// Brute Force Approach :
	// Take a node0 and record itself in the HashSet and traverse to the parent till
	// you reach the root and then start traversing for node 1 till you reach the
	// LCA
	// or (traverse upwards from one node to the root, recording the
	// nodes on the search path and traversing upwards from the other node, stopping
	// as soon as we see a node on the path from the first node)
	// issue is we end up going to the root even if the LCA is the parent of two
	// nodes(siblings)
	// Hence brute force is sub optimal because potentially processes node well
	// above
	// the LCA
	// Each time we visit a node we check to see if it has been visited

	// Optimal Solution is traverse alternatively moving upwards from the two nodes
	// and storing the nodes visited as we move up in the Hash Table

	// here we trading space for time // algo in BT uses O(1) space and O(H) time
	// this use time O(D0+D1) D0 is the distance from the LCA to node1, D1 is the
	// distance from the LCA to node2 // worst case O(H) space , h is the height of
	// the tree(leave nodes and LCA is root )
	public static BinaryTreeNode<Integer> LCA(BinaryTreeNode<Integer> node0, BinaryTreeNode<Integer> node1) {

		Set<BinaryTreeNode<Integer>> hash = new HashSet<>();

		while (node0 != null || node1 != null) {
			if (node0 != null) {
				if (!hash.add(node0)) {
					return node0;
				}
				node0 = node0.parent;
			}

			if (node1 != null) {
				if (!hash.add(node1)) {
					return node1;
				}
				node1 = node1.parent;
			}
		}
		throw new IllegalArgumentException("Both the nodes are not belonging to same tree!");
	}

}
