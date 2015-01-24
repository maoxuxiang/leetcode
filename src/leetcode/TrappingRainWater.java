package leetcode;
/*Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.*/


public class TrappingRainWater {
	//http://www.cnblogs.com/springfor/p/3877101.html
	public class Solution {
	    public int trap(int[] A) {
	        if (A == null || A.length == 0) {
	            return 0;
	        }
	        
	        int[] left = new int[A.length];
	        int[] right = new int[A.length];
	        
	        left[0] = A[0];
	        int max = A[0];
	        for (int i=1; i<A.length; i++) {
	            left[i] = Math.max(max, A[i]);
	            max = Math.max(max, A[i]);
	        }
	        
	        right[A.length-1] = A[A.length-1];
	        max = A[A.length-1];
	        for (int i=A.length-2; i>=0; i--) {
	            right[i] = Math.max(max, A[i]);
	            max = Math.max(max, A[i]);
	        }
	        
	        int res = 0;
	        for (int i=1; i<A.length-1; i++) {
	            int bit = Math.min(left[i],right[i]) - A[i];
	            if (bit > 0) {
	                res += bit;
	            }
	        }
	        return res;
	    }
	}
}
