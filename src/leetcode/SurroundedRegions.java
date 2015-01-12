package leetcode;

import java.util.LinkedList;

/*My Submissions Question Solution 
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X*/
public class SurroundedRegions {
	public class Solution {
	    public void solve(char[][] board) {
	        if (board.length == 0 || board == null || board[0].length == 0) {
	            return;
	        }
	        
	        for (int i=0; i<board.length; i++) {
	            fill(board, i,0);
	            fill(board, i,board[0].length-1);
	        }
	        
	        for (int i=0; i<board[0].length; i++) {
	            fill(board, 0, i);
	            fill(board, board.length-1, i);
	        }
	        
	        for (int i=0; i<board.length; i++) {
	            for (int j=0; j<board[0].length; j++) {
	                if (board[i][j] == 'O') {
	                    board[i][j] = 'X';
	                }
	                if (board[i][j] == '#') {
	                    board[i][j] = 'O';
	                }
	            }
	        }
	    }
	    
	    private void fill (char[][] board, int row, int col) {
	        if (board[row][col] != 'O') {
	            return;
	        }
	        board[row][col] = '#';
	        LinkedList<int[]> queue = new LinkedList<int[]>();
	        int[] item = new int[2];
	        item[0] = row;
	        item[1] = col;
	        queue.add(item);
	        
	        while (!queue.isEmpty()) {
	            int[] zero = queue.poll();
	            
	            int i = zero[0];
	            int j = zero[1];
	            
	            if (i<=board.length-2 && board[i+1][j] == 'O') {
	                board[i+1][j] = '#';
	                int[] next = new int[2];
	                next[0] = i+1;
	                next[1] = j;
	                queue.add(next);
	            }
	            
	            if (i>=1 && board[i-1][j] == 'O') {
	                board[i-1][j] = '#';
	                int[] next = new int[2];
	                next[0] = i-1;
	                next[1] = j;
	                queue.add(next);
	            }
	            
	            if (j<=board[0].length-2 && board[i][j+1] == 'O') {
	                board[i][j+1] = '#';
	                int[] next = new int[2];
	                next[0] = i;
	                next[1] = j+1;
	                queue.add(next);
	            }
	            
	            if (j>=1 && board[i][j-1] == 'O') {
	                board[i][j-1] = '#';
	                int[] next = new int[2];
	                next[0] = i;
	                next[1] = j-1;
	                queue.add(next);
	            }
	        }
	    }
	}
}
