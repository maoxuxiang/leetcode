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
}
