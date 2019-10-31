package tree;

public class BinarySearchTreeSelf {
	int data;
	BinarySearchTreeSelf left, right;

	public BinarySearchTreeSelf(int data) {
		this.data = data;
	}

	public void insert(int val) {
		if (val < this.data) {
			if (this.left == null)
				this.left = new BinarySearchTreeSelf(val);
			else
				this.left.insert(val);
		} else {
			if (this.right == null)
				this.right = new BinarySearchTreeSelf(val);
			else
				this.right.insert(val);
		}
	}

	public void preOrder() {
		System.out.println(data);

		if (this.left != null)
			this.left.preOrder();

		if (this.right != null)
			this.right.preOrder();

	}

	public static void main(String[] args) {
		int[] a = { 50, 30, 70, 20, 40, 60, 80 };
		BinarySearchTreeSelf root = new BinarySearchTreeSelf(a[0]);
		for (int i = 1; i < a.length; i++) {
			root.insert(a[i]);
		}

		root.preOrder();

	}

}
