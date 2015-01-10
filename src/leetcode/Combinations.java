package leetcode;

import java.util.ArrayList;
import java.util.List;

/*Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]*/
public class Combinations {
	public class Solution {
	    public List<List<Integer>> combine(int n, int k) {
	        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
	        if (n == 0 || k>n) {
	            return res;
	        }
	        helper(res, 1, k, n, new ArrayList<Integer>());
	        return res;
	    }
	    
	    private void helper(ArrayList<List<Integer>> res, int start, int k, int n, ArrayList<Integer> item) {
	        if (item.size() == k) {
	            res.add(new ArrayList<Integer>(item));
	            return;
	        }
	        
	        for (int i=start; i<=n; i++) {
	            item.add(i);
	            helper(res, i+1, k, n, item);
	            item.remove(item.size()-1);
	        }
	    }
	}
}
