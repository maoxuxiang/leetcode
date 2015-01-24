package leetcode;
/*Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false*/
public class WildcardMatching {
	public class Solution {
	    public boolean isMatch(String s, String p) {
	        if (s == null || p == null) {
	            return false;
	        }
	        
	        int m = s.length();
	        int n = p.length();
	        
	        if (m == 0 && n == 0) {
	            return true;
	        }
	        
	        if (m == 0) {
	            for (int j = 0; j < n; j++) {
	                if (p.charAt(j) != '*') {
	                    return false;
	                }
	            }
	            return true;
	        }
	        
	        if (n == 0) {
	            return false;
	        }
	        
	        char firstChar = p.charAt(0);
	        if (firstChar != '*' && firstChar != '?') {
	            return (firstChar == s.charAt(0)) && (isMatch(s.substring(1), p.substring(1)));
	        }
	        
	        if (firstChar == '?') {
	            return isMatch(s.substring(1), p.substring(1));
	        }
	        
	        if (firstChar == '*') {
	            for (int i = 0; i < m; i++) {
	                if (isMatch(s.substring(i), p.substring(1))) {
	                    return true;
	                }
	            }
	            return false;
	        }
	        
	        return false;
	    }
	}

}
