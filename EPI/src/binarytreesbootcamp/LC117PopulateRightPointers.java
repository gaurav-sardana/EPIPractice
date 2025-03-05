package binarytreesbootcamp;

import java.util.LinkedList;
import java.util.Queue;

public class LC117PopulateRightPointers {
    public static void main(String[] args) {

    }

    public void connect(final BinaryTreeNode<Integer> treeNode) {

        Queue<BinaryTreeNode<Integer>> binaryTreeNodes = new LinkedList<>();
        binaryTreeNodes.offer(treeNode);

        while (!binaryTreeNodes.isEmpty()) {
            int size = binaryTreeNodes.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode<Integer> node = binaryTreeNodes.poll();

                if (i < size - 1) {
                    node.next = binaryTreeNodes.peek();
                }

                if (node.left != null) binaryTreeNodes.offer(node.left);
                if (node.right != null) binaryTreeNodes.offer(node.right);
            }

        }
    }
}
