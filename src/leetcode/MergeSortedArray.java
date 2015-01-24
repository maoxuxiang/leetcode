package leetcode;
/*Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. 
The number of elements initialized in A and B are m and n respectively.*/
public class MergeSortedArray {
	public class Solution {
	    public void merge(int A[], int m, int B[], int n) {
	        if (n == 0) {
	            return;
	        }
	        int total = m+n-1;
	        int a = m-1;
	        int b = n-1;
	        
	        while (total >=0) {
	            if (a >=0 && b>=0 && A[a] > B[b]) {
	                A[total] = A[a];
	                a --;
	                
	            }
	            else if (a < 0 || (a >=0 && b>=0 && A[a] <= B[b])) {
	                A[total] = B[b];
	                b--;

	            }
	            total --;
	        }
	    }
	}
	
	//solution2
	public class Solution2 {
	    public void merge(int A[], int m, int B[], int n) {
	        if (n == 0) {
	            return;
	        }
	        int i = m-1;
	        int j = n-1;
	        int total = m+n-1;
	        
	        while (j>=0) {
	            if (i>=0 && A[i] > B[j]) {
	                A[total] = A[i];
	                i--;
	            }
	            else if (i>=0 && A[i]<=B[j]) {
	                A[total] = B[j];
	                j--;
	            }
	            else {
	                A[total] = B[j];
	                j--;
	            }
	            total--;
	        }
	    }
	}
}
