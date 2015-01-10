package leetcode;
/*Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.*/
public class MaximumSubarray {
	public class Solution {
	    public int maxSubArray(int[] A) {
	        int sum = 0;
	        int max = A[0];
	        for (int i=0; i<A.length; i++) {
	            sum += A[i];
	            
	            if (sum > max) {
	                max = sum;
	            }
	            if (sum < 0) {
	                sum = 0;
	            }
	        }
	        return max;
	    }
	}
}
