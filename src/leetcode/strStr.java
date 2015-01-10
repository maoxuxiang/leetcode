package leetcode;
/*Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.*/
public class strStr {
	public class Solution {
	    public int strStr(String haystack, String needle) {
	        if(needle == null || needle.length()== 0 ) {
	            return 0;
	        }
	        if(haystack == null || needle.length() > haystack.length()) {
	            return -1;
	        }
	        for(int i =0; i<=haystack.length()-needle.length(); i++) {
	            boolean flag = true;
	            
	            for(int j=0; j<needle.length(); j++) {
	                if(haystack.charAt(i+j) != needle.charAt(j)) {
	                    flag = false;
	                    break;
	                }
	            }
	            
	            if (flag) {
	                return i;
	            }
	        }
	        return -1;
	    }
	}
}
