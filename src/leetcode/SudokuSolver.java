package leetcode;
//Write a program to solve a Sudoku puzzle by filling the empty cells.
/*题解：
第一反应就是N皇后问题。就是一点点尝试着填数，不行的话就回溯，直到都填满就返回。 
如果对一个格子尝试从0~9都不行，那么说明整个sudoku无解，返回false就好。

对整个棋盘所有'.'都填完了，那么就可以返回true了。*/


public class SudokuSolver {
	public class Solution {
	    public void solveSudoku(char[][] board) {
	        if (board == null || board.length == 0) {
	            return;
	        }
	        helper(board);
	    }
	    
	    private boolean helper(char[][] board) {
	        for (int i=0; i<board.length; i++) {
	            for (int j=0; j<board[0].length; j++) {
	                if (board[i][j] == '.') {
	                    for(char num='1'; num<='9'; num++) {
	                        if(isvalid (board, i, j, num)) {
	                            board[i][j] = num;
	                            if(helper(board)) {
	                                return true;
	                            }
	                            else {
	                                board[i][j] = '.';
	                            }
	                        }
	                    }
	                    return false;
	                }
	            }
	        }
	        
	        return true;
	    }
	    
	    private boolean isvalid(char[][] board, int i, int j, char num) {
	        
	        //check column
	        for (int k=0; k<board.length; k++) {
	           if ( board[k][j] == num) {
	               return false;
	           }
	        }
	        
	        //check row
	        for (int k=0; k<board[0].length; k++) {
	            if(board[i][k] == num) {
	                return false;
	            }
	        }
	        
	        //check sub-box 
	        for (int col = i/3*3; col<i/3*3+3; col++) {
	            for (int row=j/3*3; row<j/3*3+3; row++) {
	                if (board[col][row] == num) {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
	}
}
