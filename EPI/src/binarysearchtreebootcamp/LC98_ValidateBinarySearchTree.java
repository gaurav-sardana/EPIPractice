package binarysearchtreebootcamp;

import binarytreesbootcamp.BinaryTreeNode;

public class LC98_ValidateBinarySearchTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> treeNode = new BinaryTreeNode<>(2, new BinaryTreeNode<>(1, null, null
        ), new BinaryTreeNode<Integer>(1, null, null));
        System.out.println(isValidBST(treeNode));


    }

    public static boolean isValidBST(final BinaryTreeNode<Integer> treeNode) {
        return isKeyINRange(treeNode, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isKeyINRange(final BinaryTreeNode<Integer> treeNode, int lower, int upper) {

        if (treeNode == null) {
            return true;
        }

        if (treeNode.ele <= lower || treeNode.ele >= upper) {
            return false;
        }

        return isKeyINRange(treeNode.left, lower, treeNode.ele) && isKeyINRange(treeNode.right, treeNode.ele, upper);
    }
}
