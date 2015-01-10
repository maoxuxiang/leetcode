package leetcode;

import leetcode.AddTwoNumbers.Solution.ListNode;

/*Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.*/
public class PartitionList {
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
	    public ListNode partition(ListNode head, int x) {
	        if (head == null || head.next == null) {
	            return head;
	        }
	        ListNode fakehead1 = new ListNode(0);
	        ListNode fakehead2 = new ListNode(0);
	        ListNode cur = head;
	        
	        ListNode l1 = fakehead1;
	        ListNode l2 = fakehead2;
	        
	        while (cur != null) {
	            if (cur.val < x) {
	                l1.next = cur;
	                l1 = l1.next;
	                cur = cur.next;
	            }
	            else {
	                l2.next = cur;
	                l2 = l2.next;
	                cur = cur.next;
	            }
	        }
	        
	        l2.next = null;
	        
	        l1.next = fakehead2.next;
	        return fakehead1.next;
	    }

	    
	}
}
