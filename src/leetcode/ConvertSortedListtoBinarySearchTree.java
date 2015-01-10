package leetcode;

import javax.swing.tree.TreeNode;

import leetcode.AddTwoNumbers.Solution.ListNode;

//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
public class ConvertSortedListtoBinarySearchTree {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; next = null; }
	 * }
	 */
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
	    public TreeNode sortedListToBST(ListNode head) {
	        if (head == null) {
	            return null;
	        }
	        if (head.next == null) {
	            return new TreeNode(head.val);
	        }
	        ListNode slow = head;
	        ListNode fast = head.next;
	        while (fast.next != null && fast.next.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        ListNode behind = slow.next;
	        slow.next = null;
	        ListNode before = head;
	        
	        TreeNode root = new TreeNode(behind.val);
	        root.left = sortedListToBST(before);
	        root.right = sortedListToBST(behind.next);
	        
	        return root;
	    }
	}
}
