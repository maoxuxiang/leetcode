package leetcode;

import leetcode.AddTwoNumbers.Solution.ListNode;

/*Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.*/
public class RemoveDuplicatesfromSortedListII {
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
	        ListNode fakehead = new ListNode(0);
	        fakehead.next = head;
	        
	        ListNode pre = fakehead;
	        ListNode cur = fakehead.next;
	        ListNode suc = fakehead.next.next;
	        
	        boolean flag = false;
	        while (suc != null) {
	            if (cur.val == suc.val) {
	                suc = suc.next;
	                flag = true;
	                if (suc == null) {
	                    pre.next = null;
	                }
	            }
	            else {
	                if (flag) {
	                    pre.next = suc;
	                    cur = suc;
	                    suc = suc.next;
	                    flag = false;
	                }
	                else {
	                    pre = pre.next;
	                    cur = cur.next;
	                    suc = suc.next;
	                }
	            }
	        }
	        
	        return fakehead.next;
	    }
	}
}
