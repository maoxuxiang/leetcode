package leetcode;
/*Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.*/
public class Searcha2DMatrix {
	public class Solution {
	    public boolean searchMatrix(int[][] matrix, int target) {
	        if (matrix == null || matrix.length == 0) {
	            return false;
	        }

	        int m = matrix.length;
	        int n = matrix[0].length;
	        
	        if (target > matrix[m-1][n-1] || target<matrix[0][0]) {
	            return false;
	        }
	        
	        int row = searchRow(0, m-1, target, matrix);
	        if (row == -1) {
	            return false;
	        }
	        return searchNum(row, 0, n-1, matrix, target);
	    }
	    
	    private int searchRow(int start, int end, int target, int[][] matrix) {
	        while (start<=end){
	            int mid = (start+end)/2;
	            
	            if (target >= matrix[mid][0] && target<=matrix[mid][matrix[0].length-1]) {
	                return mid;
	            }
	            
	            else if (target > matrix[mid][matrix[0].length-1]) {
	                start = mid+1;
	            }
	            
	            else {
	                end = mid -1;
	            }
	        }
	        return -1;
	    }
	    
	    private boolean searchNum (int row, int start, int end, int[][] matrix, int target) {
	        while (start <= end) {
	            int mid = (start+end)/2;
	            if (matrix[row][mid] == target) {
	                return true;
	            }
	            
	            else if (target > matrix[row][mid]) {
	                start = mid+1;
	            }
	            
	            else {
	                end = mid -1;
	            }
	        }
	        return false;
	    }
	}
}
