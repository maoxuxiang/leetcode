package leetcode;

import java.util.Arrays;
import java.util.Stack;

/*Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.*/
public class LargestRectangleinHistogram {
	//http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
	public class Solution {
	    public int largestRectangleArea(int[] height) {
	        if (height == null || height.length == 0) {
	            return 0;
	        }
	        
	        int[] min = new int[height.length];
	        int maxarea = 0;
	        for (int i=0; i<height.length; i++) {
	             if(height[i] != 0 && maxarea/height[i] >= (height.length - i)) {
	                  continue;
	              }
	            for (int j=i; j<height.length; j++) {
	                if (i == j) {
	                    min[j] = height[j];
	                }
	                else {
	                    if (height[j] > min[j-1]) {
	                        min[j] = min[j-1];
	                    }
	                    else {
	                        min[j] = height[j];
	                    }
	                }
	                int area = min[j]*(j-i+1);
	                maxarea = Math.max(maxarea, area);
	            }
	        }
	        return maxarea;
	    }
	}
	// o(n)
	public class Solution2
	{
		   public int largestRectangleArea(int[] height) {
		      
		        Stack<Integer> stack = new Stack<Integer>();
		        int i = 0;
		        int maxArea = 0;
		        int[] h = new int[height.length + 1];
		        h = Arrays.copyOf(height, height.length + 1);
		        while(i < h.length){
		            if(stack.isEmpty() || h[stack.peek()] <= h[i]){
		                stack.push(i++);
		            }else {
		                int t = stack.pop();
		                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
		            }
		        }
		        return maxArea;
		    }
		}
}
