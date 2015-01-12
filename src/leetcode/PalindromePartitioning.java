package leetcode;

import java.util.ArrayList;
import java.util.List;

/*Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]*/
public class PalindromePartitioning {
	public class Solution {
	    public List<List<String>> partition(String s) {
	        List<List<String>> res = new ArrayList<List<String>>();
	        if (s.length() == 0 || s == null) {
	            return res;
	        }
	        List<String> item = new ArrayList<String>();
	        helper (res, s, item);
	        return res;
	    }
	    
	    private void helper (List<List<String>> res, String s, List<String> item) {
	        if (s.length() == 0) {
	            res.add(new ArrayList<String>(item));
	        }
	        for (int i=0; i<s.length(); i++) {
	            String str1 = s.substring(0,i+1);
	            String str2 = s.substring(i+1);
	            if (isPalindrome(str1)) {
	                item.add(str1);
	                helper(res, str2, item);
	                item.remove(item.size()-1);
	            }
	        }
	    }
	    
	    private boolean isPalindrome (String s) {
	        if (s == null || s.length() == 0) {
	            return true;
	        }
	        for (int i=0; i<s.length(); i++) {
	            int end = s.length()-1-i;
	            if (s.charAt(i) != s.charAt(end)) {
	                return false;
	            }
	        }
	        return true;
	    }
	    
	}
}
