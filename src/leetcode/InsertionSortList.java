package leetcode;

import leetcode.AddTwoNumbers.Solution.ListNode;

//Sort a linked list using insertion sort.
public class InsertionSortList {
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
	    public ListNode insertionSortList(ListNode head) {
	        if (head == null || head.next == null) {
	            return head;
	        }
	        ListNode fakehead = new ListNode(0);
	        
	        ListNode cur = head;
	        ListNode nxt;
	        
	        while (cur != null) {
	            nxt = cur.next;
	            ListNode pre = fakehead;
	            while (pre.next != null && pre.next.val < cur.val) {
	                pre = pre.next;
	            }
	            cur.next = pre.next;
	            pre.next = cur;
	            cur = nxt;
	        }
	        return fakehead.next;
	    }
	}
}
