package leetcode;

import java.util.HashSet;

public class ValidSudoku {
	public class Solution {
	    public boolean isValidSudoku(char[][] board) {
	        
	        //check column;
	        for (int i=0; i<board[0].length; i++) {
	            HashSet<Character> set = new HashSet<Character>();
	            for(int j=0; j<board.length; j++) {
	                if(board[j][i] != '.' && !set.add(board[j][i])) {
	                    return false;
	                }
	            }
	        }
	        
	        //check row;
	        for (int i=0; i<board.length; i++) {
	            HashSet<Character> set = new HashSet<Character>();
	            for (int j=0;j<board[0].length; j++) {
	                 if(board[i][j] != '.' && !set.add(board[i][j])) {
	                    return false;
	                }
	            }
	        }
	        
	        //check sub-box
	        for (int i=0; i<3; i++) {
	            for (int j =0; j<3;j++) {
	                HashSet<Character> set = new HashSet<Character>();
	                for (int m=i*3; m<i*3+3; m++) {
	                    for(int n=j*3; n<j*3+3; n++) {
	                        if(board[m][n] != '.' && !set.add(board[m][n])) {
	                            return false;
	                        }
	                    }
	                }
	            }
	        }
	        
	        return true;
	    }
	}
}
