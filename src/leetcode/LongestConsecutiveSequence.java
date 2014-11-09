package leetcode;

import java.util.HashSet;
import java.util.Set;


/*Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.*/

public class LongestConsecutiveSequence {
	class Solution {
	    public int longestConsecutive(int[] num) {
	    Set<Integer> set = new HashSet<Integer>();
	    
	    for (int i =0; i<num.length; ++i) {
	        set.add(num[i]);
	    }
	    
	    int max = 0;
	    for (int i =0; i<num.length; ++i) {
	      int next = num[i] -1;
	      int count = 1;
	      set.remove(num[i]);
	      while (set.contains(next)) {
	          set.remove(next);
	          next --;
	          count ++;
	      }
	      
	      next = num[i] + 1;
	      while (set.contains(next)) {
	          set.remove(next);
	          next++;
	          count ++;
	      }
	      
	      max = max > count? max: count;
	      
	    }
	    return max;
	    }
	}
	   

}
