package binarytreesbootcamp;

public class BinaryTreeNode<T> {
	public T ele;
	public BinaryTreeNode<T> left, right;
	public BinaryTreeNode<Integer> parent;

	@Override
	public String toString() {
		return "[ele : " + ele + "]";
	}

}
