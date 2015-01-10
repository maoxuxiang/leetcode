package leetcode;
/*Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].*/
public class SearchForARange {
	public class Solution {
	    public int[] searchRange(int[] A, int target) {
	        int[] res = new int[2];
	        res[0] = -1;
	        res[1] = -1;
	        
	        if(A.length == 0 && A == null) {
	            return res;
	        }
	        
	        int ll = 0;
	        int lr = A.length-1;
	        
	        while (ll<=lr) {
	            int m1 = (ll+lr)/2;
	            if (A[m1] < target) {
	                ll = m1 + 1;
	            }
	            else {
	                lr = m1 - 1;
	            }
	        }
	        
	        int rl = 0;
	        int rr = A.length-1;
	        
	        while (rl<=rr) {
	            int m2 = (rl+rr)/2;
	            if (A[m2] <= target) {
	                rl = m2 + 1;
	            }
	            else {
	                rr = m2 -1;
	            }
	        }
	        if (ll <= rr) {
	            res[0] = ll;
	            res[1] = rr;
	        }

	        return res;
	    }
	}
}
