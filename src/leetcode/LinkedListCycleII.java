package leetcode;

import leetcode.AddTwoNumbers.Solution.ListNode;

/*Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?*/
public class LinkedListCycleII {
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
	    public ListNode detectCycle(ListNode head) {
	        if (head == null) {
	            return head;
	        }
	        ListNode slow = head;
	        ListNode fast = head;
	        while (fast != null && fast.next != null) {
	                slow = slow.next;
	                fast = fast.next.next;
	                if (slow == fast) {
	                    break;
	                }
	        }
	        
	        if (fast == null || fast.next == null) {
	            return null;
	        }
	        
	        while (head != slow) {
	            head = head.next;
	            slow = slow.next;
	        }
	        
	        return head;
	        
	    }
	}
	
}
