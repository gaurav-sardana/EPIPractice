package binarytreesbootcamp;

public class Problem17ImplementLockingInABinaryTree {

	public static void main(String[] args) {

		
	}

}

class BinaryTree {
	private BinaryTree left, right, parent;
	private boolean isLocked = false;
	private int numLockedDescendants = 0;

	public boolean isLocked() {
		return isLocked;
	}

	public boolean lock() {
		if (numLockedDescendants > 0 || isLocked) {
			return false;
		}
		for (BinaryTree iter = parent; iter != null; iter = iter.parent) {
			if (iter.isLocked) {
				return false;
			}
		}
		this.isLocked = true;
		for (BinaryTree iter = this.parent; iter != null; iter = iter.parent) {
			++iter.numLockedDescendants;
		}
		return this.isLocked;
	}

	public void unlock() {
		if (isLocked) {
			isLocked = false;
			for (BinaryTree iter = parent; iter != null; iter = iter.parent) {
				--iter.numLockedDescendants;
			}
		}
	}
}
