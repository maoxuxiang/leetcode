package leetcode;

import java.util.ArrayList;
import java.util.List;

/*The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]*/
public class NQueens {
	public class Solution {
	    public List<String[]> solveNQueens(int n) {
	        List<String[]> res = new ArrayList<String[]>();
	        int[] column = new int[n];
	        place(column, res, 0, n);
	        return res;
	    }
	    
	    private void place(int[] column, List<String[]> res, int row, int n) {
	        if (row == n) {
	            String[] str = new String[n];
	            for (int i=0; i<n ;i++) {
	                
	                StringBuffer sb = new StringBuffer();
	                for (int j=0; j<n; j++){
	                    
	                    if (column[i] == j) {
	                        sb.append('Q');
	                    }
	                    else {
	                        sb.append('.');
	                    }
	                }
	                str[i] = sb.toString();
	            }
	            res.add(str);
	            
	        }
	        else {
	            for (int col=0; col<n; col++) {
	                if (isValid(column, row, col)) {
	                    column[row] = col;
	                    place(column, res, row+1, n);
	                }
	            }
	        }
	    }
	    
	    private boolean isValid(int[] column, int row, int col) {
	        for (int before =0; before<row; before++) {
	            if(column[before] == col) {
	                return false;
	            }
	            
	            if (Math.abs(column[before] - col) == Math.abs(row - before)) {
	                return false;
	            }
	         }
	         return true;
	    }
	}
}
