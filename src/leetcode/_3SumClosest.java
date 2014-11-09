package leetcode;

import java.util.Arrays;

/*Given an array S of n integers, find three integers in S such that the sum is closest to a given number, 
 * target. Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).*/

public class _3SumClosest {
	public class Solution {
	    public int threeSumClosest(int[] num, int target) {
	        if (num == null || num.length < 3) {
	            return Integer.MIN_VALUE;
	        }
	        
	        Arrays.sort(num);
	        int closest = num[0] + num[1] + num[2] -target;
	        for (int i = num.length -1; i>=2; --i) {
	            int curclosest = twoSumClosest(num, target - num[i], i-1);
	            if (Math.abs(curclosest) < Math.abs(closest)) {
	                closest = curclosest;
	            }
	        }
	        
	        return closest + target;
	    }
	    
	    private int twoSumClosest(int[] num, int target, int end) {
	        
	        if (num == null || num.length<2) {
	            return Integer.MIN_VALUE;
	        }
	        
	        int closest = num[0] + num[1] -target;
	        int l = 0;
	        int r = end;
	        int tmp;
	        
	        while (l<r) {

	            if (num[l] + num[r] == target) {
	                return 0;
	            }
	            else if (num[l] + num[r] < target) {
	                tmp = num[l] + num[r] -target;
	                if (Math.abs(tmp) < Math.abs(closest)) {
	                    closest = tmp;
	                }
	                l++;
	            }
	            else {
	                tmp = num[l] + num[r] -target;
	                if (Math.abs(tmp) < Math.abs(closest)) {
	                    closest = tmp;
	                }
	                r--;
	            }
	            
	        }
	        
	        return closest;
	    }
	}
}
