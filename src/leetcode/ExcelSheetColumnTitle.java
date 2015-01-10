package leetcode;
/*Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB */
public class ExcelSheetColumnTitle {
	public class Solution {
	    public String convertToTitle(int n) {
	        if ( n == 0) {
	            return null;
	        }
	        StringBuilder sb = new StringBuilder();
	        while (n > 26) {
	            int i = n%26;
	            n = n/26;
	            if (i == 0) {
	                sb.insert(0,'Z');
	                n --;
	            }
	            else {
	                char c = inttochar(i);
	                sb.insert(0,c);
	            }
	            
	        }
	        sb.insert(0,inttochar(n));
	        return sb.toString();
	    }
	    private char inttochar (int n) {
	        if (n < 1 || n > 26) {
	            return 'x';
	        }
	        return (char) (((int)'A')+n-1);
	    }
	}
}
