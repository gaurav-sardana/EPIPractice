package binarytreesbootcamp;

public class BinaryTreeNode<T> {
	public T ele;
	public BinaryTreeNode<T> left, right;
	public BinaryTreeNode<Integer> parent;
	int size;

	@Override
	public String toString() {
		return "[ele : " + ele + "]";
	}

}
