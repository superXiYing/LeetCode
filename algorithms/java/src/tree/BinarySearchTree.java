package tree;

import java.util.Stack;

class BinarySearchTree {
	Node root;

	BinarySearchTree() {
		root = null;
	}

	/* A recursive function to insert a new key in BST */
	Node insertNode(Node current, int value) {
		if (current == null) {
			current = new Node(value);
			return current;
		} else {
			if (value < current.key) {
				current.left = insertNode(current.left, value);
			} else {
				current.right = insertNode(current.right, value);
			}
		}

		return current;

	}

	// wrapper for above function
	public void insert(int value) {
		root = insertNode(root, value);
	}

	boolean searchNode(Node root, int value) {

		if(root == null)
			return false;
		if (value == root.key) {
			return true;
		}

		if (value < root.key)
			return searchNode(root.left, value);
		else
			return searchNode(root.right, value);
	}

	public boolean search(int value) {
		return searchNode(root, value);
	}

	public boolean isBSTRecursive(Node root, int min, int max) {
		// an empty tree is BST
		if (root == null)
			return true;

		// false if this node violates the min/max constraints
		if (root.key <= min || root.key >= max)
			return false;

		return (isBSTRecursive(root.left, min, root.key) && isBSTRecursive(
				root.right, root.key, max));
	}

	public boolean isBSTInOrder(Node root) {
		Stack<Node> stack = new Stack<Node>();
		double inorder = -Double.MAX_VALUE;

		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}

			root = stack.pop();
			// If next element in inorder traversal
			// is smaller than the previous one
			// that's not BST.
			if (root.key <= inorder)
				return false;
			inorder = root.key;

			root = root.right;
		}

		return true;
	}

	public boolean isBST() {
		return isBSTInOrder(root);
	}

	// Given a binary tree, print its nodes in preorder of Depth first order
	// search
	void printPreOrderWithNull(Node node) {
		if (node == null) {
			System.out.println("NULL");
			return;
		}

		// print the data of the node
		System.out.println(node.key);
		// recur on left child
		printPreOrderWithNull(node.left);
		// recur on right child
		printPreOrderWithNull(node.right);
	}

	public void printPreOrderWithNull() {
		printPreOrderWithNull(root);
	}

	public static void main(String[] args) {
		int[] a = { 50, 30, 70, 20, 40, 60, 80 };
		BinarySearchTree bst = new BinarySearchTree();
		for (int i = 0; i < a.length; i++) {
			bst.insert(a[i]);
		}

		bst.printPreOrderWithNull();

		// Found
		if (bst.search(40)) {
			System.out.println("Found it!");
		} else
			System.out.println("Not Found it!");

		// Not Found
		if (bst.search(41)) {
			System.out.println("Found it!");
		} else
			System.out.println("Not Found it!");

	}

}
