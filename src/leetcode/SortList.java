package leetcode;

import leetcode.AddTwoNumbers.Solution.ListNode;

//Sort a linked list in O(n log n) time using constant space complexity.
public class SortList {
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
	    public ListNode sortList(ListNode head) {
	        if (head == null || head.next == null) {
	            return head;
	        }
	        ListNode fast = head;
	        ListNode slow = head;
	        while (fast.next != null && fast.next.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        ListNode lefthalf = head;
	        ListNode righthalf = slow.next;
	        slow.next = null;
	        
	        lefthalf = sortList(lefthalf);
	        righthalf = sortList(righthalf);
	        return merge(lefthalf, righthalf);
	    }
	    
	    private ListNode merge(ListNode lefthalf, ListNode righthalf) {
	        if (lefthalf == null) {
	            return righthalf;
	        }
	        if (righthalf == null) {
	            return lefthalf;
	        }
	        ListNode fakehead = new ListNode(0);
	        ListNode l = fakehead;
	        while (lefthalf != null && righthalf != null) {
	            if (lefthalf.val<=righthalf.val) {
	                l.next = lefthalf;
	                l = l.next;
	                lefthalf = lefthalf.next;
	            }
	            else {
	                l.next = righthalf;
	                l = l.next;
	                righthalf = righthalf.next;
	            }
	        }
	        
	        if (lefthalf != null) {
	            l.next = lefthalf;
	        }
	        
	        if (righthalf != null) {
	            l.next = righthalf;
	        }
	        
	        return fakehead.next;

	    }

	}
}
