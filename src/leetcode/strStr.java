package leetcode;
/*Implement strStr().

Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.*/
public class strStr {
	public class Solution {
	    public String strStr(String haystack, String needle) {
	        if (haystack == null || needle == null || needle.length()== 0) {
	            return haystack;
	        }
	        
	        if (haystack.length() < needle.length()) {
	            return null;
	        }
	        
	        for (int i=0; i <= haystack.length() - needle.length(); i++) {
	            boolean flag = true;
	            
	            for (int j =0; j< needle.length(); j++) {
	                if (haystack.charAt(i+j) != needle.charAt(j)) {
	                    flag = false;
	                    break;
	                }
	            }
	            
	            if (flag) {
	                return haystack.substring(i);
	            }
	        }
	        return null;
	    }
	}
}
