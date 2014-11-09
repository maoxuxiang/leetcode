package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/*Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)*/

public class _3sum {
	public class Solution {
	    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
	        
	        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	        
	        if (num == null || num.length < 3) {
	            return res;
	        }
	        
	        Arrays.sort(num);
	        for (int i = num.length-1; i>=2; i--) {
	            if (i<num.length-1 && num[i] == num[i+1]) {
	                continue;
	            }
	            ArrayList<ArrayList<Integer>> twoTmp = twoSum(num, i-1, -num[i]);
	            for(ArrayList<Integer> a: twoTmp) {
	                a.add(num[i]);
	            }
	            
	            res.addAll(twoTmp);
	        }
	        
	        return res;
	    }
	    
	    private ArrayList<ArrayList<Integer>> twoSum(int[] num, int end, int target) {
	        
	        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	        
	        if (num == null || num.length < 2) {
	            return res;
	        }
	        
	        int l = 0;
	        int r = end;
	        
	        while (l<r) {
	            if (num[l] + num[r] == target) {
	                ArrayList<Integer> tmp = new ArrayList<Integer>();
	                tmp.add(num[l]);
	                tmp.add(num[r]);
	                l++;
	                r--;
	                res.add(tmp);
	                while (l<r && num[l] == num[l-1]) {
	                    l++;
	                }
	                while (l<r && num[r] == num[r+1]) {
	                    r--;
	                }
	            }
	          
	            else if (num[l] + num[r] < target) {
	                l++;
	            }
	            else if (num[l] + num[r] > target) {
	                r--;
	            }
	        }
	        return res;
	    }
	}
}
