package leetcode;
/*Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.*/
public class MaximumSubarray {
	//http://www.programcreek.com/2013/02/leetcode-maximum-subarray-java/
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
	
	//dp
	public class Solution2 {
	    public int maxSubArray(int[] A) {
	        if (A == null || A.length == 0) {
	            return 0;
	        }
	        int[] sum = new int[A.length];
	        sum[0] = A[0];
	        int max = A[0];
	        for (int i=1; i<A.length; i++) {
	            sum[i] = Math.max(A[i], sum[i-1]+A[i]);
	            max = Math.max(sum[i], max);
	        }
	        return max;
	    }
	}
}
