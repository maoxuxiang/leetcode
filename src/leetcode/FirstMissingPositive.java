package leetcode;
/*Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.*/
public class FirstMissingPositive {
	//http://www.cnblogs.com/AnnieKim/archive/2013/04/21/3034631.html
	public class Solution {
	    public int firstMissingPositive(int[] A) {
	        if (A == null || A.length == 0) {
	            return 1;
	        }
	        
	        int i = 0;
	        while (i<A.length) {
	            if (A[i] != i+1 && A[i]>=1 && A[i]<=A.length && A[i] != A[A[i]-1]) {
	                swap(A, i, A[i]-1);
	            }
	            else {
	                i++;
	            }
	        }
	        
	        for (int j=0; j<A.length; j++) {
	            if (A[j] != j+1) {
	                return j+1;
	            }
	        }
	        return A.length+1;
	    }
	    private void swap (int[] A, int i, int j) {
	        int tep = A[i];
	        A[i] = A[j];
	        A[j] = tep;
	    } 
	}
}
