package tree;

/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:
Given binary tree [3,9,20,null,null,15,7],
   3
 9  20
  15   7
return its depth is 3
*/

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class MaximumDepthOfBinaryTree {
	public static int maxDepth(TreeNode node){
		if(node == null)
			return 0;
		//The height for left subTree
		int lh = 0;
		//The height for right subTree
		int rh = 0;
		
		//return the max of height of left subTree and right subTree PLUS 1
		lh = maxDepth(node.left);
		rh = maxDepth(node.right);
		if(lh>rh)
		  return lh+1;
		else 		  
		  return rh+1;
		
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(3);
		System.out.println(maxDepth(root));
		
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(maxDepth(root));
	}

}
