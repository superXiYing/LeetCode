package tree;

import java.util.Stack;

/*Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 2
/ \
1 3
input: 2, 1,3
output: true

	5
   / \
  1   4
     / \
    3	6
 input: [5,1,4,null, null, 3, 6]   
 output: false;

*/
public class ValidateBinarySearchTree {
	
	public static boolean isValidBST(TreeNode root){
		Stack<TreeNode> s = new Stack<TreeNode>();
		double saved = -Double.MAX_VALUE;
		
		if(root == null)
			return false;
		while(!s.isEmpty() || root != null){
			while(root != null){
				s.push(root);
				root = root.left;
			}
			
			root = s.pop();
			
			 // If next element in inorder traversal
		      // is smaller than the previous one
		      // that's not BST.
			if(root.val <= saved)
				return false;
			saved = root.val;
			
			root = root.right;		
		}
	   return true;
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(5);
		TreeNode n1 = new TreeNode(1);
		TreeNode n4 = new TreeNode(4);
		TreeNode n3 = new TreeNode(3);
		TreeNode n6 = new TreeNode(6);
		
		root.left = n1;
		root.right = n4;
		n4.left = n3;
		n4.right = n6;
		
		System.out.println(isValidBST(root));
	}

}
