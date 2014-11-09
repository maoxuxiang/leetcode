package leetcode;

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
	}
}
