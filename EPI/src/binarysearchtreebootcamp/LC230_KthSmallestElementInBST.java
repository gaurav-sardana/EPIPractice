package binarysearchtreebootcamp;

import binarytreesbootcamp.BinaryTreeNode;

public class LC230_KthSmallestElementInBST {

    static int i = 0;
    static int ans = 0;

    public static void main(String[] args) {

    }

    public static int kthSmallest(BinaryTreeNode<Integer> treeNode, int k) {
        inorder(treeNode, k);
        return ans;
    }


    public static void inorder(BinaryTreeNode<Integer> node, int k) {
        if (node == null) return;
        inorder(node.left, k);
        i++;
        if (i == k) {
            ans = node.ele;
            return;
        }
        if (ans > 0) {
            return;
        }
        inorder(node.right, k);
    }
}
