package leetcode;

import java.util.List;
//我们来分析一下上述算法的时间复杂度。假设总共有k个list，每个list的最大长度是n，
//那么运行时间满足递推式T(k) = 2T(k/2)+O(n*k)。根据主定理，可以算出算法的总复杂度是O(nklogk)。
public class MergekSortedLists {
	
	//  Definition for singly-linked list.
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	 
	public class Solution {
	    public ListNode mergeKLists(List<ListNode> lists) {
	        if (lists == null || lists.size() == 0) {
	            return null;
	        }
	        
	        return mergeKListsHelper(lists, 0, lists.size()-1);
	    }
	    
	    private ListNode mergeKListsHelper(List<ListNode> lists, int start, int end) {
	        int mid = (start + end)/2;
	        
	        while (start < end) {
	            return merge(mergeKListsHelper(lists, start, mid),mergeKListsHelper(lists, mid+1, end));
	        }
	        return lists.get(start);
	    }
	    
	    private ListNode merge(ListNode l1, ListNode l2) {
	        ListNode fakehead = new ListNode(0);
	        ListNode l3 = fakehead;
	        
	        while (l1 != null && l2 != null) {
	            if (l1.val < l2.val) {
	                l3.next = l1;
	                l3 = l3.next;
	                l1 = l1.next;
	            }
	            else {
	                l3.next = l2;
	                l3 = l3.next;
	                l2 = l2.next;
	            }
	        }
	        if (l1 != null) {
	            l3.next = l1;
	        }
	        if (l2 != null) {
	            l3.next = l2;
	        }
	        return fakehead.next;
	    }
	}
}
