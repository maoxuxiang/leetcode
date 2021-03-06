package leetcode;
/*You are given two linked lists representing two non-negative numbers. 
 The digits are stored in reverse order and each of their nodes contain a single digit.
 Add the two numbers and return it as a linked list.*/
//
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
public class AddTwoNumbers {
	
	public class Solution {
		
		 public class ListNode {
			     int val;
			     ListNode next;
			     ListNode(int x) {
			         val = x;
			         next = null;
			     }
			 }
	    
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        return addTwoNumbers(l1, l2, 0);
	    }
	    
	    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
	        if (l1 == null && l2 == null && carry == 0) {
	            return null;
	        }
	        
	        int value = carry;
	        if (l1 != null) {
	            value += l1.val;
	        }
	        
	        if (l2 != null) {
	            value += l2.val;
	        }
	        
	        ListNode res = new ListNode(0);
	        res.val = value % 10;
	        
	        if (l1 != null || l2 != null) {
	            ListNode more = addTwoNumbers(l1 !=null? l1.next: null, l2 !=null? l2.next: null, value>=10?1:0);
	            res.next = more;
	        }
	        
	        return res;
	    }
	}
}
