package leetcode;
/*Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.*/
public class SearchinRotatedSortedArrayII {
	public class Solution {
	    public boolean search(int[] A, int target) {
	        if (A.length == 0 || A == null) {
	            return false;
	        }
	        
	        int start = 0;
	        int end = A.length - 1;
	        
	        while (start <= end) {
	            int mid = (start+end)/2;
	            if (target == A[mid]) {
	                return true;
	            }
	            
	            if (A[mid] == A[start]) {
	                start ++;
	            }
	            
	            else if (A[mid] > A[start]) {
	                if (target < A[mid] && target >= A[start]) {
	                    end = mid -1;
	                }
	                else {
	                    start = mid+1;
	                }
	            }
	            
	            else if (A[mid] < A[start]) {
	                if (target > A[mid] && target <= A[end]) {
	                    start = mid +1;
	                }
	                else {
	                    end = mid -1;
	                }
	            }
	        }
	        
	        return false;
	    }
	}
}
