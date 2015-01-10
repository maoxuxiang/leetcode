package leetcode;
/*Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along 
the shortest path from the root node down to the nearest leaf node.*/
public class MinimumDepthofBinaryTree {
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	
	//非递归  http://www.cnblogs.com/springfor/p/3879680.html
	public class Solution {
	    public int minDepth(TreeNode root) {
	        if (root == null) {
	            return 0;
	        }
	        
	        int minleft = minDepth(root.left);
	        int minright = minDepth(root.right);
	        
	        if (minleft == 0 || minright == 0) {
	            return minleft>=minright?minleft+1:minright+1;
	        }
	        
	        return Math.min(minleft,minright)+1;
	    }
	}
}
