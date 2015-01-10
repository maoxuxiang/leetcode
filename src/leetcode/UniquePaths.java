package leetcode;
/*A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.*/
public class UniquePaths {
	public class Solution {
	    public int uniquePaths(int m, int n) {
	        if (m == 0 || n == 0) {
	            return 0;
	        }
	        if (m == 1 || n == 1) {
	            return 1;
	        }
	        
	        int[][] map = new int[m][n];
	        
	        // if there is only one column, the path is 1
	        for (int i=0; i<m; i++) {
	            map[i][0] = 1;
	        }
	        
	        //if there is only one row, the path is 1
	        for (int i=0; i<n; i++) {
	            map[0][i] = 1;
	        }
	        
	        for(int i=1; i<m; i++) {
	            for(int j=1; j<n; j++) {
	                map[i][j] = map[i-1][j] + map[i][j-1];
	            }
	        }
	        
	        return map[m-1][n-1];

	    }
	}
}