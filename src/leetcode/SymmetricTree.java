package leetcode;

import java.util.LinkedList;

//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

public class SymmetricTree {
	
	 // Definition for binary tree
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	public class Solution {
	    public boolean isSymmetric(TreeNode root) {
	    
	       if (root == null) {
	           return true;
	       }
	       
	       return helper(root.left, root.right);
	    }
	    
	    private boolean helper(TreeNode r1, TreeNode r2) {
	        if (r1 == null && r2 == null) {
	            return true;
	        }
	        if (r1 == null || r2 == null) {
	            return false;
	        }
	        if (r1.val != r2.val) {
	            return false;
	        }
	        return helper(r1.left, r2.right) && helper(r1.right, r2.left);
	    }
	    
	}
	//solution 2:
	  public boolean isSymmetric(TreeNode root) {
	        if (root == null) {
	            return true;
	        }
	        if (root.left == null && root.right == null) {
	            return true;
	        }
	        if (root.left == null || root.right == null) {
	            return false;
	        }
	        
	        LinkedList<TreeNode> l1 = new LinkedList<TreeNode>();
	        LinkedList<TreeNode> l2 = new LinkedList<TreeNode>();
	        
	        l1.add(root.left);
	        l2.add(root.right);
	        
	        while (!l1.isEmpty() && !l2.isEmpty()) {
	            TreeNode n1 = l1.poll();
	            TreeNode n2 = l2.poll();
	            
	            if (n1.val != n2.val) {
	                return false;
	            }
	            if (n1.left != null && n2.right == null || n1.left == null && n2.right != null) {
	                return false;
	            }
	            if (n1.right != null && n2.left == null || n1.right == null && n2.left != null) {
	                return false;
	            }
	            if (n1.left != null && n2.right != null) {
	                l1.add(n1.left);
	                l2.add(n2.right);
	            }
	            if (n1.right != null && n2.left != null) {
	                l1.add(n1.right);
	                l2.add(n2.left);
	            }
	            
	        }
	        return true;
	    }
}
