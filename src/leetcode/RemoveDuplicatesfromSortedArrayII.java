package leetcode;
/*Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].*/
public class RemoveDuplicatesfromSortedArrayII {
	public class Solution {
	    public int removeDuplicates(int[] A) {
	        if (A.length <=2) {
	            return A.length;
	        }
	        
	        int pre = 1;
	        int cur = 2;
	        
	        while (cur < A.length) {
	            if (A[pre] == A[cur] && A[cur] == A[pre-1]) {
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
