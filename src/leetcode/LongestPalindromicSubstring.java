package leetcode;

public class LongestPalindromicSubstring {
	public class Solution {
	    public String longestPalindrome(String s) {
	        if (s == null || s.length() ==0) {
	            return "";
	        }
	        if (s.length() == 1) {
	            return s;
	        }
	        
	        boolean[][] map = new boolean[s.length()][s.length()];

	        
	        int maxLen = 1;
	        int left = 0;
	        int right = 0;
	        for (int k=1; k<s.length(); k++) {
	            for (int i=0; i+k<s.length(); i++) {
	                int j = i+k;
	                if (s.charAt(i) == s.charAt(j)) {
	                    if (j-i<=2) {
	                        map[i][j] = true;
	                    }
	                    else {
	                        map[i][j] = map[i+1][j-1];
	                    }
	                    
	                    if (map[i][j]) {
	                        if (k+1 > maxLen) {
	                            maxLen = k+1;
	                            left = i;
	                            right = j;
	                        }
	                    }
	                }
	            }
	        }
	        
	        return s.substring(left,right+1);
	    }
	}
}
