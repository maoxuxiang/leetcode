package leetcode;

import leetcode.AddTwoNumbers.Solution.ListNode;

/*Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.*/
public class IntersectionofTwoLinkedLists {
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
	    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        int lenA = len(headA);
	        int lenB = len(headB);
	        int diff = Math.abs(lenA-lenB);
	        
	        while (lenA > lenB && diff > 0) {
	            headA = headA.next;
	            diff --;
	        }
	        
	        while (lenA < lenB && diff > 0) {
	            headB = headB.next;
	            diff --;
	        }
	        
	        while (headA != null && headB != null) {
	            if (headA == headB) {
	                return headA;
	            }
	            headA = headA.next;
	            headB = headB.next;
	        }
	        
	        return null;
	    }
	    
	    private int len(ListNode head) {
	        if (head == null) {
	            return 0;
	        }
	        int len = 0;
	        while (head != null) {
	            head = head.next;
	            len++;
	        }
	        return len;
	    }
	     
	    
	}
	
	//solution2
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
	    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        if (headA == null || headB == null) {
	            return null;
	        }
	        ListNode a = headA;
	        ListNode b = headB;
	        while (a != null && b != null) {
	            a = a.next;
	            b = b.next;
	        }
	        
	        if (a == null) {
	            a = headB;
	            while (b != null) {
	                b = b.next;
	                a = a.next;
	            }
	            while (a != null && headA != null) {
	                if (a == headA) {
	                    return a;
	                }
	                a = a.next;
	                headA = headA.next;
	            }
	        }
	        
	        if (b == null) {
	            b = headA;
	            while (a != null) {
	                b = b.next;
	                a = a.next;
	            }
	            while (b != null && headB != null) {
	                if (b == headB) {
	                    return b;
	                }
	                b = b.next;
	                headB = headB.next;
	            }
	        }
	        
	        return null;
	    }
	}
}
