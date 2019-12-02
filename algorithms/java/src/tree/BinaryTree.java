package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
	public int key;
	public Node left, right;

	public Node(int key) {
		this.key = key;
		left = right = null;
	}
}

class BinaryTree {
	// root of BinaryTree
	Node root;

	BinaryTree() {
		root = null;
	}

	// Compute the "height" of a tree -- the number of nodes along the longest
	// path from the root node down to the farthest leaf node
	int height(Node root) {
		if (root == null)
			return 0;
		else {
			int lh = height(root.left);
			int rh = height(root.right);

			if (lh > rh) {
				return lh + 1;
			} else
				return rh + 1;
		}

	}

	void printGivenLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.println(root.key);
		else {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	// Given a binary tree, print its node in breadth first order using level by level manner
	public void printBFS() {
		int height = height(root);
		for (int i = 1; i <= height; i++) {
			printGivenLevel(root, i);
		}
	}

	void printLevelOrder(Node node) {
		Queue<Node> queue = new LinkedList<Node>();
		
		
		queue.add(node);
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			System.out.println(current.key);

			if (current.left != null)
				queue.add(current.left);
			if (current.right != null)
				queue.add(current.right);
		}
	}

	// Given a binary tree, print its node in breadth first order using Queue
	public void printBFS_Queue() {
		printLevelOrder(root);
	}

	private void printDFSPreOrder_Stack(Node root) {
		if (root == null)
			return;

		Stack<Node> stack = new Stack<Node>();
		stack.push(root);

		while (!stack.isEmpty()) {
			root = stack.pop();
			System.out.println(root.key);

			if (root.right != null)
				stack.push(root.right);
			if (root.left != null)
				stack.push(root.left);
		}

	}

	private void printDFSPostOrder_Stack(Node root) {
		if (root == null)
			return;

		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		s1.push(root);
		while (!s1.isEmpty()) {
			root = s1.pop();
			s2.push(root);
			if (root.left != null)
				s1.push(root.left);
			if (root.right != null)
				s1.push(root.right);
		}

		while (!s2.isEmpty()) {
			root = s2.pop();
			System.out.println(root.key);
		}

	}

	private void printDFSInOrder_Stack(Node node) {
		Stack<Node> stack = new Stack<Node>();

		while (!stack.isEmpty() || node != null) {
			// Reach the left most Node of the current Node
			while (node != null) {
				stack.push(node);
				node = node.left;
			}

			node = stack.pop();
			System.out.println(node.key);

			node = node.right;
		}

	}

	// Given a binary tree, print its nodes in DFS(post order) using
	// non-recursion
	// method
	public void printDFSPostOrder_Stack() {
		printDFSPostOrder_Stack(root);
	}

	// Given a binary tree, print its nodes in DFS(preorder) using non-recursion
	// method
	public void printDFSPreOrder_Stack() {
		printDFSPreOrder_Stack(root);
	}

	// Given a binary tree, print its nodes in DFS(inorder) using non-recursion
	// method
	public void printDFSInOrder_Stack() {
		printDFSInOrder_Stack(root);
	}

	// Given a binary tree, print its nodes in inorder
	void printInOrder(Node node) {
		if (node == null)
			return;

		// first recur on left child
		printInOrder(node.left);
		// then print the data of the node
		System.out.println(node.key);
		// at last recur on right child
		printInOrder(node.right);
	}

	// Given a binary tree, print its nodes in preorder of Depth first order
	// search
	void printPreOrder(Node node) {
		if (node == null)
			return;

		// print the data of the node
		System.out.println(node.key);
		// recur on left child
		printPreOrder(node.left);
		// recur on right child
		printPreOrder(node.right);
	}

	// Given a binary tree, print its nodes in postorder of Depth first order
	// search
	void printPostOrder(Node node) {
		if (node == null)
			return;

		// recur on left child
		printPostOrder(node.left);
		// recur on right child
		printPostOrder(node.right);
		// print the data of the node
		System.out.println(node.key);
	}

	// wrappers over above recursive function of Depth first order search
	public void printInOrder() {

		printInOrder(root);
	}

	// wrappers over above recursive function
	public void printPreOrder() {

		printPreOrder(root);
	}

	// wrappers over above recursive function
	public void printPostOrder() {

		printPostOrder(root);
	}

	// Driver method
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		// 4,2,5,1,3
		System.out.println("Traverse the tree in the InOrder:");
		tree.printInOrder();

		// 1,2,4,5,3
		System.out.println("Traverse the tree in the PreOrder:");
		tree.printPreOrder();

		// 4,5,2,3,1
		System.out.println("Traverse the tree in the PostOrder:");
		tree.printPostOrder();

		// 1,2,3,4,5
		System.out.println("Traverse the tree in the breadthOrder");
		tree.printBFS();

		// 4,2,5,1,3
		System.out
				.println("Traverse the tree in DFS(inorder) using non-recursion method");
		tree.printDFSInOrder_Stack();
	}

}
