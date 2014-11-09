package leetcode;
/*Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5*/
public class ReverseNodesinkGroup {
	
	 // Definition for singly-linked list.
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	 
	public class Solution {
	    public ListNode reverseKGroup(ListNode head, int k) {
	        if(head == null || k == 1) {
	            return head;
	        }
	        ListNode dummy = new ListNode(-1);
	        dummy.next = head;
	        ListNode pre = dummy;
	        int i=0;
	        
	        while (head != null) {
	            i++;
	            if (i % k == 0) {
	                pre = reverse(pre, head.next);
	                head = pre.next;
	            }
	            else {
	                head = head.next;
	            }
	        }
	        return dummy.next;
	    }
	    
	    private ListNode reverse(ListNode fakehead, ListNode des) {
	        
	        ListNode pre = fakehead.next;
	        ListNode cur = fakehead.next.next;
	        ListNode next;
	        
	        while (cur != des) {
	            next = cur.next;
	            cur.next = pre;
	            pre = cur;
	            cur = next;
	        }
	        
	        fakehead.next.next = des;
	        ListNode tmp = fakehead.next;
	        fakehead.next = pre;
	        
	        return tmp;
	    }
	}
}
