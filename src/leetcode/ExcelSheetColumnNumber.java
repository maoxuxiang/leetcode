package leetcode;
/*Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
Credits:
Special thanks to @ts for adding this problem and creating all test cases.*/
public class ExcelSheetColumnNumber {
	public class Solution {
	    public int titleToNumber(String s) {
	        if (s == null || s.length() == 0) {
	            return 0;
	        }
	        int res = 0;
	        for (int i=0; i<s.length(); i++) {
	            res = res*26;
	            res += chartoint(s.charAt(i));
	        }
	        
	        return res;
	        
	    }
	    
	    private int chartoint(char c) {
	        if (c < 'A' || c > 'Z') {
	            return 0;
	        }
	        
	        return (int)(c - 'A')+1;
	    }
	}
}
