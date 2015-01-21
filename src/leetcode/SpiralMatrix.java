package leetcode;

import java.util.ArrayList;
import java.util.List;

/*Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].*/
public class SpiralMatrix {
	public class Solution {
	    public List<Integer> spiralOrder(int[][] matrix) {
	        List<Integer> res = new ArrayList<Integer>();
	        if (matrix == null || matrix.length == 0) {
	            return res;
	        }
	        int width = matrix[0].length;
	        int height = matrix.length;
	        
	        int x = 0;
	        int y = 0;
	        
	        while (width > 0 && height >0) {
	            // only one column
	            if (width == 1) {
	                for (int i=0; i<height; i++) {
	                    res.add(matrix[x++][y]);
	                }
	                break;
	            }
	            // only one row
	            if (height == 1) {
	                for (int i=0; i<width; i++) {
	                    res.add(matrix[x][y++]);
	                }
	                break;
	            }
	            
	            //other condition 
	            // add top
	            for (int i=0; i<width-1; i++) {
	                res.add(matrix[x][y++]);
	            }
	            
	            //add right 
	            for (int i=0; i<height-1; i++) {
	                res.add(matrix[x++][y]);
	            }
	            
	            //add bottom 
	            for (int i=0; i<width-1; i++) {
	                res.add(matrix[x][y--]);
	            }
	            
	            //add left 
	            for (int i=0; i<height-1; i++) {
	                res.add(matrix[x--][y]);
	            }
	            
	            width -= 2;
	            height -= 2;
	            x++;
	            y++;

	        }
	        return res;
	        
	    }
	}
	
	//more clear
	public class Solution2 {
	    public List<Integer> spiralOrder(int[][] matrix) {
	        List<Integer> res = new ArrayList<Integer>();
	        if (matrix == null || matrix.length == 0) {
	            return res;
	        }
	        
	        int m = matrix.length;
	        int n = matrix[0].length;
	        
	        int min = Math.min(m,n);
	        int level = min/2;
	        
	        for (int i=0; i<level; i++) {
	            for (int j=i; j<n-i-1; j++) {
	                res.add(matrix[i][j]);
	            }
	            for (int j=i; j<m-1-i; j++) {
	                res.add(matrix[j][n-1-i]);
	            }
	            for (int j=i; j<n-i-1; j++) {
	                res.add(matrix[m-1-i][n-j-1]);
	            }
	            for (int j=i; j<m-1-i; j++) {
	                res.add(matrix[m-1-j][i]);
	            }
	        }
	        
	        if (min%2 == 1) {
	            if (m > n) {
	                for (int i=level; i<m-level; i++) {
	                    res.add(matrix[i][level]);
	                }
	            }
	            else {
	                for (int i=level; i<n-level; i++) {
	                    res.add(matrix[level][i]);
	                }
	            }
	        }
	        
	        return res;

	    }
	}
}
