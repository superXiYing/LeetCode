package tree;

import java.util.LinkedList;
import java.util.Stack;


public class PlayGame {
	public static void main(String[] args){
		final String SEPERATOR = "-------------------------------";
		TreeNode root = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		root.left = n2;
		root.right = n3;
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n2.left = n4;
		n2.right = n5;
		
		printBFS(root);
		
		System.out.println(SEPERATOR);
		
		printDFSPreOrder_Stack(root);
		
		System.out.println(SEPERATOR);
		printDFSPostOrder_Stack(root);
		
	}
	
	public static void printBFS(TreeNode root){
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode current;
		
		if(root == null)
			return;
		queue.add(root);
		
		while(!queue.isEmpty()){
			current = queue.poll();
			System.out.println(current.val);
			
			if(current.left != null)
				queue.add(current.left);
			
			if(current.right != null)
				queue.add(current.right);
		}
	}
	
	public static void printDFSInOrder_Stack(TreeNode root){
		if(root == null)
			return;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;
		while(!stack.isEmpty() || current != null){
			while(current != null){
				 stack.push(current);
				 current = current.left;
				}
			
			current = stack.pop();
			System.out.println(current.val);
			
			current = current.right;
		}
		
		 
	}
	
	public static void printDFSPreOrder_Stack(TreeNode root){
		if(root == null)
			return;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			root = stack.pop();
			System.out.println(root.val);
			
			if(root.right != null)
				stack.push(root.right);
			if(root.left != null)
				stack.push(root.left);
		}
		
	}
		
		public static void printDFSPostOrder_Stack(TreeNode root){
			if(root == null)
				return;
			
			Stack<TreeNode> s1 = new Stack<TreeNode>();
			Stack<TreeNode> s2 = new Stack<TreeNode>();
			s1.push(root);
			while(!s1.isEmpty()){
				root = s1.pop();
				s2.push(root);
				if(root.left != null)
					s1.push(root.left);
				if(root.right != null)
					s1.push(root.right);
			}
			
			while(!s2.isEmpty()){
				root = s2.pop();
				System.out.println(root.val);
			}
		 
	}

}
