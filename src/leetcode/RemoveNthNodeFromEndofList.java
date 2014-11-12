package leetcode;

/*Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.*/

public class RemoveNthNodeFromEndofList {
	/**
	 * Definition for singly-linked list. */
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	 
	public class Solution {
	    public ListNode removeNthFromEnd(ListNode head, int n) {
	        if (head == null) {
	            return null;
	        }
	        ListNode pre = head;
	        ListNode late = head;
	        if (n == 1) {
	            late = late.next;
	            
	            if (late == null) {
	                return null;
	            }
	            while (late.next != null) {
	                late = late.next;
	                pre = pre.next;
	            }
	            pre.next = null;
	            return head;
	        }
	        else {
	            for (int i = 1; i<n; ++i) {
	            late = late.next;
	            }
	            
	            while (late.next != null) {
	                late = late.next;
	                pre = pre.next;
	            }
	            pre.val = pre.next.val;
	            pre.next = pre.next.next;
	            return head;
	        }
	        
	        
	    }
	}
}
