package leetcode;
/*Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest 
path from the root node down to the farthest leaf node.*/
public class MaximumDepthofBinaryTree {
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	
	// http://www.cnblogs.com/springfor/p/3879619.html 非递归

	public class Solution {
	    public int maxDepth(TreeNode root) {
	        if (root == null) {
	            return 0;
	        }
	        
	        int maxleft = maxDepth(root.left);
	        int maxright = maxDepth(root.right);
	        
	        return Math.max(maxleft, maxright) + 1;
	    }
	}
}
