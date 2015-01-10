package leetcode;
/*Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.*/
public class ReverseLinkedListII {
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
	    public ListNode reverseBetween(ListNode head, int m, int n) {
	        if (head == null || head.next == null) {
	            return head;
	        }
	        ListNode fakehead = new ListNode(0);
	        fakehead.next = head;

	        ListNode first = fakehead;
	        ListNode pre = head;
	        ListNode cur = pre.next;
	        ListNode next;
	    
	        for (int i=0; i<m-1; i++) {
	            first = first.next;
	            pre = pre.next;
	            cur = cur.next;
	        }

	        ListNode second = pre;
	        
	        int i = n-m;
	        
	        while (i > 0) {
	            next = cur.next;
	            cur.next = pre;
	            pre = cur;
	            cur = next;
	            i--;
	        }
	        first.next = pre;
	        second.next = cur;
	        
	        return fakehead.next;
	        
	    }
	}
}
