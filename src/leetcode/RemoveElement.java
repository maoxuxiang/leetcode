package leetcode;
/*Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/public class RemoveElement {
	
	public class Solution {
	    public int removeElement(int[] A, int elem) {
	        int len = A.length;
	        if (len < 1) {
	            return len;
	        }
	        
	        if (len == 1) {
	            if (A[0] == elem) {
	                return 0;
	            }
	            return 1;
	        }
	        
	        int i = 0;
	        int j = 0;
	        
	        while (j < len) {
	            if (A[j] != elem) {
	                A[i] = A[j];
	                i++;
	            }
	            j++;
	        }
	        
	        return i;
	        
	    }
	}
}
