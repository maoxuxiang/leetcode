package leetcode;
/*A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.*/
public class DecodeWays {
	public class Solution {
	    public int numDecodings(String s) {
	        if (s == null || s.length() == 0|| s == "0") {
	            return 0;
	        }
	        
	        int[] map = new int[s.length()+1];
	        map[0] = 1;
	        
	        if (isvaild(s.substring(0,1))) {
	            map[1] = 1;
	        }
	        else {
	            map[1] = 0;
	        }
	        
	        for (int i=2; i<=s.length(); i++) {
	            if(isvaild(s.substring(i-1, i))) {
	                map[i] += map[i-1];
	            }
	            if(isvaild(s.substring(i-2, i))) {
	                map[i] += map[i-2];
	            }
	        }
	        
	        return map[s.length()];
	    }
	    
	    private boolean isvaild(String s) {
	        if (s.charAt(0) == '0') {
	            return false;
	        }
	        
	        int num = Integer.parseInt(s);
	        if (num>=1 && num<=26) {
	            return true;
	        }
	        else return false;
	    }
	}
}
