package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].*/
public class PermutationsII {
	public class Solution {
	    public List<List<Integer>> permuteUnique(int[] num) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if (num == null || num.length == 0) {
	            return res;
	        }
	        boolean[] visited = new boolean[num.length];
	        ArrayList<Integer> item = new ArrayList<Integer>();
	        Arrays.sort(num);
	        helper(res, num, item, visited);
	        return res;
	    }
	    
	    private void helper(List<List<Integer>> res, int[] num, ArrayList<Integer> item, boolean[] visited) {
	        if (item.size() == num.length) {
                res.add(new ArrayList<Integer>(item));
                return; 
	        }
	        
	        for (int i=0; i<num.length; i++) {
	            if (i>0 && num[i] == num[i-1] && visited[i-1] == false) {
	                continue;
	            }
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
