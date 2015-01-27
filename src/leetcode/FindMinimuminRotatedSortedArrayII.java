package leetcode;
/*Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.*/
public class FindMinimuminRotatedSortedArrayII {
	public class Solution {
	    public int findMin(int[] num) {
	        int start = 0;
	        int end = num.length-1;
	        
	        while (start <= end) {
	            int mid = (start+end)/2;
	            
	            if (start == end) {
	                return num[start];
	            }
	            if (num[mid] < num[end]) {
	                end = mid;
	            }
	            else if (num[mid] > num[end]) {
	                start = mid+1;
	            }
	            else {
	                end = end-1;
	            }
	        }
	        return Integer.MIN_VALUE;
	    }
	}
}
