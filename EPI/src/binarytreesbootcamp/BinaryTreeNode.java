package binarytreesbootcamp;

public class BinaryTreeNode<T> {
	public T ele;
	public BinaryTreeNode<T> left, right;
	public BinaryTreeNode<Integer> parent;
	int size;

	public BinaryTreeNode(T ele, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
		super();
		this.ele = ele;
		this.left = left;
		this.right = right;
	}

	public BinaryTreeNode() {
		super();
	}

	@Override
	public String toString() {
		return "[ele : " + ele + "]";
	}

}
