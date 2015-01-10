package leetcode;

import java.util.ArrayList;

/*Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
*/
public class NQueensII {
	public class Solution {
	    public int totalNQueens(int n) {
	        ArrayList<int[]> res = new ArrayList<int[]>();
	        int[] column = new int[n];
	        helper(res, column, 0, n);
	        return res.size();
	    }
	    
	    private void helper(ArrayList<int[]> res, int[] column, int row, int n) {
	        if (row == n) {
	            res.add(column);
	        }
	        for (int i=0; i<n; i++) {
	            if(isValid(column,row,i)) {
	                column[row] = i;
	                helper(res, column, row+1, n);
	            }
	        }
	    }
	    
	    private boolean isValid(int[] column, int row, int col) {
	        for (int i=0; i<row; i++) {
	            if(column[i] == col) {
	                return false;
	            }
	            if(Math.abs(column[i]-col) == Math.abs(row-i)) {
	                return false;
	            }
	        }
	        return true;
	    }
	}
}
