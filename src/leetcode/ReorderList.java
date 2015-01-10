package leetcode;

import leetcode.AddTwoNumbers.Solution.ListNode;

/*Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.*/
public class ReorderList {
	/**
	 * Definition for singly-linked list.
	 * class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 */
	public class Solution {
	    public void reorderList(ListNode head) {
	        if (head == null || head.next == null) {
	            return;
	        }
	        ListNode slow = head;
	        ListNode fast = head;
	        while (fast.next != null && fast.next.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        ListNode firsthalf = head;
	        ListNode secondhalf = slow.next;
	        slow.next = null;
	        secondhalf = reverse(secondhalf);
	        
	        while (firsthalf != null && secondhalf != null) {
	            ListNode fnext = firsthalf.next;
	            ListNode snext = secondhalf.next;
	            firsthalf.next = secondhalf;
	            firsthalf = fnext;
	            secondhalf.next = firsthalf;
	            secondhalf = snext;
	        }

	    }
	    
	    private ListNode reverse(ListNode head) {
	        if (head == null || head.next == null) {
	            return head;
	        }
	        ListNode fakehead = new ListNode(0);
	        ListNode pre = fakehead;
	        ListNode cur = head;
	        ListNode nxt;
	        
	        while (cur != null) {
	            nxt = cur.next;
	            cur.next = pre;
	            pre = cur;
	            cur = nxt;
	        }
	        head.next = null;
	        return pre;
	    }
	}
}
