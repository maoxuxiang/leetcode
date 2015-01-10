package leetcode;
/*Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.*/
public class MinimumPathSum {
	public class Solution {
	    public int minPathSum(int[][] grid) {
	        if (grid == null) {
	            return 0;
	        }
	        
	        int m = grid.length;
	        int n = grid[0].length;
	        
	        int[][] map = new int[m][n];
	        map[0][0] = grid[0][0];
	        
	        for(int i=1; i<m; i++) {
	            map[i][0] = grid[i][0] + map[i-1][0];
	        }
	        
	        for(int i=1; i<n; i++) {
	            map[0][i] = grid[0][i] + map[0][i-1];
	        }
	        
	        for(int i=1; i<m; i++) {
	            for(int j=1; j<n; j++) {
	                if(map[i-1][j] < map[i][j-1]) {
	                    map[i][j] = map[i-1][j]+grid[i][j];
	                }
	                else {
	                    map[i][j] = map[i][j-1]+grid[i][j];
	                }
	            }
	        }
	        return map[m-1][n-1];
	    }
	}
}
