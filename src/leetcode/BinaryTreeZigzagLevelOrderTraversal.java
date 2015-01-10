package leetcode;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]*/
public class BinaryTreeZigzagLevelOrderTraversal {
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
	    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if (root == null) {
	            return res;
	        }
	        
	        zigzagLevelOrder(root, 0, res);
	        return res;
	    }
	    
	    private void zigzagLevelOrder(TreeNode root, int start, List<List<Integer>> res) {
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
	        
	        if (start%2 == 0) {
	            item.add(root.val);
	        }
	        else {
	            item.add(0, root.val);
	        }
	        zigzagLevelOrder (root.left, start+1, res);
	        zigzagLevelOrder (root.right, start+1, res);
	    }
	}
}
