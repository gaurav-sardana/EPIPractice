package binarysearchtreebootcamp;

import binarytreesbootcamp.BinaryTreeNode;

//https://leetcode.com/problems/minimum-absolute-difference-in-bst
public class LC530_MinimumAbsoluteDifferenceInBST {

    static Integer prev = null;
    static Integer minimumDifference = Integer.MAX_VALUE;

    public static void main(String[] args) {

    }

    public static int getMinimumDifference(BinaryTreeNode<Integer> root) {
        inorder(root);
        return minimumDifference;
    }

    public static void inorder(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (prev != null) {
            minimumDifference = Math.min(minimumDifference, node.ele - prev);
        }
        prev = node.ele;
        inorder(node.right);
    }

}
