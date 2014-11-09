package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2)
 * are not zero-based.
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * @author Mao
 *
 */

public class twoSum {
	//O(n2)
	public class Solution {
	    public int[] twoSum(int[] numbers, int target) {
	        int[] res = new int[2];
	        
	        for (int i=0; i<numbers.length-1; i++) {
	            for(int j=i+1; j<numbers.length; j++) {
	               int value =  numbers[i] + numbers[j];
	               if (value == target) {
	                   res[0] = i+1;
	                   res[1] = j+1;
	               }
	            }
	        }
	        return res;
	    }
	}
	
	//	O(N) map
	public class Solution2 {
	    public int[] twoSum(int[] numbers, int target) {
	        
	        int[] res = new int[2];
	        
	        int small = 0;
	        int large = 0;
	        
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for (int i=0; i<numbers.length; ++i) {
	            if (!map.containsKey(numbers[i])) {
	                map.put(target - numbers[i], i);
	            } 
	            else {
	                small = i > map.get(numbers[i])?map.get(numbers[i]):i;
	                large = small == i? map.get(numbers[i]):i;
	            }
	        }
	        
	        res[0] = small +1;
	        res[1] = large + 1;
	        
	        return res;
	    
	    }
	}
}
