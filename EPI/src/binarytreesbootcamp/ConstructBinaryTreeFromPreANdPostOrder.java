package binarytreesbootcamp;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreANdPostOrder {

    static int preIndex = 0;
    static Map<Integer, Integer> postOrderMap = new HashMap<>();


    public static void main(String[] args) {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] postOrder = {9, 15, 7, 20, 3};
        BinaryTreeNode<Integer> tree = construct(preOrder, postOrder);
        TraversingBinaryTree.treeTraversal(tree);
    }

    // first Node in preOrder will always be root node
    // last node in post order will always be root node
    // second node inn preorder is the root of left sub tree
    // find this node in postOrder to determine the boundary between left and right sub tree
    // Recursively build the left and right subtrees


    //explanation
    // store post order indices in a Hash Map (postIndexMap) for quick look up
    // UserPreIndex to track preorder traversal
    // Recursively construct the tree :
    //   - Root is taken from preOrder
    //   - left subtree is identified using postorder
    //   - Recur for left and right subtree


    // time complexity : O(n) each node is visited once
    // space complexity : O(n)
    public static BinaryTreeNode<Integer> construct(int[] preOrder, int[] postOrder) {

        for (int i = 0; i < postOrder.length; i++) {
            postOrderMap.put(postOrder[i], i);
        }

        return buildTree(preOrder, 0, postOrder.length - 1);
    }

    public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int left, int right) {

        if (left > right || preIndex >= preOrder.length) return null;

        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<>(preOrder[preIndex++]);

        if (left == right) return rootNode;

        int leftSubtreeIndex = postOrderMap.get(preOrder[preIndex]);

        rootNode.left = buildTree(preOrder, left, leftSubtreeIndex);
        rootNode.right = buildTree(preOrder, leftSubtreeIndex + 1, right - 1);
        return rootNode;
    }

}
