package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:*/
public class Subsets {
	//similar to combinations
	public class Solution {
	    public List<List<Integer>> subsets(int[] S) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if (S == null || S.length == 0) {
	            return res;
	        }
	        
	        Arrays.sort(S);
	        List<Integer> item = new ArrayList<Integer>();
	        for (int i=1; i<=S.length; i++) {
	            helper (res, i, 0, S, item);
	        }
	        
	        res.add(new ArrayList<Integer>());
	        return res;
	    }
	    
	    private void helper (List<List<Integer>> res, int len, int start, int[] S, List<Integer> item) {
	        if (item.size() == len) {
	            res.add(new ArrayList<Integer>(item));
	            return;
	        }
	        
	        for (int i=start; i<S.length; i++) {
	            item.add(S[i]);
	            helper(res, len, i+1, S, item);
	            item.remove(item.size()-1);
	        }
	    }
	}
	
	//solution 2
	public class Solution2 {
	    public List<List<Integer>> subsets(int[] S) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if (S == null || S.length == 0) {
	            return res;
	        }
	        
	        Arrays.sort(S);
	        List<Integer> item = new ArrayList<Integer>();
	        
	        helper (res, item, 0, S);
	        
	        res.add(new ArrayList<Integer>());
	        return res;
	    }
	    
	    private void helper (List<List<Integer>> res, List<Integer> item, int start, int[] S) {
	        for(int i=start; i<S.length; i++) {
	            item.add(S[i]);
	            res.add(new ArrayList<Integer>(item));
	            helper(res, item, i+1, S);
	            item.remove(item.size()-1);
	        }
	    }
	  
	} 
}
