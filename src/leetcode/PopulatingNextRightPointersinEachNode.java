package leetcode;
/*Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.*/
public class PopulatingNextRightPointersinEachNode {
	/**
	 * Definition for binary tree with next pointer.
	 * public class TreeLinkNode {
	 *     int val;
	 *     TreeLinkNode left, right, next;
	 *     TreeLinkNode(int x) { val = x; }
	 * }
	 */
	public class Solution {
	    public void connect(TreeLinkNode root) {
	        if (root == null) {
	            return;
	        }
	        
	        if (root.left != null && root.right != null) {
	            root.left.next = root.right;
	            if (root.next != null) {
	                root.right.next = root.next.left;
	            }
	        
	            if (root.next == null) {
	                root.right.next = null;
	            }
	        }

	        connect(root.left);
	        connect(root.right);
	    }
	}
}
