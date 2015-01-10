package leetcode;
/*Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth 
of the two subtrees of every node never differ by more than 1.*/
public class BalancedBinaryTree {
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
	    public boolean isBalanced(TreeNode root) {
	        if (root == null) {
	          return true;  
	        }
	        
	        if (height(root) == -1) {
	            return false;
	        } 
	        else {
	            return true;
	        }
	    }
	    
	    public int height(TreeNode root) {
	        if (root == null) {
	            return 0;
	        }
	        
	        if (height(root.left) == -1) {
	            return -1;
	        }
	        int left = height(root.left);
	        
	        if (height(root.right) == -1) {
	            return -1;
	        }
	        
	        int right = height(root.right);
	        
	        int dif = Math.abs(left - right);
	        if (dif > 1) {
	            return -1;
	        }
	        else {
	            return Math.max(left,right)+1;
	        }
	    }
	}
}
