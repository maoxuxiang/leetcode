package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/*Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] */

public class CombinationSum {
	public class Solution {
	    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
	        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	        if(candidates == null || candidates.length == 0) {
	            return res;
	        }
	        Arrays.sort(candidates);
	        ArrayList<Integer> item = new ArrayList<Integer>();
	        helper(res, 0, target, candidates, item);
	        return res;
	    }
	    
	    private void helper(ArrayList<ArrayList<Integer>> res, int start, int target, int[] candidates, ArrayList<Integer> item) {
	        if (target < 0) {
	            return;
	        }
	        if (target == 0) {
	        	//这里要add的应该是一个复制的全新list，而不能直接把sol这个list加到结果ret里面去。
	        	//因为后面我们会不断的修改sol，如果直接加sol这个list，最终ret里面已经被加进去的list其实全都是sol这一个list，
	        	//最后的结果会返回一个空list。
	            res.add(new ArrayList<Integer>(item));
	            return;
	        }
	        for (int i=start; i<candidates.length; i++) {
	            if(i>0 && candidates[i] == candidates[i-1]) {
	                continue;
	            }
	            item.add(candidates[i]);
	            helper(res, i, target-candidates[i], candidates, item);
	            item.remove(item.size()-1);
	        }
	    }
	}
}
