package binarytreesbootcamp;

import java.util.ArrayList;
import java.util.List;

public class LC173_BinarySearchTreeIterator {

    public static void main(String[] args) {

    }

    int itrVal = 0;
    List<Integer> vals = new ArrayList<>();

    public LC173_BinarySearchTreeIterator(BinaryTreeNode<Integer> treeNode) {
          inorder(treeNode);
    }

    public int next() {
        return vals.get(itrVal++);
    }

    public boolean hasNext() {
        return vals.size() > itrVal;
    }

    private void inorder((BinaryTreeNode<Integer> treeNode) {
        if (treeNode == null) return;
        inorder(treeNode.left);
        vals.add(treeNode.ele);
        inorder(treeNode);

    }
}
