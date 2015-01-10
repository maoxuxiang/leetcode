package leetcode;

import java.util.ArrayList;

import javax.swing.tree.TreeNode;

/*Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.*/
public class SumRoottoLeafNumbers {
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
	    public int sumNumbers(TreeNode root) {
	        if (root == null) {
	            return 0;
	        }
	        ArrayList<String> res = new ArrayList<String>();
	        
	        StringBuffer sb = new StringBuffer();
	        helper (res, sb, root);
	        int sum = 0;
	        for (String s: res) {
	            int i = Integer.parseInt(s);
	            sum += i;
	        }
	        
	        return sum;
	    }
	    
	    private void helper(ArrayList<String> res, StringBuffer sb, TreeNode root) {
	        if (root == null) {
	            return;
	        }
	        
	        if (root.left == null && root.right == null) {
	            sb.append(root.val);
	            res.add(sb.toString());
	            sb.deleteCharAt(sb.length()-1);
	            return;
	        }
	        sb.append(root.val);
	        helper(res, sb, root.left);
	        helper(res, sb, root.right);
	        sb.deleteCharAt(sb.length()-1);
	    }
	}
}
