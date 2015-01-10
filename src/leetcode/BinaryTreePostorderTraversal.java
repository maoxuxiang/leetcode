package leetcode;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].*/
public class BinaryTreePostorderTraversal {
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	//recursive
	public class Solution {
	    public List<Integer> postorderTraversal(TreeNode root) {
	        List<Integer> res = new ArrayList<Integer>();
	        if (root == null) {
	            return res;
	        }
	        
	        helper (res, root);
	        return res;
	    }
	    
	    private void helper (List<Integer> res, TreeNode root) {
	        if (root == null) {
	            return;
	        }

	        helper (res, root.left);
	        helper (res, root.right);
	        res.add(root.val);
	    }
	}
	
	//iterative http://www.cnblogs.com/springfor/p/3877260.html
}
