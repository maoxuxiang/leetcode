package leetcode;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]*/
public class BinaryTreeLevelOrderTraversal {
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
	    public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if (root == null) {
	            return res;
	        }
	        
	        helper (res, root, 0);
	        return res;
	    }
	    
	    private void helper (List<List<Integer>> res, TreeNode root, int start) {
	        if (root == null) {
	            return;
	        }
	        List<Integer> item = null;
	        if (res.size() == start) {
	            item = new ArrayList<Integer>();
	            res.add(item);
	        }
	        else {
	            item = res.get(start);
	        }
	        item.add(root.val);
	        
	        helper(res, root.left, start+1);
	        helper(res, root.right, start+1);
	    }
	}
	
}
