package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?*/
public class BinaryTreeInorderTraversal {
//recursive 
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
	    public List<Integer> inorderTraversal(TreeNode root) {
	        List<Integer> res = new ArrayList<Integer>();
	        if (root == null) {
	            return res;
	        }
	        
	        helper (root, res);
	        return res;
	    }
	    
	    private void helper(TreeNode root, List<Integer> res) {
	        if (root == null) {
	            return;
	        }
	        
	        helper(root.left, res);
	        res.add(root.val);
	        helper(root.right, res);
	    }
	}
	
	//iteratively
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public class Solution2 {
	    public List<Integer> inorderTraversal(TreeNode root) {
	        List<Integer> res = new ArrayList<Integer>();
	        if (root == null) {
	            return res;
	        }
	        helper (res, root);
	        return res;
	    }
	    
	    private void helper (List<Integer> res, TreeNode root) {
	        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
	        while (!stack.isEmpty() || root != null) {
	            if (root != null) {
	                stack.push(root);
	                root = root.left;
	            }
	            else {
	                root = stack.pop();
	                res.add(root.val);
	                root = root.right;
	            }
	        }
	            
	    }
	}

}
