package leetcode;
/*Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].*/
public class RemoveDuplicatesfromSortedArray {
	public class Solution {
	    public int removeDuplicates(int[] A) {
	        if (A == null || A.length == 0) {
	            return 0;
	        }
	        if (A.length == 1) {
	            return 1;
	        }
	        
	        int pre = 0;
	        int cur = 1;
	        
	        while (cur < A.length) {
	            if (A[pre] == A[cur]) {
	                cur++;
	            }
	            else {
	                pre++;
	                A[pre] = A[cur];
	                cur++;
	            }
	        }
	        
	        return pre+1;
	    }
	}
}
