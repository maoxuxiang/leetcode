package leetcode;
/*Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]*/
public class SpiralMatrixII {
	public class Solution {
	    public int[][] generateMatrix(int n) {

	        int[][] res = new int[n][n];
	        if (n == 0) {
	            return res;
	        }
	        
	        int level = (n+1)/2;
	        int num = 1;
	        for (int i=0; i<level; i++) {
	            //top
	            for (int m=i; m<n-i-1; m++) {
	                res[i][m] = num;
	                num++;
	            }
	            //right
	            for (int m=i; m<n-i-1; m++) {
	                res[m][n-i-1] = num;
	                num++;
	            }
	            //bottom
	            for (int m=i; m<n-i-1; m++) {
	                res[n-i-1][n-1-m] = num;
	                num++;
	            }
	            //left
	            for (int m=i; m<n-i-1; m++) {
	                res[n-1-m][i] = num;
	                num++;
	            }
	        }
	        
	        if (n%2 != 0) {
	            res[n/2][n/2] = num;
	        }
	        
	        return res;
	    }
	}
}
