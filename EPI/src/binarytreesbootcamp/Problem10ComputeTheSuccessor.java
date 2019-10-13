package binarytreesbootcamp;

public class Problem10ComputeTheSuccessor {

	public static void main(String[] args) {

	}

	public static BinaryTreeNode<Integer> findSuccessor(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> iter = root;
		if (iter.right != null) {
			iter = iter.right;
			while (iter.left != null) {
				iter = iter.left;
			}
			return iter;
		}
		while (iter.parent != null && iter.parent.right == iter) {
			iter = iter.parent;
		}
		return iter.parent;
	}

}
