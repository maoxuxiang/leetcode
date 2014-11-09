package leetcode;

/*The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".*/

public class ZigZagConversion {
	public class Solution {
	    public String convert(String s, int nRows) {
	        
	        if (nRows == 1 || nRows > s.length() ) {
	            return s;
	        }
	        
	        StringBuffer[] res = new StringBuffer[nRows];
	        for (int i =0; i< nRows; ++i) {
	            res[i] = new StringBuffer();
	        }
	        
	        int group = 2*nRows - 2;
	        for (int i = 0; i<s.length(); ++i) {
	            int index = i % group;
	            if (index < nRows ) {
	                res[index].append(s.charAt(i));
	            }
	            else {
	                res[group - index].append(s.charAt(i));
	            }
	        }
	        
	        StringBuffer result = new StringBuffer();
	        for (int i =0; i<nRows; i++) {
	            result.append(res[i]);
	        }
	        
	        return result.toString();
	        
	    }
	}
}
