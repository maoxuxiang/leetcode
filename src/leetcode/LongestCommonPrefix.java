package leetcode;

//Write a function to find the longest common prefix string amongst an array of strings.
public class LongestCommonPrefix {
	public class Solution {
	    public String longestCommonPrefix(String[] strs) {
	        if (strs == null || strs.length == 0) {
	            return "";
	        }
	        if (strs.length == 1) {
	            return strs[0];
	        }
	        
	        String res = strs[0];
	        
	        for (int i =0; i< res.length(); i++) {
	            for (int j = 1; j<strs.length;++j) {
	                if (strs[j].length() == i || strs[j].charAt(i) != res.charAt(i)) {
	                    return res.substring(0,i);
	                }
	            }
	        }
	        
	        return res;
	    }
	}
}
