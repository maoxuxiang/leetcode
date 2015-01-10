package leetcode;
/*Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.*/
public class ContainerWithMostWater {
	public class Solution {

		public int maxArea(int[] height) {
		    
		    if (height.length == 0|| height == null){
		        return 0;
		    }
		    
	    	
	    	int lh = height[0];
	    	int len = height.length;
	    	int rh = height[len - 1];
	    	int i = 0;
	    	int j = len -1;
	    	int max = 0;
	    	int tmp;
	    	
	    	while (i < j) {
	            tmp = Math.min(lh,rh)*(j-i);
	            
	            if (tmp > max) {
	                max = tmp;
	            }
	            
	            if (lh < rh) {
	                
	                 while (i<j && height[i] <= lh) {
	    	           i++;
	    	           
	    	         }
	    	         if (i< j) {
	    	             lh = height[i];
	    	         }
	            } 
	            else {
	                
	                while(i<j && height[j]<= rh) {
	                    j--;
	                    
	                }
	                if (i < j) {
	                    rh= height[j];
	                }
	            }
	    	   
	    	}
	    	
	    	return max;
		
		}
		
		//solution 2
		public class Solution2 {
		    public int maxArea(int[] height) {
		        int maxarea = 0;
		        int i = 0;
		        int j = height.length - 1;
		        while(i < j)
		        {
		            int area = 0;
		            if(height[i] <= height[j])
		            {
		                area = height[i]*(j-i);
		                i++;
		            }   
		            else
		            {
		                area = height[j]*(j-i);
		                j--;
		            }    
		            if(area > maxarea)
		                maxarea = area;
		        }
		        return maxarea;
		    }
		}
	}
}
