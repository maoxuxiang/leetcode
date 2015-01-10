package leetcode;

import java.util.ArrayList;
import java.util.List;

/*Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].*/
public class Permutations {
	public class Solution {
	    public List<List<Integer>> permute(int[] num) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if (num == null || num.length == 0) {
	            return res;
	        }
	        boolean[] visited = new boolean[num.length];
	        ArrayList<Integer> item = new ArrayList<Integer>();
	        helper(res, num, item, visited);
	        return res;
	    }
	    
	    private void helper(List<List<Integer>> res, int[] num, ArrayList<Integer> item, boolean[] visited) {
	        if (item.size() == num.length) {
	            res.add(new ArrayList<Integer>(item));
	            return;
	        }
	        
	        for (int i=0; i<num.length; i++) {
	            if (visited[i] == true) {
	                continue;
	            }
	            item.add(num[i]);
	            visited[i] = true;
	            helper(res, num, item, visited);
	            item.remove(item.size()-1);
	            visited[i] = false;
	        }
	    }
	}
}
