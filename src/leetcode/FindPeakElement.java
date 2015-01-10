package leetcode;
/*A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.*/
public class FindPeakElement {
	public class Solution1 {
	    public int findPeakElement(int[] num) {
	        if (num.length == 1) {
	            return 0;
	        }
	        for (int i=1; i<num.length-1; i++) {
	            if (num[i] > num[i-1] && num[i]>num[i+1]) {
	                return i;
	            }
	        }
	        
	        if (num[0]>num[1]) {
	            return 0;
	        }
	        if (num[num.length-1]>num[num.length-2]) {
	            return num.length-1;
	        }
	        
	        return -1;
	    }
	}
	
	//solution2 log(n)
	/*如果中间元素大于其相邻后续元素，则中间元素左侧(包含该中间元素）必包含一个局部最大值。
			如果中间元素小于其相邻后续元素，则中间元素右侧必包含一个局部最大值。*/
	public class Solution {
	    public int findPeakElement(int[] num) {
	        if (num.length == 1) {
	            return 0;
	        }
	        
	        if (num[0]>num[1]) {
		       return 0;
		    }
		    if (num[num.length-1]>num[num.length-2]) {
		       return num.length-1;
		    }
	        
	        return find(num, 0, num.length-1);
	    }
	    private int find (int[] num, int start, int end) {
	        while (start<=end) {
	            int mid = (start+end)/2;
	            
	            if (start == end) {
	                return start;
	            }
	            
	            if (num[mid] > num[mid+1]) {
	                end = mid;
	            }
	            
	            else {
	                start = mid+1;
	            }
	            
	        }
	        return -1;
	    }
	}
}
