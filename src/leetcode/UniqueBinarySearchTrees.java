package leetcode;
/*Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3*/
public class UniqueBinarySearchTrees {
	
	//http://www.cnblogs.com/springfor/p/3884009.html
	public class Solution {
	    public int numTrees(int n) {
	        if (n == 0 || n == 1) {
	            return 1;
	        }
	        
	        int[] count = new int[n+1];
	        count[0] = 1;
	        
	        for (int num=1; num<=n; num++) {
	            for (int i=0; i<=num-1; i++) {
	                count[num] += count[i]*count[num-1-i]; 
	            }
	        }
	        
	        return count[n];
	    }
	}
}
