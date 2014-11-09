package leetcode;

/*Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.*/
public class RomantoInteger {
	public class Solution {
	    public int romanToInt(String s) {
	        if (s == null || s.length() == 0) {
	            return 0;
	        }
	        
	        if (s.length() == 1) {
	            return convert(s.charAt(0));
	        }
	        
	        int res = convert(s.charAt(0));
	        
	        for (int i=0; i<s.length()-1; ++i) {
	            char pre = s.charAt(i);
	            char cur = s.charAt(i+1);
	            
	            if (convert(pre) >=convert(cur)) {
	                res +=convert(cur);
	            }
	            else {
	                res = res - convert(pre)*2 +convert(cur);
	            }
	        }
	        return res;
	     }
	    
	    public int convert(char c) {
	        int data = 0;
	        switch (c) {
	            case 'I':
	                data = 1;
	                break;
	            case 'V':
	                data = 5;
	                break;
	            case 'X':
	                data = 10;
	                break;
	            case 'L':  
	                data = 50;  
	                break;  
	            case 'C':  
	                data = 100;  
	                break;  
	            case 'D':  
	                data = 500;  
	                break;  
	            case 'M':  
	                data = 1000;  
	                break;  
	        }
	        
	        return data;
	    }
	}
}
