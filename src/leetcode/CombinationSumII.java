package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] */
public class CombinationSumII {
	public class Solution {
	    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
	        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	        if (num == null || num.length== 0) {
	            return res;
	        }
	        Arrays.sort(num);
	        ArrayList<Integer> item = new ArrayList<Integer>();
	        helper(res, 0, target, num, item);
	       // remove duplicate arraylist
	        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
	        set.addAll(res);
	        res.clear();
	        res.addAll(set);
	        return res;
	    }
	    
	    private void helper(ArrayList<ArrayList<Integer>> res, int start, int target, int[] num, ArrayList<Integer> item) {
	        if (target < 0) {
	            return;
	        }
	        if (target == 0) {
	            res.add(new ArrayList<Integer>(item));
	            return;
	        }
	        for (int i=start; i<num.length; i++) {
	            item.add(num[i]);
	            helper(res, i+1, target-num[i], num, item);
	            item.remove(item.size()-1);
	        }
	    }
	}
	
	// solution2
	public class Solution2 {
	    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
	        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	        if (num == null || num.length== 0) {
	            return res;
	        }
	        Arrays.sort(num);
	        ArrayList<Integer> item = new ArrayList<Integer>();
	        helper(res, 0, target, num, item);
	        return res;
	    }
	    
	    private void helper(ArrayList<ArrayList<Integer>> res, int start, int target, int[] num, ArrayList<Integer> item) {
	        if (target < 0) {
	            return;
	        }
	        if (target == 0) {
	            res.add(new ArrayList<Integer>(item));
	            return;
	        }
	        for (int i=start; i<num.length; i++) {
	        	/*在这里我们还是需要在每一次for循环前做一次判断，因为虽然一个元素不可以重复使用，但是如果这个元素重复出现是允许的，
	        	但是为了避免出现重复的结果集，我们只对于第一次得到这个数进行递归，接下来就跳过这个元素了，
	        	因为接下来的情况会在上一层的递归函数被考虑到，这样就可以避免重复元素的出现。
	        	这个问题可能会觉得比较绕，大家仔细想想就明白了哈。*/
	            if(i>start &&  num[i]==num[i-1]) continue;  
	            item.add(num[i]);
	            helper(res, i+1, target-num[i], num, item);
	            item.remove(item.size()-1);
	        }
	    }
	}
}
