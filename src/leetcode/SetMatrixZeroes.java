package leetcode;
// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
public class SetMatrixZeroes {
	public class Solution {
		// 注意要从一开始
	    public void setZeroes(int[][] matrix) {
	        if (matrix == null) {
	            return;
	        }
	        
	        int m = matrix.length;
	        int n = matrix[0].length;
	        boolean rowflag = false;
	        boolean columnflag = false;
	        
	        for (int i=0; i<m; i++) {
	            if (matrix[i][0] == 0) {
	                columnflag = true;
	            }
	        }
	        
	        for (int j=0; j<n; j++) {
	            if (matrix[0][j] == 0) {
	                rowflag = true;
	            }
	        }
	        
	        for (int i=1; i<m; i++) {
	            for (int j=1; j<n; j++) {
	                if (matrix[i][j] == 0) {
	                    matrix[0][j] = 0;
	                    matrix[i][0] = 0;
	                }
	            }
	        }
	        
	        for (int i=1; i<m; i++) {
	            if (matrix[i][0] == 0) {
	                for (int j=0; j<n; j++) {
	                    matrix[i][j] = 0;
	                }
	            } 
	        }
	        
	        for (int j=1; j<n; j++) {
	            if (matrix[0][j] == 0) {
	                for (int i=0; i<m; i++) {
	                    matrix[i][j] = 0;
	                }
	            }
	        }
	        
	        if (rowflag) {
	            for (int i=0; i<n; i++) {
	                matrix[0][i] = 0;
	            }
	        }
	        
	        if (columnflag) {
	            for (int j=0; j<m; j++) {
	                matrix[j][0] = 0;
	            }
	        }
	    
	        
	    }
	}
}
