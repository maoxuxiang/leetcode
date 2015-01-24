package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]*/
public class SubsetsII {
	public class Solution {
	    public List<List<Integer>> subsetsWithDup(int[] num) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if (num == null || num.length== 0) {
	            return res;
	        }
	        Arrays.sort(num);
	        List<Integer> item = new ArrayList<Integer>();
	        helper (res, num, 0, item);
	        res.add(new ArrayList<Integer>());
	        return res;
	    }
	    
	    private void helper(List<List<Integer>> res, int[] num, int start, List<Integer> item) {
	        for (int i = start; i<num.length; i++) {
	            item.add(num[i]);
	            res.add(new ArrayList<Integer>(item));
	            helper(res, num, i+1, item);
	            item.remove(item.size()-1);
	            while (i < num.length-1 && num[i] == num[i+1]) {
	                i++;
	            }
	        }
	    }
	}
	
	//solution 2
	public class Solution2 {
	    public List<List<Integer>> subsetsWithDup(int[] num) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if (num == null || num.length== 0) {
	            return res;
	        }
	        Arrays.sort(num);
	        List<Integer> item = new ArrayList<Integer>();
	        int len = num.length;
	        
	        for (int i=1; i<= len; i++) {
	            helper(res, item, i, 0, num);
	        }
	        
	        res.add(new ArrayList<Integer>());
	        return res;
	    }
	    
	    private void helper(List<List<Integer>> res, List<Integer> item, int len, int start, int[] num) {
	        if (item.size() == len) {
	            if(!res.contains(item)) {
	                res.add(new ArrayList<Integer>(item));
	            }
	        }
	        
	        for (int i=start; i<num.length; i++) {
	            item.add(num[i]);
	            helper(res, item, len, i+1, num);
	            item.remove(item.size()-1);
	        }
	    }
	    
	   
	}
	
	//Solution3
	public class Solution3 {
	    public List<List<Integer>> subsetsWithDup(int[] num) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if (num == null || num.length == 0) {
	            return res;
	        }
	        Arrays.sort(num);
	        List<Integer> item = new ArrayList<Integer>();
	        helper (res, item, num, 0);
	        res.add(new ArrayList());
	        return res;
	    }
	    
	    private void helper(List<List<Integer>> res, List<Integer> item, int[] num, int start) {
	        for (int i=start; i<num.length; i++) {
	            if (i>start && num[i] == num[i-1]) {
	                continue;
	            }
	            item.add(num[i]);
	            res.add(new ArrayList<Integer>(item));
	            helper (res, item, num, i+1);
	            item.remove(item.size()-1);
	            
	        }
	    }
	}
}
