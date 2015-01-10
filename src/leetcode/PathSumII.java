package leetcode;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]*/
public class PathSumII {
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
	    public List<List<Integer>> pathSum(TreeNode root, int sum) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if (root == null) {
	            return res;
	        }
	        
	        List<Integer> item = new ArrayList<Integer>();
	        int num = 0;
	        helper (root, res, sum, item, num);
	        return res;
	    }
	    
	    private void helper (TreeNode root, List<List<Integer>> res, int sum, List<Integer> item, int num) {
	        if (root == null) {
	            return;
	        }
	        
	        if (root.left == null && root.right == null) {
	            num += root.val;
	            if (num == sum) {
	                item.add(root.val);
	                res.add(new ArrayList<Integer>(item));
	                item.remove(item.size()-1);
	            }
	            return;
	        }
	        
	        num += root.val;
	        item.add(root.val);
	        helper(root.left, res, sum, item, num);
	        helper(root.right, res, sum, item, num);
	        item.remove(item.size()-1);
	    }
	}
}
