package leetcode;
/*Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.*/
public class FindMinimuminRotatedSortedArray {
	public class Solution {
	    public int findMin(int[] num) {
	        return bs(num, 0, num.length-1);
	    }
	    
	    private int bs(int[] num, int start, int end) {
	        while (start<=end) {
	            if (start == end) {
	                return num[start];
	            }
	            
	            int mid = (start+end)/2;
	            if (num[mid] < num[end]) {
	                end = mid;
	            }
	            else {
	                start = mid+1;
	            }
	        }
	        return Integer.MIN_VALUE;
	    }
	}
}
