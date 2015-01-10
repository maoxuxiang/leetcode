package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].*/
public class BinaryTreePreorderTraversal {
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
	    public List<Integer> preorderTraversal(TreeNode root) {
	        List<Integer> res = new ArrayList<Integer>();
	        if (root == null) {
	            return res;
	        }
	        
	        helper (res, root);
	        return res;
	    }
	    
	    private void helper (List<Integer> res, TreeNode root) {
	        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
	        while (!stack.isEmpty() || root !=null) {
	            if (root != null) {
	                res.add(root.val);
	                stack.push(root);
	                root = root.left;
	            }
	            else {
	                root = stack.pop();
	                root = root.right;
	            }
	        }
	    }
	}
}
