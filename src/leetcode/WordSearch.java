package leetcode;
/*Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.*/
public class WordSearch {
	public class Solution {
	    public boolean exist(char[][] board, String word) {
	        int m = board.length;
	        int n = board[0].length;
	        
	        boolean[][] visited = new boolean[m][n];
	        for (int i=0; i<m; i++) {
	            for (int j=0; j<n;j++) {
	                if (helper(board, word, 0, i, j, visited)) return true;
	            }
	        }
	        
	        return false;
	    }
	    
	    private boolean helper (char[][] board, String word, int idx, int i, int j, boolean[][] visited) {
	        if (idx == word.length()) {
	            return true;
	        }
	        if (i< 0 || j<0 || i>=board.length || j>=board[0].length) {
	            return false;
	        }
	        if (visited[i][j] == true) {
	            return false;
	        }
	        if (word.charAt(idx) != board[i][j]) {
	            return false;
	        }
	        visited[i][j] = true;
	        boolean res = helper(board, word, idx+1, i-1, j, visited) ||
	        helper(board, word, idx+1, i, j-1, visited) || 
	        helper(board, word, idx+1, i+1, j, visited) ||
	        helper(board, word, idx+1, i, j+1, visited);
	        visited[i][j] = false;
	        return res;
	    }
	}
}
