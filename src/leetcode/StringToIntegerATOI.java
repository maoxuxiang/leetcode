package leetcode;

/*Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.*/

public class StringToIntegerATOI {
	public class Solution {
	    public int atoi(String str1) {
	        
	        String str = str1.trim();
	        if (str == null || str.length() == 0) {
	            return 0;
	        }
	        char c = str.charAt(0);
	        double sum = 0;
	        boolean pos = true;
	        
	        if (c - '0' >= 0 && c - '0'<=9) {
	            sum += c - '0';
	        }
	        else if (c == '+') {
	            pos = true;
	        }
	        else if (c == '-') {
	            pos = false;
	        }
	        else {
	            return 0;
	        }
	        
	        for (int i = 1; i<str.length(); ++i) {
	            c = str.charAt(i);
	            if (c - '0' >= 0 && c - '0'<=9) {
	                sum = sum*10;
	                sum += c - '0';
	            }
	            else {
	                break;
	            }
	        }
	        if (pos == false) {
	            sum = -sum;
	        }
	        if (sum > Integer.MAX_VALUE ) {
	            return Integer.MAX_VALUE;
	        }
	        else if (sum < Integer.MIN_VALUE) {
	            return Integer.MIN_VALUE;
	        }
	        
	        return (int)sum;
	    }
	}
}
