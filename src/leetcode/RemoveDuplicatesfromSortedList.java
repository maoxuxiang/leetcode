package leetcode;

import leetcode.AddTwoNumbers.Solution.ListNode;

/*Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.*/
public class RemoveDuplicatesfromSortedList {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 */
	public class Solution {
	    public ListNode deleteDuplicates(ListNode head) {
	        if (head == null || head.next == null) {
	            return head;
	        }
	        ListNode cur = head;
	        ListNode nxt = head.next;
	        
	        while (nxt != null) {
	            if (nxt.val == cur.val) {
	                nxt = nxt.next;
	            }
	            else {
	                cur.next = nxt;
	                cur = nxt;
	                nxt = nxt.next;
	            }
	        }
	        cur.next = null;
	        return head;
	        
	    }
	}
}
