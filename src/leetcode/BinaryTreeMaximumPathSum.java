package leetcode;

import javax.swing.tree.TreeNode;

/*Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.*/
public class BinaryTreeMaximumPathSum {
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public class Solution {
	    public int maxPathSum(TreeNode root) {
	        
	        if (root == null) {
	            return 0;
	        }
	        // java 里面数组是引用类型，所用数组这里。
	        int[] res = new int[1];
	        res[0] = Integer.MIN_VALUE;
	        helper (res, root);
	        return res[0];
	    }
	    
	    private int helper(int[] res, TreeNode root) {
	        if (root == null) {
	            return 0;
	        }
	        
	        int left = helper(res, root.left);
	        int right = helper(res, root.right);
	        
	        int update1 = Math.max(root.val, Math.max(root.val+left, root.val+right));
	        res[0] = Math.max(res[0],Math.max(update1,root.val+left+right));
	        
	        return update1;
	    }
	}
	
}
