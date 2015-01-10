package leetcode;

import java.util.ArrayList;

/*Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".*/
public class ReverseWordsinaString {
	public class Solution {
	    public String reverseWords(String s) {
	        s = s.trim();
	        ArrayList<String> res = new ArrayList<String>();
	        
	        String[] str = s.split(" ");
	        for(int i=str.length-1; i>=0; i--) {
	            if (!str[i].isEmpty()) {
	                res.add(str[i]);
	            }
	        }

	        StringBuilder sb = new StringBuilder();
	        for (String ss: res) {
	            sb.append(ss);
	            sb.append(" ");
	        }
	        
	        return sb.toString().trim();
	        
	        

	    }
	}
	
}
