package leetcode;

import leetcode.AddTwoNumbers.Solution.ListNode;

/*Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.*/
public class RotateList {
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
	    public ListNode rotateRight(ListNode head, int n) {
	        if(head == null) {
	            return null;
	        }
	        ListNode pre = head;
	        ListNode nxt = head;
	        ListNode count = head;
	        int length = 0;
	        
	        // 注意的点就是旋转的结点数可能超过链表长度，所以我们要对这个进行取余。
	        while (count != null) {
	            count = count.next;
	            length++;
	        }
	        n = n % length;
	        
	        for (int i=0; i<n; i++) {
	            nxt = nxt.next;
	        }
	        
	        while (nxt.next != null) {
	            pre = pre.next;
	            nxt = nxt.next;
	        }
	        nxt.next = head;
	        head = pre.next;
	        pre.next = null;
	        
	        return head;
	    }
	}
}
