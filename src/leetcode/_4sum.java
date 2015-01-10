package leetcode;
/*Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _4sum {
	public  class Solution {

	    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
	        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	        
	        if (num == null || num.length<4) {
	            return res;
	        } 
	        Arrays.sort(num);

	        for (int i = num.length - 1; i>=3; i--) {
		        if(i==num.length-1 || num[i]!=num[i+1]) {
	
		            ArrayList<ArrayList<Integer>> temThree = temThree(num, target - num[i], i-1);
	
		            for (List<Integer> l: temThree) {
		                l.add(num[i]);
		            }
		            res.addAll(temThree);
		        }
	        
	        }
	        return res;
	    }
	    
	    private ArrayList<ArrayList<Integer>> temThree(int[] num, int target, int end) {
	        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

	        if (num == null || num.length<3) {
	            return res;
	        }
	        
	        for (int i = end; i>=2; i--) {
	        	
	        	if(i==end || num[i]!=num[i+1]) {

	            ArrayList<ArrayList<Integer>> temTwo = temTwo(num, target - num[i], i-1);
	            for (List<Integer> l: temTwo) {
	                l.add(num[i]);
	            }
	            res.addAll(temTwo);
	        	}
	        
	        }
	        return res;
	    }

	    private ArrayList<ArrayList<Integer>> temTwo(int[] num, int target, int end) {
	        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

	        if (num == null || num.length<2) {
	            return res;
	        }

	        int l = 0;
	        int r = end;
	        while (l<r) {
	            if (num[l]+num[r] == target) {
	                ArrayList<Integer> tmp = new ArrayList<Integer>();
	                tmp.add(num[l]);
	                tmp.add(num[r]);
	                res.add(tmp);
	                l++;
	                r--;
	                while (l<r && num[l]==num[l-1]) {
	                    l++;
	                }
	                while (l<r && num[r]==num[r+1]) {
	                    r--;
	                }
	            }
	            else if (num[l]+num[r] > target) {
	                r--;
	            }
	            else {
	                l++;
	            }
	        }
	        return res;
	    }
	}
}
 
